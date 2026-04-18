package org.raspberry.piforge.core.service.pipeline;

import org.raspberry.piforge.core.dto.pipeline.PipelineStepParamDto;
import org.raspberry.piforge.core.entity.pipeline.PipelineStepParam;
import org.raspberry.piforge.core.exception.NotFoundException;
import org.raspberry.piforge.core.mapper.pipeline.PipelineStepParamMapper;
import org.raspberry.piforge.core.repository.pipeline.PipelineStepParamRepository;
import org.raspberry.piforge.core.repository.pipeline.PipelineStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PipelineStepParamService {

    @Autowired
    private PipelineStepParamRepository pipelineStepParamRepository;
    @Autowired
    private PipelineStepRepository pipelineStepRepository;

    @Autowired
    private PipelineStepParamMapper mapper;

    public PipelineStepParamDto findById(Long id) {
        PipelineStepParam pipelineStepParam = pipelineStepParamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("PipelineStepParam with id '%s' not found", id)));

        return mapper.toDto(pipelineStepParam);
    }

    public List<PipelineStepParamDto> findAll() {
        List<PipelineStepParam> pipelineStepParamList = pipelineStepParamRepository.findAll();

        return mapper.toDto(pipelineStepParamList);
    }

    public PipelineStepParamDto create(PipelineStepParamDto pipelineStepParamDto) {
        PipelineStepParam pipelineStepParam = new PipelineStepParam();
        pipelineStepParam.setPipelineStep(pipelineStepRepository.getReferenceById(pipelineStepParamDto.pipelineStepId()));
        pipelineStepParam.setName(pipelineStepParamDto.name());
        pipelineStepParam.setValue(pipelineStepParamDto.value());

        pipelineStepParam = pipelineStepParamRepository.save(pipelineStepParam);

        return mapper.toDto(pipelineStepParam);
    }

    public PipelineStepParamDto update(Long id, PipelineStepParamDto pipelineStepParamDto) {
        PipelineStepParam pipelineStepParam = pipelineStepParamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("PipelineStepParam with id '%s' not found", id)));

        pipelineStepParam.setPipelineStep(pipelineStepRepository.getReferenceById(pipelineStepParamDto.pipelineStepId()));
        pipelineStepParam.setName(pipelineStepParamDto.name());
        pipelineStepParam.setValue(pipelineStepParamDto.value());

        pipelineStepParam = pipelineStepParamRepository.save(pipelineStepParam);

        return mapper.toDto(pipelineStepParam);
    }

    public void delete(Long id) {
        PipelineStepParam pipelineStepParam = pipelineStepParamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("PipelineStepParam with id '%s' not found", id)));

        pipelineStepParamRepository.delete(pipelineStepParam);
    }

}