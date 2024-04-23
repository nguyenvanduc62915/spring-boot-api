package com.example.project.Service;

import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.OrderDTO;
import com.example.project.Entity.Order;
import com.example.project.Repository.OrderRepository;
import com.example.project.Service.Imp.OrderImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements OrderImp {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public BaseResponse<List<OrderDTO>> getAllOrder() {
        BaseResponse<List<OrderDTO>> baseResponse = new BaseResponse<>();
        List<OrderDTO> orderDTOList = new ArrayList<>();
        try {
            List<Order> orderList = orderRepository.findAll();
            if (orderList.isEmpty() || orderList == null) {
                baseResponse.setMessage("Không tồn tại đơn hàng ");
                baseResponse.setCode(404);
                return baseResponse;
            }
            for (Order order : orderList) {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setOrderId(order.getOrderId());
                orderDTO.setToTalAmount(order.getToTalAmount());
                orderDTO.setStatus(order.getStatus());
                orderDTO.setShippingAddress(order.getShippingAddress());
                orderDTO.setReceiverName(order.getReceiverName());
                orderDTO.setCreatedAt(order.getCreatedAt());
                orderDTO.setUpdatedAt(order.getUpdatedAt());
                orderDTO.setReceiverPhoneNumber(order.getReceiverPhoneNumber());
                orderDTOList.add(orderDTO);
            }
            baseResponse.setData(orderDTOList);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex) {
            baseResponse.setMessage("Lỗi trong quá trình tìm " + ex.getMessage());
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<OrderDTO> getOrderById(Long orderId) {
        BaseResponse<OrderDTO> baseResponse = new BaseResponse<>();
        try {
            Order order = orderRepository.findOrderById(orderId);
            if (order == null) {
                baseResponse.setMessage("Id không tồn tại");
                baseResponse.setCode(404);
                return baseResponse;
            }
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderId(order.getOrderId());
            orderDTO.setToTalAmount(order.getToTalAmount());
            orderDTO.setStatus(order.getStatus());
            orderDTO.setShippingAddress(order.getShippingAddress());
            orderDTO.setReceiverName(order.getReceiverName());
            orderDTO.setCreatedAt(order.getCreatedAt());
            orderDTO.setUpdatedAt(order.getUpdatedAt());
            orderDTO.setReceiverPhoneNumber(order.getReceiverPhoneNumber());
            baseResponse.setData(orderDTO);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex) {
            baseResponse.setMessage("Lỗi trong quá trình tìm " + ex.getMessage());
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<OrderDTO> addOrder(OrderDTO orderDTO) {
        BaseResponse<OrderDTO> baseResponse = new BaseResponse<>();
        try {
            Order order = new Order();
            order.setToTalAmount(orderDTO.getToTalAmount());
            order.setStatus(orderDTO.getStatus());
            order.setShippingAddress(orderDTO.getShippingAddress());
            order.setReceiverName(orderDTO.getReceiverName());
            order.setCreatedAt(orderDTO.getCreatedAt());
            order.setUpdatedAt(orderDTO.getUpdatedAt());
            order.setReceiverPhoneNumber(orderDTO.getReceiverPhoneNumber());
            orderRepository.save(order);
            baseResponse.setData(orderDTO);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex) {
            baseResponse.setMessage("Lỗi trong quá trình thêm Category");
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<OrderDTO> updateOrder(Long orderId, OrderDTO orderDTO) {
        BaseResponse<OrderDTO> baseResponse = new BaseResponse<>();
        try {
            Order order = orderRepository.findOrderById(orderId);
            if (order == null) {
                baseResponse.setMessage("Không tìm thấy " + orderId + "nên không thể sửa");
                baseResponse.setCode(404);
                return baseResponse;
            }
            order.setToTalAmount(orderDTO.getToTalAmount());
            order.setStatus(orderDTO.getStatus());
            order.setShippingAddress(orderDTO.getShippingAddress());
            order.setReceiverName(orderDTO.getReceiverName());
            order.setCreatedAt(orderDTO.getCreatedAt());
            order.setUpdatedAt(orderDTO.getUpdatedAt());
            order.setReceiverPhoneNumber(orderDTO.getReceiverPhoneNumber());
            orderRepository.save(order);
            baseResponse.setData(orderDTO);
            baseResponse.setMessage("Thành công");
            baseResponse.setCode(200);
        } catch (Exception ex) {
            baseResponse.setMessage("Lỗi trong quá trình thêm đơn hàng");
            baseResponse.setCode(500);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<OrderDTO> deleteOrderById(Long orderId) {
        BaseResponse<OrderDTO> baseResponse = new BaseResponse<>();
        try {
            Order order = orderRepository.findOrderById(orderId);
            if (order == null) {
                baseResponse.setData(null);
                baseResponse.setMessage("Không tìm thấy " + orderId + " nên không thể xóa");
                baseResponse.setCode(404);
                return baseResponse;
            }
            orderRepository.delete(order);
            baseResponse.setMessage("Xóa thành công với đơn hàng có id là: " + orderId);
            baseResponse.setCode(202);
        } catch (Exception ex){
            baseResponse.setMessage("Lỗi khi xóa " + ex.getMessage());
            baseResponse.setCode(404);
        }
        return baseResponse;
    }
}
