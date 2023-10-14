/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Loai;
import java.util.List;
import DAO.Connect;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LoaiDAO extends BanhPao<Loai, String> {
    // Các câu truy vấn SQL được lưu trong các biến dưới đây

    String insert = "INSERT INTO Loai(LoaiBanh) VALUES(?)";
    String update = "UPDATE Loai SET LoaiBanh = ?";
    String delete = "DELETE FROM Loai WHERE LoaiBanh = ?";
    String selectAll = "SELECT *FROM Loai";
    String selectbyId = "SELECT *FROM Loai WHERE LoaiBanh = ?";

    @Override
    public void insert(Loai entity) {
        // Thực hiện câu truy vấn INSERT để chèn dữ liệu của đối tượng 'entity' vào bảng CHUYENDE
        Connect.update(insert, entity.getLoaiBanh());
    }

    @Override
    public void update(Loai entity) {
        // Thực hiện câu truy vấn UPDATE để cập nhật thông tin của đối tượng 'entity' trong bảng CHUYENDE
        Connect.update(update, entity.getLoaiBanh());
    }

    @Override
    public void delete(String id) {
        // Thực hiện câu truy vấn DELETE để xóa đối tượng có khóa chính 'id' khỏi bảng CHUYENDE
        Connect.update(delete, id);
    }

    @Override
    public Loai selectbyId(String id) {
        // Thực hiện câu truy vấn SELECT để lấy một đối tượng CHUYENDE dựa trên khóa chính 'id'
        List<Loai> list = (List<Loai>) this.selectbySql(selectbyId, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Loai> selectAll() {
        // Thực hiện câu truy vấn SELECT để lấy danh sách tất cả các đối tượng CHUYENDE từ bảng CHUYENDE
        return (List<Loai>) this.selectbySql(selectAll);
    }

    @Override
    protected List<Loai> selectbySql(String sql, Object... args) {
        List<Loai> list = new ArrayList<Loai>();
        try {
            // Thực hiện truy vấn SQL sử dụng câu truy vấn 'sql' và các đối số 'args'

            ResultSet rs = Connect.query(sql, args);
            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet và tạo đối tượng ChuyenDe từ kết quả truy vấn

                Loai bm = new Loai();
                bm.setLoaiBanh(rs.getString("LoaiBanh"));
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

