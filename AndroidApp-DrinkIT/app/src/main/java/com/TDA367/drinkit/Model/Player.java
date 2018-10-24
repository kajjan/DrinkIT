package com.TDA367.drinkit.Model;

/**
 * This is the Player class which contain a String name and an int point
 *
 * @authors Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

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



}
