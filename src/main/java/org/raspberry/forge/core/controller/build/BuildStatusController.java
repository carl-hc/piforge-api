package org.raspberry.forge.core.controller.build;

import org.raspberry.forge.core.entity.build.BuildStatus;
import org.raspberry.forge.core.service.build.BuildStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/core/buildStatus")
public class BuildStatusController {

    @Autowired
    private BuildStatusService service;

    @GetMapping
    public List<BuildStatus> findAll() {
        return service.findAll();
    }

}