package org.raspberry.forge.core.mapper.build;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.raspberry.forge.core.dto.build.BuildDto;
import org.raspberry.forge.core.entity.build.Build;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BuildMapper {

    @Mapping(target = "idPipeline", source = "pipeline.id")
    BuildDto toDto(Build entity);

    List<BuildDto> toDto(List<Build> entities);

}