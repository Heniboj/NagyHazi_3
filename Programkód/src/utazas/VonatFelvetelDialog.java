package utazas;
import java.awt.event.*;

public class VonatFelvetelDialog extends JaratFelvetelDialog {

    public class okButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(idField.getText().equals("") || ind_helyField.getText().equals("") || erk_helyField.getText().equals("")) {
                new ErrorDialog("Ne hagyj üresen mezőt és ellenőrizd az adatok helyességét.");
                return;
            }
            try {
                Datum ind = new Datum((String)ind_ev.getSelectedItem(), (String)(ind_honap.getSelectedItem()), (String)(ind_nap.getSelectedItem()), ind_ora.getText(), ind_perc.getText());
                Datum erk = new Datum((String)(erk_ev.getSelectedItem()), (String)(erk_honap.getSelectedItem()), (String)(erk_nap.getSelectedItem()), erk_ora.getText(), erk_perc.getText());
                Vonat v = new Vonat(idField.getText(), ind_helyField.getText(), erk_helyField.getText(), ind, erk, Integer.parseInt(specField.getText()));
                jaratok.add(v);
                jaratok.save();
                dispose();
                ConfirmationDialog cd = new ConfirmationDialog();
                cd.ujJarat();
            } catch(Exception ex) {
                new ErrorDialog("Ne hagyj üresen mezőt és ellenőrizd az adatok helyességét.");
            }
        }
    }

    public VonatFelvetelDialog(Jaratok jaratok) {
        super(jaratok);
        specLabel.setText("Kocsik száma:");
        okButton.addActionListener(new okButtonActionListener());
        panel.add(okButton);
        add(panel);
        setVisible(true);
    }
}
