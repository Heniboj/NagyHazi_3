import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FoglalasDialog extends JDialog {
    private Jegyek jegyek;
    private String jarmu;
    private JPanel panel;
    private JLabel nevLabel;
    private JTextField nevTextField;
    private JComboBox combobox;
    private JTextField secondTextField;
    private JTextField thirdTextField;
    private JButton okButton;

    public class okButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int confirmationNumber;
            Jegy j = new Jegy();
            if(jegyek.size() == 0) {
                confirmationNumber = 1;
            } else {
                confirmationNumber = ((Jegy)jegyek.get(jegyek.size()-1)).get_ConfirmationNumber() + 1;
            }
            if(jarmu == "Vonat") {
                j = new VonatJegy(confirmationNumber, nevTextField.getText(), Integer.parseInt(secondTextField.getText()), Integer.parseInt(thirdTextField.getText()));
                
            } else if(jarmu == "Repulo") {
                j = new RepuloJegy(confirmationNumber, nevTextField.getText(), combobox.getSelectedItem().toString(), thirdTextField.getText());
              } 
            jegyek.add(j);
            jegyek.save();
            dispose();
            ConfirmationDialog cd = new ConfirmationDialog();
            cd.ujFoglalas(confirmationNumber);     
        }
    }

    public FoglalasDialog(Jegyek jegyek) {
        this.jegyek = jegyek;
        setSize(300,300);
        setLocation(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setTitle("Foglalas");
        
        panel = new JPanel();

        nevLabel = new JLabel("Név:");
        nevTextField = new JTextField(20);

        secondTextField = new JTextField(5);
        thirdTextField = new JTextField(5);

        okButton = new JButton("OK");
        okButton.addActionListener(new okButtonActionListener());
    }
    
    public void vonat() {
        jarmu = "Vonat";
        JLabel kocsiszamLabel = new JLabel("Kocsiszám:");
        JLabel helyLabel = new JLabel("Hely:");
        
        panel.add(nevLabel);
        panel.add(nevTextField);
        panel.add(kocsiszamLabel);
        panel.add(secondTextField);
        panel.add(helyLabel);
        panel.add(thirdTextField);
        panel.add(okButton);

        add(panel);
    }

    public void repulo() {
        jarmu = "Repulo";
        JLabel osztalyLabel = new JLabel("Osztaly:");
        combobox = new JComboBox(new String[]{"Economy", "Business", "First"});
        JLabel menuLabel = new JLabel("Menu:");
        
        panel.add(nevLabel);
        panel.add(nevTextField);
        panel.add(osztalyLabel);
        panel.add(combobox);
        //panel.add(secondTextField);
        panel.add(menuLabel);
        panel.add(thirdTextField);
        panel.add(okButton);

        add(panel);
    }


}
