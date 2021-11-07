import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class JaratokFrame extends JFrame{

    //private VonatJaratok vonatjaratok; 
    //private Jaratok repulojaratok;

    private Jaratok jaratok;
    

    public JaratokFrame(Jaratok jaratok) {
        this.setLayout(new BorderLayout());
        this.jaratok = jaratok;

        //vonatjaratok.load();

        JTable table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        table.setModel(jaratok);
        table.setFillsViewportHeight(true);
        this.add(sp, BorderLayout.CENTER);
        
        setMinimumSize(new Dimension(550, 200));
    }

}
