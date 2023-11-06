package com.example.boards.controller;


import com.example.boards.dto.BoardRequestDeleteDto;
import com.example.boards.dto.BoardRequestDto;
import com.example.boards.dto.BoardResponseDto;
import com.example.boards.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/board/create")
    public BoardResponseDto createBoard (@RequestBody BoardRequestDto boardRequestDto){
        return boardService.createBoard(boardRequestDto);
    }

    @GetMapping("/board/{id}")
    public BoardResponseDto getBoard (@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    @GetMapping("/board/list")
    public List<BoardResponseDto> getBoardList() {
        return boardService.getBoardList();
    }

    @PutMapping("/board/{id}")
    public BoardResponseDto updateBoard (@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto) {
        return boardService.updateBoard(id, boardRequestDto);
    }

    @DeleteMapping("/board/{id}")
    public void deleteBoard(@PathVariable Long id,@RequestBody BoardRequestDeleteDto boardRequestDeleteDto) {
        boardService.deleteBoard(id,boardRequestDeleteDto);
    }

}
