package org.suyuesheng.spring06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.suyuesheng.spring06.pojo.Person;

@Configuration
public class AppConfig2 {

    @Bean({"person","Person"})
    public Person getPerson(){
        return new Person();
    }
}
