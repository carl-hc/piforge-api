package org.raspberry.piforge.core.repository.pipeline;

import org.raspberry.framework.core.repository.GenericRepository;
import org.raspberry.piforge.core.entity.pipeline.PipelineStep;
import org.springframework.stereotype.Repository;

@Repository
public interface PipelineStepRepository extends GenericRepository<PipelineStep, Long> {

}
