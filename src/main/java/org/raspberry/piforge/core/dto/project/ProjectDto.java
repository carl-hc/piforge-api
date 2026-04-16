package org.raspberry.piforge.core.dto.project;

import lombok.Data;

@Data
public class ProjectDto {

    private Long id;

    private Long projectTypeId;

    private String name;

    private String repoUrl;

    private String repoBranch;

}
