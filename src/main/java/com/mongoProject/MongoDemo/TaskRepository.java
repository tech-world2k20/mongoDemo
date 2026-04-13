package com.mongoProject.MongoDemo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task,String> {

    List<Task> findBySeverity(int severity);

    @Query("{ assignee: ?0 }")
    List<Task> getTasksByAssignee(String assignee);

    List<Task> findBySeverityAndAssignee(int severity, String assignee);

    List<Task> findBySeverityOrderByModifiedAtDesc(int severity);

//    List<Task> findBySeverityGreaterThan(int severity);


    @Query("{ severity : { $gt : 2}}")
    List<Task> usingQueryAnnotation(int severity);

    List<Task> findByTaskHistoryAssignedTo(String assignedTo);
//    same to be achived if by query { "taskHistory.assignedTo" : "Anshika"}
}