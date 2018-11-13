/**
 * Created by sivanlauf on 13/11/2018.
 */
public class GameOfLifeInfection extends GameOfLife {

    private static final int LIVE_NEIGHBORS = 1;


    public GameOfLifeInfection(int width, int height, int[][] data){
        super(width, height,data);
    }

    /**
     *
     * Calculating for each cell what wil be its verdict in the next generation (will he live or die
     * The rules are:
     * Any dead cell with a single live neighbor lives on to the next generation.
     * Any live cell with no horizontal or vertical live neighbors dies.
     */
    public void nextGeneration(){
        int[][] future = new int[width][height];

        // Loop through every cell
        for (int l = 0; l < width; l++){
            for (int m = 0; m < height; m++){
                // finding no Of Neighbours that are alive
                int aliveNeighbours = countLiveNeighbors(l, m);

                // Implementing the Rules of infected life
                // DEAD cell with one live neighbor lives
                if ((grid[l][m] == Cell.DEAD.getValue()) && (aliveNeighbours == LIVE_NEIGHBORS))
                    future[l][m] = Cell.LIVE.getValue();

                else if((grid[l][m] == Cell.LIVE.getValue()) && (!hasVerOrzLiveNeighbors(l,m))){
                    future[l][m] = Cell.DEAD.getValue();
                }

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


    public boolean hasVerOrzLiveNeighbors(int x, int y){
        return checkHorizontal(x, y) || checkVertical(x,y);

    }

    private boolean checkVertical(int x, int y){
        if(y > 0){
            if(grid[x][y-1] == Cell.LIVE.getValue()){
                return true;
            }
        }
        if(y < height-1){
            if(grid[x][y+1] == Cell.LIVE.getValue()){
                return true;
            }
        }
        return false;
    }

    private boolean checkHorizontal(int x, int y){
        if(x > 0){
            if(grid[x-1][y] == Cell.LIVE.getValue()){
                return true;
            }
        }
        if(x < width-1){
            if(grid[x+1][y] == Cell.LIVE.getValue()){
                return true;
            }
        }
        return false;
    }
}
