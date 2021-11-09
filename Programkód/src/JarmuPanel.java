import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class JarmuPanel extends JPanel {
    protected MainFrame parent;
    protected Jaratok jaratok;

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
            ff.vonat();
            ff.setVisible(true);
            ff.setAlwaysOnTop(true);
        }
    }

    class EllenorzesButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // ez a default, de minden jármű esetén újra kell implementálni
            MeglevoFoglalasDialog mfd = new VonatMeglevoFoglalasDialog(getJegyek()); 
        }
    }
    
    public JarmuPanel(MainFrame parent) {
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

        // járatok tárolójának példányosítása, szerializált adatok beolvasása
        initJaratok();
    }

    protected abstract void initJaratok();

    public Jegyek getJegyek() {
        return parent.getJegyek();
    }
}
