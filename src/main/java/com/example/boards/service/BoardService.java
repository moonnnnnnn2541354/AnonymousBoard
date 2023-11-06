package com.example.boards.service;

import com.example.boards.dto.BoardRequestDeleteDto;
import com.example.boards.dto.BoardRequestDto;
import com.example.boards.dto.BoardResponseDto;
import com.example.boards.entity.Board;
import com.example.boards.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {
        // RequestDto -> Entity
        Board board = Board.builder().title(boardRequestDto.getTitle())
                .userName(boardRequestDto.getUserName())
                .password(boardRequestDto.getPassword())
                .content(boardRequestDto.getContent())
                .build();

        // Entity -> Repository 저장
        Board saveBoard = boardRepository.save(board);
        // 저장후 ResponseDto
        return BoardResponseDto.of(saveBoard);
    }

    public BoardResponseDto getBoard(Long id) {
        // id값으로 repository에서 해당 id값 데이터 추출
        Board board = boardRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시물은 존재하지 않습니다."));

        // entity -> ResponseDto
        return BoardResponseDto.of(board);
    }


    public List<BoardResponseDto> getBoardList() {
        // repository의 모든 Board를 불러오기
        List<Board> boardList = boardRepository.findAllByOrderByCreatedAtDesc();
        // 이를 List인 ResponseDto로 변환해준다
        List<BoardResponseDto> list = new ArrayList<>();
        for (Board board : boardList) {
            list.add(BoardResponseDto.of(board));
        }
        return list;
//        return boardRepository.findAll().stream()
//                .map(BoardResponseDto::of)
//                .collect(Collectors.toList());
    }

    @Transactional
    public BoardResponseDto updateBoard(Long id, BoardRequestDto boardRequestDto) {
        // boardRepository에서 id값의 자료 찾기
        Board board = boardRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시물은 존재하지 않습니다."));
        // boardRepository와 boardRequestDto의 password가 같은가? 다른가?
        if (board.getPassword().equals(boardRequestDto.getPassword())) {
            // 같으면 update
            board.update(boardRequestDto.getTitle(),boardRequestDto.getUserName(),boardRequestDto.getContent());
            return BoardResponseDto.of(board);
        } else {
            // 다르면 문구 출력
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }


    public void deleteBoard(Long id, BoardRequestDeleteDto boardRequestDeleteDto) {
        // boardRepository에서 id값의 자료 찾기
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물은 존재하지 않습니다."));
        if (board.getPassword().equals(boardRequestDeleteDto.getPassword())){
            // 같으면 remove
            boardRepository.delete(board);
        } else {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // boardRepository와 boardRequestDto의 password가 같은가? 다른가?
    }
}
