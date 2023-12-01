package com.example.pokemon_project.Models;


public class Attack {
    private String name;
    private String description;
    private String damage;

    public Attack(String name, String description, String damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
    }

    public Attack() {

    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getDamage() {
        return damage;
    }
}
