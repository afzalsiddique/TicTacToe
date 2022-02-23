import org.junit.jupiter.api.Test;
//import org.testng.Assert;

import javax.swing.*;

public class TestRandomAI {
    @Test
    public void test1() {
        RandomAI ai = new RandomAI();
        Integer[] random = new Integer[2];
        Integer[] expected = new Integer[2];
        String[][] stringButtons = {
                {"X","Move","Move"},
                {"X","O","X"},
                {"Move","O","Move"}
        };
//        random = ai.makesMove(stringButtons);
//        expected could be randomly selected
        //        expected =
//        Assert.assertEquals(random,expected);
    }

}
