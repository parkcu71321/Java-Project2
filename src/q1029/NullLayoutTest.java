package q1029;

import center_frame.CenterFrame;

import javax.swing.*;

public class NullLayoutTest extends JFrame{
    public NullLayoutTest(){
        setLayout(null);        //레이아웃 매니저 없음, 즉 규칙과 규칙 대상이 없음
        int[] xy={50,70,90,110};

        for(int i=0; i<xy.length; i++){
            JButton btn=new JButton("버튼"+(i+1));
            btn.setBounds(xy[i],xy[i],70,60);       //레이아웃 매니저가 없어서 위치와 크기를 지정해야됨(절대값으로 지정됨). setBounds(x,y,width,height) - 위치와 크기를 정하는 메서드
            add(btn);
        }

        setTitle("NullLayoutTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(300, 300);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    public static void main(String[] args){
        new NullLayoutTest();
    }
}
