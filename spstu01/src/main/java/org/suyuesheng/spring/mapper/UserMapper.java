package org.suyuesheng.spring.mapper;

import org.apache.ibatis.annotations.Param;
import org.suyuesheng.spring.pojo.User;

import java.util.List;

public interface  UserMapper {

    public List<User> findAll();

    List<User> findById(@Param("id") int id) throws Exception;
}
