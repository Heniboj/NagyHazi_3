package utazas;
import javax.swing.*;

public class ConfirmationDialog extends JDialog {
    public ConfirmationDialog() {
        setSize(300,100);
        setLocation(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setAlwaysOnTop(true);
    }

    public void ujFoglalas(int confirmationNumber) {
        JPanel panel = new JPanel();
        JLabel confirmationLabel = new JLabel("Sikeres foglalás! A foglalási szám: "+confirmationNumber);

        panel.add(confirmationLabel);
        add(panel);
        setVisible(true);
    }

    public void foglalasTorles(int confirmationNumber) {
        JPanel panel = new JPanel();
        JLabel confirmationLabel = new JLabel("A "+confirmationNumber+" számú foglalást sikeresen töröltük.");

        panel.add(confirmationLabel);
        add(panel);
        setVisible(true);
    }

    public void ujJarat() {
        JPanel panel = new JPanel();
        JLabel confirmationLabel = new JLabel("Sikeres járatfelvétel!");

        panel.add(confirmationLabel);
        add(panel);
        setVisible(true);
    }
}
