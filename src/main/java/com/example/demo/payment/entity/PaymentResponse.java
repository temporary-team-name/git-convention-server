package com.example.demo.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class PaymentResponse {
    private String message;

    // 생성자
    public PaymentResponse(String message) {
        this.message = message;
    }

    // Getter (필수)
    public String getMessage() {
        return message;
    }

    // Setter (선택적이지만 일반적으로 DTO에 추가)
    public void setMessage(String message) {
        this.message = message;
    }
}
