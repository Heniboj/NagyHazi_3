import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JaratFelvetelDialog extends JDialog {
    private VonatJaratok jaratok;
    private String jarmu;
    private JTextField idField;
    private JTextField ind_helyField;
    private JTextField erk_helyField; 
    private JTextField ind_datumField;
    private JTextField erk_datumField;

    public class okButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(jarmu == "Vonat") {
                Datum ind = new Datum(ind_datumField.getText());
                Datum erk = new Datum(erk_datumField.getText());
                Vonat v = new Vonat(idField.getText(), ind_helyField.getText(), erk_helyField.getText(), ind, erk, 5);
                jaratok.add(v);
                jaratok.save();
                dispose();
                ConfirmationDialog cd = new ConfirmationDialog();
                cd.ujJarat();
            }

            if(jarmu == "Repulo") {
                
            } 
        }
    }

    public JaratFelvetelDialog(VonatJaratok jaratok, String jarmu) {
        this.jaratok = jaratok;
        this.jarmu = jarmu;
        setSize(300,300);
        setLocation(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setTitle("Járat felvétele");
        
        JPanel panel = new JPanel();

        JLabel idLabel = new JLabel("Járatazonosító:");
        idField = new JTextField(10);
        JLabel ind_helyLabel = new JLabel("Indulási hely:");
        ind_helyField = new JTextField(20);
        JLabel erk_helyLabel = new JLabel("Érkezési hely:");
        erk_helyField = new JTextField(20);
        JLabel ind_datumLabel = new JLabel("Indulási dátum:");
        ind_datumField = new JTextField(20);
        JLabel erk_datumLabel = new JLabel("Érkezési dátum:");
        erk_datumField = new JTextField(20);
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new okButtonActionListener());

        panel.add(idLabel);
        panel.add(idField);
        panel.add(ind_helyLabel);
        panel.add(ind_helyField);
        panel.add(erk_helyLabel);
        panel.add(erk_helyField);
        panel.add(ind_datumLabel);
        panel.add(ind_datumField);
        panel.add(erk_datumLabel);
        panel.add(erk_datumField);
        panel.add(okButton);

        add(panel);
        setVisible(true);
    }
    
}


