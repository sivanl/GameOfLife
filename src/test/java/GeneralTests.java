import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sivanlauf on 13/11/2018.
 */
public class GeneralTests {

    @Test
    public void IsValidGridTest(){
        boolean isValid = Game.isGridValid(3, 3, "0 0 0 0 1 0 0 1 0");
        Assert.assertTrue(isValid);

        boolean isValid2 = Game.isGridValid(3, 5, "0 0 0 0 1 0 0 1 0");
        Assert.assertFalse(isValid2);

    }

}
