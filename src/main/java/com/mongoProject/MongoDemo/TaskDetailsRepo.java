package com.mongoProject.MongoDemo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TaskDetailsRepo extends MongoRepository<TaskDetails,String> {
}