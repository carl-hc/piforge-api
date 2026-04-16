package org.raspberry.piforge.core.mapper.project;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.raspberry.piforge.core.dto.project.ProjectDto;
import org.raspberry.piforge.core.entity.project.Project;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper {

    @Mapping(target = "idProjectType", source = "projectType.id")
    ProjectDto toDto(Project entity);

    List<ProjectDto> toDto(List<Project> entities);

}