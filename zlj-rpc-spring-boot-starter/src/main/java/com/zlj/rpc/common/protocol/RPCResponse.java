package com.zlj.rpc.common.protocol;

import java.util.HashMap;
import java.util.Map;

public class RPCResponse {
    private static final long serialVersionUID = -1520948023849L;
    private RPCStatus status;
    private Map<String, String> headers = new HashMap<>();
    private Object returnVale;
    private Exception exception;

    public String getHeader(String name) {
        return this.headers == null ? null : this.headers.get(name);
    }

    public void putHeader(String key, String value) {
        this.headers.put(key, value);
    }

    public RPCStatus getStatus() {
        return status;
    }

    public void setStatus(RPCStatus status) {
        this.status = status;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Object getReturnVale() {
        return returnVale;
    }

    public void setReturnVale(Object returnVale) {
        this.returnVale = returnVale;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
