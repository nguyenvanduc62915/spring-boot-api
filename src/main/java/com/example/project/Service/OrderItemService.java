package com.example.project.Service;

import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.OrderDTO;
import com.example.project.DTO.OrderItemDTO;
import com.example.project.Entity.OrderItem;
import com.example.project.Repository.OrderItemRepository;
import com.example.project.Service.Imp.OrderitemImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService implements OrderitemImp {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public BaseResponse<List<OrderItemDTO>> getAllOrderItem() {
        BaseResponse<List<OrderItemDTO>> baseResponse = new BaseResponse<>();
        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();
        try {
            List<OrderItem> orderItemList = orderItemRepository.findAll();
            if (orderItemList.isEmpty() || orderItemList == null){
                baseResponse.setMessage("Không tồn tại");
                baseResponse.setCode(404);
                return baseResponse;
            }
            for (OrderItem orderItem : orderItemList){
                OrderItemDTO orderItemDTO = new OrderItemDTO();
                orderItemDTO.setOrderItemId(orderItem.getOrderItemId());
                orderItemDTO.setQuantity(orderItem.getQuantity());
                orderItemDTO.setCreatedAt(orderItem.getCreatedAt());
                orderItemDTO.setPrice(orderItem.getPrice());
                orderItemDTO.setUpdatedAt(orderItem.getUpdatedAt());
                orderItemDTOList.add(orderItemDTO);
            }
            baseResponse.setData(orderItemDTOList);
            baseResponse.setMessage("Thêm thành công");
            baseResponse.setCode(200);
        } catch (Exception ex) {
            baseResponse.setMessage("Lỗi trong quá trình tìm " + ex.getMessage());
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<OrderItemDTO> getOrderItemById(Long orderItemId) {
        BaseResponse<OrderItemDTO> baseResponse = new BaseResponse<>();
        try{
            OrderItem orderItem = orderItemRepository.findOrderItemById(orderItemId);
            if (orderItem == null){
                baseResponse.setMessage("Id không tồn tại");
                baseResponse.setCode(404);
                return baseResponse;
            }
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setOrderItemId(orderItem.getOrderItemId());
            orderItemDTO.setQuantity(orderItem.getQuantity());
            orderItemDTO.setCreatedAt(orderItem.getCreatedAt());
            orderItemDTO.setPrice(orderItem.getPrice());
            orderItemDTO.setUpdatedAt(orderItem.getUpdatedAt());
            baseResponse.setData(orderItemDTO);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex){
            baseResponse.setMessage("Lỗi trong quá trình tìm " + ex.getMessage());
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<OrderItemDTO> addOrderItem(OrderItemDTO orderItemDTO) {
        BaseResponse<OrderItemDTO> baseResponse = new BaseResponse<>();
        try {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(orderItemDTO.getQuantity());
            orderItem.setCreatedAt(orderItemDTO.getCreatedAt());
            orderItem.setPrice(orderItemDTO.getPrice());
            orderItem.setUpdatedAt(orderItemDTO.getUpdatedAt());
            orderItemRepository.save(orderItem);
            baseResponse.setData(orderItemDTO);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex){
            baseResponse.setMessage("Lỗi trong quá trình thêm Account");
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<OrderItemDTO> updateOrderItem(OrderItemDTO orderItemDTO, Long orderItem) {
        return null;
    }

    @Override
    public BaseResponse<OrderItemDTO> deleteOrderItem(Long orderItemId) {
        return null;
    }
}
