package org.raspberry.piforge.core.mapper.pipeline;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.raspberry.framework.core.mapper.GenericMapper;
import org.raspberry.piforge.core.dto.pipeline.PipelineStepParamDto;
import org.raspberry.piforge.core.entity.pipeline.PipelineStepParam;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PipelineStepParamMapper extends GenericMapper<PipelineStepParam, PipelineStepParamDto> {

    @Mapping(target = "pipelineStepId", source = "pipelineStep.id")
    PipelineStepParamDto toDto(PipelineStepParam entity);

}