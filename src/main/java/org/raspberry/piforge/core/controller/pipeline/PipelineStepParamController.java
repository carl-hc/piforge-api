package org.raspberry.piforge.core.controller.pipeline;

import org.raspberry.piforge.core.dto.pipeline.PipelineStepParamDto;
import org.raspberry.piforge.core.service.pipeline.PipelineStepParamService;
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
@RequestMapping("/api/core/pipelineStepParam")
public class PipelineStepParamController {

    @Autowired
    private PipelineStepParamService service;

    @GetMapping("/{id}")
    public PipelineStepParamDto findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<PipelineStepParamDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public PipelineStepParamDto create(@RequestBody PipelineStepParamDto pipelineStepParamDto) {
        return service.create(pipelineStepParamDto);
    }

    @PutMapping("/{id}")
    public PipelineStepParamDto update(@PathVariable("id") Long id, @RequestBody PipelineStepParamDto pipelineStepParamDto) {
        return service.update(id, pipelineStepParamDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}