/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Banh;
import java.util.List;
import DAO.Connect;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BanhDAO extends BanhPao<Banh, String> {
    // Các câu truy vấn SQL được lưu trong các biến dưới đây

    String insert = "INSERT INTO Banh(SPMa,SPLoai,SPTen,SPDonVi,SPGia,hinh) VALUES(?,?,?,?,?,?)";
    String update = "UPDATE Banh SET SPLoai = ? , SPTen = ? , SPDonVi = ?, SPGia = ?, hinh = ? WHERE SPMa = ?";
    String delete = "DELETE FROM Banh WHERE SPMa = ?";
    String selectAll = "SELECT *FROM Banh";
    String selectbyId = "SELECT *FROM Banh WHERE SPMa = ?";

    @Override
    public void insert(Banh entity) {
        // Thực hiện câu truy vấn INSERT để chèn dữ liệu của đối tượng 'entity' vào bảng CHUYENDE
        Connect.update(insert, entity.getMaBanh(), entity.getLoaiBanh(), entity.getTenBanh(), entity.getDonViTinh(), entity.getGiaTien(), entity.getHinh());
    }

    @Override
    public void update(Banh entity) {
        // Thực hiện câu truy vấn UPDATE để cập nhật thông tin của đối tượng 'entity' trong bảng CHUYENDE
        Connect.update(update, entity.getMaBanh(), entity.getLoaiBanh(), entity.getTenBanh(), entity.getDonViTinh(), entity.getGiaTien(), entity.getHinh());
    }

    @Override
    public void delete(String id) {
        // Thực hiện câu truy vấn DELETE để xóa đối tượng có khóa chính 'id' khỏi bảng CHUYENDE
        Connect.update(delete, id);
    }

    @Override
    public Banh selectbyId(String id) {
        // Thực hiện câu truy vấn SELECT để lấy một đối tượng CHUYENDE dựa trên khóa chính 'id'
        List<Banh> list = this.selectbySql(selectbyId, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Banh> selectAll() {
        // Thực hiện câu truy vấn SELECT để lấy danh sách tất cả các đối tượng CHUYENDE từ bảng CHUYENDE
        return this.selectbySql(selectAll);
    }

    @Override
    protected List<Banh> selectbySql(String sql, Object... args) {
        List<Banh> list = new ArrayList<Banh>();
        try {
            // Thực hiện truy vấn SQL sử dụng câu truy vấn 'sql' và các đối số 'args'

            ResultSet rs = Connect.query(sql, args);
            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet và tạo đối tượng ChuyenDe từ kết quả truy vấn

                Banh bm = new Banh();
                bm.setMaBanh(rs.getString("SPMa"));
                bm.setLoaiBanh(rs.getString("SPLoai"));
                bm.setTenBanh(rs.getString("SPTen"));
                bm.setDonViTinh(rs.getString("SPDonVi"));
                bm.setGiaTien(rs.getInt("SPGia"));
                bm.setHinh(rs.getString("hinh"));
                list.add(bm);
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

