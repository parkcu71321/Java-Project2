package q1105;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;

public class DrawPolygon extends JFrame {
    public DrawPolygon(){
        DrawPanel dp = new DrawPanel();
        add(dp);

        setTitle("MouseEvent find location");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(500, 400);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }
    public static void main(String[] args){
        new DrawPolygon();
    }

    class DrawPanel extends JPanel{
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.red);
            g.drawLine(10,20,150,20);       //시작x,시작y,끝x,끝y

            g.setColor(Color.pink);
            g.drawOval(20,30,150,100);       //타원       왼쪽 위 x좌표,왼쪽 위 y좌표,가로, 세로

            g.setColor(Color.blue);
            g.fillOval(150,30,150,100);      //채워진 타원       왼쪽 위 x좌표,왼쪽 위 y좌표,가로, 세로

            g.setColor(Color.black);
            g.fillOval(400,400,150,150);     //원         왼쪽 위 x좌표,왼쪽 위 y좌표,가로 세로

            g.setColor(Color.orange);
            g.drawRect(400,100,150,150);

            g.setColor(Color.yellow);
            g.drawRect(350,300,150,150);

            g.setColor(Color.magenta);
            g.drawRoundRect(250,200,150,150,10,10);

            g.setColor(Color.blue);
            int[] xPoints={70,40,100};
            int[] yPoints={50,20,100};
            g.drawPolygon(xPoints,yPoints,xPoints.length);
        }
    }
}
