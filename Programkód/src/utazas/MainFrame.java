package utazas;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel panels;
    private CardLayout cl;

    private Jegyek<Jegy> jegyek;

    /**
     * Konstruktor: panelek létrehozása, cardlayoutba berakása
     */
    public MainFrame() {
        jegyek = new Jegyek();
        jegyek.load();
        setLayout(new BorderLayout());
        setSize(600,300);
        setLocation(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Főmenü");

        SelectionPanel sp = new SelectionPanel(this);
        VonatPanel vp = new VonatPanel(this);
        RepuloPanel rp = new RepuloPanel(this);
        
        panels = new JPanel(new CardLayout());
        panels.add(sp, "main");
        panels.add(vp, "vonatpanel");
        panels.add(rp, "repulopanel");

        add(panels, BorderLayout.CENTER);

        setMinimumSize(new Dimension(300, 100));

        cl = (CardLayout)(panels.getLayout());
    }

    /**
     * Főmenü megjelenítése
     */
    public void mainMenu() {
        cl.show(panels, "main");
    }

    /**
     * VonatPanel megjelenítése
     */
    public void vonatPanel() {
        cl.show(panels, "vonatpanel");
    }

    /**
     * RepuloPanel megjelenítése
     */
    public void repuloPanel() {
        cl.show(panels, "repulopanel");
    }

    public Jegyek getJegyek() {return jegyek;}
}
