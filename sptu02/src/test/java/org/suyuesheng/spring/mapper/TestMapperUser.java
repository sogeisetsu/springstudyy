package org.suyuesheng.spring.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.suyuesheng.spring.util.SqlsessionUtil;

public class TestMapperUser {
    @Test
    public void testFind(){
        SqlSession sqlsession = SqlsessionUtil.getSqlsession();
        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        userMapper.findAll().forEach(System.out::println);

        sqlsession.close();
    }

    @Test
    public void testFindById(){
        SqlSession sqlsession = SqlsessionUtil.getSqlsession();
        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        try {
            System.out.println(userMapper.findById(2).size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(userMapper.findAll());
        sqlsession.close();
    }
}
