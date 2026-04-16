package org.raspberry.piforge.core.mapper.runtime;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.raspberry.framework.core.mapper.GenericMapper;
import org.raspberry.piforge.core.dto.runtime.RuntimeDto;
import org.raspberry.piforge.core.entity.runtime.Runtime;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RuntimeMapper extends GenericMapper<Runtime, RuntimeDto> {

}