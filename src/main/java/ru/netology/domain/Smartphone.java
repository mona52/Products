package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String producer;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (producer.toLowerCase().contains(search.toLowerCase())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone smartphone = (Smartphone) o;
        return Objects.equals(producer, smartphone.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), producer);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "producer='" + producer + '\'' +
                '}';
    }

}

