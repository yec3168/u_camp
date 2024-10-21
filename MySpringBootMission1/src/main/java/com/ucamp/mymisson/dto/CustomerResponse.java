package com.ucamp.mymisson.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerResponse {

    private Long id;
    private int age;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm E a", timezone = "Asia/Seoul")
    private LocalDateTime entryDate;
}
