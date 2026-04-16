package org.raspberry.piforge.core.repository.build;

import org.raspberry.framework.core.repository.GenericRepository;
import org.raspberry.piforge.core.entity.build.BuildStep;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildStepRepository extends GenericRepository<BuildStep, Long> {

}
