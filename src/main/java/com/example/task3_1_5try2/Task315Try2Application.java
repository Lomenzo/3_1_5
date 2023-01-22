package com.example.task3_1_5try2;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Task315Try2Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Task315Try2Application.class, args);
        UserService userService = ctx.getBean(UserService.class);

        List<User> userList= userService.getAllUsersList();
        for (User user : userList) {
            System.out.println(user.getId() + user.getName() + user.getLastName() + user.getAge());
        }
    }
}
