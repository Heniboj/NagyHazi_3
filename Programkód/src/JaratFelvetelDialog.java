import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JaratFelvetelDialog extends JDialog {
    private Jaratok jaratok;
    private JTextField idField;
    private JTextField ind_helyField;
    private JTextField erk_helyField; 
    private JComboBox ind_ev;
    private JComboBox ind_honap;
    private JComboBox ind_nap;
    private JTextField ind_ora;
    private JTextField ind_perc;
    private JComboBox erk_ev;
    private JComboBox erk_honap;
    private JComboBox erk_nap;
    private JTextField erk_ora;
    private JTextField erk_perc;

    public class okButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(jaratok.getClass() == VonatJaratok.class) {
                Datum ind = new Datum((String)ind_ev.getSelectedItem(), (String)(ind_honap.getSelectedItem()), (String)(ind_nap.getSelectedItem()), ind_ora.getText(), ind_perc.getText());
                Datum erk = new Datum((String)(erk_ev.getSelectedItem()), (String)(erk_honap.getSelectedItem()), (String)(erk_nap.getSelectedItem()), erk_ora.getText(), erk_perc.getText());
                Vonat v = new Vonat(idField.getText(), ind_helyField.getText(), erk_helyField.getText(), ind, erk, 5);
                jaratok.add(v);
                jaratok.save();
                dispose();
                ConfirmationDialog cd = new ConfirmationDialog();
                cd.ujJarat();
            }

            if(jaratok.getClass() == RepuloJaratok.class) {
                Datum ind = new Datum((String)ind_ev.getSelectedItem(), (String)(ind_honap.getSelectedItem()), (String)(ind_nap.getSelectedItem()), ind_ora.getText(), ind_perc.getText());
                Datum erk = new Datum((String)(erk_ev.getSelectedItem()), (String)(erk_honap.getSelectedItem()), (String)(erk_nap.getSelectedItem()), erk_ora.getText(), erk_perc.getText());
                Repulo r = new Repulo(idField.getText(), ind_helyField.getText(), erk_helyField.getText(), ind, erk, 100);
                jaratok.add(r);
                jaratok.save();
                dispose();
                ConfirmationDialog cd = new ConfirmationDialog();
                cd.ujJarat();
            }
        }
    }

    public JaratFelvetelDialog(Jaratok jaratok) {
        this.jaratok = jaratok;
        setSize(300, 350);
        setLocation(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setTitle("Járat felvétele");
        setResizable(true);
        
         
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        

        JLabel idLabel = new JLabel("Járatazonosító:");
        idLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        idField = new JTextField(10);
        JLabel ind_helyLabel = new JLabel("Indulási hely:");
        ind_helyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ind_helyField = new JTextField(20);
        JLabel erk_helyLabel = new JLabel("Érkezési hely:");
        erk_helyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        erk_helyField = new JTextField(20);
        JLabel ind_datumLabel = new JLabel("Indulási dátum:");
        ind_datumLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel ind_datumPanel = new JPanel();
        ind_datumPanel.setLayout(new BoxLayout(ind_datumPanel, BoxLayout.LINE_AXIS));
        String evek[] = {"2021", "2022", "2023", "2024"};
        ind_ev = new JComboBox(evek);
        String[] honapok = new String[12];
        for(int i = 0; i < 12; i++) {
            honapok[i] = String.valueOf(i+1);
        }
        ind_honap = new JComboBox(honapok);
        String[] napok = new String[31];
        for(int i = 0; i < 31; i++) {
            napok[i] = String.valueOf(i+1);
        }
        ind_nap = new JComboBox(napok);

        JPanel ind_idopontPanel = new JPanel();
        ind_ora = new JTextField(5);
        ind_perc = new JTextField(5);
        ind_idopontPanel.add(ind_ora);
        ind_idopontPanel.add(new JLabel(":"));
        ind_idopontPanel.add(ind_perc);

        JPanel erk_datumPanel = new JPanel();
        erk_datumPanel.setLayout(new BoxLayout(erk_datumPanel, BoxLayout.LINE_AXIS));
        JLabel erk_datumLabel = new JLabel("Érkezési dátum:");
        erk_datumLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        erk_ev = new JComboBox(evek);
        erk_honap = new JComboBox(honapok);
        erk_nap = new JComboBox(napok);

        JPanel erk_idopontPanel = new JPanel();
        erk_ora = new JTextField(5);
        erk_perc = new JTextField(5);
        erk_idopontPanel.add(erk_ora);
        erk_idopontPanel.add(new JLabel(":"));
        erk_idopontPanel.add(erk_perc);
        
        JButton okButton = new JButton("OK");
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okButton.addActionListener(new okButtonActionListener());

        panel.add(idLabel);
        panel.add(idField);
        panel.add(ind_helyLabel);
        panel.add(ind_helyField);
        panel.add(erk_helyLabel);
        panel.add(erk_helyField);
        panel.add(ind_datumLabel);
        ind_datumPanel.add(ind_ev);
        ind_datumPanel.add(ind_honap);
        ind_datumPanel.add(ind_nap);
        panel.add(ind_datumPanel);
        panel.add(ind_idopontPanel);
        panel.add(erk_datumLabel);
        erk_datumPanel.add(erk_ev);
        erk_datumPanel.add(erk_honap);
        erk_datumPanel.add(erk_nap);
        panel.add(erk_datumPanel);
        panel.add(erk_idopontPanel);
        panel.add(okButton);

        add(panel);
        
        setVisible(true);
    }
    
}


