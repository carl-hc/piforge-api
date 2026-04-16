package org.raspberry.piforge.core.mapper.project;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.raspberry.framework.core.mapper.GenericMapper;
import org.raspberry.piforge.core.dto.project.ProjectTypeDto;
import org.raspberry.piforge.core.entity.project.ProjectType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectTypeMapper extends GenericMapper<ProjectType, ProjectTypeDto> {

}