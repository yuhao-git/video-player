package com.yh.videoplayer.vo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yh.videoplayer.pojo.User;
import com.yh.videoplayer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtTokenUtils {
    private static UserService staticUserService;
    private static final Logger log = LoggerFactory.getLogger(JwtTokenUtils.class);

    @Resource
    private UserService userService;
    @PostConstruct // 项目启动时/容器初始化时执行该方法
    public void setUserService(){
        staticUserService = userService;
    }

    /**
     * 生成token
     * @param userId
     * @param sign
     * @return
     */
    public static String getToken(String userId,String sign){
        return JWT.create().withAudience(userId) // user id 保存到token中
                .withExpiresAt(DateUtil.offsetHour(new Date(),2)) // 2小时后失效
                .sign(Algorithm.HMAC256(sign));  // 用password作为token的密钥
    }

    public static User getCurrentUser(){
        String token = null;
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            token = request.getHeader("token");
            if(StrUtil.isBlank(token)){
                token = request.getParameter("token");
            }
            if(StrUtil.isBlank(token)){
                log.error("获取当前登录的token失败",token);
                return null;
            }
            String userId = JWT.decode(token).getAudience().get(0);
            return staticUserService.getUserById(userId);
        }
        catch (Exception e){
            log.error("获取当前登录的token失败",token,e);
            return null;
        }
    }
}
