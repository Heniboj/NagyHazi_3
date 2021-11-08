import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RepuloPanel extends JPanel {
    private MainFrame parent;
    private RepuloJaratok jaratok;

    class MainMenuButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            parent.mainMenu();
        }
    }

    class JaratokButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JaratokFrame jf = new JaratokFrame(jaratok);
            jf.setVisible(true);
        }
    }

    class FoglalasButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            FoglalasDialog ff = new FoglalasDialog(getJegyek());
            ff.repulo();
            ff.setVisible(true);
            ff.setAlwaysOnTop(true);
        }
    }

    class EllenorzesButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            MeglevoFoglalasDialog mfd = new MeglevoFoglalasDialog(getJegyek(), RepuloPanel.this);
        }
    }
    
    public RepuloPanel(MainFrame parent) {
        jaratok = new RepuloJaratok();
        jaratok.load();

        this.parent = parent;
        setLayout(new BorderLayout());
        JLabel infoLabel = new JLabel("Válassza ki a megfelelő menüpontot.");

        JButton jaratokButton = new JButton("Járatok megtekintése");
        jaratokButton.addActionListener(new JaratokButtonActionListener());

        JButton ujFoglalas = new JButton("Új foglalás");
        ujFoglalas.addActionListener(new FoglalasButtonActionListener());

        JButton foglalasEllenorzes = new JButton("Meglévő foglalás ellenőrzése");
        foglalasEllenorzes.addActionListener(new EllenorzesButtonActionListener());

        JButton fomenuGomb = new JButton("Vissza a Főmenübe");
        fomenuGomb.addActionListener(new MainMenuButtonActionListener());
        
        this.add(infoLabel, BorderLayout.PAGE_START);
        this.add(jaratokButton, BorderLayout.LINE_START);
        this.add(ujFoglalas, BorderLayout.CENTER);
        this.add(foglalasEllenorzes, BorderLayout.LINE_END);
        this.add(fomenuGomb, BorderLayout.PAGE_END);
    }

    public Jegyek getJegyek() {
        return parent.getJegyek();
    }
}
