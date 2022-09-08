package com.house;

public class House {
    private int id, flatNumber, square, floor, roomsCount;
    private String street;

    public House() { }

    public House(int id, int flatNumber, int square, int floor, int roomsCount, String street) {
        this.id = id;
        this.flatNumber = flatNumber;
        this.square = square;
        this.floor = floor;
        this.roomsCount = roomsCount;
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return  "id [ " + id + " ], flatnumber [ " + flatNumber + " ], square [ " + square + " ], floor [ " + floor +" ], roomscount [ " + roomsCount + " ], street [ " + street + " ]";
    }
}
