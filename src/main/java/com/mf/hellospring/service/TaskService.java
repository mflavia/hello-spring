package com.mf.hellospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mf.hellospring.domain.Task;
import com.mf.hellospring.repo.TaskRepository;

@Service
public class TaskService {

	private final TaskRepository repo;

	public TaskService(TaskRepository repo) {
		this.repo = repo;
	}

	public Task save(Task task) {
		return repo.save(task);
	}

	public List<Task> all() {
		return repo.findAll();
	}

	public Task one(Long id) {
		return repo.findById(id).orElseThrow();
	}
}