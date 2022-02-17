package com.kyhslam.myweb.controller;

import com.kyhslam.myweb.model.Board;
import com.kyhslam.myweb.repository.BoardRepository;
import com.kyhslam.myweb.validator.BoardValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;

    private final BoardValidator boardValidator;

    @GetMapping("/list")
    public String list(Model model) {
        System.out.println("list ## ");
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id) {
        System.out.println("id = " + id);
        if (id == null) {
            model.addAttribute("board", new Board());
        } else {
            Board board = boardRepository.findById(id).orElse(null);
            model.addAttribute("board", board);
        }

        return "board/form";
    }

    @PostMapping("/form")
    public String greetingSubmit(@Valid Board board, BindingResult bindingResult) {

        boardValidator.validate(board, bindingResult);

        if (bindingResult.hasErrors()) {
            return "board/form";
        }
        System.out.println("greetingSubmit = " + board);

        boardRepository.save(board);
        return "redirect:/board/list";
    }
}
