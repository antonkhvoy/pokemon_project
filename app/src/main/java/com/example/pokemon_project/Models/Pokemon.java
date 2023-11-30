package com.example.pokemon_project.Models;


import java.util.List;

public class Pokemon {
    private String id;
    private String name;
    private Images images;
    private int hp;
    private List<Attack> attacks;

    public Pokemon(String name, Images images, int hp, List<Attack> attacks) {
        this.name = name;
        this.images = images;
        this.hp = hp;
        this.attacks = attacks;
    }

    public Pokemon() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Images getImages() {
        return images;
    }

    public int getHp() {
        return hp;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }
}

