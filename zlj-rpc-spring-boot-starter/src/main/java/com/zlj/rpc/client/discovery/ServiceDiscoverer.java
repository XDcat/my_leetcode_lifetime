package com.zlj.rpc.client.discovery;

import com.zlj.rpc.common.service.Service;

import java.util.List;

/**
 * 服务发现接口
 */
public interface ServiceDiscoverer {
    List<Service> getServices(String name);
}
