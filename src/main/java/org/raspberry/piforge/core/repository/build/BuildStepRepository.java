package org.raspberry.piforge.core.repository.build;

import org.raspberry.piforge.core.entity.build.BuildStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildStepRepository extends JpaRepository<BuildStep, Long> {

}
