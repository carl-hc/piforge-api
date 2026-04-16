package org.raspberry.forge.core.mapper.build;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.raspberry.forge.core.dto.build.BuildStepDto;
import org.raspberry.forge.core.entity.build.BuildStep;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BuildStepMapper {

    @Mapping(target = "idBuild", source = "build.id")
    @Mapping(target = "idPipelineStep", source = "pipelineStep.id")
    BuildStepDto toDto(BuildStep entity);

    List<BuildStepDto> toDto(List<BuildStep> entities);

}