import java.util.Random;

public class RandomAI implements AI {

    @Override
    public Integer[] makesMove(String[][] stringButtons) {
        Integer[] random = new Integer[2];
        Random rand = new Random();
        do {
            random[0] = rand.nextInt(3);
            random[1] = rand.nextInt(3);
        } while (!stringButtons[random[0]][random[1]].equals("Move"));
        return random;
    }
}
