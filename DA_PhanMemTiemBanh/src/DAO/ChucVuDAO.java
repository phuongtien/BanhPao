/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.ChucVu;
import Entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tienl
 */
public class ChucVuDAO extends BanhPao<ChucVu, String> {
    // Các câu truy vấn SQL được lưu trong các biến dưới đây

    String insert = "INSERT INTO ChucVu(ChucVu) VALUES(?)";
    String update = "UPDATE ChucVu SET ChucVu = ? WHERE ChucVu = ?";
    String delete = "DELETE FROM ChucVu WHERE ChucVu = ?";
    String selectAll = "SELECT *FROM ChucVu";
    String selectbyId = "SELECT *FROM ChucVu WHERE ChucVu = ?";

    @Override
    public void insert(ChucVu entity) {
        // Thực hiện câu truy vấn INSERT để chèn dữ liệu của đối tượng 'entity' vào bảng CHUYENDE
        Connect.update(insert, entity.getChucVu());
    }

    @Override
    public void update(ChucVu entity) {
        // Thực hiện câu truy vấn UPDATE để cập nhật thông tin của đối tượng 'entity' trong bảng CHUYENDE
        Connect.update(update, entity.getChucVu());
    }

    @Override
    public void delete(String id) {
        // Thực hiện câu truy vấn DELETE để xóa đối tượng có khóa chính 'id' khỏi bảng CHUYENDE
        Connect.update(delete, id);
    }

    @Override
    public ChucVu selectbyId(String id) {
        // Thực hiện câu truy vấn SELECT để lấy một đối tượng CHUCVU dựa trên khóa chính 'id'
        List<ChucVu> list = this.selectbySql(selectbyId, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChucVu> selectAll() {
        // Thực hiện câu truy vấn SELECT để lấy danh sách tất cả các đối tượng CHUYENDE từ bảng CHUYENDE
        return (List<ChucVu>) this.selectbySql(selectAll);
    }

    @Override
    protected List<ChucVu> selectbySql(String sql, Object... args) {
        List<ChucVu> list = new ArrayList<ChucVu>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            // Tạo kết nối
            connection = Connect.getConnection();
            // Chuẩn bị câu truy vấn
            preparedStatement = connection.prepareStatement(sql);

            // Đặt các tham số cho câu truy vấn
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            // Thực hiện truy vấn SQL
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet và tạo đối tượng ChucVu từ kết quả truy vấn
                ChucVu cv = new ChucVu();
                cv.setChucVu(rs.getString("ChucVu"));
                list.add(cv);
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi để debug
            throw new RuntimeException(e);
        } finally {
            try {
                // Đóng ResultSet
                if (rs != null) {
                    rs.close();
                }
                // Đóng PreparedStatement
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                // Đóng Connection
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        return list;
    }
}
