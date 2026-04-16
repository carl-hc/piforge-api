package org.raspberry.forge.core.service.pipeline;

import org.raspberry.forge.core.dto.pipeline.PipelineStepTypeDto;
import org.raspberry.forge.core.entity.pipeline.PipelineStepType;
import org.raspberry.forge.core.exception.NotFoundException;
import org.raspberry.forge.core.mapper.pipeline.PipelineStepTypeMapper;
import org.raspberry.forge.core.repository.pipeline.PipelineStepTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PipelineStepTypeService {

    @Autowired
    private PipelineStepTypeRepository pipelineStepTypeRepository;
    
    @Autowired
    private PipelineStepTypeMapper mapper;

    public PipelineStepTypeDto findById(Long id) {
        PipelineStepType pipelineStepType = pipelineStepTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("PipelineStepType with id '%s' not found", id));

        return mapper.toDto(pipelineStepType);
    }

    public List<PipelineStepTypeDto> findAll() {
        List<PipelineStepType> pipelineStepTypeList = pipelineStepTypeRepository.findAll();

        return mapper.toDto(pipelineStepTypeList);
    }

    public PipelineStepTypeDto create(PipelineStepTypeDto pipelineStepTypeDto) {
        PipelineStepType pipelineStepType = new PipelineStepType();
        pipelineStepType.setName(pipelineStepTypeDto.getName());

        pipelineStepType = pipelineStepTypeRepository.save(pipelineStepType);

        return mapper.toDto(pipelineStepType);
    }

    public PipelineStepTypeDto update(Long id, PipelineStepTypeDto pipelineStepTypeDto) {
        PipelineStepType pipelineStepType = pipelineStepTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("PipelineStepType with id '%s' not found", id));

        pipelineStepType.setName(pipelineStepTypeDto.getName());

        pipelineStepType = pipelineStepTypeRepository.save(pipelineStepType);

        return mapper.toDto(pipelineStepType);
    }

    public void delete(Long id) {
        PipelineStepType pipelineStepType = pipelineStepTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("PipelineStepType with id '%s' not found", id));

        pipelineStepTypeRepository.delete(pipelineStepType);
    }

}