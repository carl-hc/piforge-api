package org.raspberry.forge.core.entity.pipeline;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.raspberry.forge.core.entity.project.Project;

@Data
@Entity
@Table(name = "PIPELINE")
public class Pipeline {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PROJECT")
    private Project project;

    @Column(name = "NAME")
    private String name;

}