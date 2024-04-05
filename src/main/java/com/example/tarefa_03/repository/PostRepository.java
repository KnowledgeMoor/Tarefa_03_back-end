package com.example.tarefa_03.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.tarefa_03.domain.Post;

public interface PostRepository extends CrudRepository<Post,Long> {
    
}