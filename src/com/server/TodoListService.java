package com.server;

import com.database.JdbcServiceDatabase;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Class <em>TodoListService</em> is a class publish the todolist WebService
 *
 * @author Hong Zhifeng
 */
@WebService(name = "TodoListInterfaceService", portName = "TodoListServicePort", targetNamespace = "http://www.todoservices.com")
public class TodoListService {
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm");
    private final JdbcServiceDatabase db = new JdbcServiceDatabase();

    /**
     * TodoListService constructor
     */
    public TodoListService() {
        sdf.setLenient(false);
    }

    /**
     * Registration service for the user
     *
     * @param username name of the user
     * @param password password of the user
     * @return the registration result
     */
    @WebMethod
    public String register(String username, String password) {
        if (db.isUsernameExist(username)) {
            return "Register Error: username '" + username + "' already exists, please try again";
        } else {
            db.insertUser(username, password);
            return "Successful!";
        }
    }

    /**
     * Login service for the user
     *
     * @param username name of the user
     * @param password password of the user
     * @return the login result
     */
    @WebMethod
    public String login(String username, String password) {
        if (!db.isUserMatch(username, password)) {
            return "Login Error: incorrect username or password, please try again";
        } else {
            return "Successful!";
        }
    }


    /**
     * List all users and todos in the database
     *
     * @return user list and todolist
     */
    @WebMethod
    public String listUsers() {
        StringBuilder userString = new StringBuilder();

        /*
         * append users to listString
         */
        userString.append("User List:\n");
        userString.append("No.  userName\n");

        ArrayList<String> usernameList = db.getAllUser();
        if (usernameList.size() == 0){
            return "No user registered yet";
        }
        Iterator<String> userIterator = usernameList.iterator();
        int count = 1;
        while (userIterator.hasNext()) {
            userString.append(String.format("%-3d:  %s\n", count, userIterator.next()));
            count++;
        }

        return userString.toString();
    }


    /**
     * Add a new _todo_ for user in [startTime, endTime]
     *
     * @param username    name of _todo_ creator
     * @param startTime   start time of the _todo_
     * @param endTime     end time of the _todo_
     * @param description description of the _todo_
     * @return operation result
     */
    @WebMethod
    public String addTodo(String username, String startTime, String endTime, String description) {

        try {
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);

            if (startDate.after(endDate)) {
                return "Error: start time is later than end time";
            }

            startTime = startTime.replace('/', ' ');
            endTime = endTime.replace('/', ' ');

            db.insertTodo(username, startTime, endTime, description);
            return "Successfully add a todo for '" + username + "'\n";

        } catch (ParseException pe) {
            return "Time error: Please input a time like 'yyyy-MM-dd/HH:mm' in a reasonable range";
        }
    }


    /**
     * Query all todos in [startTime, endTime] of the user
     *
     * @param username  name of the user
     * @param startTime start time of the interval
     * @param endTime   end time of the interval
     * @return operation result
     */
    @WebMethod
    public String queryTodos(String username, String startTime, String endTime) {
        try {
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);

            if (startDate.after(endDate)) {
                return "Error: startTime after endTime";
            }

            startTime = startTime.replace('/', ' ');
            endTime = endTime.replace('/', ' ');

            StringBuilder todoString = new StringBuilder();
            /*
            append meetings to todoString
             */
            todoString.append("\n");
            todoString.append("Todo List:\n");
            todoString.append(String.format("%-20s%-30s%-30s%-30s\n", "id", "startTime", "endTime", "description"));

            ArrayList<String> todoList = db.getAllTodo(username, startTime, endTime);
            if (todoList.size() == 0){
                return "Failed: You have not todo in this period of time yet";
            }

            Iterator<String> todoIterator = todoList.iterator();
            while (todoIterator.hasNext()) {
                todoString.append(todoIterator.next());
            }
            return todoString.toString();

        } catch (ParseException pe) {
            return "Error: time format error. Please input it like 'yyyy-MM-dd/HH:mm'";
        }
    }

    /**
     * Delete _todo_ created by the user with id 'todoId'
     *
     * @param username name of the user
     * @param todoID   id of the _todo_ to be deleted
     * @return operation result
     */
    @WebMethod
    public String deleteTodo(String username, String todoID) {
        if (!db.isTodoExist(todoID)) {
            return "Failed: the todo with ID '" + todoID + "' does not exist";
        }

        if (!db.isTodoCreatedByUser(username, todoID)) {
            return "Failed: the todo with ID '" + todoID + "' is not created by user '" + username + "'";
        }

        db.deleteTodoByID(username, todoID);
        return "Successful: the todo with ID '" + todoID + "' has been deleted";
    }

    /**
     * Delete all todos created by user
     *
     * @param username name of the user
     */
    @WebMethod
    public String clearTodo(String username) {
        db.clearAllTodoCreatedByUser(username);
        return "Clear done.";
    }

    /**
     * @param args args[0]: ip or hostname, args[1]: port, args[2]: uri
     */
    public static void main(String[] args) {
        if (args.length != 3){
            System.out.println("Usage: server.TodoListService <ip or hostname> <port> <uri>");
        } else {
            String address = "http://" + args[0] + ":" + args[1] + args[2];
            Endpoint.publish(address, new TodoListService());
            System.out.println("wsdl地址 :" + address + "?WSDL");
        }
    }
}
