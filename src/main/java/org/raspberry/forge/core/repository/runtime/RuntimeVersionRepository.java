package org.raspberry.forge.core.repository.runtime;

import org.raspberry.forge.core.entity.runtime.RuntimeVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuntimeVersionRepository extends JpaRepository<RuntimeVersion, Long> {

}
