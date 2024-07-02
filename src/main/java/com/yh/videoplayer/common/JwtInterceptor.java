package com.yh.videoplayer.common;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.yh.videoplayer.exception.CustomException;
import com.yh.videoplayer.dao.User;
import com.yh.videoplayer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(JwtInterceptor.class);
    @Resource
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler){
        // 从请求头中获取token
        String token = request.getHeader("token");
        // 获取失败再从请求参数中获取token
        if(StrUtil.isBlank(token)){
            token = request.getParameter("token");
        }
        // token为空则返回错误信息
        if(StrUtil.isBlank(token)){
            throw new CustomException("token不能为空");
        }
        String userId;
        User user;
        try{
            // 解码
            userId = JWT.decode(token).getAudience().get(0);
            // 通过token中的userId查询用户信息
            user = userService.getUserById(userId);
        }catch (Exception e){
            String errMsg = "token验证失败";
            log.error(errMsg + ", token="+token,e);
            throw new CustomException(errMsg);
        }
        if (user == null){
            throw new CustomException("用户不存在");
        }
        try{
            // 相同方式解密后验证
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            jwtVerifier.verify(token); // 验证token
        }
        catch(JWTVerificationException e){
            throw new CustomException("token验证失败");
        }
        return true;
    }
}
