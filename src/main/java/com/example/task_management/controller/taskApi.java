package com.example.task_management.controller;

import com.example.task_management.entity.Status;
import com.example.task_management.entity.Task;
import com.example.task_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class taskApi {
    @Autowired
    private TaskService service;

    @PostMapping("/add")
    public Task addOp(@RequestBody Task task){
        return service.addTask(task);

    }
    @PatchMapping("/{id}")
    public Task updateStatus(@PathVariable Long id, @RequestBody Status newStatus){
        return service.updateTaskStatus(id,newStatus);
    }

    @DeleteMapping("/{id}")
    public Task deleteTask(@PathVariable Long id){
        return service.delete(id);
    }
    @GetMapping("/get_tasks")
    public List<Task> getAll(){
        return service.getAll();
    }

}
