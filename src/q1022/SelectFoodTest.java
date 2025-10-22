package q1022;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFoodTest extends JFrame {
    JTextField tf;
    JLabel imageLabel;
    JButton btn;

    public SelectFoodTest() {
        setTitle("음식쇼");
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel lblFood = new JLabel("Food:");
        tf = new JTextField(10);
        btn = new JButton("확인");
        topPanel.add(lblFood);
        topPanel.add(tf);
        topPanel.add(btn);
        add(topPanel, BorderLayout.NORTH);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.CENTER);


        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String food = tf.getText().trim();

                ImageIcon icon = null;
                switch (food) {
                    case "pizza":
                        icon = new ImageIcon("src/q1022/images/pizza.png");
                        break;
                    case "chicken":
                        icon = new ImageIcon("src/q1022/images/chicken.png");
                        break;
                    case "hamburger":
                        icon = new ImageIcon("src/q1022/images/hamburger.png");
                        break;
                    default:
                        icon = null;
                        JOptionPane.showMessageDialog(null, "이미지를 찾을 수 없습니다.");
                }
                imageLabel.setIcon(icon);
            }
        });

        setSize(300, 300);
        setLocationRelativeTo(null); // 화면 중앙 배치
        setVisible(true);
    }

    public static void main(String[] args) {
        new SelectFoodTest();
    }
}
