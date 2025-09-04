package com.mf.hellospring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mf.hellospring.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}