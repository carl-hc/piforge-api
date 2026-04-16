package org.raspberry.piforge.core.mapper.pipeline;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.raspberry.framework.core.mapper.GenericMapper;
import org.raspberry.piforge.core.dto.pipeline.PipelineStepDto;
import org.raspberry.piforge.core.entity.pipeline.PipelineStep;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PipelineStepMapper extends GenericMapper<PipelineStep, PipelineStepDto> {

    @Mapping(target = "pipelineId", source = "pipeline.id")
    @Mapping(target = "pipelineStepTypeId", source = "pipelineStepType.id")
    @Mapping(target = "runtimeVersionId", source = "runtimeVersion.id")
    PipelineStepDto toDto(PipelineStep entity);

}