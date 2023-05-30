package co.edu.uniquindio.inmobiliaria.controllers;

import co.edu.uniquindio.inmobiliaria.dto.RealEstateDTO;
import co.edu.uniquindio.inmobiliaria.dto.MessageDTO;
import co.edu.uniquindio.inmobiliaria.services.interfaces.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/real-estates")
public class RealEstateController {

    private final RealEstateService realEstateService;

    @Autowired
    public RealEstateController(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> createRealEstate(@RequestBody RealEstateDTO realEstateDTO) {
        realEstateService.createRealEstate(realEstateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO<>(HttpStatus.CREATED, false, "Real estate created successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getRealEstateById(@PathVariable Integer id) {
        RealEstateDTO realEstateDTO = realEstateService.getRealEstateById(id);
        if (realEstateDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, realEstateDTO));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDTO<>(HttpStatus.NOT_FOUND, true, "Not found"));
    }

    @GetMapping
    public ResponseEntity<MessageDTO> getAllRealEstates() {
        List<RealEstateDTO> realEstateDTOs = realEstateService.getAllRealEstates();
        if (!realEstateDTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, realEstateDTOs));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageDTO<>(HttpStatus.NO_CONTENT, true, "No content"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> updateRealEstate(@PathVariable Integer id, @RequestBody RealEstateDTO realEstateDTO) {
        realEstateService.updateRealEstate(id, realEstateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, "Real estate updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteRealEstate(@PathVariable Integer id) {
        realEstateService.deleteRealEstate(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageDTO<>(HttpStatus.NO_CONTENT, false, "Real estate deleted successfully"));
    }
}
