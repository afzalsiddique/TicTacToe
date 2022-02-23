public class GameState {
    String playerSign = "X";
    String aiSign = "O";
    String moveAvailableSign = "Move";
    String draw = "Draw";
    String noWinner = "No winner yet";
    String stringNone = "None";
    public boolean ifGameEnded(String[][] stringButtons){
        String winner = getWinner(stringButtons);
        return !winner.equals(noWinner);
    }
    public String getWinner(String[][] stringButtons){
        String winner;
        winner = checkAllColumn(stringButtons);
        if(winner.equals(playerSign) || winner.equals(aiSign))
            return winner;
        winner = checkAllRow(stringButtons);
        if(winner.equals(playerSign) || winner.equals(aiSign))
            return winner;
        winner = checkDiagonal(stringButtons);
        if(winner.equals(playerSign) || winner.equals(aiSign))
            return winner;
        if(!moveAvailable(stringButtons))
            return draw;
        return noWinner;
    }
    private boolean moveAvailable(String[][] stringButtons){
        for(int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if (stringButtons[i][j].equals(moveAvailableSign))
                    return true;
            }
        }
        return false;
    }
    public String checkAllRow(String[][] stringButtons){
        String winner;
        for(int i=0;i<3;i++){
            winner = checkRow(stringButtons,i);
            if(winner.equals(playerSign) || winner.equals(aiSign))
                return winner;
        }
        return stringNone;
    }
    public String checkAllColumn(String[][] stringButtons){
        String winner;
        for(int i=0;i<3;i++){
            winner = checkColumn(stringButtons,i);
            if(winner.equals(playerSign) || winner.equals(aiSign))
                return winner;
        }
        return stringNone;
    }
    public String checkDiagonal(String[][] stringButtons){
        String position0,position1, position2;
        position0=stringButtons[0][0];
        position1=stringButtons[1][1];
        position2=stringButtons[2][2];
        if(position0.equals(position1) && position1.equals(position2)
                && !position0.equals(moveAvailableSign))
            return position0;

        position0=stringButtons[0][2];
        position1=stringButtons[1][1];
        position2=stringButtons[2][0];
        if(position0.equals(position1) && position1.equals(position2)
                && !position0.equals(moveAvailableSign))
            return position0;
        return stringNone;
    }
    public String checkRow(String[][] stringButtons, int row){
        String position0,position1, position2;
        position0=stringButtons[row][0];
        position1=stringButtons[row][1];
        position2=stringButtons[row][2];
        if(position0.equals(position1) && position1.equals(position2)
                && !position0.equals(moveAvailableSign))
            return position0;
        return stringNone;
    }
    public String checkColumn(String[][] stringButtons, int col){
        String position0,position1, position2;
        position0=stringButtons[0][col];
        position1=stringButtons[1][col];
        position2=stringButtons[2][col];
        if(position0.equals(position1) && position1.equals(position2)
                && !position0.equals(moveAvailableSign))
            return position0;
        return stringNone;
    }

    public String getStringNone() {
        return stringNone;
    }
}
