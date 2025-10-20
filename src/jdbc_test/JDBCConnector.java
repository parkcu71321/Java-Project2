package jdbc_test;

import java.sql.*;

public class JDBCConnector
{
    private static final String DRIVER_PATH = "oracle.jdbc.driver.OracleDriver";        //오라클 jdbc 드라이버의 경로
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";        //DB 연결 주소
    private static final String USER_NAME = "c##chanung";       //db 연결할 때 사용자 이름
    private static final String PASSWORD = "1234";              //db 연결할 때 비번

    private static Connection con;         //db 연결을 저장하는 변수, 이 변수에 저장된 db에 접근 가능

    public static Connection getConnection()            //연결 객체의 필드 값 반환
    {
        try {
            Class.forName(DRIVER_PATH);         //오라클용 JDBC 드라이버를 JVM(자바 엔진)에 등록, sql문을 번역해주는 코드
            System.out.println("JDBC Driver Loaded");
            con= DriverManager.getConnection(URL,USER_NAME,PASSWORD);           //통과 되면 해당 db 사용 가능
            System.out.println("Connection Done Successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Class not found");
        } catch(SQLException e){
            System.out.println("Connection Error");
        }
        return con;
    }

    public static void resultSetTest()
    {
        try {
            String sql="select id, name, publish_name, author from book,publish where book.publish_id=publish.publish_id";       //sql문 준비
            PreparedStatement pstmt = con.prepareStatement(sql);            //실행 준비
            ResultSet rs = pstmt.executeQuery();        //실행
            while(rs.next())            //next() 한 줄씩 읽고 더 이상 읽을 게 없으면 false값 반환
            {
                System.out.print(rs.getString("name")+": \t");
                System.out.println(rs.getString("publish_name"));
            }
        } catch (SQLException e) {
            System.out.println("SQL 출력 실패");
        }
    }

    public static void main(String[] args)
    {
        con=getConnection();
        resultSetTest();
    }
}
