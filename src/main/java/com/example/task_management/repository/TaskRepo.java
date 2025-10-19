package com.example.task_management.repository;

import com.example.task_management.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TaskRepo extends JpaRepository<Task,Long>{
}
