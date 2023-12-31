package UI.main;

import UI.main.Main.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Loading extends javax.swing.JFrame {

    Timer t;

    public Loading() {
        initComponents();

        // Tao doi tuong timer
        t = new Timer(80, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // sau mỗi giây tăng giá trị progress lên 1 đơn vị-> nếu quá 100 bắt đầu lại từ 0
                int value = prgui.getValue() + 1;
                prgui.setValue(value);
                if (value == 20) {
                    lblStatus.setText("Đang khởi động.");
                }
                if (value == 10) {
                    lblStatus.setText("Đang khởi động..");
                }
                if (value == 15) {
                    lblStatus.setText("Đang khởi động...");
                }
                if (value == 20) {
                    lblStatus.setText("Đang khởi động.");
                }
                if (value == 23) {
                    lblStatus.setText("Đang khởi động..");
                }
                if (value == 25) {
                    lblStatus.setText("Đang khởi động...");
                }
                if (value == 27) {
                    lblStatus.setText("Đang khởi động.");
                }
                if (value == 29) {
                    lblStatus.setText("Đang khởi động..");
                }
                if (value == 31) {
                    lblStatus.setText("Đang khởi động...");
                }
                if (value == 41) {
                    lblStatus.setText("Đang khởi động.");
                }
                if (value == 45) {
                    lblStatus.setText("Đang khởi động..");
                }
                if (value == 55) {
                    lblStatus.setText("Đang khởi động...");
                }
                if (value == 56) {
                    lblStatus.setText("Đang khởi động.");
                }
                if (value == 57) {
                    lblStatus.setText("Đang khởi động..");
                }
                if (value == 60) {
                    lblStatus.setText("Đang khởi động...");
                }
                if (value == 65) {
                    lblStatus.setText("Đang khởi động.");
                }
                if (value == 67) {
                    lblStatus.setText("Đang khởi động..");
                }
                if (value == 69) {
                    lblStatus.setText("Đang khởi động...");
                }
                if (value == 71) {
                    lblStatus.setText("Đang khởi động.");
                }
                if (value == 72) {
                    lblStatus.setText("Đang khởi động..");
                }
                if (value == 75) {
                    lblStatus.setText("Đang khởi động...");
                }
                if (value == 79) {
                    lblStatus.setText("Đang khởi động.");
                }
                if (value == 81) {
                    lblStatus.setText("Đang khởi động..");
                }
                if (value == 82) {
                    lblStatus.setText("Đang khởi động...");
                }
                if (value == 84) {
                    lblStatus.setText("Đang khởi động.");
                }
                if (value == 87) {
                    lblStatus.setText("Đang khởi động..");
                }
                if (value == 89) {
                    lblStatus.setText("Đang khởi động...");
                }
                if (value == 91) {
                    lblStatus.setText("Đang khởi động.");
                }
                if (value == 93) {
                    lblStatus.setText("Đang khởi động..");
                }
                if (value == 95) {
                    lblStatus.setText("Đang khởi động...");
                }
                if (value == 99) {
                    lblStatus.setText("Thành công !");
                }
                if (value == 100) {
                    new Main().setVisible(true);
                    dispose();
                    return;
                }
            }
        });
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnimg = new javax.swing.JPanel();
        prgui = new progressbar.ProgressBarCustom();
        lblStatus = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnimg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnimg.add(prgui, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 760, 20));

        lblStatus.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setText("Đang khởi động...");
        pnimg.add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cake.gif"))); // NOI18N
        pnimg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 400));

        getContentPane().add(pnimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loading().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnimg;
    private progressbar.ProgressBarCustom prgui;
    // End of variables declaration//GEN-END:variables
}
