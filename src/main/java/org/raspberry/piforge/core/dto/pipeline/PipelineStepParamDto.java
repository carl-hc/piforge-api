package org.raspberry.piforge.core.dto.pipeline;

import lombok.Builder;

@Builder
public record PipelineStepParamDto(

        Long id,

        Long pipelineStepId,

        String name,

        String value

) { }
