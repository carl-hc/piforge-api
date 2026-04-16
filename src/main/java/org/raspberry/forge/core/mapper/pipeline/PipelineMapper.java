package org.raspberry.forge.core.mapper.pipeline;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.raspberry.forge.core.dto.pipeline.PipelineDto;
import org.raspberry.forge.core.entity.pipeline.Pipeline;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PipelineMapper {

    @Mapping(target = "idProject", source = "project.id")
    PipelineDto toDto(Pipeline entity);

    List<PipelineDto> toDto(List<Pipeline> entities);

}