package restaurantmanagement.view;

import restaurantmanagement.domain.RestaurantVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class RestaurantUpdateView extends JPanel {
    JTable table;
    DefaultTableModel model;
    ArrayList<RestaurantVO> list;
    String[] header = {"ID", "이름", "위치", "전화", "분위기", "소개", "등록일"};
    String[] categoryNames = {"Chill (CH)", "Calm (CA)", "Stylish (ST)", "Cozy (CO)"};

    JPanel panS;
    JTextField[] tf = new JTextField[4]; // ID, 이름, 위치, 전화
    JComboBox<String> categoryCombo;
    JTextArea introArea;
    JButton btnUpdate, btnDelete;

    public RestaurantUpdateView() {
        setLayout(new BorderLayout());
        categoryCombo = new JComboBox<>(categoryNames);
        btnUpdate = new JButton("수정");
        btnDelete = new JButton("삭제");

        panS = new JPanel(new GridLayout(5, 2, 5, 5));
        panS.add(new JLabel("ID(수정/삭제 기준)"));
        tf[0] = new JTextField(); tf[0].setEditable(true); panS.add(tf[0]); // 수정/삭제 시 ID 사용

        panS.add(new JLabel("이름"));
        tf[1] = new JTextField(); panS.add(tf[1]);

        panS.add(new JLabel("위치"));
        tf[2] = new JTextField(); panS.add(tf[2]);

        panS.add(new JLabel("전화"));
        tf[3] = new JTextField(); panS.add(tf[3]);

        panS.add(new JLabel("분위기"));
        panS.add(categoryCombo);

        introArea = new JTextArea(4, 20);
        JPanel introPanel = new JPanel(new BorderLayout());
        introPanel.add(new JLabel("소개 (선택)"), BorderLayout.NORTH);
        introPanel.add(new JScrollPane(introArea), BorderLayout.CENTER);

        JPanel south = new JPanel(new BorderLayout());
        south.add(panS, BorderLayout.NORTH);
        south.add(introPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnUpdate);
        btnPanel.add(btnDelete);
        south.add(btnPanel, BorderLayout.SOUTH);

        add(south, BorderLayout.SOUTH);
    }

    public void setTextField(int rowIndex) {
        if (model == null) return;
        tf[0].setText(model.getValueAt(rowIndex,0).toString());
        tf[1].setText(model.getValueAt(rowIndex,1).toString());
        tf[2].setText(model.getValueAt(rowIndex,2).toString());
        tf[3].setText(model.getValueAt(rowIndex,3).toString());
        String display = (String) model.getValueAt(rowIndex,4); // "Chill (CH)" 형태
        if (display != null) {
            for (int i = 0; i < categoryCombo.getItemCount(); i++) {
                if (categoryCombo.getItemAt(i).equals(display)) {
                    categoryCombo.setSelectedIndex(i);
                    break;
                }
            }
        } else {
            categoryCombo.setSelectedIndex(0);
        }
        introArea.setText((String) model.getValueAt(rowIndex,5));
    }

    public void initView() {
        model = new DefaultTableModel(header, list == null ? 0 : list.size()){
            @Override public boolean isCellEditable(int row, int column){ return false; }
        };
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        putSearchResult();
        add(sp, BorderLayout.CENTER);
    }

    public void putSearchResult() {
        if (model == null) return;
        model.setRowCount(list == null ? 0 : list.size());
        for (int i = 0; i < (list == null ? 0 : list.size()); i++) {
            RestaurantVO vo = list.get(i);
            model.setValueAt(vo.getRestaurantId(), i,0);
            model.setValueAt(vo.getRestaurantName(), i,1);
            model.setValueAt(vo.getLocation(), i,2);
            model.setValueAt(vo.getPhone(), i,3);
            model.setValueAt(mapCodeToDisplay(vo.getCategoryCode()), i,4);
            model.setValueAt(vo.getIntro(), i,5);
            model.setValueAt(vo.getRegisterDate() == null ? "" : vo.getRegisterDate().toString(), i,6);
        }
    }

    public RestaurantVO neededUpdateData() {
        // 필수 입력 체크
        for (int i = 0; i < tf.length; i++) {
            if (tf[i].getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "필수 입력 칸이 비어있습니다.");
                throw new RuntimeException("필수 입력 없음");
            }
        }

        RestaurantVO vo = new RestaurantVO();
        vo.setRestaurantId(Integer.parseInt(tf[0].getText()));
        vo.setRestaurantName(tf[1].getText().trim());
        vo.setLocation(tf[2].getText().trim());
        vo.setPhone(tf[3].getText().trim());
        vo.setCategoryCode(mapDisplayToCode((String)categoryCombo.getSelectedItem()));
        vo.setIntro(introArea.getText().trim());
        return vo;
    }

    // 삭제용 메서드
    public int neededDeleteId() {
        if (tf[0].getText().trim().isEmpty()) {
            throw new NumberFormatException("ID가 비어있습니다.");
        }
        return Integer.parseInt(tf[0].getText().trim());
    }

    private String mapDisplayToCode(String display) {
        if (display == null) return "CH";
        int a = display.indexOf('(');
        int b = display.indexOf(')');
        if (a >= 0 && b > a) return display.substring(a+1, b);
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

    public void setList(ArrayList<RestaurantVO> list) { this.list = list; }
    public JButton getBtnUpdate() { return btnUpdate; }
    public JButton getBtnDelete() { return btnDelete; }
    public JTable getTable() { return table; }

    public void initUpdateData() {
        for (int i = 0; i < tf.length; i++) if (tf[i] != null) tf[i].setText("");
        categoryCombo.setSelectedIndex(0);
        introArea.setText("");
    }
}
