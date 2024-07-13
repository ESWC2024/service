package com.example.eswc.service;

import com.example.eswc.model.MissingPerson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AIService {

    public String findMissingPersonByImage(byte[] imageBytes) {
    // TODO: AI 모델을 사용하여 이미지에서 실종자를 찾는 로직 구현
    // 예시로 단순 문자열 반환
    return "AI 기반으로 실종자를 찾았습니다!";
}

}