package com.example.app4.controlller;

import com.example.app4.dto.AdminDTO;
import com.example.app4.dto.GoodsDTO;
import com.example.app4.dto.OrderDTO;
import com.example.app4.service.AdminService;
import com.example.app4.service.GoodsService;
import com.example.app4.service.OrderService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final GoodsService goodsService;
    private final OrderService orderService;

    @GetMapping("/admin/")
    public String admin(){
        return "/admin/login";
    }

    @GetMapping("/admin/join")
    public String join(){
        return  "/admin/join";
    }

    @PostMapping("/admin/join")
    public String joinok(@ModelAttribute AdminDTO adminDTO){
        System.out.println("adminDTO = " + adminDTO);
        adminService.save(adminDTO);
        return "/admin/login";
    }

    @PostMapping("/admin/save")
    public String save(@ModelAttribute AdminDTO adminDTO, HttpSession session){
        AdminDTO loginResult = adminService.login(adminDTO);
        if (loginResult != null){
            //로그인성공
            session.setAttribute("admId", loginResult.getAdmId());
            session.setAttribute("admName",loginResult.getAdmName());
            session.setMaxInactiveInterval(60 * 30);

            return "redirect:/admin/main";
        } else {
            return "/admin/login";
        }
    }
    @GetMapping("/admin/main")
    public String main(Model model){
        List<AdminDTO> adminDTOList = adminService.findAll();
        model.addAttribute("admin", adminDTOList);
        return "/admin/main";
    }

    @GetMapping("/admin/goodsWrite")
    public String goodsWrite(){
        return "/admin/goodsWrite";

    }
    @PostMapping("/admin/goodsSave")
    public String goodsSave(@ModelAttribute GoodsDTO goodsDTO) throws IOException {
        goodsService.save(goodsDTO);
        return null;
    }
    @GetMapping("/admin/order")
    public String order(Model model){
        List<OrderDTO> orderDTOList = orderService.findAll();
        model.addAttribute("orderList", orderDTOList);
        return "/admin/order";

    }
}
