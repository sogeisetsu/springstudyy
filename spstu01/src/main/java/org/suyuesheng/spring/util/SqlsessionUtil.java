package org.suyuesheng.spring.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class SqlsessionUtil {
    private static SqlSessionFactory factory;
    static{
        InputStream resourceAsStream = SqlsessionUtil.class.getResourceAsStream("/mybatis.config.xml");
        factory=new SqlSessionFactoryBuilder().build(resourceAsStream);
    }
    public static SqlSession getSqlsession(){
        return factory.openSession(true);
    }
}
