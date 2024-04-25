package com.example.project.Repository;

import com.example.project.Entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {
    @Query("SELECT p FROM PaymentMethod p WHERE p.paymentMethodId = :paymentMethodId")
    PaymentMethod findPaymentMethodById(@RequestParam("id") Long paymentMethodId);
}
