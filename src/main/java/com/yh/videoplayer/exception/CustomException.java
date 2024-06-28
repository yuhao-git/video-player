package com.yh.videoplayer.exception;


import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CustomException(String msg) {
        this.msg = msg;
    }
}
