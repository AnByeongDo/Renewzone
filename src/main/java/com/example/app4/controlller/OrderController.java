package com.example.app4.controlller;

import com.example.app4.dto.GoodsDTO;
import com.example.app4.dto.OrderDTO;
import com.example.app4.entity.OrderEntity;
import com.example.app4.service.GoodsService;
import com.example.app4.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class OrderController {
    private final GoodsService goodsService;
    private final OrderService orderService;
    @GetMapping("/order/order/{id}")
    public String order(@PathVariable Long id, Model model){
        GoodsDTO goodsDTO = goodsService.findById(id);
        model.addAttribute("goods",goodsDTO);
        return "/order/order";
    }
    @PostMapping("/order/save")
    public String save(@ModelAttribute OrderDTO orderDTO){
        orderService.save(orderDTO);
        return null;
    }
}
