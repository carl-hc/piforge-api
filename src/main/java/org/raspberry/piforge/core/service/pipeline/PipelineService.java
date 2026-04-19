package org.raspberry.piforge.core.service.pipeline;

import org.raspberry.piforge.core.dto.pipeline.PipelineDto;
import org.raspberry.piforge.core.entity.pipeline.Pipeline;
import org.raspberry.piforge.core.exception.NotFoundException;
import org.raspberry.piforge.core.mapper.pipeline.PipelineMapper;
import org.raspberry.piforge.core.repository.pipeline.PipelineRepository;
import org.raspberry.piforge.core.repository.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PipelineService {

    @Autowired
    private PipelineRepository pipelineRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PipelineMapper mapper;

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
        pipeline.setProject(projectRepository.getReferenceById(pipelineDto.projectId()));
        pipeline.setName(pipelineDto.name());

        pipeline = pipelineRepository.save(pipeline);

        return mapper.toDto(pipeline);
    }

    public PipelineDto update(Long id, PipelineDto pipelineDto) {
        Pipeline pipeline = pipelineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pipeline with id '%s' not found", id));

        pipeline.setProject(projectRepository.getReferenceById(pipelineDto.projectId()));
        pipeline.setName(pipelineDto.name());

        pipeline = pipelineRepository.save(pipeline);

        return mapper.toDto(pipeline);
    }

    public void delete(Long id) {
        Pipeline pipeline = pipelineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pipeline with id '%s' not found", id));

        pipelineRepository.delete(pipeline);
    }

}