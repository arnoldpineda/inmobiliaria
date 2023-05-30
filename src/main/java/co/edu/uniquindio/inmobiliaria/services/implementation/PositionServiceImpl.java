package co.edu.uniquindio.inmobiliaria.services.implementation;

import co.edu.uniquindio.inmobiliaria.dto.PositionDTO;
import co.edu.uniquindio.inmobiliaria.repositories.PositionRepository;
import co.edu.uniquindio.inmobiliaria.services.interfaces.PositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<PositionDTO> getAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    public PositionDTO getPositionById(Integer id) {
        return positionRepository.findById(id);
    }

    @Override
    public void createPosition(PositionDTO position) {
        positionRepository.save(position);
    }

    @Override
    public void updatePosition(Integer id, PositionDTO position) {
        positionRepository.update(id, position);
    }

    @Override
    public void deletePosition(Integer id) {
        positionRepository.delete(id);
    }
}
