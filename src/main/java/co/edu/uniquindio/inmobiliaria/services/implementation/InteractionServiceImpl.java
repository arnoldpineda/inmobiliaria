package co.edu.uniquindio.inmobiliaria.services.implementation;

import co.edu.uniquindio.inmobiliaria.dto.InteractionDTO;
import co.edu.uniquindio.inmobiliaria.repositories.InteractionRepository;
import co.edu.uniquindio.inmobiliaria.services.interfaces.InteractionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InteractionServiceImpl implements InteractionService {
    private final InteractionRepository interactionRepository;

    public InteractionServiceImpl(InteractionRepository interactionRepository) {
        this.interactionRepository = interactionRepository;
    }

    @Override
    public List<InteractionDTO> getAllInteractions() {
        return interactionRepository.findAll();
    }

    @Override
    public InteractionDTO getInteractionById(Integer id) {
        return interactionRepository.findById(id);
    }

    @Override
    public void createInteraction(InteractionDTO interaction) {
        interactionRepository.save(interaction);
    }

    @Override
    public void updateInteraction(Integer id, InteractionDTO interaction) {
        interactionRepository.update(id, interaction);
    }

    @Override
    public void deleteInteraction(Integer id) {
        interactionRepository.delete(id);
    }
}
