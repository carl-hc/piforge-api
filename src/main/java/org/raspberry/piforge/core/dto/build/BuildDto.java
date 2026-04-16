package org.raspberry.piforge.core.dto.build;

import lombok.Builder;
import org.raspberry.piforge.core.entity.build.BuildStatus;

import java.time.LocalDateTime;

@Builder
public record BuildDto(

        Long id,

        Long pipelineId,

        BuildStatus status,

        LocalDateTime iniProcess,

        LocalDateTime endProcess

) { }
