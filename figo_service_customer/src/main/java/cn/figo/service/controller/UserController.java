package cn.figo.service.controller;

import cn.figo.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Figo
 * @Date 2020/1/18 22:53
 */
@Controller
@RequestMapping("customer/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    @ResponseBody
    private User queryUserById(@RequestParam("id") Long id){
        return this.restTemplate.getForObject("http://localhost:8081/user/" + id, User.class);
    }
}
