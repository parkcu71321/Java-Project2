package center_frame;

import java.awt.*;

public class CenterFrame {
    private int x,y,fw,fh;

    public CenterFrame(int fw, int fh) {
        this.fw = fw;
        this.fh = fh;
    }

    public void centerXY(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();              //가로 세로 위치를 나타냄
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        x=screenWidth/2-fw/2;
        y=screenHeight/2-fh/2;          //필드라고 부른다
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFw() {
        return fw;
    }

    public void setFw(int fw) {
        this.fw = fw;
    }

    public int getFh() {
        return fh;
    }

    public void setFh(int fh) {
        this.fh = fh;
    }
}
