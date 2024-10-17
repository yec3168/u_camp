package com.ucamp.mymisson.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("myprop")
@Getter @Setter
public class MyPropsProperties {
    //1-5 application.properties에 있는 환경변수를 저장하고 조회하는 Properties 클래스 작성하기
    private String username;
    private int port;
}
