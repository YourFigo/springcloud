package cn.figo.service.client;

import cn.figo.service.pojo.User;
import org.springframework.stereotype.Component;

/**
 * Hystrix熔断器实现类
 * @Author Figo
 * @Date 2020/2/4 20:56
 */
@Component
public class UserClientFallback implements UserClient {

    @Override
    public User queryUserById(Long id) {
        User user = new User();
        user.setUsername("服务器繁忙，请稍后再试！");
        return user;
    }
}
