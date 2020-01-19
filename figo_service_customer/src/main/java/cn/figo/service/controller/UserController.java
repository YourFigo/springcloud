package cn.figo.service.controller;

import cn.figo.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author Figo
 * @Date 2020/1/18 22:53
 */
@Controller
@RequestMapping("customer/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    // 拉去服务提供方的所有服务列表
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping
    @ResponseBody
    private User queryUserById(@RequestParam("id") Long id){
        List<ServiceInstance> instances = discoveryClient.getInstances("service_provider");
        ServiceInstance serviceInstance = instances.get(0);
        return this.restTemplate.getForObject("http://" + serviceInstance.getHost() +":"+serviceInstance.getPort()+"/user/" + id, User.class);
//        return this.restTemplate.getForObject("http://localhost:8081/user/" + id, User.class);
    }
}
