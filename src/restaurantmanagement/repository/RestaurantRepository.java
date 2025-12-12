package restaurantmanagement.repository;

import restaurantmanagement.domain.RestaurantVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class RestaurantRepository {
    public ArrayList<RestaurantVO> select(String searchWord, int selectedIndex) {
        Connection con = JDBCConnector.getConnection();
        ArrayList<RestaurantVO> list = new ArrayList<>();
        PreparedStatement psmt = null;
        ResultSet rs = null;

        // 검색 대상 컬럼: 식당명, 위치, 분위기 코드
        String[] columnName = {"restaurant_name", "location", "category_code"};
        String sql = "SELECT r.restaurant_id, r.restaurant_name, r.location, r.phone, r.category_code, r.intro, r.register_date " +
                "FROM restaurants r " +
                "WHERE " + columnName[selectedIndex] + " LIKE ? " +
                "ORDER BY r.restaurant_id";

        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, "%" + searchWord + "%");
            rs = psmt.executeQuery();
            while (rs.next()) {
                RestaurantVO vo = new RestaurantVO();
                vo.setRestaurantId(rs.getInt("restaurant_id"));
                vo.setRestaurantName(rs.getString("restaurant_name"));
                vo.setLocation(rs.getString("location"));
                vo.setPhone(rs.getString("phone"));
                vo.setCategoryCode(rs.getString("category_code"));
                vo.setIntro(rs.getString("intro"));
                Timestamp ts = rs.getTimestamp("register_date");
                if (ts != null) vo.setRegisterDate(new Date(ts.getTime()));
                list.add(vo);
            }
        } catch (SQLException e) { e.printStackTrace();
        } finally {
            try { if(rs != null) rs.close(); if(psmt != null) psmt.close(); if(con != null) con.close(); }
            catch (SQLException e) { e.printStackTrace(); }
        }
        return list;
    }

    public void insert(RestaurantVO vo) {
        Connection con = JDBCConnector.getConnection();
        String sql = "INSERT INTO restaurants (restaurant_name, location, phone, category_code, intro, register_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement psmt = con.prepareStatement(sql)) {
            psmt.setString(1, vo.getRestaurantName());
            psmt.setString(2, vo.getLocation());
            psmt.setString(3, vo.getPhone());
            psmt.setString(4, vo.getCategoryCode());
            psmt.setString(5, vo.getIntro());
            psmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            psmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void update(RestaurantVO vo) {
        Connection con = JDBCConnector.getConnection();
        String sql = "UPDATE restaurants SET restaurant_name=?, location=?, phone=?, category_code=?, intro=? WHERE restaurant_id=?";
        try (PreparedStatement psmt = con.prepareStatement(sql)) {
            psmt.setString(1, vo.getRestaurantName());
            psmt.setString(2, vo.getLocation());
            psmt.setString(3, vo.getPhone());
            psmt.setString(4, vo.getCategoryCode());
            psmt.setString(5, vo.getIntro());
            psmt.setInt(6, vo.getRestaurantId());
            psmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void delete(int restaurantId) {
        Connection con = JDBCConnector.getConnection();
        String sql = "DELETE FROM restaurants WHERE restaurant_id=?";
        try (PreparedStatement psmt = con.prepareStatement(sql)) {
            psmt.setInt(1, restaurantId);
            psmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
