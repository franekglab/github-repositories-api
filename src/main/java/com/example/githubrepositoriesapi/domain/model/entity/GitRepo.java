package com.example.githubrepositoriesapi.domain.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity
@Table(name = "gitrepo")
public class GitRepo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String owner;

    @Column(nullable = false)
    String name;

    public GitRepo() {

    }

    public GitRepo(String owner, String name) {
        this.owner = owner;
        this.name = name;
    }

    public GitRepo(Long id, String owner, String name) {
        this.id = id;
        this.owner = owner;
        this.name = name;
    }
}
