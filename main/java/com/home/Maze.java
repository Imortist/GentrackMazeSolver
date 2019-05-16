package com.home;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Maze  {
    private List<String> instructions;

    public Maze(String file) throws IOException {
        instructions = Files.readAllLines(Paths.get(file));
    }


    public int getMazeWidth(){
        return Integer.parseInt(instructions.get(0).substring(
                0,
                instructions.get(0).indexOf(' ')
                ));
    }

    public int getMazeHeight(){
        return Integer.parseInt(instructions.get(0).substring(instructions.get(0).indexOf(' ')).trim());
    }

    public int getStartingX() {
        return Integer.parseInt(instructions.get(1).substring(
                0,
                instructions.get(1).indexOf(' ')
        ));
    }

    public int getStartingY(){
        return Integer.parseInt(instructions.get(1).substring(instructions.get(1).indexOf(' ')).trim());
    }


    public int getEndingX() {
        return Integer.parseInt(instructions.get(2).substring(
                0,
                instructions.get(2).indexOf(' ')
        ));
    }
}
