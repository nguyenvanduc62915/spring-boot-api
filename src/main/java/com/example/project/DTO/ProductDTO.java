package com.example.project.DTO;

import com.example.project.Entity.Category;
import com.example.project.Entity.OrderItem;
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
public class ProductDTO { @Column(name = "product_id")
    private Long productId;
    @NotBlank(message = "Tên sản phẩm không được bỏ trống")
    private String name;
    private String image;
    @NotBlank(message = "Giá sản phẩm không được bỏ trống")
    private Double price;
    private Integer quantity;
    private String description;
    private Boolean active;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Category category;
    private List<OrderItem> orderItems;
}
