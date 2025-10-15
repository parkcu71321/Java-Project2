package q1015;

import center_frame.CenterFrame;

import javax.swing.*;

public class ImageIconTest extends JFrame {
    public ImageIconTest() {
        ImageIcon icon1 = new ImageIcon("C:/JavaProjects/Java2Project/src/q1015/imgs/img.jpg");
        ImageIcon icon2 = new ImageIcon("C:/JavaProjects/Java2Project/src/q1015/imgs/img_1.jpg");
        JLabel label = new JLabel(icon1);
        JButton button = new JButton(icon2);
        add(label, "North");
        add(button, "Center");

        setTitle("ImageIconTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        JFrame이 모니터 화면에 정중앙에 오도록 한다.
        CenterFrame cf = new CenterFrame(500, 500);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    public static void main(String[] args) {
        new ImageIconTest();
    }
}