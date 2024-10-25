package com.example.app4.controlller;

import com.example.app4.dto.GoodsDTO;
import com.example.app4.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {
    private final GoodsService goodsService;
    @GetMapping("/")
    public String index(Model model){
        List<GoodsDTO> goodsDTOList = goodsService.findAll();
        model.addAttribute("goodsList",goodsDTOList);
        return "index";
    }

    @GetMapping("/goods/view/{id}")
    public String findById(@PathVariable Long id,Model model){
        //goodsService.updateHits(id);
        GoodsDTO goodsDTO = goodsService.findById(id);
        model.addAttribute("goods",goodsDTO);
        return "/goods/view";
    }
}
