package com.shopingmall.seungjae.controller.Member;

import lombok.Data;

@Data
public class LoginForm {
    private String loginId;
    private String password;

    private String loginError;
}
