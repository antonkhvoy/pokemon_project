package com.example.pokemon_project.Models;
import java.util.List;

public class Pokemon {
    private String name;
    private String imageResourceId;
    private int hp;
    private List<Attack> attacks;

    public Pokemon(String name, String imageResourceId, int hp, List<Attack> attacks) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.hp = hp;
        this.attacks = attacks;
    }

    public Pokemon() {

    }

    public String getName() {
        return name;
    }

    public String getImageResourceId() {
        return imageResourceId;
    }

    public int getHp() {
        return hp;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }
}

