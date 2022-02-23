import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonNormalClassic extends ButtonTheme implements ActionListener {

    ButtonNormalClassic(String text, Dimension dim, JButton[][] button) {
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
                button[i][j].setBackground(Color.BLUE);
                button[i][j].setForeground(Color.WHITE);

            }
    }
}
