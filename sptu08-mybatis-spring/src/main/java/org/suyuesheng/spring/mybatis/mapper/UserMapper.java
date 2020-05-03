package org.suyuesheng.spring.mybatis.mapper;

import org.suyuesheng.spring.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> findAll();
}
