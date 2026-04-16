package org.raspberry.piforge.core.repository.build;

import org.raspberry.framework.core.repository.GenericRepository;
import org.raspberry.piforge.core.entity.build.Build;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildRepository extends GenericRepository<Build, Long> {

}
