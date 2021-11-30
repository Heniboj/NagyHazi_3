package utazas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RepuloFoglalasDialog extends FoglalasDialog {
    private JComboBox combobox;

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

                if(jegyek.checkAvailableSeat(jaratszamComboBox.getSelectedItem().toString(), (RepuloJaratok)jaratok)) {
                    Jegy j = new RepuloJegy(jaratszamComboBox.getSelectedItem().toString(), confirmationNumber, nevTextField.getText(), combobox.getSelectedItem().toString(), thirdTextField.getText());
                    jegyek.add(j);
                    jegyek.save();
                    dispose();
                    ConfirmationDialog cd = new ConfirmationDialog();
                    cd.ujFoglalas(confirmationNumber); 
                }
                else {
                    new ErrorDialog("Ezen a járaton más nincs több férőhely.");
                    return;
                }
            } catch(Exception ex) {
                new ErrorDialog("Ne hagyj üresen mezőt és ellenőrizd az adatok helyességét.");
            } 
        }
    }

    public RepuloFoglalasDialog(Jegyek jegyek, Jaratok jaratok) {
        super(jegyek, jaratok);
        okButton.addActionListener(new okButtonActionListener());

        JLabel osztalyLabel = new JLabel("Osztaly:");
        combobox = new JComboBox(new String[]{"Economy", "Business", "First"});

        JPanel jaratszamPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jaratszamPanel.add(jaratszamLabel);
        jaratszamPanel.add(jaratszamComboBox);
        JPanel nevPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nevPanel.add(nevLabel);
        nevPanel.add(nevTextField);
        JPanel osztalyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        osztalyPanel.add(osztalyLabel);
        osztalyPanel.add(combobox);

        panel.add(jaratszamPanel);
        panel.add(nevPanel);
        panel.add(osztalyPanel);
        panel.add(okButton);
        add(panel);
        setVisible(true);
    }
}
