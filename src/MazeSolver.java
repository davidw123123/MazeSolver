import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MazeSolver {
    String currentPosition;
    int currentX = 0;
    int currentY = 0;
    String[][] maze;
    ArrayList<String> coordinates = new ArrayList<>();

    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                maze[i][j] = d.charAt(j) + "";
            }
        }
        return maze;
    }
    public boolean goUp()
    {
        try {
            if (!maze[currentX - 1][currentY].equals("#")) {
            return true;
            }
        return false;
        }
        catch (Exception e) {
            return false;
         }
    }
    public boolean goDown() {
       try{ if (!maze[currentX + 1][currentY].equals("#")) {
            return true;
        }
        return false;
       } catch (Exception e)
        {
        return false;
        }
    }
    public boolean goLeft()
    {
        try {
            if (!maze[currentX][currentY - 1].equals("#")) {
                return true;
            }
            return false;
        } catch (Exception e)
            {
                return false;
            }
        }
    public boolean goRight() {
       try{ if (!maze[currentX][currentY + 1].equals("#")) {
            return true;
        }
        return false;
    }  catch (Exception e)
        {
            return false;
        }
    }
    public MazeSolver(String fileName)
    {
        maze = getMaze(fileName);
        currentPosition = "(0,0)";
    }

    public void movePosition()
    {
        if (goDown() && !maze[currentX][currentY].equals( "-" ))
        {
            coordinates.add("(" + currentX + "," + currentY + ")");
            maze[currentX][currentY] = "-";
            currentX = currentX+1;
        }
        if (goUp()&&!maze[currentX][currentY].equals( "-" ))
        {
            coordinates.add("(" + currentX + "," + currentY + ")");
            maze[currentX][currentY] = "-";
            currentX = currentX-1;
        }
        if (goRight()&&!maze[currentX][currentY].equals( "-" ))
        {
            coordinates.add("(" + currentX + "," + currentY + ")");
            maze[currentX][currentY] = "-";
            currentY = currentY+1;
        }
        if (goLeft()&&!maze[currentX][currentY].equals( "-" ))
        {
            coordinates.add("(" + currentX + "," + currentY + ")");
            maze[currentX][currentY] = "-";
            currentY = currentY-1;
        }
    }

    public ArrayList<String> getCoordinates()
    {
        return coordinates;
    }
    public String[][] getMaze() {
        return maze;
    }
    public void partOne()
    {
        while (currentX = maze.length && currentY = maze[0].length)
        {
            movePosition();
            if ()
        }
    }
}
