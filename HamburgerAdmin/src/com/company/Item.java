package com.company;

public class Item {
    private String name;
    private double price;
    private boolean isCombo;
    private double comboPrice;

    public Item(String name, double price) {
        this.name=name;
        this.price=price;
        this.isCombo=false;
        this.comboPrice=0;
    }

    public Item(String name, double price, boolean isCombo, double comboPrice) {
        this.name = name;
        this.price = price;
        this.isCombo = isCombo;
        this.comboPrice = comboPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCombo() {
        return isCombo;
    }

    public void setCombo(boolean combo) {
        isCombo = combo;
    }

    public double getComboPrice() {
        return comboPrice;
    }

    public void setComboPrice(double comboPrice) {
        this.comboPrice = comboPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", isCombo=" + isCombo +
                ", comboPrice=" + comboPrice +
                '}';
    }
}
