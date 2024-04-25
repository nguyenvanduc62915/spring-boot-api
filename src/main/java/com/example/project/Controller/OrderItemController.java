package com.example.project.Controller;

import com.example.project.DTO.BaseResponse;
import com.example.project.DTO.OrderItemDTO;
import com.example.project.Service.OrderItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/orderItem")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/get/all")
    public ResponseEntity<BaseResponse<List<OrderItemDTO>>> getAllOrderItem() {
        BaseResponse<List<OrderItemDTO>> baseResponse = orderItemService.getAllOrderItem();
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @GetMapping("/get")
    public ResponseEntity<BaseResponse<OrderItemDTO>> getOrderItemById(@RequestParam("id") Long orderItemId) {
        BaseResponse<OrderItemDTO> baseResponse = orderItemService.getOrderItemById(orderItemId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<OrderItemDTO>> addOrderItem(
            @Valid @RequestBody OrderItemDTO orderItemDTO,
            @RequestParam("id") Long orderId
    ) {
        BaseResponse<OrderItemDTO> baseResponse = orderItemService.addOrderItem(orderItemDTO, orderId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<OrderItemDTO>> updateOrderItem(
            @RequestParam("id") Long orderItemId,
            @Valid @RequestBody OrderItemDTO orderItemDTO
    ) {
        BaseResponse<OrderItemDTO> baseResponse = orderItemService.updateOrderItem(orderItemDTO, orderItemId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse<OrderItemDTO>> deleteOrderItem(@RequestParam("id") Long orderItemId) {
        BaseResponse<OrderItemDTO> baseResponse = orderItemService.deleteOrderItem(orderItemId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }
}
