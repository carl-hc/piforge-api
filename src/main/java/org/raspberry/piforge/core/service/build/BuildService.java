package org.raspberry.piforge.core.service.build;

import lombok.AllArgsConstructor;
import org.raspberry.piforge.core.dto.build.BuildDto;
import org.raspberry.piforge.core.entity.build.Build;
import org.raspberry.piforge.core.exception.NotFoundException;
import org.raspberry.piforge.core.mapper.build.BuildMapper;
import org.raspberry.piforge.core.repository.build.BuildRepository;
import org.raspberry.piforge.core.repository.pipeline.PipelineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuildService {

    private final BuildRepository buildRepository;
    private final PipelineRepository pipelineRepository;

    private final BuildMapper mapper;

    public BuildDto findById(Long id) {
        Build build = buildRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Build with id '%s' not found", id));

        return mapper.toDto(build);
    }

    public List<BuildDto> findAll() {
        List<Build> buildList = buildRepository.findAll();

        return mapper.toDto(buildList);
    }

    public BuildDto create(BuildDto buildDto) {
        Build build = new Build();
        build.setPipeline(pipelineRepository.getReferenceById(buildDto.getPipelineId()));
        build.setStatus(buildDto.getStatus());
        build.setIniProcess(buildDto.getIniProcess());
        build.setEndProcess(buildDto.getEndProcess());

        build = buildRepository.save(build);

        return mapper.toDto(build);
    }

    public BuildDto update(Long id, BuildDto buildDto) {
        Build build = buildRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Build with id '%s' not found", id));

        build.setPipeline(pipelineRepository.getReferenceById(buildDto.getPipelineId()));
        build.setStatus(buildDto.getStatus());
        build.setIniProcess(buildDto.getIniProcess());
        build.setEndProcess(buildDto.getEndProcess());

        build = buildRepository.save(build);

        return mapper.toDto(build);
    }

    public void delete(Long id) {
        Build build = buildRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Build with id '%s' not found", id));

        buildRepository.delete(build);
    }

}