package com.example.tarefa_03.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tarefa_03.domain.PostComment;
import com.example.tarefa_03.repository.PostCommentRepository;

// A anotação @Service é usada para indicar que uma classe é um "Service" (ou "Service Layer").
// A anotação @Service é um especialização da anotação @Component e é usada para anotar classes de serviço.
// A anotação @Component é uma superclasse para outras anotações de componentes, como @Repository, @Service e @Controller.
// Uma classe anotada com @Service é tipicamente uma classe que fornece serviços de negócios, como lógica de negócios e regras de negócios.
@Service
public class PostCommentService {

        // A anotação @Autowired é usada para injetar dependências automaticamente.
        // A anotação @Autowired pode ser usada para injetar beans em propriedades, métodos e construtores.
        @Autowired
        PostCommentRepository repository;

        public List<PostComment> getAll() {
                try {
                        List<PostComment> postComment = new ArrayList<PostComment>();

                        // O método findAll() retorna um Iterable que é percorrido com o método
                        // forEach() que adiciona cada item à lista items.
                        // O operador :: é usado para criar expressões lambda mais claras e concisas.
                        // A expressão lambda items::add é usada para adicionar cada item retornado pelo
                        // método findAll() à lista items.
                        // A expressão lambda items::add é equivalente a: (item) -> items.add(item)
                        repository.findAll().forEach(postComment::add);
                        return postComment;
                } catch (Exception e) {
                        return null;
                }
        }

        public PostComment getById(Long id) {
                Optional<PostComment> postComment = repository.findById(id);
                if (postComment.isPresent()) {
                        return postComment.get();
                }
                return null;
        }

        // método addComment()
        public PostComment create(PostComment postComment) {
                return repository.save(postComment);
        }

        public PostComment update(Long id, PostComment postComment) {
                Optional<PostComment> existingPostCommentOptional = repository.findById(id);

                if (existingPostCommentOptional.isPresent()) {
                        PostComment existingItem = existingPostCommentOptional.get();
                        existingItem.setReview(postComment.getReview());
                        return repository.save(existingItem);
                } else {
                        return null;
                }
        }

        // método removeComment()
        public boolean delete(Long id) {
                try {
                        repository.deleteById(id);
                        return true;
                } catch (Exception e) {
                        return false;
                }
        }

}
