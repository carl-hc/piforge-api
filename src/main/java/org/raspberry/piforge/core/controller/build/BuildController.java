package org.raspberry.piforge.core.controller.build;

import lombok.AllArgsConstructor;
import org.raspberry.piforge.core.dto.build.BuildDto;
import org.raspberry.piforge.core.service.build.BuildService;
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
@RequestMapping("/api/core/build")
@AllArgsConstructor
public class BuildController {

    private final BuildService service;

    @GetMapping("/{id}")
    public BuildDto findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<BuildDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public BuildDto create(@RequestBody BuildDto buildDto) {
        return service.create(buildDto);
    }

    @PutMapping("/{id}")
    public BuildDto update(@PathVariable("id") Long id, @RequestBody BuildDto buildDto) {
        return service.update(id, buildDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}