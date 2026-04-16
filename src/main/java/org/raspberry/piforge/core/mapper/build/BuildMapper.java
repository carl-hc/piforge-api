package org.raspberry.piforge.core.mapper.build;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.raspberry.piforge.core.dto.build.BuildDto;
import org.raspberry.piforge.core.entity.build.Build;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BuildMapper {

    @Mapping(target = "idPipeline", source = "pipeline.id")
    BuildDto toDto(Build entity);

    List<BuildDto> toDto(List<Build> entities);

}