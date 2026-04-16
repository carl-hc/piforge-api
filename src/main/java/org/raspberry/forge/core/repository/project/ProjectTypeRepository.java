package org.raspberry.forge.core.repository.project;

import org.raspberry.forge.core.entity.project.ProjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTypeRepository extends JpaRepository<ProjectType, Long> {

}
