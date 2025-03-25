package com.example.demo.persistence;

import com.example.demo.domain.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
    // save, findById, delete( ) 기본메소드가 자동으로 구현됨

    // 새로운 메소드 추가
    //@Query(value="select * from Todo t where t.userId = ?1")
    List<TodoEntity> findByUserId(String userId);

    List<TodoEntity> findByUserIdAndTitle(String userId, String title);
    List<TodoEntity> findByTitle(String title);
}
