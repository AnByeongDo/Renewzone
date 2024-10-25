package com.example.app4.controlller;

import com.example.app4.dto.NoticeDTO;
import com.example.app4.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    // private final NoticeService noticeService;
    @GetMapping("/notice/list")
    public String findAll(Model model){
       List<NoticeDTO> noticeDTOList = noticeService.findAll();
       model.addAttribute("noticeList",noticeDTOList);
        return "/notice/list";
    }
    @GetMapping("/notice/write")
    public String noticewrite(){
        return "/notice/write";
    }

    @PostMapping("/notice/save")
    public String noticesave(@ModelAttribute NoticeDTO noticeDTO){
        System.out.println("noticeDTO = " + noticeDTO);
        noticeService.save(noticeDTO);
        return "redirect:/notice/list";
    }
}
