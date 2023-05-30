package co.edu.uniquindio.inmobiliaria.controllers;

import co.edu.uniquindio.inmobiliaria.dto.CityDTO;
import co.edu.uniquindio.inmobiliaria.dto.MessageDTO;
import co.edu.uniquindio.inmobiliaria.services.interfaces.CityService;
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
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> createCity(@RequestBody CityDTO cityDTO) {
        cityService.createCity(cityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO<>(HttpStatus.CREATED, false, "City created successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getCityById(@PathVariable Integer id) {
        CityDTO cityDTO = cityService.getCityById(id);
        if (cityDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, cityDTO));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDTO<>(HttpStatus.NOT_FOUND, true, "Not found"));
    }

    @GetMapping
    public ResponseEntity<MessageDTO> getAllCities() {
        List<CityDTO> cityDTOs = cityService.getAllCities();
        if (!cityDTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, cityDTOs));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageDTO<>(HttpStatus.NO_CONTENT, true, "Not content"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> updateCity(@PathVariable Integer id, @RequestBody CityDTO cityDTO) {
        cityService.updateCity(id, cityDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO<>(HttpStatus.OK, false, "City updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteCity(@PathVariable Integer id) {
        cityService.deleteCity(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageDTO<>(HttpStatus.NO_CONTENT, false, "City deleted successfully"));
    }
}
