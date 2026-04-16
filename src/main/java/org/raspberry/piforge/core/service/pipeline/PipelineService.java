package org.raspberry.piforge.core.service.pipeline;

import lombok.AllArgsConstructor;
import org.raspberry.piforge.core.dto.pipeline.PipelineDto;
import org.raspberry.piforge.core.entity.pipeline.Pipeline;
import org.raspberry.piforge.core.exception.NotFoundException;
import org.raspberry.piforge.core.mapper.pipeline.PipelineMapper;
import org.raspberry.piforge.core.repository.pipeline.PipelineRepository;
import org.raspberry.piforge.core.repository.project.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PipelineService {

    private final PipelineRepository pipelineRepository;
    private final ProjectRepository projectRepository;

    private final PipelineMapper mapper;

    public PipelineDto findById(Long id) {
        Pipeline pipeline = pipelineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pipeline with id '%s' not found", id));

        return mapper.toDto(pipeline);
    }

    public List<PipelineDto> findAll() {
        List<Pipeline> pipelineList = pipelineRepository.findAll();

        return mapper.toDto(pipelineList);
    }

    public PipelineDto create(PipelineDto pipelineDto) {
        Pipeline pipeline = new Pipeline();
        pipeline.setProject(projectRepository.getReferenceById(pipelineDto.getProjectId()));
        pipeline.setName(pipelineDto.getName());

        pipeline = pipelineRepository.save(pipeline);

        return mapper.toDto(pipeline);
    }

    public PipelineDto update(Long id, PipelineDto pipelineDto) {
        Pipeline pipeline = pipelineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pipeline with id '%s' not found", id));

        pipeline.setProject(projectRepository.getReferenceById(pipelineDto.getProjectId()));
        pipeline.setName(pipelineDto.getName());

        pipeline = pipelineRepository.save(pipeline);

        return mapper.toDto(pipeline);
    }

    public void delete(Long id) {
        Pipeline pipeline = pipelineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pipeline with id '%s' not found", id));

        pipelineRepository.delete(pipeline);
    }

}