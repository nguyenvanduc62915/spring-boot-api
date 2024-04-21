package com.example.project.DTO;

import com.example.project.Entity.Account;
import com.example.project.Entity.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private Long userId;
    @NotBlank(message = "Tên người dùng không được bỏ trống")
    private String firstName;
    @NotBlank(message = "Họ người dùng không được bỏ trống")
    private String lastName;
    @NotBlank(message = "Email người dùng không được bỏ trống")
    private String email;
    private String image;
    private String address;
    private String phoneNumber;
    private List<OrderDTO> orders;
    private AccountDTO account;
}
