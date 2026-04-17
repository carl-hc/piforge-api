package org.raspberry.piforge.core.service.pipeline;

import lombok.AllArgsConstructor;
import org.raspberry.piforge.core.dto.pipeline.PipelineStepDto;
import org.raspberry.piforge.core.entity.pipeline.PipelineStep;
import org.raspberry.piforge.core.exception.NotFoundException;
import org.raspberry.piforge.core.mapper.pipeline.PipelineStepMapper;
import org.raspberry.piforge.core.repository.pipeline.PipelineRepository;
import org.raspberry.piforge.core.repository.pipeline.PipelineStepRepository;
import org.raspberry.piforge.core.repository.pipeline.PipelineStepTypeRepository;
import org.raspberry.piforge.core.repository.runtime.RuntimeVersionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PipelineStepService {

    private final PipelineRepository pipelineRepository;
    private final PipelineStepRepository pipelineStepRepository;
    private final PipelineStepTypeRepository pipelineStepTypeRepository;
    private final RuntimeVersionRepository runtimeVersionRepository;

    private final PipelineStepMapper mapper;

    public PipelineStepDto findById(Long id) {
        PipelineStep pipelineStep = pipelineStepRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("PipelineStep with id '%s' not found", id));

        return mapper.toDto(pipelineStep);
    }

    public List<PipelineStepDto> findAll() {
        List<PipelineStep> pipelineStepList = pipelineStepRepository.findAll();

        return mapper.toDto(pipelineStepList);
    }

    public PipelineStepDto create(PipelineStepDto pipelineStepDto) {
        PipelineStep pipelineStep = new PipelineStep();
        pipelineStep.setPipeline(pipelineRepository.getReferenceById(pipelineStepDto.pipelineId()));
        pipelineStep.setPipelineStepType(pipelineStepTypeRepository.getReferenceById(pipelineStepDto.pipelineStepTypeId()));
        pipelineStep.setRuntimeVersion(runtimeVersionRepository.getReferenceById(pipelineStepDto.runtimeVersionId()));
        pipelineStep.setOrder(pipelineStepDto.order());
        pipelineStep.setCommand(pipelineStepDto.command());

        pipelineStep = pipelineStepRepository.save(pipelineStep);

        return mapper.toDto(pipelineStep);
    }

    public PipelineStepDto update(Long id, PipelineStepDto pipelineStepDto) {
        PipelineStep pipelineStep = pipelineStepRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("PipelineStep with id '%s' not found", id));

        pipelineStep.setPipeline(pipelineRepository.getReferenceById(pipelineStepDto.pipelineId()));
        pipelineStep.setPipelineStepType(pipelineStepTypeRepository.getReferenceById(pipelineStepDto.pipelineStepTypeId()));
        pipelineStep.setRuntimeVersion(runtimeVersionRepository.getReferenceById(pipelineStepDto.runtimeVersionId()));
        pipelineStep.setOrder(pipelineStepDto.order());
        pipelineStep.setCommand(pipelineStepDto.command());

        pipelineStep = pipelineStepRepository.save(pipelineStep);

        return mapper.toDto(pipelineStep);
    }

    public void delete(Long id) {
        PipelineStep pipelineStep = pipelineStepRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("PipelineStep with id '%s' not found", id));

        pipelineStepRepository.delete(pipelineStep);
    }

}