package com.akhil.machine.coding;

public class Grid {
    private int size;
    private char grid[][];

    Grid(int size){
        this.size = size;
        this.grid = new char[size][size];
        initialize();
    }

    public void initialize(){
        for(int i =0; i<size; i++)
            for(int j=0; j<size; j++)
                grid[i][j] = '-';
    }

    public void currentState(){
        for(int i =0; i<size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }
}
