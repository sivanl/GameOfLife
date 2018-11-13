import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sivanlauf on 13/11/2018.
 */
public class GameOfLifeInfectionTests {

    @Test
    public void nextGenerationInfectionTest(){

        GameOfLifeInfection goli = new GameOfLifeInfection(3, 3, Game.convertToGrid("0 0 0 1 0 0 1 0 1", 3 , 3));
        goli.nextGeneration();
        Assert.assertEquals(goli.gridToString(), "1 1 0 1 0 1 1 0 0");

    }

    @Test
    public void hasVerOrzLiveNeighborsTest(){
        GameOfLifeInfection goli = new GameOfLifeInfection(3, 3, Game.convertToGrid("0 0 0 1 0 0 1 0 1", 3 , 3));
        boolean  hasLiveNeighbors = goli.hasVerOrzLiveNeighbors(2, 1);
        Assert.assertTrue(hasLiveNeighbors);

    }
}
