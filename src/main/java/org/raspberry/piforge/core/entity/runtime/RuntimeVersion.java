package org.raspberry.piforge.core.entity.runtime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.raspberry.piforge.core.entity.pipeline.PipelineStep;

import java.util.List;

@Data
@Entity
@Table(name = "RUNTIME_VERSION")
public class RuntimeVersion {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "RUNTIME_ID")
    private Runtime runtime;

    @Column(name = "VERSION")
    private String version;

    @Column(name = "PATH")
    private String path;

    @OneToMany(mappedBy = "runtimeVersion")
    private List<PipelineStep> pipelineSteps;

}
