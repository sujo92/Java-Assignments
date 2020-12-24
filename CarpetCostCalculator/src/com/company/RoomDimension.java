package com.company;

public class RoomDimension {
    private int length;
    private int width;

    public RoomDimension(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int area() {
        return this.width * this.length;
    }
}
