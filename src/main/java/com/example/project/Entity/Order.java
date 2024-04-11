package com.example.project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
// Giỏ hàng
public class Order extends BaseEntity {
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
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "order_item_id", foreignKey = @ForeignKey(name = "FK_orderitem_order"))
    private OrderItem orderItem;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "payment_method_id", foreignKey = @ForeignKey(name = "FK_paymentMethod_order"))
    @JsonIgnore
    private PaymentMethod paymentMethod;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_user_order"))
    private User user;
}
