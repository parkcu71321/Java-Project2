package q1015;

import center_frame.CenterFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RadioButtonTest extends JFrame{
    JRadioButton[] rbArr=new JRadioButton[3];
    String[] rbStrArr={"막스","르클레르","헤밀턴"};
    String[] imgNameArr={"mac","lil","hamil"};
    JLabel lbl=new JLabel();

    public RadioButtonTest(){
        JPanel panel=new JPanel();
        setLayout(new FlowLayout());            //FlowLayout.RIGHT - 오른쪽 정렬
        ButtonGroup bg = new ButtonGroup();

        int i=0;

        for(String str:rbStrArr){
            rbArr[i]=new JRadioButton(str);
            rbArr[i].addActionListener(checkBoxListener);
            bg.add(rbArr[i]);
            add(rbArr[i]);
            panel.add(rbArr[i]);
            i++;
        }
        lbl.setOpaque(true);
        lbl.setBackground(Color.PINK);
        add(panel,"North");
        add(lbl,"Center");

        setTitle("RadioButtonTest");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        CenterFrame cf=new CenterFrame(500,300);
        cf.centerXY();
        setBounds(cf.getX(),cf.getY(),cf.getFw(),cf.getFh());        //위치를 조정할 때 쓰는 함수
        setVisible(true);           //모든 컴포넌트 작성 후에 써야 화면에 나타남.
    }

    ActionListener checkBoxListener = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i=0; i<rbArr.length; i++){
                if(rbArr[i].isSelected()){
                    ImageIcon imageIcon = new ImageIcon("./imgs/"+imgNameArr[i]+".jpg");
                    lbl.setIcon(imageIcon);
                    JOptionPane.showMessageDialog(null, rbStrArr[i] + " 선택됨");
                }
            }
        }
    };

    public static void main(String[] args){
        new RadioButtonTest();
    }
}
