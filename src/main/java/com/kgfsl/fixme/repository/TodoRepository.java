package com.kgfsl.fixme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgfsl.fixme.model.Todo;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {



}