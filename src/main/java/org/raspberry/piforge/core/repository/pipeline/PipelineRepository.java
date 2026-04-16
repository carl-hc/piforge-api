package org.raspberry.piforge.core.repository.pipeline;

import org.raspberry.piforge.core.entity.pipeline.Pipeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PipelineRepository extends JpaRepository<Pipeline, Long> {

}
