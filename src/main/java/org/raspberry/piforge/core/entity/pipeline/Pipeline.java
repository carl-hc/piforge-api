package org.raspberry.piforge.core.entity.pipeline;

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
import org.raspberry.piforge.core.entity.build.Build;
import org.raspberry.piforge.core.entity.project.Project;

import java.util.List;

@Data
@Entity
@Table(name = "PIPELINE")
public class Pipeline {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "pipeline")
    private List<Build> builds;

    @OneToMany(mappedBy = "pipeline")
    private List<PipelineStep> pipelineSteps;

}