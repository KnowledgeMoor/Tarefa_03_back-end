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

import com.example.tarefa_03.domain.Post;
import com.example.tarefa_03.service.PostService;

@RestController
@RequestMapping("/Post")
class PostController {

        @Autowired
        PostService service;

        @GetMapping
        public List<Post> getAll() {
                // Vemos aqui uma chamada à camada de serviço para buscar as categorias.
                // A camada de serviço não conhece o HTTP.
                // A camada de serviço lida com questões de negócio, o que inclui acesso aos dados da aplicação
                // A camada de controle lida com questões de HTTP
                List<Post> items = service.getAll();
                return items;
        }

        @GetMapping("{id}")
        public Post getById(@PathVariable("id") Long id) {
                return service.getById(id);
        }

        @PostMapping
        public Post create(@RequestBody Post item) {
                Post post = service.create(item);
                return post;
        }

        @PutMapping("{id}")
        public Post update(@PathVariable("id") Long id, @RequestBody Post item) {
                return service.update(id, item);
        }

        @DeleteMapping("{id}")
        public boolean delete(@PathVariable("id") Long id) {
                return service.delete(id);
        }
}