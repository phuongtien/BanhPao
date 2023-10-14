/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.HoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DAO.Connect;

public class HoaDonDAO extends BanhPao<HoaDon, String> {
    // Các câu truy vấn SQL được lưu trong các biến dưới đây

    String insert = "INSERT INTO HoaDon(MaHD,NgayXuat,NVXuat,TKTongTien,TKTienKhach,TKTienThua) VALUES(?,?,?,?,?,?)";
    String update = "UPDATE HoaDon SET NgayXuat=?, NVXuat=?, TKTongTien=?, TKTienKhach=?, TKTienThua=? WHERE MaHD=?";
    String delete = "DELETE FROM HoaDon WHERE MaHD = ?";
    String selectAll = "SELECT *FROM HoaDon";
    String selectbyId = "SELECT *FROM HoaDon WHERE MaHD = ?";

    @Override
    public void insert(HoaDon entity) {
        // Thực hiện câu truy vấn INSERT để chèn dữ liệu của đối tượng 'entity' vào bảng CHUYENDE

        Connect.update(insert, entity.getMaHD(), entity.getNgayXuat(), entity.getNVXuat(), entity.getTongTien(), entity.getTienKhach(), entity.getTienThua());
    }

    @Override
    public void update(HoaDon entity) {
        Connect.update(update, entity.getNgayXuat(), entity.getNVXuat(), entity.getTongTien(), entity.getTienKhach(), entity.getTienThua(), entity.getMaHD());
    }

    @Override
    public void delete(String id) {
        // Thực hiện câu truy vấn DELETE để xóa đối tượng có khóa chính 'id' khỏi bảng CHUYENDE
        Connect.update(delete, id);
    }

    @Override
    public HoaDon selectbyId(String id) {
        // Thực hiện câu truy vấn SELECT để lấy một đối tượng CHUYENDE dựa trên khóa chính 'id'
        List<HoaDon> list = this.selectbySql(selectbyId, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> selectAll() {
        // Thực hiện câu truy vấn SELECT để lấy danh sách tất cả các đối tượng CHUYENDE từ bảng CHUYENDE
        return this.selectbySql(selectAll);
    }

    @Override
    protected List<HoaDon> selectbySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<HoaDon>();
        try {
            // Thực hiện truy vấn SQL sử dụng câu truy vấn 'sql' và các đối số 'args'

            ResultSet rs = Connect.query(sql, args);
            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet và tạo đối tượng ChuyenDe từ kết quả truy vấn

                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNgayXuat(rs.getString("NgayXuat"));
                hd.setNVXuat(rs.getString("NVXuat"));
                hd.setTongTien(rs.getFloat("TKTongTien"));
                hd.setTienKhach(rs.getFloat("TKTienKhach"));
                hd.setTienThua(rs.getFloat("TKTienThua"));
                list.add(hd);
            }
            // Đóng kết nối và trả về danh sách các đối tượng ChuyenDe

            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra

            throw new RuntimeException(e);
        }
    }
}
