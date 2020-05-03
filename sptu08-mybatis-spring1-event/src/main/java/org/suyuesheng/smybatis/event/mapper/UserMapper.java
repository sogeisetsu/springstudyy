package org.suyuesheng.smybatis.event.mapper;

import org.apache.ibatis.annotations.Param;
import org.suyuesheng.smybatis.event.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> findAll();

    List<User> findById(@Param("id") int id);

    boolean insert(User user);

    boolean deleteById(@Param("id") int id);
}
