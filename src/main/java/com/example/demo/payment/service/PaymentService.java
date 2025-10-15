package com.example.demo.payment.service;

import com.example.demo.payment.entity.PaymentRequest;
import com.example.demo.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository mockPaymentRepository;

    // 생성자 주입
    public PaymentService(PaymentRepository mockPaymentRepository) {
        this.mockPaymentRepository = mockPaymentRepository;
    }

    // 결제 처리 비즈니스 로직 (현재는 단순히 레포지토리 호출)
    public PaymentRequest processPayment(PaymentRequest request) {
        // 실제라면 여기서 잔액 확인, 검증, 복잡한 로직이 들어갑니다.

        // 레포지토리에 저장
        return mockPaymentRepository.save(request);
    }
}
