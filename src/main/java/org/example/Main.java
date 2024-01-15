package org.example;


import data.UserTable;
import user.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("user3", "4444", "Valeria");
        UserTable userTable = new UserTable();

        userTable.insertUser(user);
    }
}