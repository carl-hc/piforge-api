package org.raspberry.piforge.core.controller.project;

import org.raspberry.piforge.core.dto.project.ProjectDto;
import org.raspberry.piforge.core.service.project.ProjectService;
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
@RequestMapping("/api/core/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping("/{id}")
    public ProjectDto findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<ProjectDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ProjectDto create(@RequestBody ProjectDto projectDto) {
        return service.create(projectDto);
    }

    @PutMapping("/{id}")
    public ProjectDto update(@PathVariable("id") Long id, @RequestBody ProjectDto projectDto) {
        return service.update(id, projectDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}