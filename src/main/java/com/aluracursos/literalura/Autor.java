package com.aluracursos.literalura;

public class Autor {

    private String name;
    private int birth_year;
    private int death_year;

    // Constructor vacío (necesario para deserialización)
    public Autor() {
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public int getDeath_year() {
        return death_year;
    }

    public void setDeath_year(int death_year) {
        this.death_year = death_year;
    }

    // Método toString() para representación de cadena
    @Override
    public String toString() {
        return "Autor{" +
                "name='" + name + '\'' +
                ", birth_year=" + birth_year +
                ", death_year=" + death_year +
                '}';
    }
}
