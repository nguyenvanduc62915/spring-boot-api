package com.example.project.Service.Imp;

import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.CategoryDTO;
import com.example.project.DTO.OrderDTO;

import java.util.List;

public interface OrderImp {
    BaseResponse<List<OrderDTO>> getAllOrder();
    BaseResponse<OrderDTO> getOrderById(Long orderId);
    BaseResponse<OrderDTO> addOrder(OrderDTO orderDTO);
    BaseResponse<OrderDTO> updateOrder(Long orderId, OrderDTO orderDTO);
    BaseResponse<OrderDTO> deleteOrderById(Long orderId);
}
