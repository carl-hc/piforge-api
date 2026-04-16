package org.raspberry.piforge.core.dto.build;

import lombok.Data;
import org.raspberry.piforge.core.entity.build.BuildStatus;

import java.time.LocalDateTime;

@Data
public class BuildStepDto {

    private Long id;

    private Long buildId;

    private Long pipelineStepId;

    private BuildStatus status;

    private LocalDateTime iniProcess;

    private LocalDateTime endProcess;

}
