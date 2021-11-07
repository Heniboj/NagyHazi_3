import javax.swing.*;

public class ConfirmationDialog extends JDialog {
    public ConfirmationDialog(int confirmationNumber) {
        setSize(300,100);
        setLocation(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setAlwaysOnTop(true);

        JPanel panel = new JPanel();
        JLabel confirmationLabel = new JLabel("Sikeres foglalás!\nA foglalási szám: "+confirmationNumber);

        panel.add(confirmationLabel);
        add(panel);
        setVisible(true);
    }
}
