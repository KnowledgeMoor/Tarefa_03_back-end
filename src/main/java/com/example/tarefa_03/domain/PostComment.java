package com.example.tarefa_03.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class PostComment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        // Coloquei isso no lugar de @JsonIgnore porque não estava funcionando com @JsonIgnore.
        @JsonBackReference
        @ManyToOne
        private Post post;

        String review;
}
