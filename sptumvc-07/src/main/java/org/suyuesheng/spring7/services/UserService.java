package org.suyuesheng.spring7.services;


import org.suyuesheng.spring7.mapper.UserMapper;
import org.suyuesheng.spring7.pojo.User;

import java.util.List;


public class UserService {
    public UserService() {
    }

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User findById(Integer id){
        if(id!=null){
            return userMapper.findById(id);
        }
        System.out.println("没有查询到相关id，请检查id");
        return null;
    }

    public boolean insertUser(User user){
        if (user.getuId()==null||findById(user.getuId())==null) {
            return userMapper.insert(user);
        }else {
            return false;
        }
    }


}
