package com.akhil.machine.coding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GridService {
    LinkedList<Player> playerList = new LinkedList<>();
    Grid grid;

    GridService(int size, List<Player> players){
        grid = new Grid(size);
        playerList.addAll(players);
        grid.currentState();
    }

    public Player start(){
        Scanner scan = new Scanner(System.in);
        Player currentPlayer = null;
        boolean gameOver = false;
        while(!gameOver) {
            currentPlayer = playerList.pollFirst();
            System.out.println("Enter the cell number");
            boolean valid = false;
            int value[] = new int[]{};
            while(!valid) {
                value = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                valid = validate(currentPlayer, value[0], value[1]);
            }
            gameOver = isGameOver(currentPlayer, value[0], value[1]);
            playerList.add(currentPlayer);
        }
        return gameOver ? currentPlayer : null;
    }

    private boolean validate(Player player, int row, int col){
        if(row > grid.getSize() || col > grid.getSize() || grid.getGrid()[row][col] != '-')
            return false;
        return true;
    }

    private boolean isGameOver(Player player, int row, int col){
        boolean gameOver = true;
        for(int i=0; i< grid.getSize(); i++)
            if(grid.getGrid()[row][i] != player.getGameChar()){
                gameOver = false;
                break;
            }
        if(gameOver)
            return true;

        for(int i=0; i< grid.getSize(); i++)
            if(grid.getGrid()[i][row] != player.getGameChar()){
                gameOver = false;
                break;
            }

        if(gameOver)
            return true;


        if(row==col || row+col == grid.getSize()-1) {
            for (int i = 0; i < grid.getSize(); i++)
                if (grid.getGrid()[i][i] != player.getGameChar()) {
                    gameOver = false;
                    break;
                }
            if(gameOver)
                return true;

            int val = grid.getSize()-1;
            for (int i = 0; i < grid.getSize(); i++) {
                if (grid.getGrid()[i][val] != player.getGameChar()) {
                    gameOver = false;
                    break;
                }
                val--;
            }
            if(gameOver)
                return true;
        }
        else
            return false;

        return false;
    }
}
