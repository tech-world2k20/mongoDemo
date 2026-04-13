package com.mongoProject.MongoDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskServiceTest {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskDetailsRepo taskDetailsRepo;

//    {
//  "description": "logging issue",
//  "severity": 2,
//  "assignee": "Abhishek kumar",
//  "storyPoint": 5,
//  "taskHistory": {
//      "assignedTo": "Anshika",
//      "status": "PENDING"
//
//  }
//}

    @Test
    public void testingTaskWithTaskDetailsSave(){
        TaskDetails details1 = TaskDetails.builder().sprintValue("3.2").org("IBM").build();
        TaskDetails details2 = TaskDetails.builder().sprintValue("3.1").org("IBM").build();

        details2 = taskDetailsRepo.save(details2);
        details1 = taskDetailsRepo.save(details1);
        Task task = Task.builder().description("testing aggregation with ref").severity(1)
                .assignee("john").storyPoint(2)
                .taskHistory(TaskHistory.builder().assignedTo("Sam").status(TaskStatus.IN_PROGRESS).build())
                .taskDetails(List.of(details2, details1))
                .build();

        taskRepository.save(task);

    }


    @Test
    public void testingGetTask(){
        List<Task> bySeverity = taskRepository.findBySeverity(1);

        bySeverity.forEach(System.out::println);

    }


}