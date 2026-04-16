package org.raspberry.piforge.core.dto.runtime;

import lombok.Builder;

@Builder
public record RuntimeVersionDto(

        Long id,

        Long runtimeId,

        String version,

        String path

) { }
