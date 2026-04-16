package org.raspberry.piforge.core.mapper.project;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.raspberry.piforge.core.dto.project.ProjectTypeDto;
import org.raspberry.piforge.core.entity.project.ProjectType;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectTypeMapper {

    ProjectTypeDto toDto(ProjectType entity);

    List<ProjectTypeDto> toDto(List<ProjectType> entities);

}