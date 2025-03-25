package com.example.demo.service;


import com.example.demo.domain.TodoEntity;
import com.example.demo.persistence.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public String testService() {
        TodoEntity entity = TodoEntity.builder().title("My first todo item").build();

        repository.save(entity);

        TodoEntity savedEntity = repository.findById(entity.getId()).get();

        return savedEntity.getTitle();
    }

    public List<TodoEntity> create(TodoEntity entity) {
        validate(entity);

        repository.save(entity);

        log.info("entity id: {} is created", entity.getId());

        return repository.findByUserId(entity.getUserId() );
    }

    private void validate(TodoEntity entity) {
        if(entity == null) {
            log.warn("entity is null");
            throw new RuntimeException("entity is null");
        }

        if(entity.getUserId() == null) {
            log.warn("entity.getUserId is null");
            throw new RuntimeException("entity.getUserId is null");
        }
    }

    public List<TodoEntity> retrieve(final String userId) {
        return repository.findByUserId(userId);
    }

    public List<TodoEntity> update(final TodoEntity entity) {
        validate(entity);

        final Optional<TodoEntity> original = repository.findById(entity.getId());

        original.ifPresent(todo -> {
            todo.setTitle(entity.getTitle());
            todo.setDone(entity.isDone());

            repository.save(todo);
        });

        return retrieve(entity.getUserId());
    }
}















