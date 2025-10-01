package q1001;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JButtonTest2
{
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();              //가로 세로 위치를 나타냄
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int fw=500;
        int fh=500;
        int x=screenWidth/2-fw/2;
        int y=screenHeight/2-fh/2;

        JFrame frame = new JFrame("입력 알림창");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(500, 300, 500, 500);

        JTextField textField = new JTextField();
        textField.setBounds(50, 50, 200, 50);
        frame.add(textField);

        JButton button = new JButton("확인");
        button.setBounds(100, 100, 100, 100);
        frame.add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                JOptionPane.showMessageDialog(frame, input);
            }
        });

        frame.setVisible(true);
    }
}
