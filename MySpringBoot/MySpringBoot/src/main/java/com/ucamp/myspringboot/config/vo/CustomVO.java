package com.ucamp.myspringboot.config.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class CustomVO {
    private String mode;
    private Double rate;
}
