package co.edu.uniquindio.inmobiliaria.services.implementation;

import co.edu.uniquindio.inmobiliaria.dto.BillDTO;
import co.edu.uniquindio.inmobiliaria.repositories.BillRepository;
import co.edu.uniquindio.inmobiliaria.services.interfaces.BillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public List<BillDTO> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public BillDTO getBillById(Integer id) {
        return billRepository.findById(id);
    }

    @Override
    public void createBill(BillDTO bill) {
        billRepository.save(bill);
    }

    @Override
    public void updateBill(Integer id, BillDTO bill) {
        billRepository.update(id, bill);
    }

    @Override
    public void deleteBill(Integer id) {
        billRepository.delete(id);
    }
}
