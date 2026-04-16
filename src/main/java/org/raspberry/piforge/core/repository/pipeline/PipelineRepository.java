package org.raspberry.piforge.core.repository.pipeline;

import org.raspberry.framework.core.repository.GenericRepository;
import org.raspberry.piforge.core.entity.pipeline.Pipeline;
import org.springframework.stereotype.Repository;

@Repository
public interface PipelineRepository extends GenericRepository<Pipeline, Long> {

}
