package com.example.demo.Controller;

import com.example.demo.Auth.NoAuth;
import com.example.demo.Auth.RedisTokenManager;
import com.example.demo.help.Response;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private RedisTokenManager tokenManager;

    @NoAuth
    @GetMapping("/login")
    public String login(HttpServletRequest request){
        /*String username = MapUtils.getString(params,"username");
        String password = MapUtils.getString(params,"password");
        if("admin".equals(username) && "123456".equals(password)){
            return Response.successMsg(tokenManager.createToken(username));
        }else{
            return Response.error("用户名或密码错误");
        }*/
        return "login";
    }

    @NoAuth
    @ResponseBody
    @GetMapping("/authenticate")
    public Response authenticate(@RequestParam Map<String,Object> params){
        String username = MapUtils.getString(params,"username");
        String password = MapUtils.getString(params,"password");
        if("admin".equals(username) && "123456".equals(password)){
            return Response.successMsg(tokenManager.createToken(username));
        }else{
            return Response.error("用户名或密码错误");
        }
    }
}
