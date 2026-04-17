package org.raspberry.piforge.core.repository.pipeline;

import org.raspberry.framework.core.repository.GenericRepository;
import org.raspberry.piforge.core.entity.pipeline.PipelineStepParam;
import org.springframework.stereotype.Repository;

@Repository
public interface PipelineStepParamRepository extends GenericRepository<PipelineStepParam, Long> {

}
