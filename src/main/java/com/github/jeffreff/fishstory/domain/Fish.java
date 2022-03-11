package com.github.jeffreff.fishstory.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private boolean isGutted;

    public Fish() {
        type = "DEFAULT";
        weight = 99.99;
        isGutted = false;
    }

    public Fish(Long id, String type, double weight, boolean isGutted) {
        this.id = id;
        this.type = type;
        this.weight = weight;
        this.isGutted = isGutted;
    }

    public Fish(String type, double weight, boolean isGutted) {
        this.type = type;
        this.weight = weight;
        this.isGutted = isGutted;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isGutted() {
        return isGutted;
    }

    public void setGutted(boolean gutted) {
        isGutted = gutted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Fish fish = (Fish) o;
        return Double.compare(fish.weight, weight) == 0 && isGutted == fish.isGutted && Objects.equals(id, fish.id)
                && Objects.equals(type, fish.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, weight, isGutted);
    }

    @Override
    public String toString() {
        return "Fish{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", isGutted=" + isGutted +
                '}';
    }
}
