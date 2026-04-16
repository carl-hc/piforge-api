package org.raspberry.piforge.core.dto.build;

import lombok.Builder;
import org.raspberry.piforge.core.entity.build.BuildStatus;

import java.time.LocalDateTime;

@Builder
public record BuildStepDto(

        Long id,

        Long buildId,

        Long pipelineStepId,

        BuildStatus status,

        LocalDateTime iniProcess,

        LocalDateTime endProcess

) { }
