package org.raspberry.piforge.core.repository.pipeline;

import org.raspberry.piforge.core.entity.pipeline.PipelineStepType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PipelineStepTypeRepository extends JpaRepository<PipelineStepType, Long> {

}
