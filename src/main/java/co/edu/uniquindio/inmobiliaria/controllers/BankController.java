package co.edu.uniquindio.inmobiliaria.controllers;

import co.edu.uniquindio.inmobiliaria.dto.BankDTO;
import co.edu.uniquindio.inmobiliaria.dto.MessageDTO;
import co.edu.uniquindio.inmobiliaria.services.interfaces.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> createBank(@RequestBody BankDTO bankDTO) {
        bankService.createBank(bankDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO<>(HttpStatus.CREATED, false, "Bank created successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getBankById(@PathVariable Integer id) {
        BankDTO bankDTO = bankService.getBankById(id);
        if (bankDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, bankDTO));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDTO<>(HttpStatus.NOT_FOUND, true, "Not found"));
    }

    @GetMapping
    public ResponseEntity<MessageDTO> getAllBanks() {
        List<BankDTO> bankDTOs = bankService.getAllBanks();
        if (!bankDTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, bankDTOs));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageDTO<>(HttpStatus.NO_CONTENT, true, "Not content"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> updateBank(@PathVariable Integer id, @RequestBody BankDTO bankDTO) {
        bankService.updateBank(id, bankDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, "Bank updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteBank(@PathVariable Integer id) {
        bankService.deleteBank(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageDTO<>(HttpStatus.NO_CONTENT, false, "Bank deleted successfully"));
    }
}
