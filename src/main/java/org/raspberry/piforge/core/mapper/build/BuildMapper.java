package org.raspberry.piforge.core.mapper.build;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.raspberry.framework.core.mapper.GenericMapper;
import org.raspberry.piforge.core.dto.build.BuildDto;
import org.raspberry.piforge.core.entity.build.Build;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BuildMapper extends GenericMapper<Build, BuildDto> {

    @Mapping(target = "pipelineId", source = "pipeline.id")
    BuildDto toDto(Build entity);

}