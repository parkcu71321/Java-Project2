package restaurantmanagement.view;

import restaurantmanagement.domain.RestaurantVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class RestaurantSearchView extends JPanel {
    JTable table;
    DefaultTableModel model;
    ArrayList<RestaurantVO> list;
    String[] header = {"ID", "이름", "위치", "전화", "분위기", "소개", "등록일"};

    JPanel panN;
    JTextField tfSearch;
    JComboBox<String> combo;
    JButton btnSearch;

    String[] searchCriteria = {"식당명", "위치", "분위기"};

    public RestaurantSearchView() {
        setLayout(new BorderLayout());

        panN = new JPanel();
        tfSearch = new JTextField(15);
        combo = new JComboBox<>(searchCriteria);
        btnSearch = new JButton("검색");

        panN.add(new JLabel("검색어:"));
        panN.add(tfSearch);
        panN.add(new JLabel("기준:"));
        panN.add(combo);
        panN.add(btnSearch);
    }

    public void initView() {
        model = new DefaultTableModel(header, list == null ? 0 : list.size()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);

        // ID 열 숨기기
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);

        JScrollPane scrollPane = new JScrollPane(table);
        putSearchResult();

        add(panN, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void putSearchResult() {
        if (model == null) return;
        model.setRowCount(list == null ? 0 : list.size());
        for (int i = 0; i < (list == null ? 0 : list.size()); i++) {
            RestaurantVO vo = list.get(i);
            model.setValueAt(vo.getRestaurantId(), i, 0);
            model.setValueAt(vo.getRestaurantName(), i, 1);
            model.setValueAt(vo.getLocation(), i, 2);
            model.setValueAt(vo.getPhone(), i, 3);
            model.setValueAt(vo.getCategoryCode(), i, 4);
            model.setValueAt(vo.getIntro(), i, 5);
            model.setValueAt(vo.getRegisterDate() == null ? "" : vo.getRegisterDate().toString(), i, 6);
        }
    }

    public String getSearchWord() {
        return tfSearch.getText().trim();
    }

    public JComboBox<String> getCombo() {
        return combo;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public void setList(ArrayList<RestaurantVO> list) {
        this.list = list;
    }

    public void pubSearchResult() {
        putSearchResult();
    }

    public JTable getTable() {
        return table;
    }
}
