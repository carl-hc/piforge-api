package org.raspberry.piforge.core.dto.pipeline;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PipelineStepDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("id_pipeline")
    private Long idPipeline;

    @JsonProperty("id_pipeline_step_type")
    private Long idPipelineStepType;

    @JsonProperty("id_runtime_version")
    private Long idRuntimeVersion;

    @JsonProperty("step_order")
    private Long stepOrder;

    @JsonProperty("command")
    private String command;

}
