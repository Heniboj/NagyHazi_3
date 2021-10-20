import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame("Jegyvásárló program");
        JPanel p = new JPanel();

        JTextField nev = new JTextField("",5);
        JTextField osztaly = new JTextField("",5);
        JTextField menu = new JTextField("",5);

        JButton b = new JButton("OK");
        ActionListener al = new MyActionListener(nev);
        b.addActionListener(al);

        p.add(b);
        p.add(nev);
        p.add(osztaly);
        p.add(menu);

        FlowLayout fl = new FlowLayout();
        f.setLayout(fl);
        f.add(p);
        f.pack();
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
