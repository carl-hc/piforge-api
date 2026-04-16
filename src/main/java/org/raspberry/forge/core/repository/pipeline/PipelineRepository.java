package org.raspberry.forge.core.repository.pipeline;

import org.raspberry.forge.core.entity.pipeline.Pipeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PipelineRepository extends JpaRepository<Pipeline, Long> {

}
