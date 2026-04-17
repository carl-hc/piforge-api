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

@Data
@Entity
@Table(name = "PIPELINE_STEP_PARAM")
public class PipelineStepParam {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PIPELINE_STEP_ID")
    private PipelineStep pipelineStep;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PARAM_VALUE")
    private String value;

}