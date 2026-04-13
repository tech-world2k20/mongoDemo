package com.mongoProject.MongoDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootTest
public class MongoTemplateTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void monoTemplateTest(){

//      with mongotemplate you can pass the query with criteria where you can build dynamic query condition

//        List<Task> tasks = mongoTemplate.findAll(Task.class);
//        tasks.forEach(System.out::println);

        Criteria criteria1 = Criteria.where("severity").is(2);

        Criteria criteria2 = Criteria.where("taskHistory.status").is(TaskStatus.IN_PROGRESS);
        Criteria criteria3 = Criteria.where("taskHistory.status").in(TaskStatus.IN_PROGRESS, TaskStatus.PENDING);

        Query query3 = new Query(criteria1.and("storyPoints").gte(3));
        Query query4 = new Query(new Criteria().andOperator(criteria1,criteria2));

        Query query = new Query(criteria1);
        List<Task> tasks = mongoTemplate.find(query, Task.class);

        tasks.forEach(System.out::println);
    }


}
