package com.example.project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "PaymentMethods")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// Phương thức thanh toán
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_id")
    private Integer paymentMethodId;
    @Column(name = "name")
    @Size(max = 50, message = "Tên phương thức thanh toán không được vượt quá 50 ký tự!")
    private String name;
    @Column(name = "active")
    private Boolean active;
    @OneToOne(mappedBy = "paymentMethod", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Order order;
}
