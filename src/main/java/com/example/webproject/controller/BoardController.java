package com.example.webproject.controller;

import com.example.webproject.dto.BoardDto;
import com.example.webproject.entity.Board;
import com.example.webproject.entity.Member;
import com.example.webproject.service.BoardService;
import com.example.webproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/BoardList")
public class BoardController {

    private final BoardService boardService;
    private final MemberService memberService;

    @Autowired
    public BoardController(BoardService boardService, MemberService memberService) {
        this.boardService = boardService;
        this.memberService = memberService;
    }

    @GetMapping()
    public String viewList(Model model) {
        List<Board> boardList = boardService.getBoardList();

        model.addAttribute("boardList", boardList);

        return "view/Board/BoardList";
    }

    @GetMapping("/addBoard")
    public String showAddBoard(Model model) {
        model.addAttribute("board", new BoardDto());
        return "view/Board/BoardAdd";
    }

    @PostMapping("/addBoard")
    public String addBoard(@ModelAttribute BoardDto boardDto, Principal principal) {
        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());

        Member member = memberService.getMember(principal.getName());
        board.setMemberId(member);

        boardService.saveBoard(board);

        return "redirect:/BoardList";
    }

    @GetMapping("viewBoard/{id}")
    public String showBoard(@PathVariable("id") Long BoardId, Model model) {
        Board board = boardService.getBoard(BoardId);

        model.addAttribute("board", board);

        return "view/Board/BoardView";
    }

    @GetMapping("/editBoard/{id}")
    public String showEditBoard(@PathVariable("id") Long BoardId, Model model) {
        Board board = boardService.getBoard(BoardId);

        model.addAttribute("board", board);

        return "view/Board/BoardEdit";
    }

    @PostMapping("/editBoard/{id}")
    public String editBoard(@PathVariable("id") Long BoardId, @ModelAttribute BoardDto boardDto) {
        boardService.changeBoard(BoardId, boardDto);

        return "redirect:/BoardList";
    }
}
