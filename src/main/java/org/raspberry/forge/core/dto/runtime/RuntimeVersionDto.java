package org.raspberry.forge.core.dto.runtime;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RuntimeVersionDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("id_runtime")
    private Long idRuntime;

    @JsonProperty("version")
    private String version;

    @JsonProperty("path")
    private String path;

}
