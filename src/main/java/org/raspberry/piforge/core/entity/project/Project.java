package org.raspberry.piforge.core.entity.project;

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
import org.raspberry.piforge.core.entity.pipeline.Pipeline;

import java.util.List;

@Data
@Entity
@Table(name = "PROJECT")
public class Project {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PROJECT_TYPE_ID")
    private ProjectType projectType;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "project")
    private List<Pipeline> pipelines;

}
