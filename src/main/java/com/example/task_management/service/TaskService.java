package com.example.task_management.service;

import com.example.task_management.entity.Status;
import com.example.task_management.entity.Task;
import com.example.task_management.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.task_management.entity.Status.PENDING;

@Service
public class TaskService {
    @Autowired
    private TaskRepo repo;
     public Task addTask (Task task){
         task.setStatus(PENDING);
         task.setId(generateNextId());
         return repo.save(task);

     }

     public Task updateTaskStatus(Long id, Status newStatus){
         Task task= repo.findById(id)
                 .orElseThrow(()->new RuntimeException("Task not found"));
         task.setStatus(newStatus);
         return repo.save(task);

     }

     public List<Task> getAll(){
         return repo.findAll();
     }

     public Task delete(Long id){
        Task task=repo.findById(id).orElse(null);
        if (task!=null){
             repo.deleteById(id);
        }
        return task;

     }

    private Long generateNextId() {
        // Get all existing IDs
        List<Long> ids = repo.findAll().stream()
                .map(Task::getId)
                .sorted()
                .toList();

        // Find the smallest missing number starting from 1
        long nextId = 1;
        for (Long id : ids) {
            if (id == nextId) {
                nextId++;
            } else {
                break; // found a gap
            }
        }
        return nextId;
    }
}
