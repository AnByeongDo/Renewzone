package com.example.app4.service;

import com.example.app4.dto.OrderDTO;
import com.example.app4.entity.OrderEntity;
import com.example.app4.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public void save(OrderDTO orderDTO){
        OrderEntity orderEntity = OrderEntity.toOrderEntity(orderDTO);
        orderRepository.save(orderEntity);
    }

    public List<OrderDTO> findAll() {
        List<OrderEntity> orderEntityList = orderRepository.findAll();
        List<OrderDTO> orderDTOList = new ArrayList<>();

        for (OrderEntity orderEntity: orderEntityList){
            orderDTOList.add(OrderDTO.toOrderDTO(orderEntity));
        }
        return orderDTOList;
    }
}
