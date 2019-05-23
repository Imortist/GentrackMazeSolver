import com.home.MazeSolver;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println("Input file location and hit enter.");
        Scanner scanner = new Scanner(System.in);
        MazeSolver ms = new MazeSolver();
        ms.solve(scanner.nextLine());
    }
}