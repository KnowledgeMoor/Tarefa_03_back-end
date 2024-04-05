package com.example.tarefa_03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tarefa_03.domain.PostComment;
import com.example.tarefa_03.service.PostCommentService;

@RestController
@RequestMapping("/postComment")
class PostCommentController {

        @Autowired
        PostCommentService service;

        @GetMapping
        public List<PostComment> getAll() {
                return service.getAll();
        }

        @GetMapping("{id}")
        public PostComment getById(@PathVariable("id") Long id) {
                return service.getById(id);
        }

        @PostMapping
        public PostComment create(@RequestBody PostComment item) {
                return service.create(item);
        }

        @PutMapping("{id}")
        public PostComment update(@PathVariable("id") Long id, @RequestBody PostComment item) {
                return service.update(id, item);
        }

        @DeleteMapping("{id}")
        public boolean delete(@PathVariable("id") Long id) {
                return service.delete(id);
        }
}