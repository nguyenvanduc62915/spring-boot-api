package com.example.project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Products")
@Data
@AllArgsConstructor
@NoArgsConstructor
// Sản phẩm
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "name")
    @Size(max = 200, message = "Tên sản phẩm không được vượt quá 200 ký tự!")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "FK_category_product"))
    private Category category;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnore
    private List<OrderItem> orderItems;
}
