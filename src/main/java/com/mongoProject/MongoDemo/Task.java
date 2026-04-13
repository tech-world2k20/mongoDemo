package com.mongoProject.MongoDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@CompoundIndex(name = "idx_severity_assignee", def = "{'severity':1, 'assignee':1}")
public class Task {
    @Id
    private String taskId;
    private String description;
    @Indexed
    private int severity;
    private String assignee;
    private int storyPoint;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    private TaskHistory taskHistory;
}
