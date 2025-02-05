package com.hotel.entities;

public class Room {
    private long id;
    private float price;
    private int floor;
    private int capacity;

    public Room(long id, float price, int floor, int capacity) {
        this.id = id;
        this.price = price;
        this.floor = floor;
        this.capacity = capacity;
    }

    public Room() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", price=" + price +
                ", floor=" + floor +
                ", capacity=" + capacity +
                '}';
    }
}
