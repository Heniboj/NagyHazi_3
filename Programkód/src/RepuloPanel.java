import java.awt.event.*;

public class RepuloPanel extends JarmuPanel {
    class FoglalasButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new RepuloFoglalasDialog(getJegyek());
        }
    }

    class EllenorzesButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new RepuloMeglevoFoglalasDialog(getJegyek());
        }
    }
    
    public RepuloPanel(MainFrame parent) {
        super(parent);
        ujFoglalas.addActionListener(new FoglalasButtonActionListener());
        foglalasEllenorzes.addActionListener(new EllenorzesButtonActionListener());
    }

    protected void initJaratok() {
        this.jaratok = new RepuloJaratok();
        this.jaratok.load();
    }
}
