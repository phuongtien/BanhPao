/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author tienl
 */
import Entity.CaLam;
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
public class CaLamDAO extends BanhPao<CaLam, String> {
    // Các câu truy vấn SQL được lưu trong các biến dưới đây

    String insert = "INSERT INTO CalamViec (CalamViecID, Thu, NgayThang, GioBatDau, GioKetThuc) VALUES(?,?,?,?,?,?)";
    String update = "UPDATE CalamViec SET Thu = ?, NgayThang = ?, GioBatDau = ?, GioKetThuc = ?  WHERE CalamViecID = ?";
    String delete = "DELETE FROM CalamViec WHERE CalamViecID = ?";
    String selectAll = "SELECT *FROM CalamViec";
    String selectbyId = "SELECT *FROM CalamViec WHERE CalamViecID = ?";

    @Override
    public void insert(CaLam entity) {
        // Thực hiện câu truy vấn INSERT để chèn dữ liệu của đối tượng 'entity' vào bảng CHUYENDE
        Connect.update(insert, entity.getIDCaLam(),entity.getThu(),entity.getNgayThang(),entity.getGioBatDau(),entity.getGioKetthuc());
    }

    @Override
    public void update(CaLam entity) {
        // Thực hiện câu truy vấn UPDATE để cập nhật thông tin của đối tượng 'entity' trong bảng CHUYENDE
        Connect.update(update, entity.getIDCaLam(),entity.getThu(),entity.getNgayThang(),entity.getGioBatDau(),entity.getGioKetthuc());
    }

    @Override
    public void delete(String id) {
        // Thực hiện câu truy vấn DELETE để xóa đối tượng có khóa chính 'id' khỏi bảng CHUYENDE
        Connect.update(delete, id);
    }

    @Override
    public CaLam selectbyId(String id) {
        // Thực hiện câu truy vấn SELECT để lấy một đối tượng CHUCVU dựa trên khóa chính 'id'
        List<CaLam> list = this.selectbySql(selectbyId, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<CaLam> selectAll() {
        // Thực hiện câu truy vấn SELECT để lấy danh sách tất cả các đối tượng CHUYENDE từ bảng CHUYENDE
        return (List<CaLam>) this.selectbySql(selectAll);
    }

    @Override
    protected List<CaLam> selectbySql(String sql, Object... args) {
        List<CaLam> list = new ArrayList<CaLam>();
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
                CaLam cv = new CaLam();
                cv.setIDCaLam(rs.getInt("CalamViecID"));
                cv.setThu(rs.getString("Thu"));
                cv.setNgayThang(rs.getString("NgayThang"));
                cv.setGioBatDau(rs.getString("GioBatDau"));
                cv.setGioKetthuc(rs.getString("GioKetThuc"));
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