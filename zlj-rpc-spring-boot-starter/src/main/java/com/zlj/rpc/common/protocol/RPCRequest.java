package com.zlj.rpc.common.protocol;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求类
 */
public class RPCRequest {
    private static final long serialVersionUID = -124981394859183L;
    private String serviceName;
    private String method;
    private Map<String, String> headers =  new HashMap<>();
    private Class<?>[] parameterTypes;
    private Object[] parameters;

    public String getHeader(String name) {
        return this.headers == null ? null : this.headers.get(name);
    }

    public void putHeader(String key, String value) {
        this.headers.put(key, value);
    }
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
