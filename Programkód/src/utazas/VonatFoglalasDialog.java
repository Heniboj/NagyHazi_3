package utazas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VonatFoglalasDialog extends FoglalasDialog {
    
    /**
     * Ok gomb megnyomása után a foglalás rögzítése hibakezeléssel
     */
    public class okButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(nevTextField.getText().equals("")) {
                new ErrorDialog("Ne hagyj üresen mezőt és ellenőrizd az adatok helyességét.");
                return;
            }
            
            try {
                int confirmationNumber;
                if(jegyek.size() == 0) {
                    confirmationNumber = 1;
                } else {
                    confirmationNumber = ((Jegy)jegyek.getByIndex(jegyek.size()-1)).get_ConfirmationNumber() + 1;
                }

                if(jegyek.checkAvailableSeat(jaratszamComboBox.getSelectedItem().toString(), Integer.parseInt(secondTextField.getText()), Integer.parseInt(thirdTextField.getText()), (VonatJaratok)jaratok)) {
                    Jegy j = new VonatJegy(jaratszamComboBox.getSelectedItem().toString(), confirmationNumber, nevTextField.getText(), Integer.parseInt(secondTextField.getText()), Integer.parseInt(thirdTextField.getText()));
                    jegyek.add(j);
                    jegyek.save();
                    dispose();
                    ConfirmationDialog cd = new ConfirmationDialog();
                    cd.ujFoglalas(confirmationNumber);
                } else {
                    new ErrorDialog("Nem létező kocsiszám, vagy a hely már foglalt.");
                }
            } catch(Exception ex) {
                new ErrorDialog("Ne hagyj üresen mezőt és ellenőrizd az adatok helyességét.");
            } 
        }
    }

    public VonatFoglalasDialog(Jegyek jegyek, Jaratok jaratok) {
        super(jegyek, jaratok);
        okButton.addActionListener(new okButtonActionListener());

        JLabel kocsiszamLabel = new JLabel("Kocsiszám:");
        JLabel helyLabel = new JLabel("Hely:");

        JPanel jaratszamPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jaratszamPanel.add(jaratszamLabel);
        jaratszamPanel.add(jaratszamComboBox);
        JPanel nevPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nevPanel.add(nevLabel);
        nevPanel.add(nevTextField);
        JPanel kocsiszamPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        kocsiszamPanel.add(kocsiszamLabel);
        kocsiszamPanel.add(secondTextField);
        JPanel helyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        helyPanel.add(helyLabel);
        helyPanel.add(thirdTextField);

        panel.add(jaratszamPanel);
        panel.add(nevPanel);
        panel.add(kocsiszamPanel);
        panel.add(helyPanel);
        panel.add(okButton);
        add(panel);
        setVisible(true);
    }
}
