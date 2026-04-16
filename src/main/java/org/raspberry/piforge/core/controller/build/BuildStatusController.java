package org.raspberry.piforge.core.controller.build;

import lombok.AllArgsConstructor;
import org.raspberry.piforge.core.entity.build.BuildStatus;
import org.raspberry.piforge.core.service.build.BuildStatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/core/buildStatus")
@AllArgsConstructor
public class BuildStatusController {

    private final BuildStatusService service;

    @GetMapping
    public List<BuildStatus> findAll() {
        return service.findAll();
    }

}