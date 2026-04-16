package org.raspberry.forge.core.controller.pipeline;

import org.raspberry.forge.core.dto.pipeline.PipelineDto;
import org.raspberry.forge.core.service.pipeline.PipelineService;
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
@RequestMapping("/api/core/pipeline")
public class PipelineController {

    @Autowired
    private PipelineService service;

    @GetMapping("/{id}")
    public PipelineDto findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<PipelineDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public PipelineDto create(@RequestBody PipelineDto pipelineDto) {
        return service.create(pipelineDto);
    }

    @PutMapping("/{id}")
    public PipelineDto update(@PathVariable("id") Long id, @RequestBody PipelineDto pipelineDto) {
        return service.update(id, pipelineDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}