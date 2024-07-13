package com.example.eswc.service;

import com.example.eswc.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public void signup(User user) {
        // 회원가입 로직
    }

    public String login(String username, String password) {
        // 로그인 로직, 성공 시 토큰 반환
        return "some-token"; // 실제로는 토큰 생성 로직이 필요함
    }

    public boolean changePassword(String username, String oldPassword, String newPassword) {
        // 비밀번호 변경 로직
        return true; // 실제로는 비밀번호 변경 성공 여부 반환
    }
}
