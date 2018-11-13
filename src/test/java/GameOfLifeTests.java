import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sivanlauf on 13/11/2018.
 */
public class GameOfLifeTests {

    @Test
    public void nextGenerationTest(){
        GameOfLife gol = new GameOfLife(3, 3, Game.convertToGrid("0 0 0 1 0 0 1 0 1", 3 , 3));
        gol.nextGeneration();
        Assert.assertEquals(gol.gridToString(), "0 0 0 0 1 0 0 1 0");
    }


    @Test
    public void LiveNeighborsTest(){
        GameOfLife gol = new GameOfLife(3, 3, Game.convertToGrid("0 0 0 1 0 0 1 0 1", 3 , 3));
        int liveNeighbors = gol.countLiveNeighbors(1,1);
        Assert.assertEquals(liveNeighbors, 3);

    }
}
