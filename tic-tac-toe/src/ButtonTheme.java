import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTheme extends JButton  {
    String playerSign = "X";
    String aiSign = "O";
    Dimension dim = new Dimension(350,30);
    JButton[][] button;
    ButtonTheme(String text, Dimension dim, JButton[][] button){
        super(text);
        setPreferredSize(dim);
        this.button = button;
    }
}
