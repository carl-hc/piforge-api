package org.raspberry.piforge.core.service.build;

import org.raspberry.piforge.core.entity.build.BuildStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildStatusService {

    public List<BuildStatus> findAll() {
        return List.of(BuildStatus.values());
    }

}