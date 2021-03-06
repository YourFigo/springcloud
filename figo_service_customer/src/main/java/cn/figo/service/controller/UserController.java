package cn.figo.service.controller;

import cn.figo.service.client.UserClient;
import cn.figo.service.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
//@DefaultProperties(defaultFallback = "fallBackMethod")
public class UserController {

/*    @Autowired
    private RestTemplate restTemplate;*/

    // 拉取服务提供方的所有服务列表
//    @Autowired
//    private DiscoveryClient discoveryClient;


    @Autowired
    private UserClient userClient;

    @GetMapping
    @ResponseBody
    public User queryUserById(@RequestParam("id") Long id){
//        List<ServiceInstance> instances = discoveryClient.getInstances("service_provider");
//        ServiceInstance serviceInstance = instances.get(0);
//        return this.restTemplate.getForObject("http://" + serviceInstance.getHost() +":"+serviceInstance.getPort()+"/user/" + id, User.class);

//        开启@LoadBalanced后，不能直接访问提供方的具体主机名和端口号，否则报错 java.lang.IllegalStateException: No instances available for localhost
//        服务名不要使用下划线，否则报错 Request URI does not contain a valid hostname: http://service_provider/user/42

/*        if (id == 1){
            throw new RuntimeException();
        }*/
//        String user = this.restTemplate.getForObject("http://service-provider/user/" + id, String.class);

        return this.userClient.queryUserById(id);
    }

/*    // 服务降级逻辑
    public String queryUserByIdFallback(Long id){
        return "服务器正忙，请稍后再试";
    }

    public String fallBackMethod(){
        return "服务器正忙，请稍后再试";
    }*/
}
