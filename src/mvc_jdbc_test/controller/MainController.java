package mvc_jdbc_test.controller;

import jdbc_test.JDBCConnector;
import mvc_jdbc_test.entity.Customer;
import mvc_jdbc_test.entity.Order;
import mvc_jdbc_test.view.CustomerView;
import mvc_jdbc_test.view.InputCustomerInfoView;
import mvc_jdbc_test.view.ModifyCustomer;
import mvc_jdbc_test.view.OrdersView;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Connection con = JDBCConnector.getConnection();
//        customerListAndView(con);
//        orderListAndView(con);
        inputCustomerAndView(con);
        modifyCustomerView(con);
        deleteCustomerView(con);
    }

    public static void orderListAndView(Connection con) {
        ArrayList<Order> orderList = new ArrayList<Order>();
        String sql = "select 주문번호, 고객이름, 고객아이디, 배송지, 수량, 주문일자, 제품명  from 주문, 고객, 제품  where 주문.주문고객=고객.고객아이디 and 주문.주문제품=제품.제품번호";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Order order = null;
            while (rs.next()) {
                order = new Order();
                order.setOrderNum(rs.getString("주문번호"));
                order.setCustomerName(rs.getString("고객이름"));
                order.setCustomerId(rs.getString("고객아이디"));
                order.setShippingAddress(rs.getString("배송지"));
                order.setQuantity(rs.getInt("수량"));
                order.setShippingDate(rs.getDate("주문일자"));
                order.setProductName(rs.getString("제품명"));
                orderList.add(order);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        OrdersView.printHead();
        for (Order order : orderList) {
            OrdersView.printOrders(order);
        }

    }

    public static void customerListAndView(Connection con) {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        try {
            String sql = "select * from 고객";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Customer customer = null;

            while (rs.next()) {
                customer = new Customer();
                customer.setCustomerId(rs.getString("고객아이디"));
                customer.setCustomerName(rs.getString("고객이름"));
                customer.setAge(rs.getInt("나이"));
                customer.setLevel(rs.getString("등급"));
                customer.setJob(rs.getString("직업"));
                customer.setReward(rs.getInt("적립금"));
                customerList.add(customer);
            }

        } catch (SQLException e) {
            System.out.println("Statement or SQL Error");
        }


        CustomerView customerView = new CustomerView();
        customerView.printHead();
        for (Customer customer: customerList){
            customerView.printCustomer(customer);
            System.out.println();
        }
        customerView.printFooter();
    }


    public static void inputCustomerAndView(Connection con) {
        Scanner sc = new Scanner(System.in);
        InputCustomerInfoView inputCustomer = new InputCustomerInfoView();
        while (true){

            Customer customer = inputCustomer.inputCustomerInfo();
            CustomerView customerView = new CustomerView();
            customerView.printHead();
            customerView.printCustomer(customer);
            customerView.printFooter();


            String sql = "insert into 고객 values(?,?,?,?,?,?)";

            try {
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, customer.getCustomerId());
                pstmt.setString(2, customer.getCustomerName());
                pstmt.setInt(3, customer.getAge());
                pstmt.setString(4, customer.getLevel());
                pstmt.setString(5, customer.getJob());
                pstmt.setInt(6, customer.getReward());
                pstmt.executeUpdate();
                pstmt.close();
            } catch (SQLException e) {
                System.out.println("Statement or SQL Error");
            }
            System.out.print("프로그램 종료를 원하면 e를 입력:");

            String input = sc.nextLine();

            if(input.equals("e")){
                break;
            }
        }
        System.out.println("프로그램이 종료 되었습니다.");

    }

    public static void deleteCustomerView(Connection con) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("삭제할 고객의 ID를 입력하세요: ");
            String customerId = sc.nextLine();

            try {

                String deleteOrderSql = "DELETE FROM 주문 WHERE 고객아이디 = ?";
                PreparedStatement pstmtOrder = con.prepareStatement(deleteOrderSql);
                pstmtOrder.setString(1, customerId);
                int orderDeleted = pstmtOrder.executeUpdate();
                pstmtOrder.close();

                if (orderDeleted > 0) {
                    System.out.println("🗑 관련 주문 데이터 " + orderDeleted + "건이 삭제되었습니다.");
                }


                String deleteCustomerSql = "DELETE FROM 고객 WHERE 고객아이디 = ?";
                PreparedStatement pstmtCustomer = con.prepareStatement(deleteCustomerSql);
                pstmtCustomer.setString(1, customerId);
                int customerDeleted = pstmtCustomer.executeUpdate();
                pstmtCustomer.close();

                if (customerDeleted > 0) {
                    System.out.println("고객 정보가 삭제되었습니다");
                } else {
                    System.out.println("해당 ID의 고객이 존재하지 않습니다");
                }

            } catch (SQLException e) {
                System.out.println("SQL 실행 중 오류 발생: " + e.getMessage());
            }

            System.out.print("계속 삭제하시겠습니까? (e 입력 시 종료): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("e")) {
                break;
            }
        }
        System.out.println("삭제 기능이 종료되었습니다");
    }



    public static void modifyCustomerView(Connection con) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("수정할 고객의 ID를 입력하세요: ");
            String customerId = sc.nextLine();

            System.out.print("새 이름을 입력하세요: ");
            String name = sc.nextLine();
            System.out.print("새 나이를 입력하세요: ");
            int age = Integer.parseInt(sc.nextLine());
            System.out.print("새 등급을 입력하세요: ");
            String level = sc.nextLine();
            System.out.print("새 직업을 입력하세요: ");
            String job = sc.nextLine();
            System.out.print("새 적립금을 입력하세요: ");
            int reward = Integer.parseInt(sc.nextLine());

            String sql = "update 고객 SET 고객이름=?, 나이=?, 등급=?, 직업=?, 적립금=? WHERE 고객아이디=?";

            try {
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.setString(3, level);
                pstmt.setString(4, job);
                pstmt.setInt(5, reward);
                pstmt.setString(6, customerId);

                int result = pstmt.executeUpdate();
                pstmt.close();

                if (result > 0) {
                    System.out.println("고객 정보가 수정되었습니다");
                } else {
                    System.out.println("해당 ID의 고객이 존재하지 않습니다");
                }

            } catch (SQLException e) {
                System.out.println("SQL 실행 중 오류 발생: " + e.getMessage());
            }

            System.out.print("계속 수정하시겠습니까? (e 입력 시 종료): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("e")) {
                break;
            }
        }
        System.out.println("수정 기능이 종료되었습니다");
    }

}