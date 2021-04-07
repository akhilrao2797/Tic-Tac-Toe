package com.akhil.machine.coding;

public class Player {
    private String name;
    private char gameChar;

    Player(String name, char gameChar){
        this.name = name;
        this.gameChar = gameChar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGameChar() {
        return gameChar;
    }

    public void setGameChar(char gameChar) {
        this.gameChar = gameChar;
    }
}
