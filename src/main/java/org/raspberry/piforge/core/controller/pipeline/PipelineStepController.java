package org.raspberry.piforge.core.controller.pipeline;

import org.raspberry.piforge.core.dto.pipeline.PipelineStepDto;
import org.raspberry.piforge.core.service.pipeline.PipelineStepService;
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
@RequestMapping("/api/core/pipelineStep")
public class PipelineStepController {

    @Autowired
    private PipelineStepService service;

    @GetMapping("/{id}")
    public PipelineStepDto findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<PipelineStepDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public PipelineStepDto create(@RequestBody PipelineStepDto pipelineStepDto) {
        return service.create(pipelineStepDto);
    }

    @PutMapping("/{id}")
    public PipelineStepDto update(@PathVariable("id") Long id, @RequestBody PipelineStepDto pipelineStepDto) {
        return service.update(id, pipelineStepDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}