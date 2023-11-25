package com.example.pokemon_project.Models;


import java.util.List;

public class Pokemon {
    private String name;
    private String imageResourceId;
    private int hp;
    private List<Attack> attacks;

    /**
     * Конструктор для создания объекта Pokemon.
     *
     * @param name             Имя покемона.
     * @param imageResourceId  Идентификатор ресурса изображения покемона.
     * @param hp               Количество здоровья покемона.
     * @param attacks          Список атак, которые покемон может выполнять.
     */
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

