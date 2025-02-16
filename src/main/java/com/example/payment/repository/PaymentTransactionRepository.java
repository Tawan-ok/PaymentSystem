package com.example.payment.repository;

import com.example.payment.model.PaymentTransaction;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction,Long> {
    Optional<PaymentTransaction> findByOrderId(String orderId);

}
