package org.raspberry.piforge.core.repository.pipeline;

import org.raspberry.framework.core.repository.GenericRepository;
import org.raspberry.piforge.core.entity.pipeline.PipelineStepType;
import org.springframework.stereotype.Repository;

@Repository
public interface PipelineStepTypeRepository extends GenericRepository<PipelineStepType, Long> {

}
