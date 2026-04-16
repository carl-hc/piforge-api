package org.raspberry.forge.core.controller.project;

import org.raspberry.forge.core.dto.project.ProjectTypeDto;
import org.raspberry.forge.core.service.project.ProjectTypeService;
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
@RequestMapping("/api/core/projectType")
public class ProjectTypeController {

    @Autowired
    private ProjectTypeService service;

    @GetMapping("/{id}")
    public ProjectTypeDto findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<ProjectTypeDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ProjectTypeDto create(@RequestBody ProjectTypeDto projectTypeDto) {
        return service.create(projectTypeDto);
    }

    @PutMapping("/{id}")
    public ProjectTypeDto update(@PathVariable("id") Long id, @RequestBody ProjectTypeDto projectTypeDto) {
        return service.update(id, projectTypeDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}