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

    public class RepuloButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            parent.repuloPanel();
        }
    }
    
    public SelectionPanel(MainFrame parent) {
        this.parent = parent;

        JButton vonat = new JButton("Vonat");
        vonat.addActionListener(new VonatButtonActionListener());

        JButton repulo = new JButton("Repülő");
        repulo.addActionListener(new RepuloButtonActionListener());

        this.add(vonat);
        this.add(repulo);
    }
}
