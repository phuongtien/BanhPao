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
public class ChucVu {
    
    String chucVu;

    public ChucVu() {
    }

    public ChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public String toString() {
        return "ChucVu{" + "chucVu=" + chucVu + '}';
    }

   
    
}
