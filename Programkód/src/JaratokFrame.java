import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.channels.NetworkChannel;
import java.util.*;
import javax.swing.event.*;
import javax.swing.table.*;

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

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
        JTextField jtfFilter = new JTextField(10);
        //JButton jbtFilter = new JButton("Filter");
        table.setRowSorter(rowSorter);

        // IDEIGLENES HELY A PANELNEK
        JPanel bottomPanel = new JPanel(new BorderLayout());

        bottomPanel.add(new JLabel("Specify a word to match:"), BorderLayout.WEST);
        bottomPanel.add(jtfFilter, BorderLayout.CENTER);
        this.setLayout(new BorderLayout());
        this.add(bottomPanel, BorderLayout.SOUTH);
        //this.add(new JScrollPane(table), BorderLayout.CENTER);
        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        this.add(sp, BorderLayout.CENTER);

        // alsó panel setup
        // PANEL HELYE
        JLabel searchLabel = new JLabel("Kereses");
        JButton newButton = new JButton("Új járat felvétele");
        newButton.addActionListener(new NewButtonActionListener());
        
        //bottomPanel.add(searchLabel);
        //bottomPanel.add(newButton);
        
        
        //this.add(bottomPanel, BorderLayout.PAGE_END);
        
        setMinimumSize(new Dimension(550, 200));
    }

}
