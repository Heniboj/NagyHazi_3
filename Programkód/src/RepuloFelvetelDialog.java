import java.awt.event.*;

public class RepuloFelvetelDialog extends JaratFelvetelDialog {

    public class okButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Datum ind = new Datum((String)ind_ev.getSelectedItem(), (String)(ind_honap.getSelectedItem()), (String)(ind_nap.getSelectedItem()), ind_ora.getText(), ind_perc.getText());
                Datum erk = new Datum((String)(erk_ev.getSelectedItem()), (String)(erk_honap.getSelectedItem()), (String)(erk_nap.getSelectedItem()), erk_ora.getText(), erk_perc.getText());
                Repulo r = new Repulo(idField.getText(), ind_helyField.getText(), erk_helyField.getText(), ind, erk, 100);
                jaratok.add(r);
                jaratok.save();
                dispose();
                ConfirmationDialog cd = new ConfirmationDialog();
                cd.ujJarat();
            } catch(Exception ex) {
                new ErrorDialog("Ne hagyj üresen mezőt és ellenőrizd az adatok helyességét.");
              }
        }
    }
    public RepuloFelvetelDialog(Jaratok jaratok) {
        super(jaratok);
        okButton.addActionListener(new okButtonActionListener());
        panel.add(okButton);
        add(panel);
        setVisible(true);
    }
}
