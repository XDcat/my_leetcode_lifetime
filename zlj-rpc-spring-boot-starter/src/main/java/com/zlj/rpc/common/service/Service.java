package com.zlj.rpc.common.service;

/**
 * 服务信息，记录注册的服务信息
 */
public class Service {
    private String name;  // 名称
    private String protocol;  // 协议
    private String address;  // 地址

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
