import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class JaratokFrame extends JFrame{
    private Jaratok jaratok;

    class NewButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new JaratFelvetelDialog(jaratok);
        }
    }

    class TableDocumentListener implements DocumentListener {
        private TableRowSorter<TableModel> rowSorter;
        private ArrayList<RowFilter<Object,Object>> filters;
        private JTextField jtfFilter;
        private int columnIndex;
        public TableDocumentListener(TableRowSorter<TableModel> rowSorter, ArrayList<RowFilter<Object,Object>> filters, JTextField jtfFilter, int columnIndex) {
            this.rowSorter = rowSorter;
            this.filters = filters;
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
                filters.set(columnIndex, RowFilter.regexFilter(".*", columnIndex));
            } else {
                filters.set(columnIndex, RowFilter.regexFilter("(?i)" + text, columnIndex));
            }
            rowSorter.setRowFilter(RowFilter.andFilter(filters));
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

        ArrayList<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>();
        initFilters(filters, 4);

        // alsó panel setup
        JPanel bottomPanel = new JPanel();
        JPanel searchPanel = new JPanel();

        searchPanel.add(new JLabel("ID:"));
        JTextField idFilter = new JTextField(3);
        idFilter.getDocument().addDocumentListener(new TableDocumentListener(rowSorter, filters, idFilter, 0));
        searchPanel.add(idFilter);
        searchPanel.add(new JLabel("Indulási állomás:"));
        JTextField induloFilter = new JTextField(10);
        induloFilter.getDocument().addDocumentListener(new TableDocumentListener(rowSorter, filters, induloFilter, 1));
        searchPanel.add(induloFilter);
        searchPanel.add(new JLabel("Érkezési állomás:"));
        JTextField erkezoFilter = new JTextField(10);
        erkezoFilter.getDocument().addDocumentListener(new TableDocumentListener(rowSorter, filters, erkezoFilter, 2));
        searchPanel.add(erkezoFilter);
        searchPanel.add(new JLabel("Indulási dátum:"));
        JTextField indulodatumFilter = new JTextField(10);
        indulodatumFilter.getDocument().addDocumentListener(new TableDocumentListener(rowSorter, filters, indulodatumFilter, 3));
        searchPanel.add(indulodatumFilter);

        // esetleg érkezési dátum alapján szűrés
        /* searchPanel.add(new JLabel("Érkezési dátum:"));
        JTextField erkezodatumFilter = new JTextField(10);
        erkezodatumFilter.getDocument().addDocumentListener(new TableDocumentListener(rowSorter, filters, erkezodatumFilter, 4));
        searchPanel.add(erkezodatumFilter); */

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

    public void initFilters(ArrayList<RowFilter<Object,Object>> filters, int size) {
        for(int i = 0; i < size; i++) {
            filters.add(RowFilter.regexFilter(".*", i));
        }
    }
}
