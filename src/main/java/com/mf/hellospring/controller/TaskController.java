package com.mf.hellospring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mf.hellospring.domain.Task;
import com.mf.hellospring.dto.TaskDTO;
import com.mf.hellospring.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	private final TaskService service;

	public TaskController(TaskService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<TaskDTO> create(@Valid @RequestBody TaskDTO in) {
		Task saved = service.save(new Task(null, in.title(), in.description()));
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new TaskDTO(saved.getId(), saved.getTitle(), saved.getDescription()));
	}

	@GetMapping
	public List<TaskDTO> list() {
		return service.all().stream().map(t -> new TaskDTO(t.getId(), t.getTitle(), t.getDescription())).toList();
	}

	@GetMapping("/{id}")
	public TaskDTO get(@PathVariable Long id) {
		Task t = service.one(id);
		return new TaskDTO(t.getId(), t.getTitle(), t.getDescription());
	}
}