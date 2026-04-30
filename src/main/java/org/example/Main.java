package org.example;


import org.example.console.Console;
import org.example.console.ConsoleView;
import org.example.controller.UserController;
import org.example.mapper.UserMapperDTO;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.example.utilita_hibernate.HibernateUtilita;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        UserController userController = new UserController(userService);
        Console console = new Console(userController);
        ConsoleView consoleView = new ConsoleView(console);
        consoleView.view();
        HibernateUtilita.shutdown();


    }
}