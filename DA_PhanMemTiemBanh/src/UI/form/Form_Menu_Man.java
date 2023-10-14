/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.form;

import DAO.BanhDAO;
import DAO.LoaiDAO;
import Entity.Banh;
import Entity.Loai;
import java.util.List;
import UI.swing.table.Table;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import Utils.MsgBox;
import Utils.XDate;
import Utils.XImage;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.awt.Image;
import java.io.File;
import UI.main.Main;
import javax.swing.SwingUtilities;
import UI.glasspanepopup.DefaultOption;
import UI.glasspanepopup.GlassPanePopup;

public class Form_Menu_Man extends javax.swing.JPanel {

    private BanhDAO Bdao = new BanhDAO();
    private LoaiDAO Ldao = new LoaiDAO();
    private List<Banh> list; // Thêm danh sách để lấy dữ liệu từ DAO
    private int row = 0;

    public Form_Menu_Man() {
        initComponents();
        doDuLieu();
        init();

    }

    public void doDuLieu() {
        list = Bdao.selectAll();
        fillTable();
    }

    private void init() {
        fillComboboxBanh();
        row = 0;
        updateStatus();
    }

    private void fillTable() {
        tblDataMan.fixTable(jScrollPane1);
        DefaultTableModel modelMan = (DefaultTableModel) tblDataMan.getModel();
        modelMan.setRowCount(0);
        try {
            for (Banh bm : list) {
                modelMan.addRow(new Object[]{
                    bm.getMaBanh(), bm.getLoaiBanh(), bm.getTenBanh(), bm.getDonViTinh(), bm.getGiaTien(), bm.getHinh()
                });
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu !");
        }
    }

    private void fillComboboxBanh() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        cboLoaiBanh.setModel(model);
        List<Loai> list = Ldao.selectAll();
        for (Loai bm : list) {
            model.addElement(bm.getLoaiBanh());
        }
    }

    private void setForm(Banh bm) {
        txtMaBanh.setText(bm.getMaBanh());
        cboLoaiBanh.setSelectedItem(bm.getLoaiBanh());
        txtTenBanh.setText(bm.getTenBanh());
        txtDonViTinh.setText(bm.getDonViTinh());
        txtGiaTien.setText(String.valueOf(bm.getGiaTien()));
    }

    private Banh getForm() {
        Banh bm = new Banh();
        bm.setMaBanh(txtMaBanh.getText());
        bm.setLoaiBanh(cboLoaiBanh.getSelectedItem().toString());
        bm.setTenBanh(txtTenBanh.getText());
        bm.setDonViTinh(txtDonViTinh.getText());
        bm.setGiaTien(Float.parseFloat(txtGiaTien.getText()));
        return bm;
    }

    private void updateStatus() {
        boolean edit = this.row >= 0;
        boolean first = this.row == 0;
        boolean last = this.row == tblDataMan.getRowCount() - 1;
        // Trạng thái form
        txtMaBanh.setEditable(!edit);
        cboLoaiBanh.setEditable(!edit);
        txtTenBanh.setEditable(!edit);
        txtDonViTinh.setEditable(!edit);
        txtGiaTien.setEditable(!edit);
        btnAdd.setEnabled(!edit);
        btnEdit.setEnabled(edit);
        btnDel.setEnabled(edit);
        // Trạng thái điều hướng
        btnFirst.setEnabled(edit && !first);
        btnPre.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
    }

    private void clear() {
        txtMaBanh.setText("");
        cboLoaiBanh.setSelectedIndex(0);
        txtTenBanh.setText("");
        txtDonViTinh.setText("");
        txtGiaTien.setText("0.0");
        this.row = -1;
        this.Img();
        this.updateStatus();
    }

    private boolean checkAll() {
        String maBanh = txtMaBanh.getText();
        String loaiBanh = cboLoaiBanh.getSelectedItem().toString();
        String tenBanh = txtTenBanh.getText();
        String donViTinh = txtDonViTinh.getText();
        String giaTien = txtGiaTien.getText();
        try {
            Float.parseFloat(giaTien);
        } catch (Exception e) {
            MsgBox.alert(this, "Tiền phải là số !");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanelDasBoard = new UI.swing.RoundPanel();
        d = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGiaTien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDataMan = new UI.swing.table.Table();
        jLabel4 = new javax.swing.JLabel();
        txtTenBanh = new javax.swing.JTextField();
        txtMaBanh = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDonViTinh = new javax.swing.JTextField();
        btnFirst = new UI.mess.Button();
        btnNew = new UI.mess.Button();
        btnAdd = new UI.mess.Button();
        btnEdit = new UI.mess.Button();
        btnDel = new UI.mess.Button();
        btnLast = new UI.mess.Button();
        btnNext = new UI.mess.Button();
        btnPre = new UI.mess.Button();
        cboLoaiBanh = new combobox.Combobox();

        roundPanelDasBoard.setBackground(new java.awt.Color(255, 255, 255));
        roundPanelDasBoard.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanelDasBoard.setRound(10);
        roundPanelDasBoard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d.setBackground(new java.awt.Color(255, 255, 255));
        d.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblHinh.setText(" ");
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout dLayout = new javax.swing.GroupLayout(d);
        d.setLayout(dLayout);
        dLayout.setHorizontalGroup(
            dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        dLayout.setVerticalGroup(
            dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        roundPanelDasBoard.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel5.setText("Giá tiền:");
        roundPanelDasBoard.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel3.setText("Tên bánh:");
        roundPanelDasBoard.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));
        roundPanelDasBoard.add(txtGiaTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 220, -1));

        tblDataMan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Loại bánh", "Tên món", "Đơn vị tính", "Giá tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDataMan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataManMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDataMan);

        roundPanelDasBoard.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 1080, 230));

        jLabel4.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel4.setText("Đơn vị tính:");
        roundPanelDasBoard.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, -1));
        roundPanelDasBoard.add(txtTenBanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 275, -1));
        roundPanelDasBoard.add(txtMaBanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 275, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel2.setText("Loại bánh:");
        roundPanelDasBoard.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel1.setText("Mã Bánh:");
        roundPanelDasBoard.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));
        roundPanelDasBoard.add(txtDonViTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 220, -1));

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Skip.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        roundPanelDasBoard.add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 600, 110, 40));

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/new.png"))); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        roundPanelDasBoard.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 600, 110, 40));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        roundPanelDasBoard.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 100, 40));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        roundPanelDasBoard.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 600, 100, 40));

        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/del.png"))); // NOI18N
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        roundPanelDasBoard.add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 600, 100, 40));

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SkipNext.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        roundPanelDasBoard.add(btnLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 600, 110, 40));

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/next.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        roundPanelDasBoard.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 600, 110, 40));

        btnPre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });
        roundPanelDasBoard.add(btnPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 600, 110, 40));
        roundPanelDasBoard.add(cboLoaiBanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 280, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanelDasBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(roundPanelDasBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDataManMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataManMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblDataMan.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblDataManMouseClicked

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        chonAnh();
    }//GEN-LAST:event_lblHinhMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String maBanh = txtMaBanh.getText().trim(); // Lấy mã sản phẩm từ JTextField và loại bỏ khoảng trắng thừa

        if (maBanh.isEmpty()) {
            // Kiểm tra xem mã sản phẩm có rỗng không
            MsgBox.alert(this, "Không được bỏ trống!");

            return;
        }

        // Kiểm tra xem mã sản phẩm đã tồn tại trong cơ sở dữ liệu chưa
        BanhDAO Bdao = new BanhDAO();
        Banh existingBanh = Bdao.selectbyId(maBanh);
        if (existingBanh != null) {
            MsgBox.alert(this, "Mã bánh bị trùng !");

            return;
        } else {
            insert();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (checkAll() == false) {
            return;
        } else {
            update();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        delete();
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        prev();
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        last();
    }//GEN-LAST:event_btnLastActionPerformed
    private void insert() {
        Banh bm = getForm();
        try {
            Bdao.insert(bm);
            MsgBox.alert(this, "Thêm thành công!");

            this.clear();
            doDuLieu();
            this.fillTable();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Thêm bánh thất bại!");;

            return;
        }
    }

    private void update() {
        Banh bm = getForm();
        try {
            Bdao.update(bm);
            this.fillTable();
            MsgBox.alert(this, "Cập nhật thành công !");
            doDuLieu();
            return;
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại !");
        }
    }

    private void delete() {

        String maBanh = (String) tblDataMan.getValueAt(row, 0);
        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa bánh này ?")) {
            try {
                Bdao.delete(maBanh);

                this.clear();
                MsgBox.alert(this, "Xóa thành công !");
                this.fillTable();
                doDuLieu();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                MsgBox.alert(this, "Xóa thất bại !");
            }
        }
    }

    private void edit() {
        String maBanh = (String) tblDataMan.getValueAt(row, 0);
        Banh bm = Bdao.selectbyId(maBanh);
        this.setForm(bm);
        this.updateStatus();
    }

    private void first() {
        this.row = 0;
        this.edit();
    }

    private void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();
        }
    }

    private void next() {
        if (this.row < tblDataMan.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    private void last() {
        this.row = tblDataMan.getRowCount() - 1;
        this.edit();
    }

    private void Img() {
        ImageIcon icon = XImage.read("default_img.png");
        lblHinh.setIcon(icon);
        lblHinh.setToolTipText("default_img.png");
    }

    private void chonAnh() {
        JFileChooser fchooser = new JFileChooser();
        if (fchooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fchooser.getSelectedFile();
            XImage.save(file);
            ImageIcon icon = XImage.read(file.getName());
            // Scale for img
            Image img = icon.getImage();
            Image imgScale = img.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaleIcon = new ImageIcon(imgScale);
            lblHinh.setIcon(scaleIcon);
            lblHinh.setToolTipText(file.getName());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.mess.Button btnAdd;
    private UI.mess.Button btnDel;
    private UI.mess.Button btnEdit;
    private UI.mess.Button btnFirst;
    private UI.mess.Button btnLast;
    private UI.mess.Button btnNew;
    private UI.mess.Button btnNext;
    private UI.mess.Button btnPre;
    private combobox.Combobox cboLoaiBanh;
    private javax.swing.JPanel d;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinh;
    private UI.swing.RoundPanel roundPanelDasBoard;
    private UI.swing.table.Table tblDataMan;
    private javax.swing.JTextField txtDonViTinh;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtMaBanh;
    private javax.swing.JTextField txtTenBanh;
    // End of variables declaration//GEN-END:variables
}
