package org.raspberry.forge.core.mapper.runtime;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.raspberry.forge.core.dto.runtime.RuntimeDto;
import org.raspberry.forge.core.entity.runtime.Runtime;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RuntimeMapper {

    RuntimeDto toDto(Runtime entity);

    List<RuntimeDto> toDto(List<Runtime> entities);

}