package com.kyhslam.myweb.controller;

import com.kyhslam.myweb.model.Board;
import com.kyhslam.myweb.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardApiController {

    private final BoardRepository boardRepository;

    @GetMapping("/boards")
    public List<Board> all(@RequestParam(required = false) String title) {
        if (StringUtils.isEmpty(title)) {
            return boardRepository.findAll();
        } else {
            return boardRepository.findByTitle(title);
        }
    }

    @PostMapping("/boards")
    public Board newBoard(@RequestBody Board newBoard) {
        return boardRepository.save(newBoard);
    }

    @GetMapping("/boards/{id}")
    public Board one(@PathVariable Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    @PutMapping("/boards/{id}")
    public Board replaceBoard(@RequestBody Board newBoard, @PathVariable Long id) {
        return boardRepository.findById(id)
                .map(board -> {
                    board.setTitle(newBoard.getTitle());
                    board.setContent(newBoard.getContent());
                    return boardRepository.save(board);
                })
                .orElseGet(() -> {
                   newBoard.setId(id);
                    return boardRepository.save(newBoard);
                });
    }
}
