import java.util.Arrays;
public class MazeRunner {
    public static void main(String[] args) {
        MazeSolver mazeSolver = new MazeSolver("src/mazeFile");
        mazeSolver.solver();
        System.out.println(mazeSolver.getCoordinates());
        for (String[] temp : mazeSolver.getMaze())
        {
            System.out.println(Arrays.toString(temp));
        }
    }

}