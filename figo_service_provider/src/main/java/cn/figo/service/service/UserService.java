package cn.figo.service.service;

import cn.figo.service.mapper.UserMapper;
import cn.figo.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Figo
 * @Date 2020/1/18 22:44
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUserById(Long id){
        return this.userMapper.selectByPrimaryKey(id);
    }
}
