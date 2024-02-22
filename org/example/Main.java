package org.example;

import java.util.Arrays;
import java.util.Scanner;
import model.User;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[3];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < users.length; i++) {
            System.out.println("Пользователь " + (i + 1) + " Детали:");
            System.out.print("Имя: ");
            String firstName = scanner.nextLine();
            System.out.print("Фамилия: ");
            String lastName = scanner.nextLine();
            System.out.print("Возраст: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            User user = new User(firstName, lastName, age);
            users[i] = user;
        }

        int action;
        String username;
        String password;
        boolean isAuthenticated = false;
        do {
            System.out.println("\nВведите имя: ");
            username = scanner.nextLine();
            System.out.println("Введите пароль: ");
            password = scanner.nextLine();

            if (username.equals("admin") && password.equals("password")) {
                isAuthenticated = true;
                System.out.println("Привет, Admin!");
                while (true) {
                    System.out.println("\n1. Создать пользователя");
                    System.out.println("2. Удалить пользователя");
                    System.out.println("3. Просмотреть массив пользователей");
                    System.out.println("4. Выйти");
                    System.out.print("Введите номер действия: ");
                    action = scanner.nextInt();
                    scanner.nextLine();

                    if (action == 1) {
                        System.out.print("Имя: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Фамилия: ");
                        String lastName = scanner.nextLine();
                        System.out.print("Возраст: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        User newUser = new User(firstName, lastName, age);
                        User[] newUsers = Arrays.copyOf(users, users.length + 1);
                        newUsers[users.length] = newUser;
                        users = newUsers;

                        System.out.println("Пользователь создан!");
                    } else if (action == 2) {
                        System.out.print("Введите имя пользователя для удаления: ");
                        String deleteUserName = scanner.nextLine();

                        User[] newUsers = new User[users.length - 1];
                        int j = 0;
                        for (int i = 0; i < users.length; i++) {
                            if (!users[i].getFirstName().equals(deleteUserName)) {
                                newUsers[j] = users[i];
                                j++;
                            }
                        }
                        users = newUsers;

                        System.out.println("Пользователь удален!");
                    } else if (action == 3) {
                        System.out.println("\nДетали пользователей:");
                        for (User user : users) {
                            user.printUserDetails();
                        }
                    } else if (action == 4) {
                        break;
                    } else {
                        System.out.println("Неправильное действие!");
                    }
                }
            } else if (username.equals("user") && password.equals("password")) {
                isAuthenticated = true;
                System.out.println("Привет, User!");
                while (true) {
                    System.out.println("\n1. Просмотреть массив пользователей");
                    System.out.println("2. Выйти");
                    System.out.print("Введите номер действия: ");
                    action = scanner.nextInt();
                    scanner.nextLine();

                    if (action == 1) {
                        System.out.println("\nДетали пользователей:");
                        for (User user : users) {
                            user.printUserDetails();
                        }
                    } else if (action == 2) {
                        break;
                    } else {
                        System.out.println("Неправильное действие!");
                    }
                }
            } else {
                System.out.println("Неправильное имя пользователя или пароль!");
            }
        } while (!isAuthenticated);


        System.out.println("\nДетали пользователей:");
        for (User user : users) {
            user.printUserDetails();
        }

        System.out.println("\nПользователи:");
        for (User user : users) {
            user.printUserSummary();
        }
    }
}