package com.example.project.Service.Imp;

import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.OrderItemDTO;

import java.util.List;

public interface OrderitemImp {
    BaseResponse<List<OrderItemDTO>> getAllOrderItem();
    BaseResponse<OrderItemDTO> getOrderItemById(Long orderItemId);
    BaseResponse<OrderItemDTO> addOrderItem(OrderItemDTO orderItemDTO);
    BaseResponse<OrderItemDTO> updateOrderItem(OrderItemDTO orderItemDTO, Long orderItem);
    BaseResponse<OrderItemDTO> deleteOrderItem(Long orderItemId);
}
