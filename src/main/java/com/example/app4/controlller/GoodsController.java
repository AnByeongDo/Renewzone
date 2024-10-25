package com.example.app4.controlller;

import com.example.app4.dto.GoodsDTO;
import com.example.app4.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class GoodsController {
    private final GoodsService goodsService;
    @GetMapping("/goods/list")
    public String list(Model model){
        List<GoodsDTO> goodsDTOList = goodsService.findAll();
        model.addAttribute("goodsList",goodsDTOList);
        return "/goods/list";
    }

}
