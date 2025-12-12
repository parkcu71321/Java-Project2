package restaurantmanagement.view;

import restaurantmanagement.domain.RestaurantVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class RestaurantInsertView extends JPanel {
    JTable table;
    DefaultTableModel model;
    ArrayList<RestaurantVO> list;
    String[] header = {"ID", "이름", "위치", "전화", "분위기", "소개", "등록일"};
    String[] categoryNames = {"Chill (CH)", "Calm (CA)", "Stylish (ST)", "Cozy (CO)"};

    JPanel panS;
    JTextField[] tf = new JTextField[3]; // 이름, 위치, 전화
    JComboBox<String> categoryCombo;
    JTextArea introArea;
    JButton btnAdd;

    public RestaurantInsertView() {
        setLayout(new BorderLayout());
        categoryCombo = new JComboBox<>(categoryNames);
        btnAdd = new JButton("가게 추가");

        panS = new JPanel(new GridLayout(4, 2, 5, 5));
        panS.add(new JLabel("이름"));
        tf[0] = new JTextField(); panS.add(tf[0]);

        panS.add(new JLabel("위치"));
        tf[1] = new JTextField(); panS.add(tf[1]);

        panS.add(new JLabel("전화"));
        tf[2] = new JTextField(); panS.add(tf[2]);

        panS.add(new JLabel("분위기"));
        panS.add(categoryCombo);

        introArea = new JTextArea(4, 20);
        JPanel introPanel = new JPanel(new BorderLayout());
        introPanel.add(new JLabel("소개"), BorderLayout.NORTH);
        introPanel.add(new JScrollPane(introArea), BorderLayout.CENTER);

        JPanel south = new JPanel(new BorderLayout());
        south.add(panS, BorderLayout.NORTH);
        south.add(introPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnAdd);
        south.add(btnPanel, BorderLayout.SOUTH);

        add(south, BorderLayout.SOUTH);
    }

    public void initView() {
        model = new DefaultTableModel(header, list == null ? 0 : list.size()) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        pubSearchResult();

        // ID 열 숨기기
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void pubSearchResult() {
        if (model == null) return;
        model.setRowCount(list == null ? 0 : list.size());
        for (int i = 0; i < (list == null ? 0 : list.size()); i++) {
            RestaurantVO vo = list.get(i);
            model.setValueAt(vo.getRestaurantId(), i, 0);
            model.setValueAt(vo.getRestaurantName(), i, 1);
            model.setValueAt(vo.getLocation(), i, 2);
            model.setValueAt(vo.getPhone(), i, 3);
            model.setValueAt(mapCodeToDisplay(vo.getCategoryCode()), i, 4);
            model.setValueAt(vo.getIntro(), i, 5);
            model.setValueAt(vo.getRegisterDate() == null ? "" : vo.getRegisterDate().toString(), i, 6);
        }
    }

    // 필수 입력 체크 포함
    public RestaurantVO neededInsertData() {
        String name = tf[0].getText().trim();
        String location = tf[1].getText().trim();
        String phone = tf[2].getText().trim();
        String category = (String) categoryCombo.getSelectedItem();

        if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || category.isEmpty()) {
            JOptionPane.showMessageDialog(this, "이름, 위치, 전화, 분위기는 반드시 입력해야 합니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        RestaurantVO vo = new RestaurantVO();
        vo.setRestaurantName(name);
        vo.setLocation(location);
        vo.setPhone(phone);
        vo.setCategoryCode(mapDisplayToCode(category));
        vo.setIntro(introArea.getText().trim()); // 소개는 선택
        return vo;
    }

    private String mapDisplayToCode(String display) {
        if (display == null) return "CH";
        int a = display.indexOf('(');
        int b = display.indexOf(')');
        if (a >= 0 && b > a) return display.substring(a + 1, b);
        return display;
    }

    private String mapCodeToDisplay(String code) {
        if (code == null) return categoryNames[0];
        switch (code) {
            case "CH": return "Chill (CH)";
            case "CA": return "Calm (CA)";
            case "ST": return "Stylish (ST)";
            case "CO": return "Cozy (CO)";
            default: return code;
        }
    }

    public JButton getBtnAdd() { return btnAdd; }
    public void setList(ArrayList<RestaurantVO> list) { this.list = list; }
    public void initInsertData() {
        for (int i = 0; i < tf.length; i++) if (tf[i] != null) tf[i].setText("");
        categoryCombo.setSelectedIndex(0);
        introArea.setText("");
    }
}
