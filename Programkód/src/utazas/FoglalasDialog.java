package utazas;
import javax.swing.*;

public abstract class FoglalasDialog extends JDialog {
    protected Jegyek jegyek;
    protected JPanel panel;
    protected JLabel nevLabel;
    protected JTextField nevTextField;
    protected JTextField secondTextField;
    protected JTextField thirdTextField;
    protected JButton okButton;



    public FoglalasDialog(Jegyek jegyek) {
        this.jegyek = jegyek;
        setSize(300,125);
        setResizable(false);
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
    }
}
