package org.raspberry.forge.core.dto.runtime;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RuntimeDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

}
