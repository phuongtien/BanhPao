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
public class CaLam {
    int IDCaLam;
    String thu, ngayThang;
    String gioBatDau;
    String gioKetthuc;

    public CaLam() {
    }

    public CaLam(int IDCaLam, String thu, String ngayThang, String gioBatDau, String gioKetthuc) {
        this.IDCaLam = IDCaLam;
        this.thu = thu;
        this.ngayThang = ngayThang;
        this.gioBatDau = gioBatDau;
        this.gioKetthuc = gioKetthuc;
    }

    public int getIDCaLam() {
        return IDCaLam;
    }

    public void setIDCaLam(int IDCaLam) {
        this.IDCaLam = IDCaLam;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(String ngayThang) {
        this.ngayThang = ngayThang;
    }

    public String getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(String gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public String getGioKetthuc() {
        return gioKetthuc;
    }

    public void setGioKetthuc(String gioKetthuc) {
        this.gioKetthuc = gioKetthuc;
    }

    @Override
    public String toString() {
        return "CaLam{" + "IDCaLam=" + IDCaLam + ", thu=" + thu + ", ngayThang=" + ngayThang + ", gioBatDau=" + gioBatDau + ", gioKetthuc=" + gioKetthuc + '}';
    }

    

   
}
