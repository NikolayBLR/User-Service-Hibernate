package org.example.console;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class ConsoleView {
    private Console console;
    private Scanner scanner = new Scanner(System.in);

    public ConsoleView(Console console) {
        this.console = console;
    }

    public void view() {
        System.out.println(" 1. Создать и сохранить пользователя");
        System.out.println(" 2. Обновить пользователя");
        System.out.println(" 3. Получить пользователя");
        System.out.println(" 4. Удалить пользователя");

        System.out.print("Введите номер: ");
        int number = scanner.nextInt();


        switch (number) {
            case 1:
                System.out.println(console.saveUser());
                break;
            case 2:
                System.out.println(console.updateUser());
                break;
            case 3:
                System.out.println(console.getUser());
                break;
            case 4:
                System.out.println(console.deleteUser());
                break;
            default:
                log.info("Такого номера с функцией не существует");
                break;

        }


    }
}
