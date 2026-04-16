package org.raspberry.piforge.core.mapper.runtime;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.raspberry.framework.core.mapper.GenericMapper;
import org.raspberry.piforge.core.dto.runtime.RuntimeVersionDto;
import org.raspberry.piforge.core.entity.runtime.RuntimeVersion;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RuntimeVersionMapper extends GenericMapper<RuntimeVersion, RuntimeVersionDto> {

    @Mapping(target = "idRuntime", source = "runtime.id")
    RuntimeVersionDto toDto(RuntimeVersion entity);

}