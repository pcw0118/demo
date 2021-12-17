package com.example.demo.Auth;

import com.example.demo.Service.RedisService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class RedisTokenManager {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private RedisService redisService;

    @Value("${spring.jwt.secret}")
    private String jwtSecret;

    @Value("${spring.jwt.expire}")
    private Long expireTime;

    @Value("${spring.jwt.authorization}")
    private String access_token;

    public String createToken(String userId){
        String token = Jwts.builder().setId(userId).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,jwtSecret).compact();
       // System.out.println("create"+token);
        redisService.set(access_token+":"+userId,token,expireTime, TimeUnit.SECONDS);
       // System.out.println("created!");
        return token;
    }

    public boolean checkToken(TokenModel model){
        if(model == null){
            return false;
        }
        String token = redisService.get(access_token+":"+model.getUserID());
        if(token == null || !token.equals(model.getAuthorization())){
            return false;
        }
        redisService.expire(access_token+":"+model.getUserID(),expireTime,TimeUnit.SECONDS);
        return true;
    }

    public void deleteToken(String userId){
        redisService.delete(access_token+":"+userId);
    }
}
