package org.raspberry.forge.core.repository.build;

import org.raspberry.forge.core.entity.build.BuildStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildStepRepository extends JpaRepository<BuildStep, Long> {

}
