package com.epam.rd.java.basic.practice8.db;

import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBManager {

    private List<User> users;
    private List<Team> teams;
    private List<Team> userTeams;

    private static DBManager dbManager;

    private DBManager() {
        try {
            Class.forName(Constants.JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static DBManager getInstance() {
        if (dbManager == null) {
            dbManager = new DBManager();
        }
        return dbManager;
    }

    public Connection getConnection()
            throws SQLException {
        Properties properties = new Properties();
        try (FileInputStream stream = new FileInputStream("app.properties")) {
            properties.load(stream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String url = properties.getProperty("connection.url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }

    public void insertUser(User user) throws SQLException {
        ResultSet rs = null;
        DBManager db = DBManager.getInstance();
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Constants.INSERT_NEW_USER);
             PreparedStatement preparedStatement1 = connection.prepareStatement(Constants.SELECT_ID_FROM_USER)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.executeUpdate();
            preparedStatement1.setString(1, user.getLogin());
            rs = preparedStatement1.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void insertTeam(Team team) {
        ResultSet rs = null;
        DBManager db = DBManager.getInstance();
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Constants.INSERT_NEW_TEAM);
             PreparedStatement preparedStatement1 = connection.prepareStatement(Constants.SELECT_ID_FROM_TEAM)) {
            preparedStatement.setString(1, team.getName());
            preparedStatement.executeUpdate();
            preparedStatement1.setString(1, team.getName());
            rs = preparedStatement1.executeQuery();
            while (rs.next()) {
                team.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<User> findAllUsers() {
        ResultSet rs = null;
        users = new ArrayList<>();
        DBManager db = DBManager.getInstance();
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Constants.FIND_ALL_USERS);) {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String login = rs.getString("login");
                int id = rs.getInt("id");
                User user = new User(id, login);
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return users;
    }

    public List<Team> findAllTeams() {

        ResultSet rs = null;
        teams = new ArrayList<>();
        DBManager db = DBManager.getInstance();
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Constants.FIND_ALL_TEAMS);) {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                Team team = new Team(name);
                teams.add(team);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return teams;
    }

    public User getUser(String name) throws SQLException {
        User user = new User();
        ResultSet rs = null;
        DBManager db = DBManager.getInstance();
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE login =(?)");) {
            preparedStatement.setString(1, name);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return user;
    }


    public Team getTeam(String name) throws SQLException {
        Team team = new Team();
        ResultSet rs = null;
        DBManager db = DBManager.getInstance();
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM teams WHERE name =(?)");) {
            preparedStatement.setString(1, name);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                team.setId(rs.getInt("id"));
                team.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (rs != null) {
            rs.close();
        }
        return team;
    }

    public void setTeamsForUser(User user, Team... team) throws SQLException {
        Connection connection = null;
        DBManager db = DBManager.getInstance();
        connection = db.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users_teams  (user_id, team_id) VALUES (?,?)");) {
            connection.setAutoCommit(false);
            for (Team value : team) {
                preparedStatement.setInt(1, user.getId());
                preparedStatement.setInt(2, value.getId());
                preparedStatement.execute();
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.close();
        }
    }

    public List<Team> getUserTeams(User user) throws SQLException {
        ResultSet rs = null;
        userTeams = new ArrayList<>();
        DBManager db = DBManager.getInstance();
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Constants.GET_USER_TEAMS);) {
            preparedStatement.setInt(1, user.getId());
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                Team tm = new Team(name);
                userTeams.add(tm);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return userTeams;
    }

    public void deleteTeam(Team team) throws SQLException {
        DBManager db = DBManager.getInstance();
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Constants.DELETE_TEAM);) {
            preparedStatement.setString(1, team.getName());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    public void updateTeam(Team team) throws SQLException {
        DBManager db = DBManager.getInstance();
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Constants.UPDATE_TEAM);) {
            preparedStatement.setString(1, team.getName());
            preparedStatement.setInt(2, team.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
