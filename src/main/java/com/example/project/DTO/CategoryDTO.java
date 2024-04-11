package com.example.project.DTO;

import com.example.project.Entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {
    private Long categoryId;
    @NotBlank(message = "Tên danh mục không được bỏ trống")
    private String name;
    private String image;
    private String description;
    private Boolean active;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private List<Product> products;
}
