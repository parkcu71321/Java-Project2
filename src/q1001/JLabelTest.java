package q1001;

import javax.swing.*;
import java.awt.*;

public class JLabelTest extends JFrame
{
    public JLabelTest()
    {
        setLayout(new FlowLayout());
        setTitle("JLabelTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        String[] lblTexts={"딴","남자","는 너무 뻔해"};
        String[] locTexts={"North","Center","South"};
        Color[] lblBgColors={Color.red,Color.pink, Color.orange};
        JLabel[] lbls=new JLabel[lblTexts.length];
        for(int i=0; i<lbls.length; i++)
        {
            lbls[i]=new JLabel(lblTexts[i],JLabel.CENTER);
            lbls[i].setForeground(Color.white);
            lbls[i].setOpaque(true);
            lbls[i].setBackground(lblBgColors[i]);
            add(lbls[i],locTexts[i]);
        }

        Font font = new Font("맑은고딕",Font.BOLD,30);
        lbls[2].setFont(font);

        setBounds(100,100,300,400);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new JLabelTest();
    }
}
