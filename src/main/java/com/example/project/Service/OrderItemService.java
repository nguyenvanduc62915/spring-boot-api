package com.example.project.Service;

import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.OrderDTO;
import com.example.project.DTO.OrderItemDTO;
import com.example.project.Entity.Order;
import com.example.project.Entity.OrderItem;
import com.example.project.Repository.OrderItemRepository;
import com.example.project.Repository.OrderRepository;
import com.example.project.Service.Imp.OrderitemImp;
import com.example.project.Utils.ConvertRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService implements OrderitemImp {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ConvertRelationship convertRelationship;

    @Override
    public BaseResponse<List<OrderItemDTO>> getAllOrderItem() {
        BaseResponse<List<OrderItemDTO>> baseResponse = new BaseResponse<>();
        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();
        try {
            List<OrderItem> orderItemList = orderItemRepository.findAll();
            if (orderItemList.isEmpty() || orderItemList == null) {
                baseResponse.setMessage("Không tồn tại");
                baseResponse.setCode(404);
                return baseResponse;
            }
            for (OrderItem orderItem : orderItemList) {
                OrderItemDTO orderItemDTO = new OrderItemDTO();
                orderItemDTO.setOrderItemId(orderItem.getOrderItemId());
                orderItemDTO.setQuantity(orderItem.getQuantity());
                orderItemDTO.setCreatedAt(orderItem.getCreatedAt());
                orderItemDTO.setPrice(orderItem.getPrice());
                orderItemDTO.setUpdatedAt(orderItem.getUpdatedAt());
                List<Order> orderList = new ArrayList<>(orderItem.getOrders());
                List<OrderDTO> orderDTOList = orderList
                        .stream()
                        .map(order -> convertRelationship.convertToOrderDTO(order))
                        .collect(Collectors.toList());
                orderItemDTO.setOrders(orderDTOList);
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
        try {
            OrderItem orderItem = orderItemRepository.findOrderItemById(orderItemId);
            if (orderItem == null) {
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
            List<Order> orderList = new ArrayList<>(orderItem.getOrders());
            List<OrderDTO> orderDTOList = orderList
                    .stream()
                    .map(order -> convertRelationship.convertToOrderDTO(order))
                    .collect(Collectors.toList());
            orderItemDTO.setOrders(orderDTOList);
            baseResponse.setData(orderItemDTO);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex) {
            baseResponse.setMessage("Lỗi trong quá trình tìm " + ex.getMessage());
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<OrderItemDTO> addOrderItem(OrderItemDTO orderItemDTO, Long orderId) {
        BaseResponse<OrderItemDTO> baseResponse = new BaseResponse<>();
        try {
            if (orderId == null){
                baseResponse.setMessage("OrderId không được để trống");
                baseResponse.setCode(400);
                return baseResponse;
            }
            Order order = orderRepository.findOrderById(orderId);
            if (order ==null){
                baseResponse.setMessage("Hóa đơn không tồn tại");
                baseResponse.setCode(404);
                return baseResponse;
            }
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(orderItemDTO.getQuantity());
            orderItem.setCreatedAt(orderItemDTO.getCreatedAt());
            orderItem.setPrice(orderItemDTO.getPrice());
            orderItem.setUpdatedAt(orderItemDTO.getUpdatedAt());
            List<Order> orderList = new ArrayList<>();
            orderList.add(order);
            orderItem.setOrders(orderList);
            OrderItem saveOrderItem = orderItemRepository.save(orderItem);
            order.setOrderItem(saveOrderItem);
            orderRepository.save(order);
            orderItemRepository.save(orderItem);
            OrderItemDTO saveOrderItemDTO = convertRelationship.convertToOrderItemDTO(saveOrderItem);
            baseResponse.setData(saveOrderItemDTO);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex) {
            baseResponse.setMessage("Lỗi trong quá trình thêm Account");
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<OrderItemDTO> updateOrderItem(OrderItemDTO orderItemDTO, Long orderItemId) {
        BaseResponse<OrderItemDTO> baseResponse = new BaseResponse<>();
        try{
            OrderItem orderItem = orderItemRepository.findOrderItemById(orderItemId);
            if (orderItem == null){
                baseResponse.setMessage("Không tồn tại Id");
                baseResponse.setCode(404);
                return baseResponse;
            }
            orderItem.setQuantity(orderItemDTO.getQuantity());
            orderItem.setCreatedAt(orderItemDTO.getCreatedAt());
            orderItem.setPrice(orderItemDTO.getPrice());
            orderItem.setUpdatedAt(orderItemDTO.getUpdatedAt());
            orderItemRepository.save(orderItem);
            baseResponse.setData(orderItemDTO);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex) {
            baseResponse.setMessage("Lỗi trong quá trình update Account");
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<OrderItemDTO> deleteOrderItem(Long orderItemId) {
        BaseResponse<OrderItemDTO> baseResponse = new BaseResponse<>();
        try{
            OrderItem orderItem = orderItemRepository.findOrderItemById(orderItemId);
            if (orderItem == null){
                baseResponse.setMessage("Không tồn tại Id");
                baseResponse.setCode(404);
                return baseResponse;
            }
            orderItemRepository.delete(orderItem);
            baseResponse.setMessage("Xóa thành công với danh mục có id là: " + orderItemId);
            baseResponse.setCode(202);
        } catch (Exception ex){
            baseResponse.setMessage("Lỗi khi xóa " + ex.getMessage());
            baseResponse.setCode(404);
        }
        return baseResponse;
    }
}
