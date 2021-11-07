import javax.swing.*;

public class ConfirmationDialog extends JDialog {
    private int confirmationNumber;
    public ConfirmationDialog(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
        setSize(300,100);
        setLocation(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setAlwaysOnTop(true);
    }

    public void ujFoglalas() {
        JPanel panel = new JPanel();
        JLabel confirmationLabel = new JLabel("Sikeres foglalás! A foglalási szám: "+confirmationNumber);

        panel.add(confirmationLabel);
        add(panel);
        setVisible(true);
    }

    public void foglalasTorles() {
        JPanel panel = new JPanel();
        JLabel confirmationLabel = new JLabel("A "+confirmationNumber+" számú foglalást sikeresen töröltük.");

        panel.add(confirmationLabel);
        add(panel);
        setVisible(true);
    }
}
