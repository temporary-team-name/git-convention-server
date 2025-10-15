package com.example.demo.payment.repository;

import com.example.demo.payment.entity.PaymentRequest;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {

    // Mock DB 역할: 하드코딩된 '결제 완료' 목록
    private final List<PaymentRequest> processedPayments = new ArrayList<>();

    // PaymentRequest를 List에 저장하고 반환 (DB 저장 Mock)
    public PaymentRequest save(PaymentRequest request) {
        // 실제 DB 로직 대신, 콘솔 출력 및 리스트에 추가
        System.out.println("Mock DB Save: " + request);
        processedPayments.add(request);

        return request;
    }

    // 연습용으로 목록 조회 함수도 간단히 남겨둡니다.
    public List<PaymentRequest> findAll() {
        return processedPayments;
    }
}