package com.example.lab22.Models;


import java.util.List;

public class Pokemon {
    private final String name;
    private final int imageResourceId;
    private final int hp;
    private final List<Attack> attacks;

    /**
     * Конструктор для создания объекта Pokemon.
     *
     * @param name             Имя покемона.
     * @param imageResourceId  Идентификатор ресурса изображения покемона.
     * @param hp               Количество здоровья покемона.
     * @param attacks          Список атак, которые покемон может выполнять.
     */
    public Pokemon(String name, int imageResourceId, int hp, List<Attack> attacks) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.hp = hp;
        this.attacks = attacks;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getHp() {
        return hp;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }
}

