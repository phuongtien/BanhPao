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
public class Loai {
    String loaiBanh;

    public Loai() {
    }

    public Loai(String loaiBanh) {
        this.loaiBanh = loaiBanh;
    }

    public String getLoaiBanh() {
        return loaiBanh;
    }

    public void setLoaiBanh(String loaiBanh) {
        this.loaiBanh = loaiBanh;
    }

    @Override
    public String toString() {
        return  loaiBanh;
    }
    
}
