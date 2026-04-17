package org.raspberry.piforge.core.service.project;

import lombok.AllArgsConstructor;
import org.raspberry.piforge.core.dto.project.ProjectDto;
import org.raspberry.piforge.core.entity.project.Project;
import org.raspberry.piforge.core.exception.NotFoundException;
import org.raspberry.piforge.core.mapper.project.ProjectMapper;
import org.raspberry.piforge.core.repository.project.ProjectRepository;
import org.raspberry.piforge.core.repository.project.ProjectTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectTypeRepository projectTypeRepository;

    private final ProjectMapper mapper;

    public ProjectDto findById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project with id '%s' not found", id));

        return mapper.toDto(project);
    }

    public List<ProjectDto> findAll() {
        List<Project> projectList = projectRepository.findAll();

        return mapper.toDto(projectList);
    }

    public ProjectDto create(ProjectDto projectDto) {
        Project project = new Project();
        project.setProjectType(projectTypeRepository.getReferenceById(projectDto.projectTypeId()));
        project.setName(projectDto.name());

        project = projectRepository.save(project);

        return mapper.toDto(project);
    }

    public ProjectDto update(Long id, ProjectDto projectDto) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project with id '%s' not found", id));

        project.setProjectType(projectTypeRepository.getReferenceById(projectDto.projectTypeId()));
        project.setName(projectDto.name());

        project = projectRepository.save(project);

        return mapper.toDto(project);
    }

    public void delete(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project with id '%s' not found", id));

        projectRepository.delete(project);
    }

}