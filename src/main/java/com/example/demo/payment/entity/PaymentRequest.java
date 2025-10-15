package com.example.demo.payment.entity;

// 결제 요청 데이터를 담는 클래스
public class PaymentRequest {
    private String username;
    private Long id;

    // Getter와 Setter (Jackson 라이브러리/Spring 필수)
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // toString은 로그 확인용으로 추가
    @Override
    public String toString() {
        return "PaymentRequest{username='" + username + "', id=" + id + '}';
    }
}