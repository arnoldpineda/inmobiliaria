package co.edu.uniquindio.inmobiliaria.controllers;

import co.edu.uniquindio.inmobiliaria.dto.CustomerDTO;
import co.edu.uniquindio.inmobiliaria.dto.MessageDTO;
import co.edu.uniquindio.inmobiliaria.services.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.createCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO<>(HttpStatus.CREATED, false, "Customer created successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getCustomerById(@PathVariable Integer id) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        if (customerDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, customerDTO));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDTO<>(HttpStatus.NOT_FOUND, true, "Not found"));
    }

    @GetMapping
    public ResponseEntity<MessageDTO> getAllCustomers() {
        List<CustomerDTO> customerDTOs = customerService.getAllCustomers();
        if (!customerDTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, customerDTOs));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageDTO<>(HttpStatus.NO_CONTENT, true, "Not content"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> updateCustomer(@PathVariable Integer id, @RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(id, customerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, "Customer updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageDTO<>(HttpStatus.NO_CONTENT, false, "Customer deleted successfully"));
    }
}
