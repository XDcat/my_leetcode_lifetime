package com.zlj.rpc.common.protocol;

/**
 * 响应状态
 */
public enum RPCStatus {
    SUCCESS(200, "SUCCESS"),
    ERROR(500, "Server ERROR"),
    NOT_FOUND(404, "NOT FOUND");

    private int code;
    private String msg;

    RPCStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
