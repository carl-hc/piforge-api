package org.raspberry.piforge.core.repository.project;

import org.raspberry.framework.core.repository.GenericRepository;
import org.raspberry.piforge.core.entity.project.ProjectType;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTypeRepository extends GenericRepository<ProjectType, Long> {

}
