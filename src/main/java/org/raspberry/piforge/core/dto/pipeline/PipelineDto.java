package org.raspberry.piforge.core.dto.pipeline;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PipelineDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("id_project")
    private Long idProject;

    @JsonProperty("name")
    private String name;

}
