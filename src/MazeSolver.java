import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MazeSolver {
    String currentPosition;
    int currentX = 0;
    int currentY = 0;
    int lastX;
    int lastY;
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
            if ((!maze[currentX - 1][currentY].equals("#")) && !maze[currentX - 1][currentY].equals("-")){
            return true;
            }
        return false;
        }
        catch (Exception e) {
            return false;
         }
    }
    public boolean goDown() {
       try{ if ((!maze[currentX + 1][currentY].equals("#") &&!maze[currentX + 1][currentY].equals("-"))) {
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
            if ((!maze[currentX][currentY - 1].equals("#") && !maze[currentX ][currentY- 1].equals("-"))) {
                return true;
            }
            return false;
        } catch (Exception e)
            {
                return false;
            }
        }
    public boolean goRight() {
       try{ if ((!maze[currentX][currentY + 1].equals("#") && !maze[currentX ][currentY+1].equals("-"))) {
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
        lastY = maze[0].length-1;
        lastX= maze.length-1;
    }

    public void movePosition()
    {
        if (goDown() && !maze[currentX][currentY].equals( "-" ))
        {
            coordinates.add("(" + currentX + "," + currentY + ")");
            maze[currentX][currentY] = "-";
            currentX = currentX+1;
            System.out.println();
            for (String[] temp : maze)
            {
                System.out.println(Arrays.deepToString(temp));
            }
        } else
        if (goUp()&&!maze[currentX][currentY].equals( "-" ))
        {
            coordinates.add("(" + currentX + "," + currentY + ")");
            maze[currentX][currentY] = "-";
            currentX = currentX-1;
            System.out.println();
            for (String[] temp : maze)
            {
                System.out.println("ee" + Arrays.deepToString(temp));
            }
        }else
        if (goRight())
        {
            coordinates.add("(" + currentX + "," + currentY + ")");
            maze[currentX][currentY] = "-";
            currentY = currentY+1;
            System.out.println();
            for (String[] temp : maze)
            {
               System.out.println(Arrays.deepToString(temp));
            }        }else
        if (goLeft())
        {
            coordinates.add("(" + currentX + "," + currentY + ")");
            maze[currentX][currentY] = "-";
            currentY = currentY-1;
            System.out.println();
            for (String[] temp : maze)
            {
               System.out.println(Arrays.deepToString(temp));
            }        }
    }

    public ArrayList<String> getCoordinates()
    {
        return coordinates;
    }
    public String[][] getMaze() {
        return maze;
    }
    public int periodCount()
    {
        int count=0;
        for (String[] period : maze)
        {
            for (String periods : period)
            {
                if (periods.equals("."))
                {
                    count++;
                }
            }
        }
        return count;
    }
    public void partOne()
    {

        int periodCount = periodCount();
        for (int i = 0; i < periodCount; i++) {
            movePosition();
        }
        coordinates.add("(" + lastX +"," + lastY+")"  );
        System.out.println(coordinates);
    }

}
