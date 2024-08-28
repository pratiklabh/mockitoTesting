package com.sts.mockitotesting.testClasses;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl {

    private UserService userService;

    public UserServiceImpl(UserService userService) {
        this.userService = userService;
    }

    public List<User> retrieveUsersWithNameContaining(String substring) {
        List<User> filteredUsers = new ArrayList<>();
        List<User> users = userService.retrieveUsers();

        for (User user : users) {
            if (user.getName().contains(substring)) {
                filteredUsers.add(user);
            }
        }
        return filteredUsers;
    }
}
