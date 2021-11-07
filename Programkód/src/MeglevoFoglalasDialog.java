import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MeglevoFoglalasDialog extends JDialog {
    private Jegyek jegyek;
    private JPanel panels;
    private CardLayout cl;
    private JTextField confirmationNumberField;

    class okButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            constructSecondPanel(Integer.parseInt(confirmationNumberField.getText()));
            cl.show(panels, "panel2");
        }
    }

    public MeglevoFoglalasDialog(Jegyek jegyek) {
        this.jegyek = jegyek;
        setSize(300,100);
        setLocation(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setAlwaysOnTop(true);

        JPanel panel1 = new JPanel();
        JLabel confirmationNumberLabel = new JLabel("Foglalási szám:");
        confirmationNumberField = new JTextField(10);
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new okButtonActionListener());

        panel1.add(confirmationNumberLabel);
        panel1.add(confirmationNumberField);
        panel1.add(okButton);

        panels = new JPanel(new CardLayout());
        panels.add(panel1, "panel1");
        add(panels);

        cl = (CardLayout)(panels.getLayout());
        setVisible(true);
    }

    private void constructSecondPanel(int confirmationNumber) {
        JPanel panel2 = new JPanel();
        VonatJegy jegy = (VonatJegy) jegyek.get(confirmationNumber-1);
        JLabel infoLabel = new JLabel(jegy.get_nev()+jegy.get_kocsiszam()+jegy.get_hely());
        panel2.add(infoLabel);
        panels.add(panel2, "panel2");
    }
}
