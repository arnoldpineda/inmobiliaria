package co.edu.uniquindio.inmobiliaria.services.interfaces;

import co.edu.uniquindio.inmobiliaria.dto.InteractionDTO;

import java.util.List;

public interface InteractionService {
    List<InteractionDTO> getAllInteractions();
    InteractionDTO getInteractionById(Integer id);
    void createInteraction(InteractionDTO interaction);
    void updateInteraction(Integer id, InteractionDTO interaction);
    void deleteInteraction(Integer id);
}
