package org.suyuesheng.spring7.mapper;

import org.apache.ibatis.annotations.Param;
import org.suyuesheng.spring7.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();

    User findById(@Param("uId") int id);

    boolean insert(User user);

    boolean updateActive(@Param("code") String code);

    User findByCode(@Param("code") String code);

    User findByName(@Param("username") String username);
}
