package org.raspberry.forge.core.mapper.runtime;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.raspberry.forge.core.dto.runtime.RuntimeVersionDto;
import org.raspberry.forge.core.entity.runtime.RuntimeVersion;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RuntimeVersionMapper {

    @Mapping(target = "idRuntime", source = "runtime.id")
    RuntimeVersionDto toDto(RuntimeVersion entity);

    List<RuntimeVersionDto> toDto(List<RuntimeVersion> entities);

}