package org.raspberry.piforge.core.controller.build;

import org.raspberry.piforge.core.dto.build.BuildStepDto;
import org.raspberry.piforge.core.service.build.BuildStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/core/buildStep")
public class BuildStepController {

    @Autowired
    private BuildStepService service;

    @GetMapping("/{id}")
    public BuildStepDto findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<BuildStepDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public BuildStepDto create(@RequestBody BuildStepDto buildStepDto) {
        return service.create(buildStepDto);
    }

    @PutMapping("/{id}")
    public BuildStepDto update(@PathVariable("id") Long id, @RequestBody BuildStepDto buildStepDto) {
        return service.update(id, buildStepDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}