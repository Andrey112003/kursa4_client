package ru.eltech.client.model;

public class Car {
    private int id;
    private String brand;
    private int year;
    private int price;

    public Car(int id, String brand, int year, int price) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public Car() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() { return id + "," + brand + "," + year + "," + price; }
}
