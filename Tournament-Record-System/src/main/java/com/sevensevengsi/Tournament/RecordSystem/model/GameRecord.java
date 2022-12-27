package com.sevensevengsi.Tournament.RecordSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "gameRecord")
public class GameRecord {
    @Id
    private int game_id;

    private String day;

    private String gameDate = LocalDateTime.now().toString();

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public GameRecord() {
    }

    public GameRecord(String day, String gameDate) {
        this.day = day;
        this.gameDate = gameDate;
    }
}
