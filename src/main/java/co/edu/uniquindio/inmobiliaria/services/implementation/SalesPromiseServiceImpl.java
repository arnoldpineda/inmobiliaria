package co.edu.uniquindio.inmobiliaria.services;

import co.edu.uniquindio.inmobiliaria.dto.SalesPromiseDTO;
import co.edu.uniquindio.inmobiliaria.repositories.SalesPromiseRepository;
import co.edu.uniquindio.inmobiliaria.services.interfaces.SalesPromiseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesPromiseServiceImpl implements SalesPromiseService {
    private final SalesPromiseRepository salesPromiseRepository;

    public SalesPromiseServiceImpl(SalesPromiseRepository salesPromiseRepository) {
        this.salesPromiseRepository = salesPromiseRepository;
    }

    @Override
    public List<SalesPromiseDTO> getAllSalesPromises() {
        return salesPromiseRepository.findAll();
    }

    @Override
    public SalesPromiseDTO getSalesPromiseById(Integer id) {
        return salesPromiseRepository.findById(id);
    }

    @Override
    public void createSalesPromise(SalesPromiseDTO salesPromise) {
        salesPromiseRepository.save(salesPromise);
    }

    @Override
    public void updateSalesPromise(Integer id, SalesPromiseDTO salesPromise) {
        salesPromiseRepository.update(id, salesPromise);
    }

    @Override
    public void deleteSalesPromise(Integer id) {
        salesPromiseRepository.delete(id);
    }
}
