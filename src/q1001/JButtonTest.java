package q1001;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JButtonTest extends JFrame {
    public JButtonTest() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setTitle("JButtonTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[] lblTexts={"안","녕","하","세","요"};
        JButton[] btns=new JButton[lblTexts.length];

        for(int i=0; i<lblTexts.length; i++)
        {
            btns[i]=new JButton(lblTexts[i]);
            btns[i].addActionListener(btnListener);
            add(btns[i]);
        }

        setBounds(200, 200, 300, 200);
        setVisible(true);
    }

    ActionListener btnListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, e.getActionCommand());
        }
    };

    public static void main(String[] args) {
        new JButtonTest();
    }
}