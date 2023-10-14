/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.NhanVien;
import java.util.List;
import DAO.Connect;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tienl
 */


public class NhanVienDAO extends BanhPao<NhanVien, String> {
    // Các câu truy vấn SQL được lưu trong các biến dưới đây

    String insert = "INSERT INTO NhanVien(NVMa,NVHoTen,GioiTinh,NVNgaySinh,NVSDT,ngayVaoLam,chucVu,hinh,NVTenDangNhap,NVMatKhau) VALUES(?,?,?,?,?,?,?,?,?,?)";
    String update = "UPDATE NhanVien SET NVHoTen = ? , GioiTinh = ? , NVNgaySinh = ?, NVSDT = ?,ngayVaoLam = ?, ChucVu = ?,hinh = ?, NVTenDangNhap = ?,NVMatKhau =? WHERE NVMa = ?";
    String delete = "DELETE FROM NhanVien WHERE NVMa = ?";
    String selectAll = "SELECT *FROM NhanVien";
    String selectbyId = "SELECT *FROM NhanVien WHERE NVMa = ?";

    @Override
    public void insert(NhanVien entity) {
        // Thực hiện câu truy vấn INSERT để chèn dữ liệu của đối tượng 'entity' vào bảng CHUYENDE
        Connect.update(insert, entity.getMaNV(), entity.getHoTen(), entity.isGioiTinh(), entity.getNgaySinh(), entity.getSoDienThoai(), entity.getNgayVaoLam(),entity.getChucVu(), entity.getHinh(),entity.getTaiKhoan(),entity.getMatKhau());
    }

    @Override
    public void update(NhanVien entity) {
        // Thực hiện câu truy vấn UPDATE để cập nhật thông tin của đối tượng 'entity' trong bảng CHUYENDE
        Connect.update(update, entity.getMaNV(), entity.getHoTen(), entity.isGioiTinh(), entity.getNgaySinh(), entity.getSoDienThoai(),entity.getNgayVaoLam(),entity.getChucVu(), entity.getHinh(),entity.getTaiKhoan(),entity.getMatKhau());
    }

    @Override
    public void delete(String id) {
        // Thực hiện câu truy vấn DELETE để xóa đối tượng có khóa chính 'id' khỏi bảng CHUYENDE
        Connect.update(delete, id);
    }

    @Override
    public NhanVien selectbyId(String id) {
        // Thực hiện câu truy vấn SELECT để lấy một đối tượng CHUYENDE dựa trên khóa chính 'id'
        List<NhanVien> list = this.selectbySql(selectbyId, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        // Thực hiện câu truy vấn SELECT để lấy danh sách tất cả các đối tượng CHUYENDE từ bảng CHUYENDE
        return this.selectbySql(selectAll);
    }

    @Override
    protected List<NhanVien> selectbySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            // Thực hiện truy vấn SQL sử dụng câu truy vấn 'sql' và các đối số 'args'

            ResultSet rs = Connect.query(sql, args);
            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet và tạo đối tượng ChuyenDe từ kết quả truy vấn

                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("NVMa"));
                nv.setHoTen(rs.getString("NVHoTen"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setNgaySinh(rs.getDate("NVNgaySinh"));
                nv.setSoDienThoai(rs.getString("NVSDT"));
                nv.setSoDienThoai(rs.getString("ngayVaoLam"));
                nv.setChucVu(rs.getString("ChucVu"));
                nv.setHinh(rs.getString("hinh"));
                nv.setTaiKhoan(rs.getString("NVTenDangNhap"));
                nv.setMatKhau(rs.getString("NVMatKhau"));
                list.add(nv);
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


