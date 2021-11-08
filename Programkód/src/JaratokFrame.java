import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.channels.NetworkChannel;
import java.util.*;
import java.util.regex.PatternSyntaxException;

import javax.swing.event.*;
import javax.swing.table.*;

public class JaratokFrame extends JFrame{
    //private VonatJaratok vonatjaratok; 
    //private Jaratok repulojaratok;

    private Jaratok jaratok;

    class NewButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JaratFelvetelDialog jfd = new JaratFelvetelDialog(jaratok);
        }
    }

    class TableDocumentListener implements DocumentListener {
        private TableRowSorter<TableModel> rowSorter;
        private JTextField jtfFilter;
        private int columnIndex;
        public TableDocumentListener(TableRowSorter<TableModel> rowSorter, JTextField jtfFilter, int columnIndex) {
            this.rowSorter = rowSorter;
            this.jtfFilter = jtfFilter;
            this.columnIndex = columnIndex;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            OnChange();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            OnChange();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            OnChange();
        }

        public void OnChange() {
            String text = jtfFilter.getText();

            if (text.trim().length() == 0) {
                rowSorter.setRowFilter(null);
            } else {
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, columnIndex));
            }
        }
    }
    

    public JaratokFrame(Jaratok jaratok) {
        this.setLayout(new BorderLayout());
        this.jaratok = jaratok;

        // table setup
        JTable table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        table.setModel(jaratok);
        table.setFillsViewportHeight(true);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        // alsó panel setup
        JPanel bottomPanel = new JPanel();
        JPanel searchPanel = new JPanel();

        searchPanel.add(new JLabel("ID:"));
        JTextField idFilter = new JTextField(3);
        idFilter.getDocument().addDocumentListener(new TableDocumentListener(rowSorter, idFilter, 0));
        searchPanel.add(idFilter);
        searchPanel.add(new JLabel("Indulási állomás:"));
        JTextField induloFilter = new JTextField(10);
        induloFilter.getDocument().addDocumentListener(new TableDocumentListener(rowSorter, induloFilter, 0));
        searchPanel.add(induloFilter);
        searchPanel.add(new JLabel("Érkezési állomás:"));
        JTextField erkezoFilter = new JTextField(10);
        erkezoFilter.getDocument().addDocumentListener(new TableDocumentListener(rowSorter, erkezoFilter, 0));
        searchPanel.add(erkezoFilter);
        searchPanel.add(new JLabel("Indulási dátum:"));
        JTextField indulodatumFilter = new JTextField(10);
        indulodatumFilter.getDocument().addDocumentListener(new TableDocumentListener(rowSorter, indulodatumFilter, 0));
        searchPanel.add(indulodatumFilter);

        // esetleg érkezési dátum alapján szűrés
        /* bottomPanel.add(new JLabel("Érkezési dátum:"));
        JTextField erkezodatumFilter = new JTextField(10);
        erkezodatumFilter.getDocument().addDocumentListener(new TableDocumentListener(rowSorter, erkezodatumFilter, 0));
        bottomPanel.add(erkezodatumFilter); */

        JButton newButton = new JButton("Új járat felvétele");
        newButton.addActionListener(new NewButtonActionListener());

        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(searchPanel, BorderLayout.CENTER);
        bottomPanel.add(newButton, BorderLayout.SOUTH);
        this.setLayout(new BorderLayout());
        this.add(sp, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        setMinimumSize(new Dimension(850, 300));
    }

}
