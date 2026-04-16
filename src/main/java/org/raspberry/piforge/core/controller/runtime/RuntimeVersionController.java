package org.raspberry.piforge.core.controller.runtime;

import lombok.AllArgsConstructor;
import org.raspberry.piforge.core.dto.runtime.RuntimeVersionDto;
import org.raspberry.piforge.core.service.runtime.RuntimeVersionService;
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
@RequestMapping("/api/core/runtimeVersion")
@AllArgsConstructor
public class RuntimeVersionController {

    private final RuntimeVersionService service;

    @GetMapping("/{id}")
    public RuntimeVersionDto findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<RuntimeVersionDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public RuntimeVersionDto create(@RequestBody RuntimeVersionDto runtimeVersionDto) {
        return service.create(runtimeVersionDto);
    }

    @PutMapping("/{id}")
    public RuntimeVersionDto update(@PathVariable("id") Long id, @RequestBody RuntimeVersionDto runtimeVersionDto) {
        return service.update(id, runtimeVersionDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}