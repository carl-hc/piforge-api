package org.raspberry.piforge.core.mapper.runtime;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.raspberry.piforge.core.dto.runtime.RuntimeDto;
import org.raspberry.piforge.core.entity.runtime.Runtime;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RuntimeMapper {

    RuntimeDto toDto(Runtime entity);

    List<RuntimeDto> toDto(List<Runtime> entities);

}