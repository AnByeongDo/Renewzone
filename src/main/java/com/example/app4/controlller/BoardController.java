package com.example.app4.controlller;


import com.example.app4.dto.BoardDTO;
import com.example.app4.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/board/list")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList",boardDTOList);
        return "/board/list";
    }
    @GetMapping("/board/write")
    public String boardwrite(){
        return "/board/write";
    }

    @GetMapping("/board/view/{id}")
    public String findById(@PathVariable Long id, Model model){
        //1. 조회수 업데이트
        boardService.updateHits(id);
        //2. 해당 id를 가져와서 dto 담으면 됨
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board",boardDTO);
        return "/board/view";
    }

    @PostMapping("/board/save")
    public String boardsave(@ModelAttribute BoardDTO boardDTO){
        System.out.println("boardDTO = " + boardDTO);
        boardService.save(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping("/board/edit/{id}")
    public String updateForm(@PathVariable Long id,Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("boardUpdate",boardDTO);
        return "/board/update";
    }

    @PostMapping("/board/update")
    public String update(@ModelAttribute BoardDTO boardDTO,Model model){
        BoardDTO board = boardService.update(boardDTO);
        model.addAttribute("board",board);
        return "/board/view";
    }

    @GetMapping("/board/delete/{id}")
    public String delete(@PathVariable Long id){
        boardService.delete(id);
        return "redirect:/board/list";
    }
}
