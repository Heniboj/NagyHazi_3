package utazas;
import java.awt.event.*;

public class VonatPanel extends JarmuPanel {
    class FoglalasButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new VonatFoglalasDialog(getJegyek());
        }
    }

    class EllenorzesButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new VonatMeglevoFoglalasDialog(getJegyek());
        }
    }
    
    public VonatPanel(MainFrame parent) {
        super(parent);
        ujFoglalas.addActionListener(new FoglalasButtonActionListener());
        foglalasEllenorzes.addActionListener(new EllenorzesButtonActionListener());
    }

    protected void initJaratok() {
        this.jaratok = new VonatJaratok();
        this.jaratok.load();
    }
}
