package co.edu.uniquindio.inmobiliaria.controllers;

import co.edu.uniquindio.inmobiliaria.dto.CountryDTO;
import co.edu.uniquindio.inmobiliaria.dto.MessageDTO;
import co.edu.uniquindio.inmobiliaria.services.interfaces.CountryService;
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
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> createCountry(@RequestBody CountryDTO countryDTO) {
        countryService.createCountry(countryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO<>(HttpStatus.CREATED, false, "Country created successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getCountryById(@PathVariable Integer id) {
        CountryDTO countryDTO = countryService.getCountryById(id);
        if (countryDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, countryDTO));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDTO<>(HttpStatus.NOT_FOUND, true, "Not found"));
    }

    @GetMapping
    public ResponseEntity<MessageDTO> getAllCountries() {
        List<CountryDTO> countryDTOs = countryService.getAllCountries();
        if (!countryDTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, countryDTOs));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageDTO<>(HttpStatus.NO_CONTENT, true, "Not content"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> updateCountry(@PathVariable Integer id, @RequestBody CountryDTO countryDTO) {
        countryService.updateCountry(id, countryDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, "Country updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteCountry(@PathVariable Integer id) {
        countryService.deleteCountry(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageDTO<>(HttpStatus.NO_CONTENT, false, "Country deleted successfully"));
    }
}
