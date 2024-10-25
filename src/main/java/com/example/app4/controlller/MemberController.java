package com.example.app4.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/join")
    public String join() {
        return "/member/join";
    }

    @GetMapping("/login")
    public String login() {
        return "/member/login";
    }
}
