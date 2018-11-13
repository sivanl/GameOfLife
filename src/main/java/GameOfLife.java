import java.util.Arrays;

/**
 * Created by sivanlauf on 13/11/2018.
 */
public class GameOfLife {

    private static final int UNDER_POPULATION = 2;
    private static final int OVER_POPULATION = 3;
    private static final int REPRODUCTION = 3;

    public final int width;
    public final int height;

    public int[][] grid;

    public enum Cell{ LIVE(1), DEAD(0);
        private int value;
        private Cell(int value) {
            this.value = value;
        }
        public int getValue(){
            return value;
        }}

    public GameOfLife(int width, int height, int[][] data){
        this.width = width;
        this.height = height;
        grid = data;

    }

    /**
     *
     * Calculating for each cell what wil be its verdict in the next generation (will he live or die
     * The rules are:
     * Any live cell with fewer than two live neighbors dies (under population).
     * Any live cell with two or three live neighbors lives on to the next generation.
     * Any live cell with more than three live neighbors dies (overpopulation).
     * Any dead cell with exactly three live neighbors becomes a live cell (reproduction).
     */
    public void nextGeneration(){
        int[][] future = new int[width][height];

        // Loop through every cell
        for (int l = 0; l < width; l++){
            for (int m = 0; m < height; m++){
                // finding no Of Neighbours that are alive
                int aliveNeighbours = countLiveNeighbors(l, m);

                // Implementing the Rules of Life
                // Cell dies due to under population
                if ((grid[l][m] == Cell.LIVE.getValue()) && (aliveNeighbours < UNDER_POPULATION))
                    future[l][m] = Cell.DEAD.getValue();

                    // Cell dies due to over population
                else if ((grid[l][m] == Cell.LIVE.getValue()) && (aliveNeighbours > OVER_POPULATION))
                    future[l][m] = Cell.DEAD.getValue();

                    // Cell comes back to life
                else if ((grid[l][m] == Cell.DEAD.getValue()) && (aliveNeighbours == REPRODUCTION))
                    future[l][m] = Cell.LIVE.getValue();

                    // Remains the same
                else
                    future[l][m] = grid[l][m];
            }
        }
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                System.out.print(future[i][j] + " ");
            }
        }
        System.out.println();
        grid = future;
    }


    public int countLiveNeighbors(int x, int y){
        int count = 0;
        for(int i=x-1; i<x+2; i++){
            if(i>=0 && i< width) {
                for (int j = y - 1; j < y + 2; j++) {
                    if(j>=0 && j<height){
                        count+=grid[i][j];
                    }
                }
            }
        }
        count-=grid[x][y];

        return count;
    }

    public String gridToString(){
        String str = "";
        for(int i = 0; i< width; i++){
            for(int j = 0; j < height ; j++){
                str += grid[i][j] + " ";
            }
        }
        return str.trim();
    }
}
