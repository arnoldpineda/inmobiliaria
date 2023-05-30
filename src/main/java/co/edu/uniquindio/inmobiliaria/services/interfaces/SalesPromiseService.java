package co.edu.uniquindio.inmobiliaria.services.interfaces;

import co.edu.uniquindio.inmobiliaria.dto.SalesPromiseDTO;

import java.util.List;

public interface SalesPromiseService {
    List<SalesPromiseDTO> getAllSalesPromises();
    SalesPromiseDTO getSalesPromiseById(Integer id);
    void createSalesPromise(SalesPromiseDTO salesPromise);
    void updateSalesPromise(Integer id, SalesPromiseDTO salesPromise);
    void deleteSalesPromise(Integer id);
}
