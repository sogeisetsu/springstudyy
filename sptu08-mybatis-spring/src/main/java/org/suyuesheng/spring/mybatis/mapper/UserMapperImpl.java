package org.suyuesheng.spring.mybatis.mapper;

import org.apache.ibatis.session.SqlSession;
import org.suyuesheng.spring.mybatis.pojo.User;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> findAll() {
        return sqlSession.getMapper(UserMapper.class).findAll();
    }
}
