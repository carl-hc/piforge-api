package org.raspberry.piforge.core.service.project;

import org.raspberry.piforge.core.dto.project.ProjectTypeDto;
import org.raspberry.piforge.core.entity.project.ProjectType;
import org.raspberry.piforge.core.exception.NotFoundException;
import org.raspberry.piforge.core.mapper.project.ProjectTypeMapper;
import org.raspberry.piforge.core.repository.project.ProjectTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTypeService {

    @Autowired
    private ProjectTypeRepository projectTypeRepository;

    @Autowired
    private ProjectTypeMapper mapper;

    public ProjectTypeDto findById(Long id) {
        ProjectType projectType = projectTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("ProjectType with id '%s' not found", id)));

        return mapper.toDto(projectType);
    }

    public List<ProjectTypeDto> findAll() {
        List<ProjectType> projectTypeList = projectTypeRepository.findAll();

        return mapper.toDto(projectTypeList);
    }

    public ProjectTypeDto create(ProjectTypeDto projectTypeDto) {
        ProjectType projectType = new ProjectType();
        projectType.setName(projectTypeDto.name());

        projectType = projectTypeRepository.save(projectType);

        return mapper.toDto(projectType);
    }

    public ProjectTypeDto update(Long id, ProjectTypeDto projectTypeDto) {
        ProjectType projectType = projectTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("ProjectType with id '%s' not found", id)));

        projectType.setName(projectTypeDto.name());

        projectType = projectTypeRepository.save(projectType);

        return mapper.toDto(projectType);
    }

    public void delete(Long id) {
        ProjectType projectType = projectTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("ProjectType with id '%s' not found", id)));

        projectTypeRepository.delete(projectType);
    }

}