package com.zlj.rpc.client.net;

import com.zlj.rpc.client.net.handler.SendHandler;
import com.zlj.rpc.common.service.Service;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyNetClient implements NetClient{
    private static Logger logger = LoggerFactory.getLogger(NettyNetClient.class);

    /**
     * 发送请求
     * @param data      请求数据
     * @param service   服务
     * @return          请求结果
     * @throws InterruptedException 异常
     */
    @Override
    public byte[] sendRequest(byte[] data, Service service) throws InterruptedException {
        String[] addInfoArray = service.getAddress().split(":");
        String serviceAddress = addInfoArray[0];
        String servicePort = addInfoArray[1];

        SendHandler sendHandler = new SendHandler(data);
        byte[] response;
        // 配置客户端
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline p = socketChannel.pipeline();
                            p.addLast(sendHandler);
                        }
                    });
            // 启动连接
            b.connect(serviceAddress, Integer.parseInt(servicePort)).sync();
            response = (byte[]) sendHandler.rspData();
            logger.info("SendRequest get reply: {}", response);
        } finally {
            // 释放资源组资源
            group.shutdownGracefully();
        }
        return response;
    }
}
