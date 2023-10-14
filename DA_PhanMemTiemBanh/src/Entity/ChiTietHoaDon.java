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
public class ChiTietHoaDon {
    String maCTHD;
    String maBanh;
    int soLuong;
    float thanhTien;

    public ChiTietHoaDon(String maCTHD, String maBanh, int soLuong, float thanhTien) {
        this.maCTHD = maCTHD;
        this.maBanh = maBanh;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public String getMaCTHD() {
        return maCTHD;
    }

    public void setMaCTHD(String maCTHD) {
        this.maCTHD = maCTHD;
    }

    public String getMaBanh() {
        return maBanh;
    }

    public void setMaBanh(String maBanh) {
        this.maBanh = maBanh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "maCTHD=" + maCTHD + ", maBanh=" + maBanh + ", soLuong=" + soLuong + ", thanhTien=" + thanhTien + '}';
    }
    
}
