package com.example.task_management;

import com.example.task_management.entity.Status;
import com.example.task_management.entity.Task;
import com.example.task_management.repository.TaskRepo;
import com.example.task_management.service.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class taskTest {

    @Mock
    private TaskRepo repo;
    @InjectMocks
    private TaskService service;



    @Test
    void testTask(){
        Task task1 = new Task (1L,"project","description", Status.PENDING);
        Task task2 = new Task(2L,"HW","homw work",Status.IN_PROGRESS);
        when(repo.findAll()).thenReturn(List.of(task1,task2));
        List<Task> result =service.getAll();
        assertEquals(2,result.size());
    }

}
