import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener{
    public JButton[][] button = new JButton[3][3];
    public JButton[] aiModeButton = new JButton[2];
    public JLabel labelResult;
    public String[][] stringButtons = new String[3][3];
    public Integer[] aiMove = new Integer[2];
    String[] themeName = {"Classic","Forrest","High Contrast"};
    User user = new User();
    AI ai;
    GameState gameState = new GameState();
    Dimension dim = new Dimension(350,30);
    String winner;
    String aiSign = "O";
    String move = "Move";
    public Gui() {
        ButtonNewGame newGame = new ButtonNewGame("Start New Game", dim, button, aiModeButton, labelResult);
        add(newGame);
        createAiModeButtons();
        createButtonTheme();
        addResultLabel();
        createButtons();
        makeLayoutVisible();
    }
    public void createButtons(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                button[i][j] = new JButton(move);
                button[i][j].setPreferredSize(new Dimension(100, 100));
                button[i][j].addActionListener(this);
                button[i][j].setEnabled(false);
                add(button[i][j]);
            }
        }
    }
    private void createAiModeButtons(){
        aiModeButton[0] = new JButton("Start With Random AI");
        aiModeButton[0].setPreferredSize(new Dimension(350,30));
        aiModeButton[0].addActionListener(this);
        add(aiModeButton[0]);

        aiModeButton[1] = new JButton("Start With Defensive AI");
        aiModeButton[1].setPreferredSize(new Dimension(350,30));
        aiModeButton[1].addActionListener(this);
        add(aiModeButton[1]);
    }
    public void createButtonTheme(){
        ButtonNormalClassic themeClassic = new ButtonNormalClassic(themeName[0],dim,button);
        add(themeClassic);
        ButtonNormalForest themeForrest = new ButtonNormalForest(themeName[1],dim,button);
        add(themeForrest);
        ButtonNormalHighContrast themeHighContrast = new ButtonNormalHighContrast(themeName[2],dim,button);
        add(themeHighContrast);
    }

    public void addResultLabel(){
        labelResult = new JLabel("Result:");
        labelResult.setPreferredSize(new Dimension(350,30));
        add(labelResult);
    }
    public void makeLayoutVisible(){
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void startButtons(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                button[i][j].setText(move);
                button[i][j].setEnabled(true);
            }
        }
    }
    public void stopButtons(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                button[i][j].setEnabled(false);
            }
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn.getText().equals("Start With Random AI")) {
            ai = new RandomAI();
            aiModeButton[0].setEnabled(false);
            aiModeButton[1].setEnabled(false);
            startButtons();
        } else if (btn.getText().equals("Start With Defensive AI")) {
            ai = new DefensiveAI();
            aiModeButton[0].setEnabled(false);
            aiModeButton[1].setEnabled(false);
            startButtons();
        }else {
            user.userMakesMove(e, button);
            updateStringButtonsFromJButton();
            if(gameState.ifGameEnded(stringButtons)) {
                stopButtons();
                winner = gameState.getWinner(stringButtons);
                labelResult.setText("Winner: "+winner);
            }
            else {
                aiMove = ai.makesMove(stringButtons);
                button[aiMove[0]][aiMove[1]].setText(aiSign);
                button[aiMove[0]][aiMove[1]].setEnabled(false);
            }
            updateStringButtonsFromJButton();
            if(gameState.ifGameEnded(stringButtons)) {
                stopButtons();
                winner = gameState.getWinner(stringButtons);
                labelResult.setText("Winner: " + winner);
            }
        }
    }
    public void updateStringButtonsFromJButton(){
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                stringButtons[i][j] = button[i][j].getText();
    }
}
