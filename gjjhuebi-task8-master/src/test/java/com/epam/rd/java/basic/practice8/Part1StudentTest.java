package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.DBManager;
import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;
import org.junit.*;
import org.mockito.Spy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertNotEquals;

public class Part1StudentTest {
    
    private static final String DB_URL = "jdbc:h2:~/rr";
    private static final String URL_CONNECTION = "jdbc:h2:~/rr;user=het;password=het;";
    private static final String USER = "het";
    private static final String PASS = "het";
    private static final String TEST_LOGIN = "somelogin";
    
    @Spy
    private static DBManager dbManager;

    @BeforeClass
    public static void beforeTest() throws SQLException {
        try (OutputStream output = new FileOutputStream("app.properties")) {
            Properties prop = new Properties();
            prop.setProperty("connection.url", URL_CONNECTION);
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
        dbManager = DBManager.getInstance();
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = con.createStatement()) {
            String sql = "DROP TABLE IF EXISTS teams; " +
                    "DROP TABLE IF EXISTS users; " +
                    "DROP TABLE IF EXISTS users_teams; ";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = con.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS users (\n" +
                    "  id INTEGER(11) NOT NULL AUTO_INCREMENT,\n" +
                    " login VARCHAR(20) NOT NULL, \n" +
                    "  PRIMARY KEY (id));";
            statement.executeUpdate(sql);
        }
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = con.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS teams (\n" +
                    "  id INTEGER(11) NOT NULL AUTO_INCREMENT,\n" +
                    " name VARCHAR(20) NOT NULL, \n" +
                    "  PRIMARY KEY (id));";
            statement.executeUpdate(sql);
        }
    }

    @After
    public void after() throws SQLException {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = con.createStatement()) {
            String sql = "DELETE FROM users WHERE login = '" + TEST_LOGIN + "' ;";
            statement.executeUpdate(sql);
        }
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = con.createStatement()) {
            String sql = "DELETE FROM teams WHERE name = '" + TEST_LOGIN + "' ;";
            statement.executeUpdate(sql);
        }
    }

    @AfterClass
    public static void afterTest() throws SQLException {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = con.createStatement()) {
            String sql = "DROP TABLE IF EXISTS users;";
            statement.executeUpdate(sql);
        }
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = con.createStatement()) {
            String sql = "DROP TABLE IF EXISTS teams;";
            statement.executeUpdate(sql);
        }

    }

    @Test
    public void shouldModifyUserId() throws SQLException {
        User user = new User(0, TEST_LOGIN);

        long id = user.getId();
        dbManager.insertUser(user);
        assertNotEquals(id, user.getId());
    }

    @Test
    public void shouldReturnListOfUsers() throws SQLException {
        User user = User.createUser(TEST_LOGIN);
        List<User> listOfUser = new ArrayList<>();
        listOfUser.add(user);
        dbManager.insertUser(user);
        Assert.assertEquals(listOfUser, dbManager.findAllUsers());
    }

    @Test
    public void shouldModifyTeamId() {
        Team team = new Team(0, TEST_LOGIN);

        long id = team.getId();
        dbManager.insertTeam(team);
        assertNotEquals(id, team.getId());
    }

    @Test
    public void shouldReturnListOfTeams() {
        Team team = Team.createTeam(TEST_LOGIN);
        List<Team> listOfTeams = new ArrayList<>();
        listOfTeams.add(team);
        dbManager.insertTeam(team);
        Assert.assertEquals(listOfTeams, dbManager.findAllTeams());
    }

}