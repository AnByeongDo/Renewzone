package com.example.app4.entity;

import com.example.app4.dto.OrderDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "order_table")
public class OrderEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String orderName;
    @Column
    private String orderCode;
    @Column
    private String orderAddr1;
    @Column
    private String orderAddr2;
    @Column
    private String orderPhone;
    @Column
    private int goodsId;
    @Column
    private String goodsName;
    @Column
    private String storedFileName;

    public static OrderEntity toOrderEntity(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderCode(orderDTO.getOrderCode());
        orderEntity.setOrderName(orderDTO.getOrderName());
        orderEntity.setOrderAddr1(orderDTO.getOrderAddr1());
        orderEntity.setOrderAddr2(orderDTO.getOrderAddr2());
        orderEntity.setOrderPhone(orderDTO.getOrderPhone());
        orderEntity.setGoodsName(orderDTO.getGoodsName());
        orderEntity.setOrderName(orderDTO.getOrderName());
        orderEntity.setGoodsId(orderDTO.getGoodsId());
        orderEntity.setStoredFileName(orderDTO.getStoredFileName());
        return orderEntity;
    }


}
