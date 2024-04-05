package com.example.tarefa_03.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tarefa_03.domain.Post;
import com.example.tarefa_03.repository.PostRepository;

// A anotação @Service é usada para indicar que uma classe é um "Service" (ou "Service Layer").
// A anotação @Service é um especialização da anotação @Component e é usada para anotar classes de serviço.
// A anotação @Component é uma superclasse para outras anotações de componentes, como @Repository, @Service e @Controller.
// Uma classe anotada com @Service é tipicamente uma classe que fornece serviços de negócios, como lógica de negócios e regras de negócios.
@Service
public class PostService {

        // A anotação @Autowired é usada para injetar dependências automaticamente.
        // A anotação @Autowired pode ser usada para injetar beans em propriedades, métodos e construtores.
        @Autowired
        PostRepository repository;

        public List<Post> getAll() {
                try {
                        List<Post> posts = new ArrayList<Post>();

                        // O método findAll() retorna um Iterable que é percorrido com o método
                        // forEach() que adiciona cada item à lista items.
                        // O operador :: é usado para criar expressões lambda mais claras e concisas.
                        // A expressão lambda items::add é usada para adicionar cada item retornado pelo
                        // método findAll() à lista items.
                        // A expressão lambda items::add é equivalente a: (item) -> items.add(item)
                        repository.findAll().forEach(posts::add);
                        return posts;
                } catch (Exception e) {
                        return null;
                }
        }

        public Post getById(Long id) {
                Optional<Post> post = repository.findById(id);
                if (post.isPresent()) {
                        return post.get();
                }
                return null;
        }

        public Post create(Post post) {
                return repository.save(post);
        }

        public Post update(Long id, Post post) {
                Optional<Post> existingPostOptional = repository.findById(id);

                if (existingPostOptional.isPresent()) {
                        Post existingPost = existingPostOptional.get();
                        existingPost.setTitle(post.getTitle());
                        return repository.save(existingPost);
                } else {
                        return null;
                }
        }

        public boolean delete(Long id) {
                try {
                        repository.deleteById(id);
                        return true;
                } catch (Exception e) {
                        return false;
                }
        }
}
