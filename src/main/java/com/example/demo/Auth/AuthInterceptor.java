package com.example.demo.Auth;

import com.example.demo.help.Response;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RedisTokenManager tokenManager;

    @Value("${spring.jwt.secret}")
    private String jwtSecret;

    @Value("${spring.jwt.authorization}")
    private String access_token;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String requestPath = request.getRequestURI().substring(request.getContextPath().length());
        //不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        //如果方法注明了NoAuth,则不需要登录token验证
        if(method.getAnnotation(NoAuth.class)!=null){
            return true;
        }

        //从header得到token
        String authorization;
        Map map = request.getParameterMap();
        //System.out.println(authorization);
        Set<String> keySet = map.keySet();
        List<String> res = new LinkedList<>();
       // System.out.println(keySet);
        for(String key:keySet){
            if("access_token".equals(key)){
                String[] values = (String[])map.get(key);
                res.add(values[0]);
            }
        }
        authorization = res.get(0);
        //验证token
        if(StringUtils.isBlank(authorization)){
            response.getWriter().write(JSONObject.toJSONString(Response.error("未提供有效token!")));
            return false;
        }
        try{
            Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authorization).getBody();
            String userId = claims.getId();
            TokenModel model = new TokenModel(userId,authorization);
            if(tokenManager.checkToken(model)){
                return true;
            }else{
                response.getWriter().write(JSONObject.toJSONString(Response.error("未提供有效token!")));
                return false;
            }
        }catch (Exception e){
            response.getWriter().write(JSONObject.toJSONString(Response.error("校验Token发生异常!")));
            return false;
        }
    }

    /*private String getAccess(Map map){
        Set<String> keySet = map.keySet();
        for(String key:keySet){
            if("access_token".equals(key)){
                String[] values = (String[])map.get(key);
                for(String value:values){
                     retur value;
                }
            }
        }
    }*/

}
