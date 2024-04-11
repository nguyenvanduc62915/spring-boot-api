package com.example.project.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
// Thông tin đăng nhập
public class Account extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "image")
    private String image;
    @Column(name = "address")
    private String address;
    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private User user;
}
