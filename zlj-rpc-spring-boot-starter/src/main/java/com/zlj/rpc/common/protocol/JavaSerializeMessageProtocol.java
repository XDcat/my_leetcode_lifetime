package com.zlj.rpc.common.protocol;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JavaSerializeMessageProtocol implements MessageProtocol{
    private byte[] serialize(Object obj) throws Exception{
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(obj);
        return bout.toByteArray();
    }
    @Override
    public byte[] marshallingRequest(RPCRequest req) throws Exception {
        return this.serialize(req);
    }

    @Override
    public RPCRequest unmarshallingRequest(byte[] data) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        return (RPCRequest) in.readObject();
    }

    @Override
    public byte[] marshallingResponse(RPCResponse res) throws Exception {
        return this.serialize(res);
    }

    @Override
    public RPCResponse unmarshallingResponse(byte[] data) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        return (RPCResponse) in.readObject();
    }
}
