package com.juniorbocelli.xmobotscase.aerodrome.domain.entities;

public class Coordinates {
    private String positionX;
    private String positionY;

    public Coordinates(String positionX, String positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Coordinates() {
    }

    public String getPositionX() {
        return positionX;
    }

    public void setPositionX(String positionX) {
        this.positionX = positionX;
    }

    public String getPositionY() {
        return positionY;
    }

    public void setPositionY(String positionY) {
        this.positionY = positionY;
    }
}
