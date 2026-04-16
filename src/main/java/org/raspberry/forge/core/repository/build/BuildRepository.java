package org.raspberry.forge.core.repository.build;

import org.raspberry.forge.core.entity.build.Build;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildRepository extends JpaRepository<Build, Long> {

}
