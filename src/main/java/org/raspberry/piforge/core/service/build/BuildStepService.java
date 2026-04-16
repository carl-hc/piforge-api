package org.raspberry.piforge.core.service.build;

import lombok.AllArgsConstructor;
import org.raspberry.piforge.core.dto.build.BuildStepDto;
import org.raspberry.piforge.core.entity.build.BuildStep;
import org.raspberry.piforge.core.exception.NotFoundException;
import org.raspberry.piforge.core.mapper.build.BuildStepMapper;
import org.raspberry.piforge.core.repository.build.BuildRepository;
import org.raspberry.piforge.core.repository.build.BuildStepRepository;
import org.raspberry.piforge.core.repository.pipeline.PipelineStepRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuildStepService {

    private final BuildRepository buildRepository;
    private final BuildStepRepository buildStepRepository;
    private final PipelineStepRepository pipelineStepRepository;

    private final BuildStepMapper mapper;

    public BuildStepDto findById(Long id) {
        BuildStep buildStep = buildStepRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BuildStep with id '%s' not found", id));

        return mapper.toDto(buildStep);
    }

    public List<BuildStepDto> findAll() {
        List<BuildStep> buildStepList = buildStepRepository.findAll();

        return mapper.toDto(buildStepList);
    }

    public BuildStepDto create(BuildStepDto buildStepDto) {
        BuildStep buildStep = new BuildStep();
        buildStep.setBuild(buildRepository.getReferenceById(buildStepDto.buildId()));
        buildStep.setPipelineStep(pipelineStepRepository.getReferenceById(buildStepDto.pipelineStepId()));
        buildStep.setStatus(buildStepDto.status());
        buildStep.setIniProcess(buildStepDto.iniProcess());
        buildStep.setEndProcess(buildStepDto.endProcess());

        buildStep = buildStepRepository.save(buildStep);

        return mapper.toDto(buildStep);
    }

    public BuildStepDto update(Long id, BuildStepDto buildStepDto) {
        BuildStep buildStep = buildStepRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BuildStep with id '%s' not found", id));

        buildStep.setBuild(buildRepository.getReferenceById(buildStepDto.buildId()));
        buildStep.setPipelineStep(pipelineStepRepository.getReferenceById(buildStepDto.pipelineStepId()));
        buildStep.setStatus(buildStepDto.status());
        buildStep.setIniProcess(buildStepDto.iniProcess());
        buildStep.setEndProcess(buildStepDto.endProcess());

        buildStep = buildStepRepository.save(buildStep);

        return mapper.toDto(buildStep);
    }

    public void delete(Long id) {
        BuildStep buildStep = buildStepRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BuildStep with id '%s' not found", id));

        buildStepRepository.delete(buildStep);
    }

}