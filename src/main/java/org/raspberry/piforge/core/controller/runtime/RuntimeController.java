package org.raspberry.piforge.core.controller.runtime;

import org.raspberry.piforge.core.dto.runtime.RuntimeDto;
import org.raspberry.piforge.core.service.runtime.RuntimeService;
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
@RequestMapping("/api/core/runtime")
public class RuntimeController {

    @Autowired
    private RuntimeService service;

    @GetMapping("/{id}")
    public RuntimeDto findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<RuntimeDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public RuntimeDto create(@RequestBody RuntimeDto runtimeDto) {
        return service.create(runtimeDto);
    }

    @PutMapping("/{id}")
    public RuntimeDto update(@PathVariable("id") Long id, @RequestBody RuntimeDto runtimeDto) {
        return service.update(id, runtimeDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}