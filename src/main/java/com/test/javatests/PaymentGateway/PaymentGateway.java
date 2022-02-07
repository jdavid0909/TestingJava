package com.test.javatests.PaymentGateway;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest paymentRequest);
}
