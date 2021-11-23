package utazas;
import javax.swing.*;

public abstract class FoglalasDialog extends JDialog {
    protected Jegyek jegyek;
    protected Jaratok jaratok;
    protected JPanel panel;
    protected JLabel jaratszamLabel;
    protected JComboBox jaratszamComboBox;
    protected JLabel nevLabel;
    protected JTextField nevTextField;
    protected JTextField secondTextField;
    protected JTextField thirdTextField;
    protected JButton okButton;



    public FoglalasDialog(Jegyek jegyek, Jaratok jaratok) {
        this.jegyek = jegyek;
        this.jaratok = jaratok;
        setSize(300,210);
        setResizable(false);
        setLocation(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setTitle("Foglalas");
        
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        jaratszamLabel = new JLabel("Járatszám:");
        String[] jaratszamok = new String[jaratok.size()];
        for(int i = 0; i < jaratok.size(); i++) {
            jaratszamok[i] = jaratok.get(i).get_id();
        }
        jaratszamComboBox = new JComboBox(jaratszamok);

        nevLabel = new JLabel("Név:");
        nevTextField = new JTextField(20);

        secondTextField = new JTextField(16);
        thirdTextField = new JTextField(19);

        okButton = new JButton("OK");
    }
}
