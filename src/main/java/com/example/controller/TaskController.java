package com.example.controller;

import com.example.entity.Task;
import com.example.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> list() {
        return taskService.list();
    }

    @GetMapping("/unfinished")
    public List<Task> listUnfinished() {
        return taskService.listUnfinished();
    }

    @PostMapping
    public boolean add(@RequestBody Task task) {
        return taskService.save(task);
    }

    @GetMapping("/expired")
    public List<Task> listExpired() {
        return taskService.listExpired();
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable Integer id, @RequestBody Task task) {
        task.setId(id);
        return taskService.updateById(task);
    }

    @GetMapping("/upcoming")
    public List<Task> listUpcoming() {
        return taskService.listUpcoming();
    }
}