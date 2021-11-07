import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelectionPanel extends JPanel {
    private MainFrame parent;
    

    public class VonatButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            parent.vonatPanel();
        }

    }
    
    public SelectionPanel(MainFrame parent) {
        this.parent = parent;

        JButton vonat = new JButton("Vonat");
        JButton repulo = new JButton("Repülő");
    
        VonatButtonActionListener va = new VonatButtonActionListener();
        vonat.addActionListener(va);
        this.add(vonat);
        this.add(repulo);
    }

}
