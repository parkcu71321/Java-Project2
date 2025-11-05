package q1105;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventTest2 extends JFrame{
    public MouseEventTest2(){

        addMouseListener(mouseListener);        //마우스 리스너 삽입

        setTitle("MouseEventTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(300, 300);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    MouseListener mouseListener = new MouseAdapter(){          //MouseAdapter은 하나의 메서드만 사용해도 된다. MouseListener는 인터페이스여서 implements(구현) 하면 선언된 모든 메서드 구현해야됨
        public void mouseClicked(MouseEvent e){
            switch(e.getButton()){
                case MouseEvent.BUTTON1:
                    JOptionPane.showMessageDialog(null,"왼쪽 버튼 클릭");
                    break;
                case MouseEvent.BUTTON2:
                    JOptionPane.showMessageDialog(null,"가운데 버튼 클릭");
                    break;
                case MouseEvent.BUTTON3:
                    JOptionPane.showMessageDialog(null,"오른쪽 버튼 클릭");
                    break;
            }
        }
    };

//    public void mousePressed(MouseEvent e) {}
//    public void mouseReleased(MouseEvent e) {}
//    public void mouseEntered(MouseEvent e) {}
//    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args){
        new MouseEventTest2();
    }
}
