package org.raspberry.piforge.core.mapper.pipeline;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.raspberry.piforge.core.dto.pipeline.PipelineStepDto;
import org.raspberry.piforge.core.entity.pipeline.PipelineStep;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PipelineStepMapper {

    @Mapping(target = "idPipeline", source = "pipeline.id")
    @Mapping(target = "idPipelineStepType", source = "pipelineStepType.id")
    @Mapping(target = "idRuntimeVersion", source = "runtimeVersion.id")
    PipelineStepDto toDto(PipelineStep entity);

    List<PipelineStepDto> toDto(List<PipelineStep> entities);

}