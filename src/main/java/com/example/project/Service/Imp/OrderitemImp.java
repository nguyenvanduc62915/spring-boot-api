package com.example.project.Service.Imp;

import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.OrderItemDTO;

import java.util.List;

public interface OrderitemImp {
    BaseResponse<List<OrderItemDTO>> getAllOrderItem();
    BaseResponse<OrderItemDTO> getOrderItemById(Long orderItemId);
    BaseResponse<OrderItemDTO> addOrderItem(OrderItemDTO orderItemDTO, Long orderId);
    BaseResponse<OrderItemDTO> updateOrderItem(OrderItemDTO orderItemDTO, Long orderItemId);
    BaseResponse<OrderItemDTO> deleteOrderItem(Long orderItemId);
}
