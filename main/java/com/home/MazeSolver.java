package com.home;

import java.io.*;

public class MazeSolver {

    private char[][] maze;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int width;
    private int height;

    private int getStartX(){
        return startX;
    }
    private int getStartY(){
        return startY;
    }

    // get input in 2d array
    private void buildMaze(String file) throws IOException {

        char temp;
        String line;
        int count = 1;
        int heightCounter = 0;
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null) {
            switch (count) {
                case (1):
                    width = Integer.parseInt(line.substring(0, line.indexOf(' ')));
                    height = Integer.parseInt((line.substring(line.indexOf(' ') + 1)));
                    maze = new char[height][width];
                    break;
                case (2):
                    temp = line.charAt(0);
                    startY = Character.getNumericValue(temp);
                    temp = line.charAt(2);
                    startX = Character.getNumericValue(temp);
                    break;
                case (3):
                    endY = Integer.parseInt(line.substring(0, line.indexOf(' ')));
                    endX = Integer.parseInt((line.substring(line.indexOf(' ') + 1)));
                    break;
                default:
                    int counter = 0;
                    for (int i = 0; i < line.length(); i++) {
                        if (line.charAt(i) != ' ') {
                            maze[heightCounter][counter] = line.charAt(i);
                            counter++;
                        }
                    }
                    heightCounter++;
                    break;
            }
            count++;
        }
    }

    // Change 1 & 0 to # ' '; add S and E to start and ending of the maze
    private void formatMaze() {

        maze[startX][startY] = 'S';
        maze[endX][endY] = 'E';

        for (int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {

                if(maze[i][j] == '1') {
                    maze[i][j] = '#';
                }

                if(maze[i][j] == '0') {
                    maze[i][j] = ' ';
                }
            }
        }
    }

    // check if maze can be solved
    private boolean canBeSolved(int i, int j) {
        //border wrapping
        if(i >= maze.length) i = 0;
        if(j >= maze.length) j = 0;
        if(i < 0) i = maze.length -1;
        if(j < 0) j = maze.length -1;

        if (maze[i][j] == '#') {
            return false;
        }

        if (maze[i][j] == 'E') {
            return true;
        }

        if (maze[i][j] == 'X') {
            return false;
        }

        maze[i][j] = 'X';

        //South
        if ((canBeSolved(i + 1, j))) {
            return true;
        }
        //West
        if ((canBeSolved(i, j - 1))) {
            return true;
        }
        //East
        if ((canBeSolved(i, j + 1))) {
            return true;
        }
        //North
        if ((canBeSolved(i - 1, j))) {
            return true;
        }

        maze[i][j] = ' ';
        return false;
    }

    // print path through solved maze
    private void printMaze() {

        maze[startX][startY] = 'S';
        for (char[] chars : maze) {
            System.out.println(chars);
        }
    }

    // interface method to be used in main.
    public void solve(String inputFile){
        try {
            buildMaze(inputFile);
        }catch (IOException ie){
            System.out.println("incorrect input");
        }
        formatMaze();
        if(canBeSolved(getStartX(),getStartY())){
            printMaze();
        }
        else System.out.println("Maze has no solutions.");
    }

}
