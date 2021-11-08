import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MeglevoFoglalasDialog extends JDialog {
    private Jegyek jegyek;
    private JPanel parent;
    private JPanel panels;
    private CardLayout cl;
    private JTextField confirmationNumberField;

    class okButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
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

    public MeglevoFoglalasDialog(Jegyek jegyek, JPanel parent) {
        this.jegyek = jegyek;
        this.parent = parent;
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
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        if(parent.getClass() == VonatPanel.class) {
            for(int i = 0; i < jegyek.size(); i ++) {
                try {
                    VonatJegy jegy = (VonatJegy) jegyek.get(i);
                    if(jegy.get_ConfirmationNumber() == confirmationNumber) {
                        JLabel nevLabel = new JLabel("Név: "+jegy.get_nev());
                        nevLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        JLabel kocsiszamLabel = new JLabel("Kocsiszám: "+jegy.get_kocsiszam());
                        kocsiszamLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        JLabel helylabel = new JLabel("Hely: "+jegy.get_hely());
                        helylabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        JButton torlesButton = new JButton("Foglalás törlése");
                        torlesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                        torlesButton.addActionListener(new TorlesButtonActionListener(confirmationNumber));
                        panel2.add(nevLabel);
                        panel2.add(kocsiszamLabel);
                        panel2.add(helylabel);
                        panel2.add(torlesButton);
                        panels.add(panel2, "panel2");
                        return;
                    }
                } catch(ClassCastException e) {}
            }
        }
        if(parent.getClass() == RepuloPanel.class) {
            for(int i = 0; i < jegyek.size(); i ++) {
                try{
                    RepuloJegy jegy = (RepuloJegy) jegyek.get(i);
                    if(jegy.get_ConfirmationNumber() == confirmationNumber) {
                        JLabel nevLabel = new JLabel("Név: "+jegy.get_nev());
                        nevLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        JLabel osztalyLabel = new JLabel("Osztály: "+jegy.get_osztaly());
                        osztalyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        JLabel menulabel = new JLabel("Menü: "+jegy.get_menu());
                        menulabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        JButton torlesButton = new JButton("Foglalás törlése");
                        torlesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                        torlesButton.addActionListener(new TorlesButtonActionListener(confirmationNumber));
                        panel2.add(nevLabel);
                        panel2.add(osztalyLabel);
                        panel2.add(menulabel);
                        panel2.add(torlesButton);
                        panels.add(panel2, "panel2");
                        return;
                    }
                } catch(ClassCastException e) {}
            }
        }


        JLabel infoLabel = new JLabel("A megadott foglalási szám alapján megvásárolt jegy nem található!");
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(infoLabel);
        panels.add(panel2, "panel2");
    }
}
