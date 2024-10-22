package com.ucamp.mymisson.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerReqForm {
    private Long id;

    @NotBlank(message = "나이는 필수입력값입니다.")
    @Min(message = "나이는 10세이상이어야합니다.", value = 10)
    private String age;
    //private String name;

    @NotBlank(message = "이메일은 필수입력값입니다.")
    @Email
    private String email;
}
