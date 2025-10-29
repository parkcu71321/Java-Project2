package q1029;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class RandomGrid extends JFrame {
    public RandomGrid(){
        int row=(int)(Math.random()*10)+1;
        int col=(int)(Math.random()*10)+1;
        setLayout(new GridLayout(row,col));

        Color[] colors={Color.red,Color.orange,Color.blue,Color.green,Color.gray,Color.cyan};

        for(int i=0; i<row*col;i++){
            int dice=(int)(Math.random()*6)+1;      //1부터 6 랜덤
            JButton btn=new JButton(dice+"");
            btn.setBackground(colors[dice-1]);
            add(btn);
        }

        setTitle("RandomGrid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(500, 500);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    public static void main(String[] args){
        new RandomGrid();
    }
}
