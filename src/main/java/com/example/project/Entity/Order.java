package com.example.project.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Entity
@Builder
@Table(name = "Orders")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "receiver_name")
    @Size(max = 200, message = "Tên đơn không được vượt quá 200 ký tự!")
    private String receiverName;
    @Column(name = "receiver_phone_number")
    private String receiverPhoneNumber;
    @Column(name = "total_amount")
    private Double toTalAmount;
    @Column(name = "status")
    private String status;
    @Column(name = "shipping_address")
    @Size(max = 500, message = "Địa chỉ nhận hàng không được vượt quá 500 ký tự!")
    private String shippingAddress;
}
