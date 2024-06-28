/**
 * 全局异常抛错
 */
package com.yh.videoplayer.exception;

import com.yh.videoplayer.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackages="com.yh.videoplayer.controller")
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    //统一异常处理@ExceptionHandLer，主要用于Exception
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<String> error(HttpServletRequest request, Exception e){
        log.error("异常信息：",e);
        return Result.fail("系统异常");
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result<String> customError(HttpServletRequest request, CustomException e){
        return Result.fail(e.getMsg());
    }
}
