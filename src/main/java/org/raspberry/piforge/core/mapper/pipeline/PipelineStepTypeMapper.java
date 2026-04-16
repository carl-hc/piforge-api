package org.raspberry.piforge.core.mapper.pipeline;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.raspberry.framework.core.mapper.GenericMapper;
import org.raspberry.piforge.core.dto.pipeline.PipelineStepTypeDto;
import org.raspberry.piforge.core.entity.pipeline.PipelineStepType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PipelineStepTypeMapper extends GenericMapper<PipelineStepType, PipelineStepTypeDto> {

}