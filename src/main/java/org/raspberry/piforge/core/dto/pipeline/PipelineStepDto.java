package org.raspberry.piforge.core.dto.pipeline;

import lombok.Data;

@Data
public class PipelineStepDto {

    private Long id;

    private Long pipelineId;

    private Long pipelineStepTypeId;

    private Long runtimeVersionId;

    private Long stepOrder;

    private String command;

}
