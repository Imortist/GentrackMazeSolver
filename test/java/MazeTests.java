import com.home.Maze;
import org.junit.Test;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MazeTests {
    private Maze maze = new Maze("D:\\Coding\\Java\\Projects\\GentrackMazeSolver\\src\\main\\resources\\input.txt");

    public MazeTests() throws IOException {
    }


    @Test
    public void getMazeWidth_Test(){
        assertEquals(5, maze.getMazeWidth());
    }

    @Test
    public void getMazeHeight_Test(){
        assertEquals(6, maze.getMazeHeight());
    }

    @Test
    public void getSTART_X_Test(){
        assertEquals(1,maze.getStartingX());
    }

    @Test
    public void getStart_Y_Test(){
        assertEquals(2,maze.getStartingY());
    }

    @Test
    public void getEnd_X_Test(){
        assertEquals(3, maze.getEndingX());
    }
}

