package org.raspberry.forge.core.repository.runtime;

import org.raspberry.forge.core.entity.runtime.Runtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuntimeRepository extends JpaRepository<Runtime, Long> {

}
