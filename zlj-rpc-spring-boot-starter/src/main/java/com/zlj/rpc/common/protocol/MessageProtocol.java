package com.zlj.rpc.common.protocol;

public interface MessageProtocol {
    /**
     * 编组请求
     */
    byte[] marshallingRequest(RPCRequest req) throws Exception;

    /**
     * 解组请求
     */
    RPCRequest unmarshallingRequest(byte[] data) throws Exception;

    /**
     * 编组响应
     */
    byte[] marshallingResponse(RPCResponse res) throws  Exception;

    /**
     * 解组相应
     */
    RPCResponse unmarshallingResponse(byte[] data) throws Exception;
}
