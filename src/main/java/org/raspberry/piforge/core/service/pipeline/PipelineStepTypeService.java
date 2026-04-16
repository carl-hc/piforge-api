package org.raspberry.piforge.core.service.pipeline;

import lombok.AllArgsConstructor;
import org.raspberry.piforge.core.dto.pipeline.PipelineStepTypeDto;
import org.raspberry.piforge.core.entity.pipeline.PipelineStepType;
import org.raspberry.piforge.core.exception.NotFoundException;
import org.raspberry.piforge.core.mapper.pipeline.PipelineStepTypeMapper;
import org.raspberry.piforge.core.repository.pipeline.PipelineStepTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PipelineStepTypeService {

    private final PipelineStepTypeRepository pipelineStepTypeRepository;
    
    private final PipelineStepTypeMapper mapper;

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