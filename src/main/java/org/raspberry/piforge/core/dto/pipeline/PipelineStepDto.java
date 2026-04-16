package org.raspberry.piforge.core.dto.pipeline;

import lombok.Builder;

@Builder
public record PipelineStepDto(

        Long id,

        Long pipelineId,

        Long pipelineStepTypeId,

        Long runtimeVersionId,

        Long stepOrder,

        String command

) { }
