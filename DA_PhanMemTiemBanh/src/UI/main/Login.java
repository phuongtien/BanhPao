/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.main;

import Utils.XImage;
import UI.main.Main.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import UI.form.Form_Dashboard;
import UI.main.Loading;
import UI.menu.EventMenuSelected;
import UI.mess.ThongBaoLogin;

import UI.glasspanepopup.GlassPanePopup;
import DAO.TaiKhoanDAO;
import Entity.TaiKhoan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import UI.mess.SaiMKOrTK;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        GlassPanePopup.install(this);
        this.setIconImage(XImage.getAppIcon());
    }

    boolean checkDangNhap() {
        String userName = txtUserName.getText();
        String password = txtPass.getText();

        // Kiểm tra nếu userName hoặc password là chuỗi trống
        return !userName.equals("UserName") && !password.equals("Password");
    }

    boolean Check() {
        String userName = txtUserName.getText();
        String password = txtPass.getText();

        // Tạo một đối tượng TaiKhoanDAO
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();

        // Sử dụng TaiKhoanDAO để kiểm tra tên người dùng và mật khẩu
        TaiKhoan taiKhoan = taiKhoanDAO.selectByUsernamePassword(userName, password);

        // Kiểm tra nếu tên người dùng và mật khẩu đúng
        if (taiKhoan != null && taiKhoan.getPassword().equals(password)) {
            // Đúng, cho phép đăng nhập
            return true;
        } else {
            // Sai, không cho phép đăng nhập
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        pnLogin = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblQuenPass = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnLogin = new UI.mess.Button();
        txtUserName = new textfield.TextField();
        txtPass = new textfield.PasswordField();
        pnSign = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblback = new javax.swing.JLabel();
        pnBaner = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnQuen = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnMain.setBackground(new java.awt.Color(255, 255, 255));
        pnMain.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pnMainFocusGained(evt);
            }
        });
        pnMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnLogin.setBackground(new java.awt.Color(255, 255, 255));
        pnLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText(" © Hoàng Nhân");
        pnLogin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, -1, -1));

        lblQuenPass.setText("Quên mật khẩu?");
        lblQuenPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenPassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuenPassMouseEntered(evt);
            }
        });
        pnLogin.add(lblQuenPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel1.setText("Đăng Nhập");
        pnLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 110, -1));

        btnLogin.setText("Đăng nhập");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnLogin.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 330, 50));

        txtUserName.setToolTipText("");
        pnLogin.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 320, -1));
        pnLogin.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 320, -1));

        pnMain.add(pnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 400, 500));

        pnSign.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Quên mật khẩu");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Vui lòng liên hệ với quản lý để được cấp lại mật khẩu");

        lblback.setText("Quay lại đăng nhập");
        lblback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblbackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnSignLayout = new javax.swing.GroupLayout(pnSign);
        pnSign.setLayout(pnSignLayout);
        pnSignLayout.setHorizontalGroup(
            pnSignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSignLayout.createSequentialGroup()
                .addGroup(pnSignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnSignLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnSignLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSignLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblback, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        pnSignLayout.setVerticalGroup(
            pnSignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSignLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(46, 46, 46)
                .addComponent(lblback, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );

        pnMain.add(pnSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 500));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/phan-mem-tinh-tien-bakery.png"))); // NOI18N

        javax.swing.GroupLayout pnBanerLayout = new javax.swing.GroupLayout(pnBaner);
        pnBaner.setLayout(pnBanerLayout);
        pnBanerLayout.setHorizontalGroup(
            pnBanerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBanerLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnBanerLayout.setVerticalGroup(
            pnBanerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pnMain.add(pnBaner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/phan-men-quan-ly-quan-cafe.png"))); // NOI18N
        jLabel6.setText("  ");

        javax.swing.GroupLayout pnQuenLayout = new javax.swing.GroupLayout(pnQuen);
        pnQuen.setLayout(pnQuenLayout);
        pnQuenLayout.setHorizontalGroup(
            pnQuenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuenLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnQuenLayout.setVerticalGroup(
            pnQuenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pnMain.add(pnQuen, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 0, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnMainFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnMainFocusGained
        this.requestFocusInWindow();
    }//GEN-LAST:event_pnMainFocusGained

    private void lblQuenPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenPassMouseClicked

        pnSign.setSize(400, 500);
        pnLogin.setSize(0, 500);
        pnQuen.setLocation(400, 0);
        pnQuen.setSize(400, 500);

    }//GEN-LAST:event_lblQuenPassMouseClicked

    private void lblbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbackMouseClicked

        pnQuen.setLocation(800, 0);
        pnQuen.setSize(0, 500);
        pnSign.setSize(0, 500);
        pnLogin.setSize(400, 500);
        pnBaner.setVisible(true);
        System.out.println("1");
    }//GEN-LAST:event_lblbackMouseClicked

    private void lblQuenPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenPassMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblQuenPassMouseEntered

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        boolean isValid = checkDangNhap();
        if (!isValid) {
            GlassPanePopup.showPopup(new ThongBaoLogin());
        } else if (Check()) {
            this.dispose();
            new Loading().setVisible(true);
        } else if (!Check()) {
            GlassPanePopup.showPopup(new SaiMKOrTK());
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.mess.Button btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblQuenPass;
    private javax.swing.JLabel lblback;
    private javax.swing.JPanel pnBaner;
    private javax.swing.JPanel pnLogin;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnQuen;
    private javax.swing.JPanel pnSign;
    private textfield.PasswordField txtPass;
    private textfield.TextField txtUserName;
    // End of variables declaration//GEN-END:variables

}
