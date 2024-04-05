package com.example.tarefa_03.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Post {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        String title;

        @JsonManagedReference
        @OneToMany(mappedBy = "post")
        List<PostComment> comments = new ArrayList<PostComment>();

         
        
}