package org.raspberry.piforge.core.mapper.pipeline;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.raspberry.piforge.core.dto.pipeline.PipelineStepTypeDto;
import org.raspberry.piforge.core.entity.pipeline.PipelineStepType;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PipelineStepTypeMapper {

    PipelineStepTypeDto toDto(PipelineStepType entity);

    List<PipelineStepTypeDto> toDto(List<PipelineStepType> entities);

}