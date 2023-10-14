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
public class ThongKe {
    String maTK;
    String ngyaThongKe;
    int soHoaDonDaIn;
    float tongDoanhSo;
    float tongTienDaThanhToan;

    public ThongKe(String maTK, String ngyaThongKe, int soHoaDonDaIn, float tongDoanhSo, float tongTienDaThanhToan) {
        this.maTK = maTK;
        this.ngyaThongKe = ngyaThongKe;
        this.soHoaDonDaIn = soHoaDonDaIn;
        this.tongDoanhSo = tongDoanhSo;
        this.tongTienDaThanhToan = tongTienDaThanhToan;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getNgyaThongKe() {
        return ngyaThongKe;
    }

    public void setNgyaThongKe(String ngyaThongKe) {
        this.ngyaThongKe = ngyaThongKe;
    }

    public int getSoHoaDonDaIn() {
        return soHoaDonDaIn;
    }

    public void setSoHoaDonDaIn(int soHoaDonDaIn) {
        this.soHoaDonDaIn = soHoaDonDaIn;
    }

    public float getTongDoanhSo() {
        return tongDoanhSo;
    }

    public void setTongDoanhSo(float tongDoanhSo) {
        this.tongDoanhSo = tongDoanhSo;
    }

    public float getTongTienDaThanhToan() {
        return tongTienDaThanhToan;
    }

    public void setTongTienDaThanhToan(float tongTienDaThanhToan) {
        this.tongTienDaThanhToan = tongTienDaThanhToan;
    }

    @Override
    public String toString() {
        return "ThongKe{" + "maTK=" + maTK + ", ngyaThongKe=" + ngyaThongKe + ", soHoaDonDaIn=" + soHoaDonDaIn + ", tongDoanhSo=" + tongDoanhSo + ", tongTienDaThanhToan=" + tongTienDaThanhToan + '}';
    }
    
}
