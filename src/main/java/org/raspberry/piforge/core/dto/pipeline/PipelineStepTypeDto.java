package org.raspberry.piforge.core.dto.pipeline;

import lombok.Builder;

@Builder
public record PipelineStepTypeDto(

        Long id,

        String name

) { }
