package com.sevensevengsi.Tournament.RecordSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {

    @Id
    private int game_id;

    private String category;

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Game() {
    }

    public Game(String category) {
        this.category = category;
    }

}
