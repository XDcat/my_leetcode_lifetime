package com.zlj.rpc.client.net;

import com.zlj.rpc.common.service.Service;

/**
 * 网络请求客户端，定义网络请求规范
 */
public interface NetClient {
    byte[] sendRequest(byte[] data, Service service) throws InterruptedException;
}
