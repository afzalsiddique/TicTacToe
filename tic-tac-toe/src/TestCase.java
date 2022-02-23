import org.junit.Assert;
import org.junit.jupiter.api.Test;
//import org.testng.Assert;


public class TestCase {
    @Test
    public void testDefensiveAI1() {
        Integer[] aiMove;
        DefensiveAI ai = new DefensiveAI();
        String move = "Move";
        String userSign = "X";
        String aiSign = "O";
        String[][] stringButtons = {
                {userSign,move  ,move},
                {userSign,aiSign,userSign},
                {move    ,aiSign,move}
        };
        aiMove = ai.makesMove(stringButtons);
        Integer[] expected = {2,0};
        Assert.assertEquals(aiMove,expected);
    }
    @Test
    public void testDefensiveAI2() {
        Integer[] aiMove;
        DefensiveAI ai = new DefensiveAI();
        String move = "Move";
        String userSign = "X";
        String aiSign = "O";
        String[][] stringButtons = {
                {userSign,aiSign  ,move},
                {move    ,userSign,userSign},
                {move    ,aiSign  ,move}
        };
        aiMove = ai.makesMove(stringButtons);
        Integer[] expected = {1,0};
        Assert.assertEquals(aiMove,expected);
    }
    @Test
    public void checkAllColumnNew1() {
        String aiMove;
        DefensiveAI ai = new DefensiveAI();
        String move = "Move";
        String userSign = "X";
        String aiSign = "O";
        String[][] stringButtons = {
                {userSign,move  ,move},
                {userSign,aiSign,userSign},
                {move    ,aiSign,move}
        };
        aiMove = ai.checkAllColumn(stringButtons);
        String expected = "20";
        Assert.assertEquals(aiMove,expected);
    }
    @Test
    public void checkAllColumnNew2() {
        String aiMove;
        DefensiveAI ai = new DefensiveAI();
        String move = "Move";
        String userSign = "X";
        String aiSign = "O";
        String[][] stringButtons = {
                {userSign,move  ,move},
                {userSign,aiSign,move},
                {aiSign  ,aiSign,userSign}
        };
        aiMove = ai.checkAllColumn(stringButtons);
        String expected = "None";
        Assert.assertEquals(aiMove,expected);
    }
    @Test
    public void checkAllColumnNew3() {
        String aiMove;
        DefensiveAI ai = new DefensiveAI();
        String move = "Move";
        String userSign = "X";
        String aiSign = "O";
        String[][] stringButtons = {
                {move  ,userSign,aiSign},
                {move  ,userSign,move},
                {aiSign,move    ,move}
        };
        aiMove = ai.checkAllColumn(stringButtons);
        String expected = "21";
        Assert.assertEquals(aiMove,expected);
    }
}
