package com.ll.ebookmarket.app.order.repository;

import com.ll.ebookmarket.app.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
