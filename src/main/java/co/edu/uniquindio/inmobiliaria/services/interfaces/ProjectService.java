package co.edu.uniquindio.inmobiliaria.services.interfaces;

import co.edu.uniquindio.inmobiliaria.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> getAllProjects();
    ProjectDTO getProjectById(Integer id);
    void createProject(ProjectDTO project);
    void updateProject(Integer id, ProjectDTO project);
    void deleteProject(Integer id);
}
