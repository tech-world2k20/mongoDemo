package com.mongoProject.MongoDemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskHistory {

    private String assignedTo;
    private TaskStatus status;
    @LastModifiedDate
    private LocalDateTime assignedDate;
}
