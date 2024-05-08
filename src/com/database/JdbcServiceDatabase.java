package com.database;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class <em>JdbcServiceDatabase</em> is a class provides operation with database
 *
 * @author Hong Zhifeng
 */
public class JdbcServiceDatabase implements ServiceDatabase {
    private Connection conn;

    /**
     * JdbcServiceDatabase constructor
     */
    public JdbcServiceDatabase() {
        try {
            String sqlUrl = "jdbc:sqlite:ServiceInformation.db";
            conn = DriverManager.getConnection(sqlUrl);
        } catch (SQLException e) {
            System.out.println("Error Message: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Determine whether username and password are correct
     *
     * @param username name of user
     * @param password password of user
     */
    @Override
    public boolean isUserMatch(String username, String password) {
        boolean isMatch = false;
        try {
            String sql = "SELECT * FROM user WHERE username=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                isMatch = true;
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR MESSAGE: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isMatch;
    }

    /**
     * Determine whether user has exist in the database
     *
     * @param username name of user
     */
    @Override
    public boolean isUsernameExist(String username) {
        boolean isExist = false;
        try {
            String sql = "SELECT * FROM user WHERE username=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                isExist = true;
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR MESSAGE: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExist;
    }

    /**
     * Insert new user into the database
     *
     * @param username name of user
     * @param password password of user
     */
    @Override
    public void insertUser(String username, String password) {
        try {
            String sql = "INSERT INTO user VALUES (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL ERROR MESSAGE: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all user
     *
     * @return user list
     */
    @Override
    public ArrayList<String> getAllUser() {
        ArrayList<String> userList = new ArrayList<String>();
        try {
            String sql = "SELECT username FROM user";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                userList.add(rs.getString("username"));
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR MESSAGE: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    /**
     * Insert a new _todo_ into the database
     */
    @Override
    public void insertTodo(String creator, String startTime, String endTime, String description) {
        try {
            String sql = "INSERT INTO todo(creator, start_time, end_time, description) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, creator);
            preparedStatement.setString(2, startTime);
            preparedStatement.setString(3, endTime);
            preparedStatement.setString(4, description);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL ERROR MESSAGE: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all todos in [startTime, endTime] created by the creator
     * @param creator creator of the _todo_
     * @param startTime start time of the _todo_
     * @param endTime end time of the _todo_
     */
    @Override
    public ArrayList<String> getAllTodo(String creator, String startTime, String endTime){
        ArrayList<String> todoList = new ArrayList<String>();
        try {
            String sql = "SELECT * FROM todo WHERE creator=? AND start_time >= ? AND end_time <= ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,creator);
            preparedStatement.setString(2,startTime);
            preparedStatement.setString(3,endTime);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                todoList.add(String.format("%-20s%-30s%-30s%-30s\n",rs.getString("id"),
                        rs.getString("start_time"),rs.getString("end_time"),rs.getString("description")));
            }
        } catch (SQLException e){
            System.out.println("SQL ERROR MESSAGE: " + e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
        return todoList;
    }

    /**
     * Determine whether the _todo_ exists with the id 'todoID'
     * @param todoID id of the _todo_
     */
    @Override
    public boolean isTodoExist(String todoID) {
        boolean isExist = false;
        try {
            String sql = "SELECT * FROM todo WHERE id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,todoID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                isExist = true;
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR MESSAGE: " + e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
        return isExist;
    }

    /**
     * Determine whether the _todo_ with id 'todoID' is created by the user
     * @param username name of the user
     * @param todoID id of the _todo_
     */
    @Override
    public boolean isTodoCreatedByUser(String username, String todoID) {
        boolean isCreator = false;
        try {
            String sql = "SELECT * FROM todo WHERE creator = ? AND id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,todoID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                isCreator = true;
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR MESSAGE: " + e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
        return isCreator;
    }

    /**
     * Delete _todo_ by id created by the user
     * @param username name of the user who created the _todo_
     * @param todoID id of the _todo_ to be deleted
     */
    @Override
    public void deleteTodoByID(String username, String todoID){
        try {
            String sql = "DELETE FROM todo where creator = ? AND id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,todoID);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println("SQL ERROR MESSAGE: " + e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Delete all _todo_ created by the user
     * @param username name of the user
     */
    @Override
    public void clearAllTodoCreatedByUser(String username){
        try {
            String sql = "DELETE FROM todo where creator = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println("SQL ERROR MESSAGE: " + e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
