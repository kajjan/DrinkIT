package com.TDA367.drinkit.Model;

public class Player { //gör privte om möjligt, se över övriga instanser i klass
    private String name;
    private int point;

    public Player(String name) {
        this.name = name;
        this.point = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    //method that makes a list that write the players name and its point in a list of strings.
    @Override
    public String toString() { //private
        return getName() + " " + getPoint() + " Points";
    }
}
