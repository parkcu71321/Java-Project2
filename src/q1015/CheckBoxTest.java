package q1015;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxTest extends JFrame {
    JCheckBox checkBox;

    public CheckBoxTest() {
        setLayout(new FlowLayout(FlowLayout.CENTER));            //FlowLayout.RIGHT - 오른쪽 정렬
        setTitle("CheckBoxTest");
        checkBox = new JCheckBox("체크 박스 선택");
        checkBox.addActionListener(checkBoxListener);
        add(checkBox);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //JFrame이 모니터 정중앙에 나오도록 한다.
        CenterFrame cf=new CenterFrame(500,300);
        cf.centerXY();
        setBounds(cf.getX(),cf.getY(),cf.getFw(),cf.getFh());        //위치를 조정할 때 쓰는 함수
        setVisible(true);           //모든 컴포넌트 작성 후에 써야 화면에 나타남.
    }

    ActionListener checkBoxListener = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            if(checkBox.isSelected()){
                JOptionPane.showMessageDialog(null,"체크박스 선택");
            }
            else{
                JOptionPane.showMessageDialog(null,"체크박스 해제");
            }
        }
    };

    public static void main(String[] args) {
        new CheckBoxTest();

    }
}
