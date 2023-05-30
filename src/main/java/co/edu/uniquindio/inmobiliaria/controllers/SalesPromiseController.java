package co.edu.uniquindio.inmobiliaria.controllers;

import co.edu.uniquindio.inmobiliaria.dto.SalesPromiseDTO;
import co.edu.uniquindio.inmobiliaria.services.interfaces.SalesPromiseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales-promises")
public class SalesPromiseController {
    private final SalesPromiseService salesPromiseService;

    public SalesPromiseController(SalesPromiseService salesPromiseService) {
        this.salesPromiseService = salesPromiseService;
    }

    @GetMapping
    public ResponseEntity<List<SalesPromiseDTO>> getAllSalesPromises() {
        List<SalesPromiseDTO> salesPromises = salesPromiseService.getAllSalesPromises();
        return new ResponseEntity<>(salesPromises, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesPromiseDTO> getSalesPromiseById(@PathVariable Integer id) {
        SalesPromiseDTO salesPromise = salesPromiseService.getSalesPromiseById(id);
        if (salesPromise != null) {
            return new ResponseEntity<>(salesPromise, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> createSalesPromise(@RequestBody SalesPromiseDTO salesPromise) {
        salesPromiseService.createSalesPromise(salesPromise);
        return new ResponseEntity<>("Sales promise created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSalesPromise(@PathVariable Integer id, @RequestBody SalesPromiseDTO salesPromise) {
        SalesPromiseDTO existingSalesPromise = salesPromiseService.getSalesPromiseById(id);
        if (existingSalesPromise != null) {
            salesPromiseService.updateSalesPromise(id, salesPromise);
            return new ResponseEntity<>("Sales promise updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sales promise not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSalesPromise(@PathVariable Integer id) {
        SalesPromiseDTO existingSalesPromise = salesPromiseService.getSalesPromiseById(id);
        if (existingSalesPromise != null) {
            salesPromiseService.deleteSalesPromise(id);
            return new ResponseEntity<>("Sales promise deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sales promise not found", HttpStatus.NOT_FOUND);
        }
    }
}
