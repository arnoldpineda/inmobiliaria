package co.edu.uniquindio.inmobiliaria.services.interfaces;

import co.edu.uniquindio.inmobiliaria.dto.BillDTO;

import java.util.List;

public interface BillService {
    List<BillDTO> getAllBills();
    BillDTO getBillById(Integer id);
    void createBill(BillDTO billDTO);
    void updateBill(Integer id, BillDTO billDTO);
    void deleteBill(Integer id);
}
