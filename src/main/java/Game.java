import org.apache.commons.lang3.StringUtils;

/**
 * Created by sivanlauf on 13/11/2018.
 */
public class Game {

    public static void main(String[] args) {

            //Before we can start play we need to verify that the input is valid
            if(isValidInput(args)){
                int count = 0;
                int width = Integer.parseInt(args[0]);
                int height = Integer.parseInt(args[1]);
                int infectAfter = Integer.parseInt(args[2]);
                int maxGeneration = Integer.parseInt(args[3]);
                GameOfLife gol = new GameOfLife(width, height, convertToGrid(args[4], width, height));
                System.out.println(args[4]);

                //We calculate future generations until we rich maxGeneration
                while(count <= maxGeneration) {

                    //After a certain number of generations we start playing with new rules (infection)
                    if(count == infectAfter){
                        gol = new GameOfLifeInfection(width, height, gol.grid);
                    }
                    gol.nextGeneration();
                    count++;
                }
            }
    }

    public static boolean isValidInput(String args[]){
        if(args.length < 5){
            System.out.println("Not enough arguments");
            return false;
        }
        if(args.length > 5){
            System.out.println("Too many arguments");
            return false;
        }
        if(!isAllNumeric(args)){
            System.out.println("All arguments must be numeric");
            return false;
        }
        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        String grid = args[4];
        if(!isGridValid(width, height, grid)){
            System.out.println("Grid data is not valid");
            return false;
        }

        return true;
    }


    public static boolean isAllNumeric(String args[]){
        for(int i=0; i<4; i++){
            if(!StringUtils.isNumeric(args[i])){
                return false;
            }
        }
        return true;
    }

    public static boolean isGridValid(int width, int height, String data){
        String grid[] = data.split(" ");
        int gridSize = grid.length;
        if(width * height != gridSize)
            return false;
        for(String cell : grid){
            if(!StringUtils.isNumeric(cell)){
                return false;
            }
            int value = Integer.parseInt(cell);
            if(value != 0 && value != 1){
                return false;
            }
        }

        return true;
    }


    public static int[][] convertToGrid(String data, int width, int height){
        String grid[] = data.split(" ");
        int[][] intarray = new int[width][height];
        int column = 0;
        int row = 0;
        for(int i=0; i< grid.length ; i++){
            intarray[row][column] = Integer.parseInt(grid[i]);
            column++;
            if(column == width){
                row++;
                column=0;
                System.out.println();
            }

        }
        return intarray;

    }


}
