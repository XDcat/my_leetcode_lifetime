package com.zlj.rpc.client.discovery;

import com.alibaba.fastjson.JSON;
import com.zlj.rpc.common.constants.Constant;
import com.zlj.rpc.common.serializer.ZookeeperSerializer;
import com.zlj.rpc.common.service.Service;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.server.ZKDatabase;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 基于 Zookeeper 的服务发现者，自定义咦 Zookeeper 为注册中的服务发现细则
 */
public class ZookeeperServiceDiscoverer implements ServiceDiscoverer {
    private ZkClient zkClient;
    public ZookeeperServiceDiscoverer(String zkAddress){
        zkClient = new ZkClient(zkAddress);
        zkClient.setZkSerializer(new ZookeeperSerializer());
    }

    /**
     * 从 Zookeeper 中获取所有注册的服务，并反序列化为 Service 对象
     * @param name
     * @return
     */
    @Override
    public List<Service> getServices(String name) {
        // 获取注册的服务
        String servicePath = Constant.ZK_SERVICE_PATH + Constant.PATH_DELIMITER + name + "/service";
        List<String> children = zkClient.getChildren(servicePath);
        // 解析服务
        List<Service> res = Optional.ofNullable(children).orElse(new ArrayList<>()).stream().map(str -> {
            String deCh = null;
            try {
                deCh = URLDecoder.decode(str, Constant.UTF_8);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return JSON.parseObject(deCh, Service.class);
        }).collect(Collectors.toList());
        return res;
    }
}
