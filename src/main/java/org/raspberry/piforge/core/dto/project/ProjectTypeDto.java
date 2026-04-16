package org.raspberry.piforge.core.dto.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProjectTypeDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

}
