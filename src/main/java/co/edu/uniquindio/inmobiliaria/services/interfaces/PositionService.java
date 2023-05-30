package co.edu.uniquindio.inmobiliaria.services.interfaces;

import co.edu.uniquindio.inmobiliaria.dto.PositionDTO;

import java.util.List;

public interface PositionService {
    List<PositionDTO> getAllPositions();

    PositionDTO getPositionById(Integer id);

    void createPosition(PositionDTO position);

    void updatePosition(Integer id, PositionDTO position);

    void deletePosition(Integer id);
}
