package com.yh.videoplayer.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private static final Integer SUCCESS = 0;
    private static final Integer FAIL = -1;
    private Integer code;
    private String message;
    private T data;
    private List<String> errors;

    public static <T> Result<T> success(T data){
        return new Result<>(SUCCESS,"success",data,null);
    }

    public static <T> Result<T> success(T data,String message){
        return new Result<>(SUCCESS,message,data,null);
    }

    public static <T> Result<T> fail(String message){
        List<String> errors = new ArrayList<>();
        errors.add(message);
        return new Result<>(FAIL,null,null, errors);
    }

}
