import javax.swing.*;
import java.awt.event.*;

public class MyActionListener implements ActionListener {
    JTextField t;
    public MyActionListener(JTextField tt) { t = tt;}
    
    public void actionPerformed(ActionEvent ae) {
        RepuloJegy rj = new RepuloJegy(t.getText(), "teszt1", "teszt2");
        System.out.println(rj.get_nev() + " " + rj.get_osztaly() + " " + rj.get_menu());
    }
}