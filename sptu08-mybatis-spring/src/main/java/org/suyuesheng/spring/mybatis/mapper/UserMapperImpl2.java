package org.suyuesheng.spring.mybatis.mapper;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.suyuesheng.spring.mybatis.pojo.User;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
    @Override
    public List<User> findAll() {
        return getSqlSession().getMapper(UserMapper.class).findAll();
    }
}
