/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.TaiKhoan;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DAO.Connect;




public class TaiKhoanDAO {

    // Câu truy vấn SQL được lưu trong các biến dưới đây
    private static final String SELECT_BY_USERNAME_PASSWORD = "SELECT * FROM TaiKhoan WHERE username = ? AND password = ?";

    // Sử dụng PreparedStatement để tránh SQL Injection
    public TaiKhoan selectByUsernamePassword(String username, String password) {
        // Thực hiện câu truy vấn SELECT để lấy một đối tượng TaiKhoan dựa trên username và password
        List<TaiKhoan> list = selectBySQL(SELECT_BY_USERNAME_PASSWORD, username, password);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    protected List<TaiKhoan> selectBySQL(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            // Thực hiện truy vấn SQL sử dụng câu truy vấn 'sql' và các đối số 'args'
            ResultSet rs = Connect.query(sql, args);
            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet và tạo đối tượng TaiKhoan từ kết quả truy vấn
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setUsername(rs.getString("username"));
                taiKhoan.setPassword(rs.getString("password"));
                list.add(taiKhoan);
            }
            // Đóng kết nối và trả về danh sách các đối tượng TaiKhoan
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra
            throw new RuntimeException(e);
        }
    }
}
