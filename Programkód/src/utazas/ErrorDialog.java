package utazas;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;

;public class ErrorDialog extends JDialog{

    public class okButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
    
    public ErrorDialog(String message) {
        setSize(500, 100);
        setLocation(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setTitle("Hibaüzenet");
        setResizable(false);
        setLayout(new BorderLayout());
        setAlwaysOnTop(true);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel hibauzenet = new JLabel("Hiba: "+message);
        hibauzenet.setAlignmentX(CENTER_ALIGNMENT);
        JButton okButton = new JButton("OK");
        okButton.setAlignmentX(CENTER_ALIGNMENT);
        okButton.addActionListener(new okButtonActionListener());

        panel.add(hibauzenet);
        panel.add(okButton);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }
}
