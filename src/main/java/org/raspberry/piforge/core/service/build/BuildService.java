package org.raspberry.piforge.core.service.build;

import org.raspberry.piforge.core.dto.build.BuildDto;
import org.raspberry.piforge.core.entity.build.Build;
import org.raspberry.piforge.core.exception.NotFoundException;
import org.raspberry.piforge.core.mapper.build.BuildMapper;
import org.raspberry.piforge.core.repository.build.BuildRepository;
import org.raspberry.piforge.core.repository.pipeline.PipelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildService {

    @Autowired
    private BuildRepository buildRepository;
    @Autowired
    private PipelineRepository pipelineRepository;

    @Autowired
    private BuildMapper mapper;

    public BuildDto findById(Long id) {
        Build build = buildRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Build with id '%s' not found", id)));

        return mapper.toDto(build);
    }

    public List<BuildDto> findAll() {
        List<Build> buildList = buildRepository.findAll();

        return mapper.toDto(buildList);
    }

    public BuildDto create(BuildDto buildDto) {
        Build build = new Build();
        build.setPipeline(pipelineRepository.getReferenceById(buildDto.pipelineId()));
        build.setStatus(buildDto.status());
        build.setIniProcess(buildDto.iniProcess());
        build.setEndProcess(buildDto.endProcess());

        build = buildRepository.save(build);

        return mapper.toDto(build);
    }

    public BuildDto update(Long id, BuildDto buildDto) {
        Build build = buildRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Build with id '%s' not found", id)));

        build.setPipeline(pipelineRepository.getReferenceById(buildDto.pipelineId()));
        build.setStatus(buildDto.status());
        build.setIniProcess(buildDto.iniProcess());
        build.setEndProcess(buildDto.endProcess());

        build = buildRepository.save(build);

        return mapper.toDto(build);
    }

    public void delete(Long id) {
        Build build = buildRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Build with id '%s' not found", id)));

        buildRepository.delete(build);
    }

}