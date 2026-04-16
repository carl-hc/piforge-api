package org.raspberry.piforge.core.dto.pipeline;

import lombok.Builder;

@Builder
public record PipelineDto(

        Long id,

        Long projectId,

        String name

) { }
