package org.raspberry.piforge.core.mapper.build;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.raspberry.framework.core.mapper.GenericMapper;
import org.raspberry.piforge.core.dto.build.BuildStepDto;
import org.raspberry.piforge.core.entity.build.BuildStep;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BuildStepMapper extends GenericMapper<BuildStep, BuildStepDto> {

    @Mapping(target = "buildId", source = "build.id")
    @Mapping(target = "pipelineStepId", source = "pipelineStep.id")
    BuildStepDto toDto(BuildStep entity);

}