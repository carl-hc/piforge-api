package org.raspberry.piforge.core.dto.runtime;

import lombok.Builder;

@Builder
public record RuntimeDto(

        Long id,

        String name

) { }
