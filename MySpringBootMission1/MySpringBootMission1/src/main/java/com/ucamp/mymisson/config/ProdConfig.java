package com.ucamp.mymisson.config;

import com.ucamp.mymisson.config.environment.MyEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 1-6 1). ProdConfig 클래스
 * @Profile("prod") 와 @Configuration 어노테이션 사용
 * MyEnvironment를 SpringBean으로 생성하고 mode값을 "운영환경" 으로 설정한다.
 */
@Profile("prod")
@Configuration
public class ProdConfig {

    @Bean
   public MyEnvironment getMyEnvironment(){
       return  MyEnvironment.builder()
               .mode("운영환경")
               .build();
   }
}
