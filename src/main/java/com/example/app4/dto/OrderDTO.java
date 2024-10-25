package com.example.app4.dto;

import com.example.app4.entity.OrderEntity;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private String orderName;
    private String orderCode;
    private String orderAddr1;
    private String orderAddr2;
    private String orderPhone;
    private int goodsId;
    private String storedFileName;
    private String goodsName;
    private LocalDateTime orderCreatedTime;
    private LocalDateTime orderUpdatedTime;

    public static OrderDTO toOrderDTO(OrderEntity orderEntity){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(orderEntity.getId());
        orderDTO.setOrderCode(orderEntity.getOrderCode());
        orderDTO.setOrderAddr1(orderEntity.getOrderAddr1());
        orderDTO.setOrderAddr2(orderEntity.getOrderAddr2());
        orderDTO.setOrderName(orderEntity.getOrderName());
        orderDTO.setOrderPhone(orderEntity.getOrderPhone());
        orderDTO.setGoodsId(orderEntity.getGoodsId());
        orderDTO.setGoodsName(orderEntity.getGoodsName());
        orderDTO.setStoredFileName(orderEntity.getStoredFileName());
        orderDTO.setOrderCreatedTime(orderEntity.getCreatedTime());
        orderDTO.setOrderUpdatedTime(orderEntity.getUpdatedTime());
        return orderDTO;

    }
}
