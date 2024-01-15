package data;

import user.User;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class UserTable {
    private static List<User> users = new ArrayList<>();

    static {
        User user = new User("admin", "0000", "Vitaliy");
        User user1 = new User("user", "1111", "Alexandra");
        User user2 = new User("newUser", "2222", "Ivan");

        users.add(user);
        users.add(user1);
        users.add(user2);
    }
    private final File database = new File(
            "C:\\Users\\admin\\IdeaProjects\\hashAuthorization\\src\\main\\java\\data\\database.txt");

    public void insertUser(User user) {
        users.add(user);

        try {
            if (database.length() == 0) {
                addDatabase();
            }
            else {
                FileWriter fileWriter = new FileWriter(database, false);
                fileWriter.write(users.get(users.size() - 1).ID
                        + " " + users.get(users.size() - 1).NAME
                        + " " + users.get(users.size() - 1).USERNAME
                        + " " + HashPassword.hashPassword(users.get(users.size() - 1).PASSWORD));

                fileWriter.flush();

                fileWriter.close();
            }

            System.out.println("Successfully writen new user.");
        } catch (IOException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private void addDatabase() throws IOException, NoSuchAlgorithmException {
        FileWriter fileWriter = new FileWriter(database, false);

        for (User user: users) {
            fileWriter.write(user.ID
                    + " " + user.NAME
                    + " " + user.USERNAME
                    + " " + HashPassword.hashPassword(user.PASSWORD) + "\n");

            fileWriter.flush();
        }

        fileWriter.close();
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public void selectUsers(String request) {

    }

    public void updateUser(String request) {

    }
}
