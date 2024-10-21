package com.ucamp.myspringboot.dto.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserReqUpdateForm {
    private Long id;

    // " "(공백) 은 허용
    @NotEmpty(message = "이름은 필수 입력항목입니다.")
    private String name;

    // 공백은 제거하고 체크하므로 " "를 허용하지 않음.
    @NotBlank(message = "이메일은 필수 입력항목입니다.")
    @Email(message = "이메일형식으로 넣어라")
    private String email;
}
