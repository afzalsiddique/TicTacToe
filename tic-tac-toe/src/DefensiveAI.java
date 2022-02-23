import javax.swing.*;

public class DefensiveAI implements AI{
    String stringNone = "None";
    String stringMove = "Move";
    @Override
    public Integer[] makesMove(String[][] stringButtons) {
        String position = checkAlmostWinning(stringButtons);
        Integer[] aiMove = new Integer[2];
        if(position.equals(stringNone)) {
            //random move
            RandomAI randomAI = new RandomAI();
            aiMove = randomAI.makesMove(stringButtons);
        }
        else{
            aiMove[0] = Integer.parseInt(position.substring(0,1));
            aiMove[1] = Integer.parseInt(position.substring(1,2));
        }
        return aiMove;
    }

    public String checkAlmostWinning(String[][] stringButtons){
        String position;
        position = checkAllRow(stringButtons);
        if(!position.equals(stringNone))
            return position;
        position = checkAllColumn(stringButtons);
        if(!position.equals(stringNone))
            return position;
        position = checkDiagonal(stringButtons);
        if(!position.equals(stringNone))
            return position;
        return stringNone;
    }

    public String checkAllColumn(String[][] stringButtons){
        String position=stringNone;
        for(int i=0;i<3;i++) {
            position = checkColumn(stringButtons, i);
            if(!position.equals(stringNone))
                return position;
        }
        return position;
    }

    public String checkAllRow(String[][] stringButtons){
        String position=stringNone;
        for(int i=0;i<3;i++) {
            position = checkRow(stringButtons, i);
            if(!position.equals(stringNone))
                return position;
        }
        return position;
    }
    public String checkDiagonal(String[][] stringButtons){
        String position0,position1, position2;
        position0=stringButtons[0][0];
        position1=stringButtons[1][1];
        position2=stringButtons[2][2];
        if(position0.equals("X") && position1.equals("X") && position2.equals(stringMove))
            return "22";
        else if(position0.equals("X") && position2.equals("X") && position1.equals(stringMove))
            return "11";
        else if(position1.equals("X") && position2.equals("X") && position0.equals(stringMove))
            return "00";

        position0=stringButtons[0][2];
        position1=stringButtons[1][1];
        position2=stringButtons[2][0];
        if(position0.equals("X") && position1.equals("X") && position2.equals(stringMove))
            return "20";
        else if(position0.equals("X") && position2.equals("X") && position1.equals(stringMove))
            return "11";
        else if(position1.equals("X") && position2.equals("X") && position0.equals(stringMove))
            return "02";
        else
            return stringNone;
    }

    public String checkColumn(String[][] stringButtons, int col){
        String position0,position1, position2;
        position0=stringButtons[0][col];
        position1=stringButtons[1][col];
        position2=stringButtons[2][col];
        if(position0.equals("X") && position1.equals("X") && position2.equals(stringMove))
            return "2"+col;
        else if(position0.equals("X") && position2.equals("X") && position1.equals(stringMove))
            return "1"+col;
        else if(position1.equals("X") && position2.equals("X") && position0.equals(stringMove))
            return "0"+col;
        else
            return stringNone;
    }
    public String checkRow(String[][] stringButtons, int row){
        String position0,position1, position2;
        position0=stringButtons[row][0];
        position1=stringButtons[row][1];
        position2=stringButtons[row][2];
        if(position0.equals("X") && position1.equals("X") && position2.equals(stringMove))
            return row+"2";
        else if(position0.equals("X") && position2.equals("X") && position1.equals(stringMove))
            return row+"1";
        else if(position1.equals("X") && position2.equals("X") && position0.equals(stringMove))
            return row+"0";
        else
            return stringNone;
    }

}
