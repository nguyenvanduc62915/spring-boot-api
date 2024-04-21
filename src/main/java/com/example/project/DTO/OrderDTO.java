package com.example.project.DTO;

import com.example.project.Entity.OrderItem;
import com.example.project.Entity.PaymentMethod;
import com.example.project.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private Long orderId;
    private String receiverName;
    private String receiverPhoneNumber;
    private Double toTalAmount;
    private String status;
    private String shippingAddress;
    private OrderItemDTO orderItem;
    private PaymentMethodDTO paymentMethod;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private UserDTO user;
}
