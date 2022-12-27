package com.sevensevengsi.Tournament.RecordSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team {
    @Id
    private int team_id;

    private String name;

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }
}
