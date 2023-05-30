package co.edu.uniquindio.inmobiliaria.controllers;

import co.edu.uniquindio.inmobiliaria.dto.BillDTO;
import co.edu.uniquindio.inmobiliaria.dto.MessageDTO;
import co.edu.uniquindio.inmobiliaria.services.interfaces.BillService;
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
@RequestMapping("/bills")
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> createBill(@RequestBody BillDTO billDTO) {
        billService.createBill(billDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO<>(HttpStatus.CREATED, false, "Bill created successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getBillById(@PathVariable Integer id) {
        BillDTO billDTO = billService.getBillById(id);
        if (billDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, billDTO));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDTO<>(HttpStatus.NOT_FOUND, true, "Not found"));
    }

    @GetMapping
    public ResponseEntity<MessageDTO> getAllBills() {
        List<BillDTO> billDTOs = billService.getAllBills();
        if (!billDTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, billDTOs));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageDTO<>(HttpStatus.NO_CONTENT, true, "Not content"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> updateBill(@PathVariable Integer id, @RequestBody BillDTO billDTO) {
        billService.updateBill(id, billDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, "Bill updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteBill(@PathVariable Integer id) {
        billService.deleteBill(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageDTO<>(HttpStatus.NO_CONTENT, false, "Bill deleted successfully"));
    }
}
