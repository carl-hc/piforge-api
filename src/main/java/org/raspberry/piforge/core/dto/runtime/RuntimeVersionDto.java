package org.raspberry.piforge.core.dto.runtime;

import lombok.Data;

@Data
public class RuntimeVersionDto {

    private Long id;

    private Long runtimeId;

    private String version;

    private String path;

}
