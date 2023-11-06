package com.example.boards.dto;

import com.example.boards.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private Long id; // ID
    private String title; // 제목
    private String userName; // 작성자명
    private String content; // 내용


    @Builder
    public BoardResponseDto(Long id, String title, String userName, String content) {
        this.id = id;
        this.title = title;
        this.userName = userName;
        this.content = content;
    }

    public static BoardResponseDto of (Board board) { // Board -> BoardResponseDto 로 정의
        return BoardResponseDto.builder().id(board.getId())
                                         .title(board.getTitle())
                                         .userName(board.getUserName())
                                         .content(board.getContent())
                                         .build();
    }
}
