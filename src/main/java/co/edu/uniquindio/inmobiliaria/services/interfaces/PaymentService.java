package co.edu.uniquindio.inmobiliaria.services.interfaces;

import co.edu.uniquindio.inmobiliaria.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    List<PaymentDTO> getAllPayments();
    PaymentDTO getPaymentById(Integer id);
    void createPayment(PaymentDTO payment);
    void updatePayment(Integer id, PaymentDTO payment);
    void deletePayment(Integer id);
}
