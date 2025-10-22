package q1022;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// CenterFrame 클래스가 정의된 패키지를 가정하고 import 합니다.
// 만약 CenterFrame이 별도의 패키지에 있다면 해당 import 문을 추가해야 합니다.
// 예: import center_frame.CenterFrame;

class TextFieldTest extends JFrame {
    // 필드 선언 부분은 그대로 유지합니다.
    JTextField tf; // 한줄 입력
    JTextArea ta; // 여러줄 입력
    JPasswordField pf; // 암호 입력
    JButton ok; // 버튼 추가

    public TextFieldTest() {
        // 컴포넌트 초기화
        tf = new JTextField(10); // columns: 10 대신 10만 사용
        ta = new JTextArea(5, 10);
        pf = new JPasswordField(10);
        ok = new JButton("ShowMessage"); // text: "ShowMessage" 대신 "ShowMessage"만 사용

        // 레이아웃 설정 (FlowLayout은 컴포넌트를 왼쪽에서 오른쪽으로 배치합니다.)
        setLayout(new FlowLayout());

        // 컴포넌트 추가
        add(tf);
        JScrollPane sp = new JScrollPane(ta);
        add(sp); // JTextArea는 스크롤 가능한 창(JScrollPane)으로 감싸서 추가
        add(pf); // JPasswordField 추가
        add(ok);    // 버튼을 프레임에 추가


        // 프레임 설정
        setTitle("텍스트 입력 가능 컴포넌트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(200, 250);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tfText = tf.getText();
            String taText = ta.getText();
            String pwText = pf.getText();
            JOptionPane.showMessageDialog(null,tfText+"\n"+taText+"\n"+pwText);
        }
    };

    public static void main(String[] args) {
        new TextFieldTest();
    }
}


// CenterFrame은 사용자 정의 클래스이므로, 해당 클래스가 없다고 가정하고 중앙에 배치하는 일반적인 코드로 대체하거나,
// CenterFrame을 사용할 경우 별도의 파일/패키지에 해당 클래스가 정의되어 있어야 합니다.

// CenterFrame 관련 코드를 Java Swing 표준 중앙 배치 코드로 대체 (CenterFrame이 없을 경우)
// setSize(250, 250); // CenterFrame에서 지정한 크기로 가정
// setLocationRelativeTo(null); // 화면 중앙에 배치

// setBounds와 CenterFrame을
