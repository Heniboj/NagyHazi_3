package utazas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class MeglevoFoglalasDialog extends JDialog {
    protected Jegyek jegyek;
    protected JPanel panels;
    protected CardLayout cl;
    protected JTextField confirmationNumberField;

    class okButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(confirmationNumberField.getText().equals("")) {
                new ErrorDialog("Ne hagyd üresen a mezőt.");
                return;
            }
            try {
                Integer.parseInt(confirmationNumberField.getText());
            } catch(NumberFormatException ex) {new ErrorDialog("Csak számot írj a mezőbe.");}
            constructSecondPanel(Integer.parseInt(confirmationNumberField.getText()));
            cl.show(panels, "panel2");
        }
    }

    class TorlesButtonActionListener implements ActionListener {
        private int confirmationNumber;
        public TorlesButtonActionListener(int confirmationNumber) {
            this.confirmationNumber = confirmationNumber;
        }
        public void actionPerformed(ActionEvent e) {
            dispose();
            jegyek.remove(confirmationNumber);
            jegyek.save();

            ConfirmationDialog cd = new ConfirmationDialog();
            cd.foglalasTorles(confirmationNumber);
        }
    }

    public MeglevoFoglalasDialog(Jegyek jegyek) {
        this.jegyek = jegyek;
        setSize(300,100);
        setLocation(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);

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

    protected abstract void constructSecondPanel(int confirmationNumber);
}
