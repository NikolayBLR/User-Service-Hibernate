package org.example.console;

import org.example.controller.UserController;
import org.example.entity.User;

import java.util.Scanner;

public class Console {

    private final Scanner scanner = new Scanner(System.in);
    private final UserController userController;

    public Console(UserController userController) {
        this.userController = userController;
    }


    public User saveUser() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите емаил");
        String email = scanner.nextLine();
        System.out.println("Введите возраст");
        Integer age = scanner.nextInt();

        User user = new User(name, email, age);
        return userController.saveUser(user);

    }

    public User getUser() {
        System.out.println("Введите айди");
        Integer id = scanner.nextInt();
        return userController.getUser(id);
    }

    public User deleteUser() {
        System.out.println("Введите айди");
        Integer id = scanner.nextInt();
        return userController.deleteUser(id);
    }

    public User updateUser() {
        System.out.println("Введите айди");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите емаил");
        String email = scanner.nextLine();
        System.out.println("Введите возраст");
        Integer age = scanner.nextInt();
        return userController.updateUser(id, new User(name, email, age));
    }
}
