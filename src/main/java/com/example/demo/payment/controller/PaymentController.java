package com.example.demo.payment.controller;


import com.example.demo.payment.entity.PaymentRequest;
import com.example.demo.payment.entity.PaymentResponse;
import com.example.demo.payment.repository.PaymentRepository;
import com.example.demo.payment.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // POST /payment 엔드포인트
    @PostMapping
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody PaymentRequest request) {
        // 1. 요청 값 검증
        if (request.getUsername() == null || request.getId() == null) {
            // Bad Request 응답도 JSON 형식으로 통일
            PaymentResponse errorResponse = new PaymentResponse("Username과 ID를 모두 입력해주세요.");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        // 2. Service 레이어 호출
        PaymentRequest savedRequest = paymentService.processPayment(request);

        // 3. 응답 객체 생성 및 반환
        String successMessage = String.format("결제 요청 성공 (Service 처리). 사용자: %s, ID: %d",
                savedRequest.getUsername(), savedRequest.getId());

        PaymentResponse successResponse = new PaymentResponse(successMessage);

        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }
}