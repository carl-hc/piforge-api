package org.raspberry.forge.core.entity.project;

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
@Table(name = "PROJECT")
public class Project {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PROJECT_TYPE")
    private ProjectType projectType;

    @Column(name = "NAME")
    private String name;

    @Column(name = "REPO_URL")
    private String repoUrl;

    @Column(name = "REPO_BRANCH")
    private String repoBranch;

}
