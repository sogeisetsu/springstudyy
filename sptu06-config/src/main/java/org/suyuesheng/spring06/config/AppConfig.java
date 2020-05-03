package org.suyuesheng.spring06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.suyuesheng.spring06.pojo.User;

//@Configuration注解，表明这是一个配置spring容器的类，相当于Beans.xml
@Configuration
//@ComponentScan 为@Component指定范围，如果不指定范围，默认是全部，相当于<context:component-scan base-package="扫描的包“/>标签
@ComponentScan("org.suyuesheng.spring06.pojo")
//相当于import标签
@Import(AppConfig2.class)
public class AppConfig {
    //@Bean相当于<bean>标签，默认bean的id是方法名，也可以指定别名通过name={}。指定别名后，方法名就不好使了。方法的返回值相当于bean标签的class
    @Bean({"user","User","getUser"})
    public User getUser(){
        return new User();
    }
}
