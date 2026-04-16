package org.raspberry.piforge.core.entity.pipeline;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.raspberry.piforge.core.entity.runtime.RuntimeVersion;

@Data
@Entity
@Table(name = "PIPELINE_STEP")
public class PipelineStep {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PIPELINE")
    private Pipeline pipeline;

    @ManyToOne
    @JoinColumn(name = "ID_PIPELINE_STEP_TYPE")
    private PipelineStepType pipelineStepType;

    @ManyToOne
    @JoinColumn(name = "ID_RUNTIME_VERSION")
    private RuntimeVersion runtimeVersion;

    @Column(name = "STEP_ORDER")
    private Long stepOrder;

    @Column(name = "COMMAND")
    private String command;

}