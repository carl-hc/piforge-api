package org.raspberry.piforge.core.mapper.pipeline;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.raspberry.framework.core.mapper.GenericMapper;
import org.raspberry.piforge.core.dto.pipeline.PipelineDto;
import org.raspberry.piforge.core.entity.pipeline.Pipeline;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PipelineMapper extends GenericMapper<Pipeline, PipelineDto> {

    @Mapping(target = "idProject", source = "project.id")
    PipelineDto toDto(Pipeline entity);

}