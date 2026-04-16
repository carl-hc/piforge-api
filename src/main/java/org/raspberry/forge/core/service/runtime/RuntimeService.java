package org.raspberry.forge.core.service.runtime;

import org.raspberry.forge.core.dto.runtime.RuntimeDto;
import org.raspberry.forge.core.entity.runtime.Runtime;
import org.raspberry.forge.core.exception.NotFoundException;
import org.raspberry.forge.core.mapper.runtime.RuntimeMapper;
import org.raspberry.forge.core.repository.runtime.RuntimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuntimeService {

    @Autowired
    private RuntimeRepository runtimeRepository;

    @Autowired
    private RuntimeMapper mapper;

    public RuntimeDto findById(Long id) {
        Runtime runtime = runtimeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Runtime with id '%s' not found", id));

        return mapper.toDto(runtime);
    }

    public List<RuntimeDto> findAll() {
        List<Runtime> runtimeList = runtimeRepository.findAll();

        return mapper.toDto(runtimeList);
    }

    public RuntimeDto create(RuntimeDto runtimeDto) {
        Runtime runtime = new Runtime();
        runtime.setName(runtimeDto.getName());

        runtime = runtimeRepository.save(runtime);

        return mapper.toDto(runtime);
    }

    public RuntimeDto update(Long id, RuntimeDto runtimeDto) {
        Runtime runtime = runtimeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Runtime with id '%s' not found", id));

        runtime.setName(runtimeDto.getName());

        runtime = runtimeRepository.save(runtime);

        return mapper.toDto(runtime);
    }

    public void delete(Long id) {
        Runtime runtime = runtimeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Runtime with id '%s' not found", id));

        runtimeRepository.delete(runtime);
    }

}