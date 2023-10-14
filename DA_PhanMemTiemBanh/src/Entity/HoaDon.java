/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author tienl
 */
public class HoaDon {
    String maHD;
    String ngayXuat;
    String NVXuat;
    float tongTien;
    float tienKhach;
    float tienThua;

    public HoaDon() {

    }

    public HoaDon(String maHD, String ngayXuat, String NVXuat, float tongTien, float tienKhach, float tienThua) {
        this.maHD = maHD;
        this.ngayXuat = ngayXuat;
        this.NVXuat = NVXuat;
        this.tongTien = tongTien;
        this.tienKhach = tienKhach;
        this.tienThua = tienThua;
    }
    

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getNVXuat() {
        return NVXuat;
    }

    public void setNVXuat(String NVXuat) {
        this.NVXuat = NVXuat;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public float getTienKhach() {
        return tienKhach;
    }

    public void setTienKhach(float tienKhach) {
        this.tienKhach = tienKhach;
    }

    public float getTienThua() {
        return tienThua;
    }

    public void setTienThua(float tienThua) {
        this.tienThua = tienThua;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHD=" + maHD + ", ngayXuat=" + ngayXuat + ", NVXuat=" + NVXuat + ", tongTien=" + tongTien + ", tienKhach=" + tienKhach + ", tienThua=" + tienThua + '}';
    }
    
}
