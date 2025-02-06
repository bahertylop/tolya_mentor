package org.example.glav5.questions.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    public static List<User> filterUsers(List<User> users, double maxUsingValue) {
        return users.stream()
                .filter(
                        (user) -> user.getUserUsings()
                                .stream()
                                .noneMatch((x) -> x > maxUsingValue)
                )
                .toList();
    }
}
