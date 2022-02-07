package com.test.javatests.movies.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
