package cn.figo.service.controller;

import cn.figo.service.pojo.User;
import cn.figo.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Figo
 * @Date 2020/1/18 22:46
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User queryUserById(@PathVariable("id") Long id){
        return this.userService.queryUserById(id);
    }
}
