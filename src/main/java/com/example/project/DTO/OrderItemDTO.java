package com.example.project.DTO;

import com.example.project.Entity.Order;
import com.example.project.Entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemDTO {
    private Long orderItemId;
    @NotBlank(message = "Số lượng không được bỏ trống")
    private Integer quantity;
    private Double price;
    private Product product;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private List<OrderDTO> orders;
}
