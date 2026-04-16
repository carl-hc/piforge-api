package org.raspberry.piforge.core.dto.project;

import lombok.Builder;

@Builder
public record ProjectTypeDto(

        Long id,

        String name

) { }
