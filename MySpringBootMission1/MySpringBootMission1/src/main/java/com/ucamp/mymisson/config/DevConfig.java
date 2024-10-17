package com.ucamp.mymisson.config;

import com.ucamp.mymisson.config.environment.MyEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *  1-6 2). DevConfig 클래스
 * @Profile("test") 와 @Configuration 어노테이션 사용
 * MyEnvironment를 SpringBean으로 생성하고 mode값을 "개발환경" 으로 설정한다.
 */
@Profile("test")
@Configuration
public class DevConfig {
    @Bean
    public MyEnvironment getMyEnvironment(){
        return  MyEnvironment.builder()
                .mode("개발환경")
                .build();
    }
}
