/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

//public class Connect {
//    // Khai báo các biến tĩnh (static) lưu thông tin kết nối cơ sở dữ liệu
//
//    static String urlDB = "jdbc:sqlserver://localhost:1433;databaseName=BanhPao;encrypt=false";
//    static String usersName = "sa";
//    static String passWord = "123";
//
//// Khối static initializer để đăng ký Driver của SQL Server
//    static {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
public class Connect {

    // Các thông tin kết nối đến cơ sở dữ liệu
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=BanhPao;encrypt=false";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Tạo kết nối đến cơ sở dữ liệu
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

// Phương thức để lấy PreparedStatement từ câu SQL và danh sách tham số
public static PreparedStatement getStm(String sql, Object... args) throws SQLException {
        // Tạo kết nối đến cơ sở dữ liệu sử dụng thông tin trong biến tĩnh
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement stm;

        // Kiểm tra nếu câu SQL bắt đầu bằng "{", tạo CallableStatement, ngược lại tạo PreparedStatement
        if (sql.trim().startsWith("{")) {
            stm = conn.prepareCall(sql);
        } else {
            stm = conn.prepareStatement(sql);
        }

        // Thiết lập các tham số cho PreparedStatement dựa trên danh sách tham số được truyền vào
        for (int i = 0; i < args.length; i++) {
            stm.setObject(i + 1, args[i]);
        }

        return stm;
    }

// Phương thức để thực hiện truy vấn và trả về ResultSet
    public static ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement stm = Connect.getStm(sql, args);
        return stm.executeQuery();
    }

// Phương thức để lấy giá trị từ truy vấn đơn
    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = Connect.query(sql, args);
            if (rs.next()) {
                return rs.getObject(1); // Lấy giá trị từ cột đầu tiên
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

// Phương thức để thực hiện cập nhật cơ sở dữ liệu
    public static int update(String sql, Object... args) {
        try {
            PreparedStatement stm = Connect.getStm(sql, args);
            try {
                return stm.executeUpdate();
            } finally {
                stm.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
