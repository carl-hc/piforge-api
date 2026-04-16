package org.raspberry.forge.core.repository.pipeline;

import org.raspberry.forge.core.entity.pipeline.PipelineStepType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PipelineStepTypeRepository extends JpaRepository<PipelineStepType, Long> {

}
