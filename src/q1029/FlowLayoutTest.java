package q1029;

import center_frame.CenterFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class FlowLayoutTest extends JFrame{
    ArrayList<JButton> buttons=new ArrayList<JButton>();

    public FlowLayoutTest(){        //생성자
        setLayout(new FlowLayout(FlowLayout.RIGHT,15,15));      //setLayout - 어떤 레이아웃 매니저를 사용할지, new FlowLayout(....) - 이 컨테이너 안의 컴포넌트는 FlowLayout을 오른쪽 정렬의 가로 세로 간격을 15 규칙대로 배치해라.

        for(int i=0; i<7; i++){     //버튼이 생성돼 List에 저장됨
            buttons.add(new JButton("버튼"+(i+1)));
        }

        for(JButton button:buttons){            //저장된 List에서 JFrame에 나타나게 해줌
            add(button);        //this.getContentPane().add(button) 와 같음. 즉 JFrame이 가지고 있는 content pane에 버튼을 추가.
            button.addActionListener(btnListener);
        }

        setTitle("FlowLayoutTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(300, 300);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);       //생성된 버튼이 화면에 보이게 함
    }

    ActionListener btnListener=new ActionListener(){
        public void actionPerformed(ActionEvent e){
            JButton btn = (JButton)e.getSource();      //e.getSource() - 이벤트를 발생 시키는 컴포넌트를 반환
            JOptionPane.showMessageDialog(null, btn.getText() + " 클릭됨");
        }
    };
    public static void main(String[] args){
        new FlowLayoutTest();
    }
}
