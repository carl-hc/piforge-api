package org.raspberry.piforge.core.dto.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProjectDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("id_project_type")
    private Long idProjectType;

    @JsonProperty("name")
    private String name;

    @JsonProperty("repo_url")
    private String repoUrl;

    @JsonProperty("repo_branch")
    private String repoBranch;

}
