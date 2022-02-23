import javax.swing.*;
import java.awt.event.ActionEvent;

public class User {
    public void userMakesMove(ActionEvent e, JButton[][] button){
        String userSign = "X";
        JButton btn;
        btn = (JButton)e.getSource();
        btn.setText(userSign);
        btn.setEnabled(false);
    }
}
