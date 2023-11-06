package com.example.boards.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id가 생성될때마다 1씩 증가한값이 나옴
    private Long id; // id

    private String title; // 제목
    private String userName; // 작성자명
    private String password; // 비밀번호
    private String content; // 내용

    @Builder
    public Board (String title, String userName, String password, String content) {
        this.title = title;
        this.userName = userName;
        this.password = password;
        this.content = content;
    }

    public void update (String title, String userName, String content) {
        this.title = title;
        this.userName = userName;
        this.content = content;
    }
}
