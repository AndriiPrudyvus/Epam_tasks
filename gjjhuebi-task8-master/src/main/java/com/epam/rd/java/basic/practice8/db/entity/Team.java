package com.epam.rd.java.basic.practice8.db.entity;

import java.util.Objects;

public class Team {

    private String name;
    private int id;

    public Team(int id, String login) {
        this.id = id;
        this.name = login;
    }

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team)) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static Team createTeam(String name) {
        return new Team(name);
    }
}
