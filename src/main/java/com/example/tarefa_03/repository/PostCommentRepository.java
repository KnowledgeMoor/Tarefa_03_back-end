package com.example.tarefa_03.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.tarefa_03.domain.PostComment;

public interface PostCommentRepository extends CrudRepository<PostComment,Long> {
    
}
