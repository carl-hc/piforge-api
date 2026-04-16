package org.raspberry.piforge.core.controller.pipeline;

import lombok.AllArgsConstructor;
import org.raspberry.piforge.core.dto.pipeline.PipelineStepTypeDto;
import org.raspberry.piforge.core.service.pipeline.PipelineStepTypeService;
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
@RequestMapping("/api/core/pipelineStepType")
@AllArgsConstructor
public class PipelineStepTypeController {

    private final PipelineStepTypeService service;

    @GetMapping("/{id}")
    public PipelineStepTypeDto findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<PipelineStepTypeDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public PipelineStepTypeDto create(@RequestBody PipelineStepTypeDto pipelineStepTypeDto) {
        return service.create(pipelineStepTypeDto);
    }

    @PutMapping("/{id}")
    public PipelineStepTypeDto update(@PathVariable("id") Long id, @RequestBody PipelineStepTypeDto pipelineStepTypeDto) {
        return service.update(id, pipelineStepTypeDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}