package utazas;
import javax.swing.*;
import java.awt.*;

public class RepuloMeglevoFoglalasDialog extends MeglevoFoglalasDialog {
    
    public RepuloMeglevoFoglalasDialog(Jegyek jegyek) {
        super(jegyek);
    }

    protected void constructSecondPanel(int confirmationNumber) {
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        for(int i = 0; i < jegyek.size(); i ++) {
            try {
                RepuloJegy jegy = (RepuloJegy) jegyek.get(i);
                if(jegy.get_ConfirmationNumber() == confirmationNumber) {
                    JLabel nevLabel = new JLabel("Név: "+jegy.get_nev());
                    nevLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    JLabel osztalyLabel = new JLabel("Osztály: "+jegy.get_osztaly());
                    osztalyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    JLabel menulabel = new JLabel("Menü: "+jegy.get_menu());
                    menulabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    JButton torlesButton = new JButton("Foglalás törlése");
                    torlesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                    torlesButton.addActionListener(new TorlesButtonActionListener(confirmationNumber));
                    panel2.add(nevLabel);
                    panel2.add(osztalyLabel);
                    panel2.add(menulabel);
                    panel2.add(torlesButton);
                    panels.add(panel2, "panel2");
                    return;
                }
            } catch(ClassCastException e) {}
              catch(TicketNotFoundException te) {}
        }
        
        JLabel infoLabel = new JLabel("A megadott foglalási szám alapján megvásárolt jegy nem található!");
        setSize(500,100);
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(infoLabel);
        panels.add(panel2, "panel2");
    }
}
