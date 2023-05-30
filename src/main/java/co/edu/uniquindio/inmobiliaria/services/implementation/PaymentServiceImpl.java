package co.edu.uniquindio.inmobiliaria.services.implementation;

import co.edu.uniquindio.inmobiliaria.dto.PaymentDTO;
import co.edu.uniquindio.inmobiliaria.repositories.PaymentRepository;
import co.edu.uniquindio.inmobiliaria.services.interfaces.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public PaymentDTO getPaymentById(Integer id) {
        return paymentRepository.findById(id);
    }

    @Override
    public void createPayment(PaymentDTO payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void updatePayment(Integer id, PaymentDTO payment) {
        paymentRepository.update(id, payment);
    }

    @Override
    public void deletePayment(Integer id) {
        paymentRepository.delete(id);
    }
}
