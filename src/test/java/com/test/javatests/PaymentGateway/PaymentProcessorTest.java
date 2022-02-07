package com.test.javatests.PaymentGateway;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;
    //Metodo utlizado para Recilar codigo
    @Before
    public void setup(){
         paymentGateway = Mockito.mock(PaymentGateway.class);
         paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void payment_is_correct(){

        //preparar el esenario

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));


        //Segunda Parte Actuar
        boolean result = paymentProcessor.makePayment(1000);

        //Tercera parte Comprobar
        assertTrue(result);
    }
    @Test
    public void payment_is_worg(){
        //preparacion del escenario

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        //Ejecucion Y comprobacion
        assertFalse(paymentProcessor.makePayment(1000));
    }

}