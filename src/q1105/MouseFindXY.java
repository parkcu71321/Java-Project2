package q1105;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseFindXY extends JFrame {
    JTextField tfX,tfY;

    public MouseFindXY(){           //생성자
        setLayout(new FlowLayout());

        addMouseListener(mouseListener);

        tfX=new JTextField(10);
        tfY=new JTextField(10);

        JLabel lblX = new JLabel("X 좌표: ");
        JLabel lblY = new JLabel("Y 좌표: ");

        add(lblX); add(tfX);            //자바는 ;를 기준으로 문장 구별
        add(lblY);
        add(tfY);

        setTitle("MouseEvent find location");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(500, 400);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    MouseAdapter mouseListener = new MouseAdapter(){            //타입 변수명 new
        public void mousePressed(MouseEvent e){
            tfX.setText(e.getX()+"");
            tfY.setText(e.getY()+"");
        }
    };
    public static void main(String[] args){
            new MouseFindXY();
    }
}

