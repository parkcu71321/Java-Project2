package restaurantmanagement.Controller;

import center_frame.CenterFrame;
import restaurantmanagement.domain.RestaurantVO;
import restaurantmanagement.repository.RestaurantRepository;
import restaurantmanagement.view.RestaurantInsertView;
import restaurantmanagement.view.RestaurantSearchView;
import restaurantmanagement.view.RestaurantUpdateView;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RestaurantController extends JFrame {
    RestaurantSearchView searchPan;
    RestaurantInsertView insertPan;
    RestaurantUpdateView updatePan;
    RestaurantRepository repo;
    ArrayList<RestaurantVO> list;

    JComboBox<String> comboSearch;
    JButton btnSearch, btnAdd, btnUpdate, btnDelete;
    JTable tableUpdate;
    JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);

    public RestaurantController() {
        repo = new RestaurantRepository();


        searchPan = new RestaurantSearchView();
        comboSearch = searchPan.getCombo();
        list = repo.select("", comboSearch.getSelectedIndex());
        searchPan.setList(list);
        searchPan.initView();
        btnSearch = searchPan.getBtnSearch();
        btnSearch.addActionListener(e -> {
            list = repo.select(searchPan.getSearchWord(), comboSearch.getSelectedIndex());
            searchPan.setList(list);
            searchPan.pubSearchResult();
        });
        tab.add("가게검색", searchPan);


        insertPan = new RestaurantInsertView();
        list = repo.select("", 0);
        insertPan.setList(list);
        insertPan.initView();
        btnAdd = insertPan.getBtnAdd();
        btnAdd.addActionListener(e -> {
            RestaurantVO vo = insertPan.neededInsertData();
            if (vo == null) return;
            repo.insert(vo);
            list = repo.select("", 0);
            insertPan.setList(list);
            insertPan.pubSearchResult();
            insertPan.initInsertData();
        });
        tab.add("가게추가", insertPan);


        updatePan = new RestaurantUpdateView();
        list = repo.select("", 0);
        updatePan.setList(list);
        updatePan.initView();

        btnUpdate = updatePan.getBtnUpdate();
        btnDelete = updatePan.getBtnDelete();

        // 수정 버튼
        btnUpdate.addActionListener(e -> {
            RestaurantVO vo = updatePan.neededUpdateData();
            if (vo == null) return; // 필수 입력 체크 실패
            try {
                repo.update(vo); // ID 기준으로 업데이트
                list = repo.select("", 0);
                updatePan.setList(list);
                updatePan.putSearchResult();
                updatePan.initUpdateData();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RestaurantController.this, "ID를 숫자로 입력하세요!");
            }
        });

        // 삭제 버튼
        btnDelete.addActionListener(e -> {
            try {
                int id = updatePan.neededDeleteId();
                int result = JOptionPane.showConfirmDialog(RestaurantController.this, "정말 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    repo.delete(id);
                    list = repo.select("", 0);
                    updatePan.setList(list);
                    updatePan.putSearchResult();
                    updatePan.initUpdateData();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RestaurantController.this, "ID를 숫자로 입력하세요!");
            }
        });

        // 테이블 클릭 시 텍스트 필드에 내용 표시
        tableUpdate = updatePan.getTable();
        tableUpdate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int rowIndex = tableUpdate.getSelectedRow();
                    updatePan.setTextField(rowIndex);
                }
            }
        });

        tab.add("가게수정 및 삭제", updatePan);


        tab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int tabIndex = tab.getSelectedIndex();
                if (tabIndex == 0) {
                    list = repo.select("", comboSearch.getSelectedIndex());
                    searchPan.setList(list);
                    searchPan.pubSearchResult();
                } else if (tabIndex == 1) {
                    list = repo.select("", 0);
                    insertPan.setList(list);
                    insertPan.pubSearchResult();
                } else {
                    list = repo.select("", 0);
                    updatePan.setList(list);
                    updatePan.putSearchResult();
                }
            }
        });

        add(tab);
        setTitle("음식점 예약/관리 시스템");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(800, 600);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    public static void main(String[] args) {
        new RestaurantController();
    }
}
