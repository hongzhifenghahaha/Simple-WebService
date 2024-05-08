package com.database;

import java.util.ArrayList;

/**
 * Interface <em>JdbcServiceDatabase</em> is a interface define operations of the database
 *
 * @author Hong Zhifeng
 */
public interface ServiceDatabase {

    /**
     * Determine whether username and password are correct
     *
     * @param username name of user
     * @param password password of user
     */
    boolean isUserMatch(String username, String password);

    /**
     * Determine whether user has exist in the database
     *
     * @param username name of user
     */
    boolean isUsernameExist(String username);

    /**
     * Insert new user into the database
     *
     * @param username name of user
     * @param password password of user
     */
    void insertUser(String username, String password);

    /**
     * Get all user
     *
     * @return user list
     */
    ArrayList<String> getAllUser();

    /**
     * Insert a new _todo_ into the database
     */
    void insertTodo(String creator, String startTime, String endTime, String description);

    /**
     * Get all todos in [startTime, endTime] created by the creator
     * @param creator creator of the _todo_
     * @param startTime start time of the _todo_
     * @param endTime end time of the _todo_
     */
    ArrayList<String> getAllTodo(String creator, String startTime, String endTime);

    /**
     * Determine whether the _todo_ exists with the id 'todoID'
     * @param todoID id of the _todo_
     */
    boolean isTodoExist(String todoID);

    /**
     * Determine whether the _todo_ with id 'todoID' is created by the user
     * @param username name of the user
     * @param todoID id of the _todo_
     */
    boolean isTodoCreatedByUser(String username, String todoID);

    /**
     * Delete _todo_ by id created by the user
     * @param username name of the user who created the _todo_
     * @param todoID id of the _todo_ to be deleted
     */
    void deleteTodoByID(String username, String todoID);

    /**
     * Delete all _todo_ created by the user
     * @param username name of the user
     */
    void clearAllTodoCreatedByUser(String username);
}
