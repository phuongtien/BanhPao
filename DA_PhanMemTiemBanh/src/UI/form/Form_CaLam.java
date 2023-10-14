/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.form;

import DAO.Connect;
import Entity.NhanVien;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Form_CaLam extends javax.swing.JPanel {

    public Form_CaLam() {
        initComponents();
        loadDataToTable();
    }

    private void loadDataToTable() {
        DefaultTableModel modelCL = (DefaultTableModel) tblDataShift.getModel();
        modelCL.setRowCount(0); // Xóa dữ liệu cũ

        try {
            Connection connection = Connect.getConnection();
            String sql = "SELECT nv.NVMa, nv.NVHoTen, cv.Thu, cv.NgayThang, cv.GioBatDau, cv.GioKetThuc "
                    + "FROM NhanVien nv "
                    + "INNER JOIN CalamViec cv ON nv.CalamViecID = cv.CalamViecID";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maNV = resultSet.getString("NVMa");
                String hoTen = resultSet.getString("NVHoTen");
                String thu = resultSet.getString("Thu");
                String ngayThang = resultSet.getString("NgayThang");
                String gioBatDau = resultSet.getString("GioBatDau");
                String gioKetThuc = resultSet.getString("GioKetThuc");

                // Thêm dữ liệu vào bảng
                modelCL.addRow(new Object[]{maNV, hoTen, thu, ngayThang, gioBatDau, gioKetThuc});
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanelDasBoard = new UI.swing.RoundPanel();
        jScrollPanéhift = new javax.swing.JScrollPane();
        tblDataShift = new UI.swing.table.Table();
        btnDoiCaLam = new UI.mess.Button();

        roundPanelDasBoard.setBackground(new java.awt.Color(255, 255, 255));
        roundPanelDasBoard.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanelDasBoard.setRound(10);

        tblDataShift.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Họ và tên", "Thứ", "Ngày tháng", "Giờ làm việc", "Giờ kết thúc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPanéhift.setViewportView(tblDataShift);

        btnDoiCaLam.setText("Danh sách đăng ký đổi ca làm");
        btnDoiCaLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiCaLamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanelDasBoardLayout = new javax.swing.GroupLayout(roundPanelDasBoard);
        roundPanelDasBoard.setLayout(roundPanelDasBoardLayout);
        roundPanelDasBoardLayout.setHorizontalGroup(
            roundPanelDasBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanelDasBoardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPanéhift, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(roundPanelDasBoardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnDoiCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanelDasBoardLayout.setVerticalGroup(
            roundPanelDasBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanelDasBoardLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnDoiCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jScrollPanéhift, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1124, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(roundPanelDasBoard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(roundPanelDasBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoiCaLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiCaLamActionPerformed
        // Tạo một JDialog để hiển thị danh sách nhân viên đổi ca
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Danh sách nhân viên đổi ca", true);

        // Đặt kích thước cố định cho form (thay đổi width và height tùy theo yêu cầu của bạn)
        int width = 1114;
        int height = 655;
        dialog.setSize(width, height);

        // Đặt vị trí của form ra giữa màn hình
        dialog.setLocationRelativeTo(null);

        // Tạo một JPanel để chứa danh sách nhân viên đổi ca
        Form_DSDoiCa employeePanel = new Form_DSDoiCa();
        // Điều này giả định rằng bạn có một phương thức hoặc giao diện để hiển thị danh sách nhân viên đổi ca trong Form_DSDoiCa

        dialog.add(employeePanel);

        // Hiển thị dialog
        dialog.setVisible(true);
    }//GEN-LAST:event_btnDoiCaLamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.mess.Button btnDoiCaLam;
    private javax.swing.JScrollPane jScrollPanéhift;
    private UI.swing.RoundPanel roundPanelDasBoard;
    private UI.swing.table.Table tblDataShift;
    // End of variables declaration//GEN-END:variables

}
