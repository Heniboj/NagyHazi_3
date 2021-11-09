import javax.swing.*;
import java.awt.event.*;

public class VonatFoglalasDialog extends FoglalasDialog {
    
    public class okButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int confirmationNumber;
            if(jegyek.size() == 0) {
                confirmationNumber = 1;
            } else {
                confirmationNumber = ((Jegy)jegyek.get(jegyek.size()-1)).get_ConfirmationNumber() + 1;
            }

            Jegy j = new VonatJegy(confirmationNumber, nevTextField.getText(), Integer.parseInt(secondTextField.getText()), Integer.parseInt(thirdTextField.getText()));
            jegyek.add(j);
            jegyek.save();
            dispose();
            ConfirmationDialog cd = new ConfirmationDialog();
            cd.ujFoglalas(confirmationNumber);     
        }
    }

    public VonatFoglalasDialog(Jegyek jegyek) {
        super(jegyek);
        okButton.addActionListener(new okButtonActionListener());

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
        setVisible(true);
    }
}
