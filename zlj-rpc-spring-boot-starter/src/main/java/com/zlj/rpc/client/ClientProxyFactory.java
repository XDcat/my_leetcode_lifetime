package com.zlj.rpc.client;

import com.zlj.rpc.client.discovery.ServiceDiscoverer;
import com.zlj.rpc.client.net.NetClient;
import com.zlj.rpc.common.protocol.MessageProtocol;
import com.zlj.rpc.common.protocol.RPCRequest;
import com.zlj.rpc.common.protocol.RPCResponse;
import com.zlj.rpc.common.service.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 客户端代理工厂：创建远程访问代理类、封装请求、发送请求等操作
 */
public class ClientProxyFactory {
    private ServiceDiscoverer serviceDiscoverer;
    private Map<String, MessageProtocol> supportMessageProtocols;
    private NetClient netClient;
    private Map<Class<?>, Object> objectCache = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> clazz){
        return (T) this.objectCache.computeIfAbsent(clazz,
                cls -> Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(),new ClientInvocationHandler(cls))
                );
    }

    private class ClientInvocationHandler implements InvocationHandler{
        private Class<?> clazz;
        private Random random = new Random();

        public ClientInvocationHandler(Class<?> clazz) {
            this.clazz = clazz;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("toString")){
                return proxy.getClass().toString();
            }

            if (method.getName().equals("hashCode")){
                return 0;
            }

            String serviceName = this.clazz.getName();
            List<Service> services = serviceDiscoverer.getServices(serviceName);
            if (services== null || services.isEmpty()){
                throw  new RuntimeException("No provider available");
            }

            // 软负载均衡：随机选择一个服务
            Service service = services.get(random.nextInt(services.size()));

            // 构造请求对象
            RPCRequest req = new RPCRequest();
            req.setServiceName(service.getName());
            req.setMethod(method.getName());
            req.setParameterTypes(method.getParameterTypes());
            req.setParameters(args);

            // 协议层编组
            MessageProtocol protocol = supportMessageProtocols.get(service.getProtocol());
            byte[] data = protocol.marshallingRequest(req);

            // 请求并解组
            byte[] resData = netClient.sendRequest(data, service);
            RPCResponse response = protocol.unmarshallingResponse(resData);

            // 处理结果
            if (response.getException() != null){
                throw response.getException();
            }

            return response.getReturnVale();
        }
    }

    public ServiceDiscoverer getServiceDiscoverer() {
        return serviceDiscoverer;
    }

    public void setServiceDiscoverer(ServiceDiscoverer serviceDiscoverer) {
        this.serviceDiscoverer = serviceDiscoverer;
    }

    public Map<String, MessageProtocol> getSupportMessageProtocols() {
        return supportMessageProtocols;
    }

    public void setSupportMessageProtocols(Map<String, MessageProtocol> supportMessageProtocols) {
        this.supportMessageProtocols = supportMessageProtocols;
    }

    public NetClient getNetClient() {
        return netClient;
    }

    public void setNetClient(NetClient netClient) {
        this.netClient = netClient;
    }

    public Map<Class<?>, Object> getObjectCache() {
        return objectCache;
    }

    public void setObjectCache(Map<Class<?>, Object> objectCache) {
        this.objectCache = objectCache;
    }
}
