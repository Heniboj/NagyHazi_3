import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.channels.NetworkChannel;
import java.util.*;

public class JaratokFrame extends JFrame{

    //private VonatJaratok vonatjaratok; 
    //private Jaratok repulojaratok;

    private VonatJaratok jaratok;

    class NewButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JaratFelvetelDialog jfd = new JaratFelvetelDialog(jaratok, "Vonat");
        }
    }
    

    public JaratokFrame(VonatJaratok jaratok) {
        this.setLayout(new BorderLayout());
        this.jaratok = jaratok;

        //vonatjaratok.load();
        
        // table setup
        JTable table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        table.setModel(jaratok);
        table.setFillsViewportHeight(true);
        this.add(sp, BorderLayout.CENTER);

        // alsó panel setup
        JPanel bottomPanel = new JPanel();
        JLabel searchLabel = new JLabel("Kereses");
        JButton newButton = new JButton("Új járat felvétele");
        newButton.addActionListener(new NewButtonActionListener());
        
        bottomPanel.add(searchLabel);
        bottomPanel.add(newButton);
        
        
        this.add(bottomPanel, BorderLayout.PAGE_END);
        
        setMinimumSize(new Dimension(550, 200));
    }

}
