package com.example.project.Repository;

import com.example.project.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @Query("SELECT oi FROM OrderItem oi WHERE oi.orderItemId =: orderItemId")
    OrderItem findOrderItemById(@Param("orderItemId")Long orderItemId);
}
