import javax.swing.*;
import java.awt.event.*;

public class RepuloFoglalasDialog extends FoglalasDialog {
    private JComboBox combobox;

    public class okButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int confirmationNumber;
            if(jegyek.size() == 0) {
                confirmationNumber = 1;
            } else {
                confirmationNumber = ((Jegy)jegyek.get(jegyek.size()-1)).get_ConfirmationNumber() + 1;
            }

            Jegy j = new RepuloJegy(confirmationNumber, nevTextField.getText(), combobox.getSelectedItem().toString(), thirdTextField.getText());
            jegyek.add(j);
            jegyek.save();
            dispose();
            ConfirmationDialog cd = new ConfirmationDialog();
            cd.ujFoglalas(confirmationNumber);     
        }
    }

    public RepuloFoglalasDialog(Jegyek jegyek) {
        super(jegyek);
        okButton.addActionListener(new okButtonActionListener());

        JLabel osztalyLabel = new JLabel("Osztaly:");
        combobox = new JComboBox(new String[]{"Economy", "Business", "First"});
        JLabel menuLabel = new JLabel("Menu:");
        
        panel.add(nevLabel);
        panel.add(nevTextField);
        panel.add(osztalyLabel);
        panel.add(combobox);
        panel.add(menuLabel);
        panel.add(thirdTextField);
        panel.add(okButton);
        add(panel);
        setVisible(true);
    }
}
