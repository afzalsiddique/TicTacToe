import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonNewGame extends JButton implements ActionListener {
    JButton[][] button;
    JButton[] aiModeButton;
    JLabel labelResult;
    ButtonNewGame(String text, Dimension dim, JButton[][] button, JButton[] aiModeButton,
                  JLabel labelResult){
        super(text);
        setPreferredSize(dim);
        addActionListener(this);
        this.button = button;
        this.aiModeButton = aiModeButton;
        this.labelResult = labelResult;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        aiModeButton[0].setEnabled(true);
        aiModeButton[1].setEnabled(true);
        closeButtons();
        labelResult.setText("Result:");//this line got broken
    }
    public void closeButtons(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                button[i][j].setText("Move");
                button[i][j].setEnabled(false);
            }
        }
    }
}
