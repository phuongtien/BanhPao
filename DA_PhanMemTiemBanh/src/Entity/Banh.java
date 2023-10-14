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
public class Banh {
    String maBanh;
    String loaiBanh;
    String tenBanh;
    String donViTinh;
    float giaTien;
    String hinh;

    public Banh() {
       
    }

    public Banh(String maBanh, String loaiBanh, String tenBanh, String donViTinh, float giaTien, String hinh) {
        this.maBanh = maBanh;
        this.loaiBanh = loaiBanh;
        this.tenBanh = tenBanh;
        this.donViTinh = donViTinh;
        this.giaTien = giaTien;
        this.hinh = hinh;
    }
    


    public String getMaBanh() {
        return maBanh;
    }

    public void setMaBanh(String maBanh) {
        this.maBanh = maBanh;
    }

    public String getLoaiBanh() {
        return loaiBanh;
    }

    public void setLoaiBanh(String loaiBanh) {
        this.loaiBanh = loaiBanh;
    }

    public String getTenBanh() {
        return tenBanh;
    }

    public void setTenBanh(String tenBanh) {
        this.tenBanh = tenBanh;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    @Override
    public String toString() {
        return tenBanh;
    }

    
    
}
