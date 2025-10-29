package q1029;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorderLayoutTest extends JFrame{
    public BorderLayoutTest(){
        String[] constraints={"North","East","South","West","Center"};

        for(int i=0; i<5; i++){
            JButton btn = new JButton(constraints[i]+"버튼");
            add(btn,constraints[i]);
            btn.addActionListener(btnListener);
        }

        setTitle("BorderTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(300, 300);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    ActionListener btnListener=new ActionListener(){        //타입 변수명 = new 타입(){}; - 익명 클래스. 인터페이스나 추상 클래스의 메서드를 바로 구현하기 위해.
        public void actionPerformed(ActionEvent e){
            JButton btn=(JButton) e.getSource();        //getSource() - 이벤트를 발생 시키는 컴포넌트를 반환, (JButton)은 형변환 - Object여서 JButton으로 바꾸면 getText 사용 가능.
            JOptionPane.showMessageDialog(null,btn.getText()+"선택됨");
        }
    };

    public static void main(String[] args){
        new BorderLayoutTest();
    }
}
