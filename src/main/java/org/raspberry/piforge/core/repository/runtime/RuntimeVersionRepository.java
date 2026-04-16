package org.raspberry.piforge.core.repository.runtime;

import org.raspberry.framework.core.repository.GenericRepository;
import org.raspberry.piforge.core.entity.runtime.RuntimeVersion;
import org.springframework.stereotype.Repository;

@Repository
public interface RuntimeVersionRepository extends GenericRepository<RuntimeVersion, Long> {

}
