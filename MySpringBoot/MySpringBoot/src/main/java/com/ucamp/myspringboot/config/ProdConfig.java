package com.ucamp.myspringboot.config;

import com.ucamp.myspringboot.config.vo.CustomVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class ProdConfig {
    @Bean
    public CustomVO customVO(){
        return  CustomVO.builder()  // CustomVOBuilder
                .mode("Prod 환경")
                .rate(1.12)
                .build(); // CustomVOBuilder -> CustomVO
        
    }
}

