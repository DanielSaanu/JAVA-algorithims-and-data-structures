import java.util.*;
import java.io.*;
public class Lab10
{
    public static void main (String[] args)
    {   
        File file = new File("C:\\Users\\Danzo\\Java projects\\CS_Labs\\lab10\\Maze5.txt");

        int lives = 200;
        int posX = 0;
        int posY = 0;
        String[] input = new String[20];
        try 
        {
            Scanner scan = new Scanner(file);

            for(int i = 0; i < 20; i++) 
            {
                input[i] = scan.nextLine(); // read the maze
            }
            posX=Integer.parseInt(scan.nextLine()); //this is where you appear
            posY=Integer.parseInt(scan.nextLine());
            scan.close();
        } 
        catch (Exception e) 
        {
            System.err.println(e);
        }

        boolean[][] maze = new boolean[20][20];
        boolean[][] visited = new boolean[20][20];// Initialize visited array 
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<20;j++)
            {
                if(input[i].charAt(j)=='X')
                {
                    maze[i][j]=false; //there's a wall
                }else
                {
                    maze[i][j]=true; //there's a space
                }
            }
        }
        Brain myBrain = new Brain(visited);// Pass the visited array to Brain


        while(lives>0)
        {
            System.out.println("Current position: "+posX+" "+posY);
            for(int i=0;i<20;i++)
                { //print out the map
                for(int j=0;j<20;j++)
                {
                    if(posX==i&&posY==j)
                    {
                        System.out.print("o");
                    }else if(maze[i][j]==true)
                    {
                        System.out.print(" "); //there is a space
                    }else
                    {
                        System.out.print("X"); //there is a wall
                    }
                }
                System.out.println();
            }

            try
            {
                Thread.sleep(100);
            }catch (InterruptedException e) 
            {
                // Handle interrupted exception (if necessary)
                e.printStackTrace();
            }
            if (myBrain.dfs(maze, posX, posY)) {
                System.out.println("You found the exit at: " + posX + "," + posY);
                System.exit(0);
            }

            /*String move =myBrain.getMove(maze[posX-1][posY],maze[posX+1][posY],maze[posX][posY+1],maze[posX][posY-1]);
            if(move.equals("north")&&maze[posX-1][posY])
            {
                posX--; //if the brain wants to move North AND it's possible
            }else if(move.equals("south")&&maze[posX+1][posY])
            {
                posX++; //if the brain wants to move South AND it's possible
            }else if(move.equals("east")&&maze[posX][posY+1])
            {
                posY++;
            }else if(move.equals("west")&&maze[posX][posY-1])
            {
                posY--;
            }
            lives--;
            if(posY%19==0||posX%19==0)
            { //found a way out!
                System.out.println("You found the exit at: "+posX+","+posY);
                System.exit(0);
            }*/
            lives--;
        }
        System.out.println("You died in the maze!");
    }
}
class Brain
{
    private boolean[][] visited;

    public Brain(boolean[][] visited) 
    {
        this.visited = visited;
    }
        public boolean dfs(boolean[][] maze, int posX, int posY) 
    {
        if (posX < 0 || posX >= maze.length || posY < 0 || posY >= maze[0].length || maze[posX][posY] == false || visited[posX][posY]) 
        {
            return false; // Base case return false
        }
        visited[posX][posY]=true;

        if(posY%19==0||posX%19==0)
        {
            //found a way out!
            System.out.println("You found the exit at: "+posX+","+posY);
            System.exit(0);
            return true;
        }
        if((dfs(maze,posX-1,posY)&&maze[posX-1][posY])|| ((dfs(maze,posX+1,posY))&&maze[posX+1][posY])||((dfs(maze,posX,posY-1)&&maze[posX][posY-1]))||((dfs(maze,posX,posY+1)&&maze[posX][posY+1])))
        {
            return true;
        }
        visited[posX][posY]=false;
        return false;
    }
    
    /*//this is the dumbest possible strategy - random
    public String getMove(boolean north, boolean south, boolean east, boolean west)
    {
        boolean[][] visited;
        int random = (int)(Math.random()*4);
        switch(random)
        {
            case 0: return "north";
            case 1: return "south";
            case 2: return "east";
            default: return "west";
        }
    }*/

}