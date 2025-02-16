package com.example.payment.controller;

import com.example.payment.model.PaymentTransaction;
import com.example.payment.service.PaymentService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<PaymentTransaction> createPayment(@RequestBody PaymentTransaction payment) {
        PaymentTransaction savedPayment = paymentService
            .createPayment(payment.getOrderId(), payment.getAmount(), payment.getPaymentMethod());
        return ResponseEntity.ok(savedPayment);
    }

    @PostMapping("confirm/{orderId}")
    public ResponseEntity<PaymentTransaction> confirmPayment(@PathVariable String orderId, @RequestParam  boolean success) {
        PaymentTransaction updatedPayment = paymentService.confirmPayment(orderId, success);
        return ResponseEntity.ok(updatedPayment);
    }

    @GetMapping
    public ResponseEntity<List<PaymentTransaction>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }


}
