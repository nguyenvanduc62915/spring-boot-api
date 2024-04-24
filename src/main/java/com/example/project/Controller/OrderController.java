package com.example.project.Controller;

import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.OrderDTO;
import com.example.project.Service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/get/all")
    public ResponseEntity<BaseResponse<List<OrderDTO>>> getAllOrder() {
        BaseResponse<List<OrderDTO>> baseResponse = orderService.getAllOrder();
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @GetMapping("/get")
    public ResponseEntity<BaseResponse<OrderDTO>> getOrderById(@RequestParam("id") Long orderId) {
        BaseResponse<OrderDTO> baseResponse = orderService.getOrderById(orderId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<OrderDTO>> addOrder(
            @Valid @RequestBody OrderDTO orderDTO
    ) {
        BaseResponse<OrderDTO> baseResponse = orderService.addOrder(orderDTO);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<OrderDTO>> updateOrder(
            @RequestParam("id") Long id,
            @Valid @RequestBody OrderDTO orderDTO
    ) {
        BaseResponse<OrderDTO> baseResponse = orderService.updateOrder(id, orderDTO);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse<OrderDTO>> deleteOrder(@RequestParam("id") Long id) {
        BaseResponse<OrderDTO> baseResponse = orderService.deleteOrderById(id);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }
}
