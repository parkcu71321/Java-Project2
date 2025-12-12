package restaurantmanagement.repository;

import java.sql.*;

public class JDBCConnector
{
    private static final String DRIVER_PATH = "oracle.jdbc.driver.OracleDriver";   // 오라클 JDBC 드라이버 경로
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";       // Oracle DB 접속 주소
    private static final String USER_NAME = "C##BOOK";                             // DB 사용자 이름
    private static final String PASSWORD = "1234";                                  // DB 사용자 비밀번호

    private static Connection con;      // DB 연결을 저장하는 변수, 연결된 DB를 사용하기 위함

    // --------------------------------------------------------------
    // DB 연결 객체 반환
    // --------------------------------------------------------------
    public static Connection getConnection()
    {
        try {
            Class.forName(DRIVER_PATH);          // 오라클 JDBC 드라이버를 JVM에 등록
            System.out.println("JDBC Driver Loaded");

            con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);    // DB 연결 시도
            System.out.println("Connection Done Successfully");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver Class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Error");
            e.printStackTrace();
        }

        return con;
    }

    // --------------------------------------------------------------
    // 테스트용 예제: Restaurants + Categories 조인 출력
    // --------------------------------------------------------------
    public static void resultSetTest()
    {
        try {
            String sql =
                    "SELECT r.restaurant_name, r.location, c.category_name " +
                            "FROM Restaurants r JOIN Categories c " +
                            "ON r.category_code = c.category_code";

            PreparedStatement pstmt = con.prepareStatement(sql);   // SQL 실행 준비
            ResultSet rs = pstmt.executeQuery();                   // SQL 실행

            while (rs.next()) {     // 결과가 있는 동안 한 줄씩 읽기
                System.out.print(rs.getString("restaurant_name") + " | ");
                System.out.print(rs.getString("location") + " | ");
                System.out.println(rs.getString("category_name"));
            }

        } catch (SQLException e) {
            System.out.println("SQL 출력 실패");
            e.printStackTrace();
        }
    }

    // --------------------------------------------------------------
    // 테스트 실행 main()
    // --------------------------------------------------------------
    public static void main(String[] args)
    {
        con = getConnection();    // DB 연결
        resultSetTest();         // SQL 테스트 실행
    }
}
