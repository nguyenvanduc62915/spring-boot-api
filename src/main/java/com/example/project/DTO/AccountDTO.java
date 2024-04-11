package com.example.project.DTO;

import com.example.project.Entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDTO {
    private Long accountId;
    @NotBlank(message = "Tên không được bỏ trống")
    private String firstName;
    @NotBlank(message = "Họ không được bỏ trống")
    private String lastName;
    @NotBlank(message = "Email không được bỏ trống")
    private String email;
    private String password;
    private String image;
    private String address;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private User user;
}
