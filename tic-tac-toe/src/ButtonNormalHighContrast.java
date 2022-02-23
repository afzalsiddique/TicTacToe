import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonNormalHighContrast extends ButtonTheme implements ActionListener {
    ButtonNormalHighContrast(String text, Dimension dim, JButton[][] button) {
        super(text, dim, button);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        changeButtonBackground();
    }
    private void changeButtonBackground() {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                button[i][j].setBackground(Color.BLACK);
                button[i][j].setForeground(Color.WHITE);
            }
    }
}

