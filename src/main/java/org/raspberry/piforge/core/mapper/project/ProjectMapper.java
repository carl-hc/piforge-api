package org.raspberry.piforge.core.mapper.project;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.raspberry.framework.core.mapper.GenericMapper;
import org.raspberry.piforge.core.dto.project.ProjectDto;
import org.raspberry.piforge.core.entity.project.Project;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper extends GenericMapper<Project, ProjectDto> {

    @Mapping(target = "projectTypeId", source = "projectType.id")
    ProjectDto toDto(Project entity);

}