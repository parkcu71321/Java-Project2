package q1105;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawLineWithMouse extends JFrame {
    int x1,y1,x2,y2;
    DrawPanel dp = new DrawPanel();

    public DrawLineWithMouse(){
        addMouseListener(mouseListener);
        add(dp);

        setTitle("DrawLineWithMouse");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(500, 500);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    int count;
    MouseListener mouseListener = new MouseAdapter(){
        public void mouseClicked(MouseEvent e){
            if(count==0){
                x1=e.getX();
                y1=e.getY();
                count++;
            }else{
                x2=e.getX();
                y2=e.getY();
                count=0;
                repaint();
            }
        }
    };

    class DrawPanel extends JPanel{
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.red);
            g.drawLine(x1, y1, x2, y2);
        }
    }
    public static void main(String[] args){
        new DrawLineWithMouse();
    }
}
