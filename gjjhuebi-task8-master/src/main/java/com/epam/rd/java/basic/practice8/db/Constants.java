package com.epam.rd.java.basic.practice8.db;

public class Constants {
    private Constants() {
    }

    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String INSERT_NEW_USER = "INSERT INTO users(login)" + "VALUES(?)";
    public static final String SELECT_ID_FROM_USER = "SELECT id FROM users WHERE login = (?)";
    public static final String SELECT_ID_FROM_TEAM = "SELECT id FROM teams WHERE name = (?)";
    public static final String INSERT_NEW_TEAM = "INSERT INTO teams(name)" + "VALUES(?)";
    public static final String FIND_ALL_USERS = "SELECT * FROM users ORDER BY id";
    public static final String FIND_ALL_TEAMS = "SELECT name FROM teams ORDER BY id";
    public static final String GET_USER_TEAMS = "SELECT name FROM teams WHERE id IN (SELECT team_id FROM users_teams WHERE user_id = (?))";
    public static final String DELETE_TEAM = "DELETE FROM teams WHERE name = (?)";
    public static final String UPDATE_TEAM = "UPDATE teams SET name = (?) WHERE id = (?)";
}
