package com.ucamp.myspringboot.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
/**
 * properties 파일안에 있는 key값 중 'myboot'로 시작한 값들을 가져옴.
 */
@ConfigurationProperties("myboot")
@Getter @Setter
public class MyBootProperties {
    private String name;
    private int age;
    private String fullName;
}
