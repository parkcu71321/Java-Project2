package bookmanagement.view;

import bookmanagement.domain.BookVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class BookInsertView extends JPanel{
    JTable table;
    DefaultTableModel model;
    ArrayList<BookVO> bookVOList;
    String[] header = {"도서번호", "도서명", "출판사", "저자명", "도서가격", "카테고리" };
    String[] categoryNames={"IT도서","소설","비소설","경제","경제"};

    JComboBox<String> categoryCombo;
    JPanel panSouth;
    JLabel[] lbls=new JLabel[header.length];
    JTextField[] tf=new JTextField[header.length-1];
    JButton btnAdd;


    public BookInsertView(){
        setLayout(new BorderLayout());
        categoryCombo=new JComboBox(categoryNames);
        btnAdd=new JButton("도서 추가");
        panSouth=new JPanel(new GridLayout(4,4));
        for(int i=0; i<header.length; i++){
            lbls[i]=new JLabel(header[i]);
            panSouth.add(lbls[i]);
            if(i<header.length-1){
                tf[i]=new JTextField();
                panSouth.add(tf[i]);
            }else{
                panSouth.add(categoryCombo);
            }
            for(int j=0; j<3; j++){
                panSouth.add(new JLabel(""));
            }
            panSouth.add(btnAdd);
        }
    }
    public void initView() {
        model = new DefaultTableModel(header, bookVOList.size()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        table = new JTable(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(70);

        //테이블의 행의 개수가 많을 때는 스크롤바가 필요
        JScrollPane scrollPane = new JScrollPane(table);

        //각 셀에 리스트에 저장된 bookVo객체가 가지고있는값들을 설정
        pubSearchResult();

        //현재 패널에 center에는 스크롤바가 있는 테이블, south에는 도서 추가 패널
        add(scrollPane, BorderLayout.CENTER);
        add(panSouth, BorderLayout.SOUTH);
    }

    //defaultablemodel에 도서정보들을 설정한다
    public void pubSearchResult(){
        //model에 행개수 설정
        model.setRowCount(bookVOList.size());
        BookVO vo = null;
        for(int i = 0; i<bookVOList.size(); i++){
            vo = bookVOList.get(i);
            model.setValueAt(vo.getIsbn(), i, 0);
            model.setValueAt(vo.getName(), i, 1);
            model.setValueAt(vo.getPublish(), i, 2);
            model.setValueAt(vo.getAuthor(), i, 3);
            model.setValueAt(vo.getPrice(), i, 4);
            model.setValueAt(vo.getCategoryName(), i, 5);

        }
    }
}
