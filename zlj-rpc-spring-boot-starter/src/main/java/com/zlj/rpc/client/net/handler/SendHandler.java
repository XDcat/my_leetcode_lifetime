package com.zlj.rpc.client.net.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * 发送处理类，定义 Netty 入栈处理细则
 */
public class SendHandler extends ChannelInboundHandlerAdapter {
    private static Logger logger = LoggerFactory.getLogger(SendHandler.class);
    private CountDownLatch cdl;
    private Object readMsg = null;
    private byte[] data;

    public SendHandler(byte[] data) {
        cdl = new CountDownLatch(1);
        this.data = data;
    }

    /**
     * 连接服务时，发送请求
     * @param ctx 通道上下文
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("Success connect to server: {}", ctx);
        ByteBuf reqBuf = Unpooled.buffer(data.length);
        reqBuf.writeBytes(data);
        logger.info("Client send message: {}", reqBuf);
        ctx.writeAndFlush(reqBuf);
    }

    /**
     * 读取数据，读取数据完成后释放 CD 锁
     * @param ctx  上下文
     * @param msg  ByteBuf
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("Client reads message: {}", msg);
        ByteBuf msgBuf = (ByteBuf) msg;
        byte[] resp = new byte[msgBuf.readableBytes()];
        msgBuf.readBytes(resp);
        readMsg = resp;
        cdl.countDown();
    }

    /**
     * 获取结果，但需要等待请求完成
     * @return
     * @throws InterruptedException
     */
    public Object rspData() throws InterruptedException {
        cdl.await();
        return readMsg;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        logger.error("Exception occurred: {}", cause.getMessage());
        ctx.close();
    }
}
