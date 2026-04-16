package org.raspberry.piforge.core.dto.build;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.raspberry.piforge.core.entity.build.BuildStatus;

import java.time.LocalDateTime;

@Data
public class BuildDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("id_pipeline")
    private Long idPipeline;

    @JsonProperty("status")
    private BuildStatus status;

    @JsonProperty("ini_process")
    private LocalDateTime iniProcess;

    @JsonProperty("end_process")
    private LocalDateTime endProcess;

}
