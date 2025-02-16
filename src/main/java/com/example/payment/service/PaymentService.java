package com.example.payment.service;

import com.example.payment.model.PaymentTransaction;
import com.example.payment.repository.PaymentTransactionRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentTransactionRepository paymentTransactionRepository;


    public PaymentService(PaymentTransactionRepository paymentTransactionRepository) {
        this.paymentTransactionRepository = paymentTransactionRepository;
    }

    public PaymentTransaction createPayment(String orderId, Double amount, String method) {
        PaymentTransaction payment = new PaymentTransaction();
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setPaymentMethod(method);
        payment.setStatus("PENDING");

        return paymentTransactionRepository.save(payment);
    }

    public PaymentTransaction confirmPayment(String orderId, boolean success) {
        PaymentTransaction payment = paymentTransactionRepository.findByOrderId(orderId)
            .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setStatus(success ? "SUCCESS" : "FAILED");
        return paymentTransactionRepository.save(payment);
    }

    public List<PaymentTransaction> getAllPayments() {
        return paymentTransactionRepository.findAll();
    }
}
