package org.raspberry.piforge.core.dto.pipeline;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PipelineStepTypeDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

}
