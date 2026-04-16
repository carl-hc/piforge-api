package org.raspberry.piforge.core.service.runtime;

import lombok.AllArgsConstructor;
import org.raspberry.piforge.core.dto.runtime.RuntimeVersionDto;
import org.raspberry.piforge.core.entity.runtime.RuntimeVersion;
import org.raspberry.piforge.core.exception.NotFoundException;
import org.raspberry.piforge.core.mapper.runtime.RuntimeVersionMapper;
import org.raspberry.piforge.core.repository.runtime.RuntimeRepository;
import org.raspberry.piforge.core.repository.runtime.RuntimeVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RuntimeVersionService {

    @Autowired
    private RuntimeRepository runtimeRepository;
    @Autowired
    private RuntimeVersionRepository runtimeVersionRepository;

    @Autowired
    private RuntimeVersionMapper mapper;

    public RuntimeVersionDto findById(Long id) {
        RuntimeVersion runtimeVersion = runtimeVersionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("RuntimeVersion with id '%s' not found", id));

        return mapper.toDto(runtimeVersion);
    }

    public List<RuntimeVersionDto> findAll() {
        List<RuntimeVersion> runtimeVersionList = runtimeVersionRepository.findAll();

        return mapper.toDto(runtimeVersionList);
    }

    public RuntimeVersionDto create(RuntimeVersionDto runtimeVersionDto) {
        RuntimeVersion runtimeVersion = new RuntimeVersion();
        runtimeVersion.setRuntime(runtimeRepository.getReferenceById(runtimeVersionDto.getRuntimeId()));
        runtimeVersion.setVersion(runtimeVersionDto.getVersion());
        runtimeVersion.setPath(runtimeVersionDto.getPath());

        runtimeVersion = runtimeVersionRepository.save(runtimeVersion);

        return mapper.toDto(runtimeVersion);
    }

    public RuntimeVersionDto update(Long id, RuntimeVersionDto runtimeVersionDto) {
        RuntimeVersion runtimeVersion = runtimeVersionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("RuntimeVersion with id '%s' not found", id));

        runtimeVersion.setRuntime(runtimeRepository.getReferenceById(runtimeVersionDto.getRuntimeId()));
        runtimeVersion.setVersion(runtimeVersionDto.getVersion());
        runtimeVersion.setPath(runtimeVersionDto.getPath());

        runtimeVersion = runtimeVersionRepository.save(runtimeVersion);

        return mapper.toDto(runtimeVersion);
    }

    public void delete(Long id) {
        RuntimeVersion runtimeVersion = runtimeVersionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("RuntimeVersion with id '%s' not found", id));

        runtimeVersionRepository.delete(runtimeVersion);
    }

}