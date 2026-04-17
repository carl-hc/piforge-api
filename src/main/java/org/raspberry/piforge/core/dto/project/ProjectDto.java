package org.raspberry.piforge.core.dto.project;

import lombok.Builder;

@Builder
public record ProjectDto(

        Long id,

        Long projectTypeId,

        String name

) { }
