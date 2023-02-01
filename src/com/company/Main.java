package com.company;

import java.util.Arrays;

public class Main extends MiniJava{
    public static void main(String[] args) {
        int pinguRow = 0;
        int pinguColumn = 3;
        int[][] world = generateExampleWorldOne();
        printWorld(world, pinguRow, pinguColumn);
        write(""+isFishReachable(world, pinguRow, pinguColumn));
    }
    public static void printWorld(int[][] world, int pinguRow, int pinguColumn) {
        String[][] stringArr = new String[world.length][world[0].length];
        for (int i = 0; i < stringArr.length; i++) {
            for (int j = 0; j < stringArr[0].length; j++) {
                if (world[i][j] == 0) {
                    stringArr[i][j] = "L";
                }
                if (world[i][j] == 1) {
                    stringArr[i][j] = "I";
                }
                if (world[i][j] == 2) {
                    stringArr[i][j] = "W";
                }
                if (world[i][j] == 3) {
                    stringArr[i][j] = "S";
                }
                if (world[i][j] == 4){
                    stringArr[i][j] = "F";
                }
                if (i==pinguRow && j==pinguColumn){
                    stringArr[i][j] +="(P)\t";
                    if (stringArr[i].length-1 == j){
                        System.out.print(stringArr[i][j]);
                    }else {
                        System.out.print(stringArr[i][j] + "");
                    }
                }else if (stringArr[i].length-1 == j){
                    System.out.print(stringArr[i][j]);
                }else {
                    System.out.print(stringArr[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }


    public static boolean isFishReachable(int[][] world, int pinguRow, int pinguColumn) {
        if (pinguRow >= world.length || pinguColumn >= world[0].length
                || pinguColumn<0 || pinguRow<0 || world[pinguRow][pinguColumn] == 3)
            return false;
        if (world[pinguRow][pinguColumn] == 4){
            return true;
        }
        int prevoiusPositioin = world[pinguRow][pinguColumn];
        world[pinguRow][pinguColumn] = 5;
        if (prevoiusPositioin==5){
            return false;
        }

        switch (prevoiusPositioin){
            case (2):{
            if (isFishReachable(world, pinguRow + 3, pinguColumn + 3))
                return true;
            if (isFishReachable(world, pinguRow - 3, pinguColumn - 3))
                return true;
            if(isFishReachable(world, pinguRow + 3, pinguColumn - 3))
                return true;
            if (isFishReachable(world, pinguRow - 3, pinguColumn + 3))
                return true;
            break;
            }
            case (1):{
                if(isFishReachable(world,pinguRow+1, pinguColumn+1))
                    return true;
                if (isFishReachable(world,pinguRow-1, pinguColumn-1))
                    return true;
                if (isFishReachable(world,pinguRow+1, pinguColumn-1))
                    return true;
                if(isFishReachable(world,pinguRow-1, pinguColumn+1))
                    return true;
                break;
            }
            case (0):{
                if(isFishReachable(world,pinguRow,pinguColumn+1))
                    return true;
                if (isFishReachable(world,pinguRow+1,pinguColumn))
                    return true;
                if (isFishReachable(world,pinguRow,pinguColumn-1))
                    return true;
                if (isFishReachable(world,pinguRow-1,pinguColumn))
                    return true;
                break;
            }
        }
        return false;
    }
    /**
     * returns the example world 1.
     * Do not modify this method.
     * @return An example world
     */
    public static int[][] generateExampleWorldOne(){
        return new int[][] {{2,3,3,1,3,3},
                            {3,0,3,3,4,3},
                            {3,3,3,3,3,1},
                            {3,3,3,0,1,3},
                            {3,3,3,3,3,3}};
    }

    /**
     * returns the example world 1.
     * Do not modify this method.
     * @return An example world
     */
    public static int[][] generateExampleWorldTwo(){
        return new int[][] {{0,0,0,2},
                            {0,0,0,1},
                            {0,1,3,4},
                            {3,4,3,3}};
    }

    /**
     *  You may use the main method for testing your program.
     */
}
