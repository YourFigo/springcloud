package cn.figo.service.client;

import cn.figo.service.configuration.FeignLogConfiguration;
import cn.figo.service.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign客户端接口
 * @Author Figo
 * @Date 2020/2/4 20:33
 */
@FeignClient(value = "service-provider", fallback = UserClientFallback.class, configuration = FeignLogConfiguration.class)
public interface UserClient {

    @GetMapping("user/{id}")  //最好不要在类上使用RequestMapping注解，而是在每个方法前拼接全局路径
    public User queryUserById(@PathVariable("id") Long id);
}
