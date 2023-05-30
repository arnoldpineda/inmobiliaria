package co.edu.uniquindio.inmobiliaria.services.implementation;

import co.edu.uniquindio.inmobiliaria.dto.ProjectDTO;
import co.edu.uniquindio.inmobiliaria.repositories.ProjectRepository;
import co.edu.uniquindio.inmobiliaria.services.interfaces.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public ProjectDTO getProjectById(Integer id) {
        return projectRepository.findById(id);
    }

    @Override
    public void createProject(ProjectDTO project) {
        projectRepository.save(project);
    }

    @Override
    public void updateProject(Integer id, ProjectDTO project) {
        projectRepository.update(id, project);
    }

    @Override
    public void deleteProject(Integer id) {
        projectRepository.delete(id);
    }
}
