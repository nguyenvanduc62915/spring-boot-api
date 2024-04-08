package com.example.project.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Table(name = "OrderItems")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long orderItemId;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Double price;
}
