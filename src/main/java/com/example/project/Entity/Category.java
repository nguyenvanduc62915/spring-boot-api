package com.example.project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
// Danh mục
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name = "name")
    @Size(max = 200, message = "Tên danh mục không được vượt quá 200 ký tự!")
    private String name;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnore // Tránh vòng lặp vô hạn khi chuyển đổi danh sách người dùng thành Json thông qua đối tượng
    private List<Product> products;
}
