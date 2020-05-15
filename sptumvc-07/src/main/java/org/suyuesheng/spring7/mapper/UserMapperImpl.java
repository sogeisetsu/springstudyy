package org.suyuesheng.spring7.mapper;

import org.apache.ibatis.session.SqlSession;
import org.suyuesheng.spring7.pojo.User;

import java.util.List;

public class UserMapperImpl implements UserMapper{
    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> findAll() {
        return sqlSession.getMapper(UserMapper.class).findAll();
    }

    @Override
    public User findById(int id) {
        return sqlSession.getMapper(UserMapper.class).findById(id);
    }

    @Override
    public boolean insert(User user) {
        return sqlSession.getMapper(UserMapper.class).insert(user);
    }
}
