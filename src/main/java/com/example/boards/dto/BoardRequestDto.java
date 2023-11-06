package com.example.boards.dto;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String title; // 제목
    private String userName; // 작성자명
    private String password; // 비밀번호
    private String content; // 내용
}
