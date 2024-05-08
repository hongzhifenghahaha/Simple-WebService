package com.client;

import com.todoservices.TodoListInterfaceService;
import com.todoservices.TodoListServiceService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class <em>Client</em> is a class provides the Client function
 *
 * @author Hong Zhifeng
 */
public class Client {
    public static BufferedReader br;
    private TodoListInterfaceService todoListService;
    private String nowUsername;

    /**
     * Client constructor
     */
    public Client() {
        // get todoListService interface object from TodoListServiceService
        todoListService = (TodoListInterfaceService) new TodoListServiceService().getTodoListServicePort();
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Main process starts the client
     */
    public static void main(String[] args) throws IOException {
        try {
            Client client = new Client();
            client.registerOrLogin();
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Try to register or login
     */
    public void registerOrLogin() throws IOException {
        /*
         * get params from keyboard
         */
        System.out.println("\nRegister:\n" +
                "\tusage: register <userName> <password>");
        System.out.println("Login:\n" +
                "\tusage: login <userName> <password>");
        String command = br.readLine().trim();
        String[] params = command.split("\\s+");
        while (params.length != 3) {
            System.out.println("Error: incorrect command, please register or login again\n");
            System.out.println("\nRegister:\n" +
                    "\tusage: register <userName> <password>");
            System.out.println("Login:\n" +
                    "\tusage: login <userName> <password>");
            command = br.readLine().trim();
            params = command.split("\\s+");
        }

        /*
         * print results
         */
        String result;
        if (params[0].equals("register")) {
            result = todoListService.register(params[1], params[2]);
        } else if (params[0].equals("login")) {
            result = todoListService.login(params[1], params[2]);
        } else {
            result = "Error: incorrect parameter, please input register or login";
        }
        System.out.println(result);
        if (!result.equals("Successful!")) {
            registerOrLogin();
        } else {
            nowUsername = params[1];
        }
    }

    /**
     * Run client, print the menu and handle operations
     */
    public void run() throws IOException {
        printMenu();

        while (true) {
            System.out.println("Input an operation:");
            String command = br.readLine().trim();
            String[] params = command.split("\\s+");

            // check whether arguments is legal
            if (!checkArguments(params[0], params.length)) {
                continue;
            }

            // handle different operations
            switch (params[0]) {
                case "list":
                    System.out.println(todoListService.listUsers());
                    break;
                case "add":
                    StringBuilder description = new StringBuilder();
                    for (int i=3; i<params.length; i++){
                        description.append(params[i]).append(" ");
                    }
                    System.out.println(todoListService.addTodo(nowUsername, params[1], params[2], description.toString()));
                    break;
                case "delete":
                    System.out.println(todoListService.deleteTodo(nowUsername, params[1]));
                    break;
                case "clear":
                    System.out.println(todoListService.clearTodo(nowUsername));
                    break;
                case "query":
                    System.out.println(todoListService.queryTodos(nowUsername,params[1], params[2]));
                    break;
                case "help":
                    printMenu();
                    break;
                case "quit":
                    System.out.println("quit successfully");
                    return;
                default:
                    System.out.println("Error: incorrect command. Please try again");
            }
        }
    }


    /**
     * Check whether arguments is legal
     * @param command command got from keyboard
     * @param paramLength length of parameters
     */
    public boolean checkArguments(String command, int paramLength) {
        boolean checkPassed = true;
        switch (command) {
            case "list":
            case "clear":
            case "help":
            case "quit":
                if (paramLength != 1) {
                    checkPassed = false;
                }
                break;
            case "add":
                if (paramLength < 4) {
                    checkPassed = false;
                }
                break;
            case "delete":
                if (paramLength != 2) {
                    checkPassed = false;
                }
                break;
            case "query":
                if (paramLength != 3) {
                    checkPassed = false;
                }
                break;
            default:
                System.out.println("Error: incorrect command '" + command + "', please try again");
                return false;
        }
        if (!checkPassed) {
            System.out.println("Error: Wrong number of parameters, please try again");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Print the client menu
     */
    public void printMenu() {
        System.out.println("Service Menu:\n" +
                "\t1. List all users\n" + "\t\t\tusage: list\n" +
                "\t2. Add a new todo\n" + "\t\t\tusage: add <start> <end> <description>\n" +
                "\t3. Delete a todo by id\n" + "\t\t\tusage: delete <todoID>\n" +
                "\t4. Clear all todos\n" + "\t\t\tusage: clear\n" +
                "\t5. Query todos in a specific time period \n" + "\t\t\tusage: query <start> <end>\n" +
                "\t6. Get help\n" + "\t\t\tusage: help\n" +
                "\t7. Quit\n" + "\t\t\tusage: quit\n"
        );
    }
}