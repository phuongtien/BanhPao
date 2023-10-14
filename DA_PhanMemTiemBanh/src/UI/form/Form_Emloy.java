/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.form;

import DAO.ChucVuDAO;
import UI.card.ModelCard;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import DAO.NhanVienDAO;
import Entity.ChucVu;
import Entity.NhanVien;
import java.util.List;
import UI.swing.table.Table;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import Utils.MsgBox;
import Utils.XDate;
import Utils.XImage;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.awt.Image;
import java.io.File;
import java.text.SimpleDateFormat;
import UI.glasspanepopup.GlassPanePopup;

public class Form_Emloy extends javax.swing.JPanel {

    private ChucVuDAO Cdao = new ChucVuDAO();
    private NhanVienDAO Ndao = new NhanVienDAO();
    private List<NhanVien> list; // Thêm danh sách để lấy dữ liệu từ DAO
    private int row = 0;

    public Form_Emloy() {
        initComponents();
        doDuLieu();
        init();
    }

    public void doDuLieu() {
        list = Ndao.selectAll(); // Lấy danh sách từ DAO
        fillTable();
    }

    private void init() {
        this.fillComboboxChucVu();
        this.row = 0;
        this.updateStatus();
    }

    private void fillTable() {
        tblDataEm.fixTable(jScrollPaneEmloy);
        DefaultTableModel modelNV = (DefaultTableModel) tblDataEm.getModel();
        modelNV.setRowCount(0);
        try {
            for (NhanVien nv : list) {
                Object[] rows = {
                    nv.getMaNV(), nv.getHoTen(), nv.isGioiTinh(), nv.getNgaySinh(), nv.getSoDienThoai(),
                    nv.getNgayVaoLam(), nv.getChucVu(), nv.getHinh(), nv.getTaiKhoan(), nv.getMatKhau()
                };
                modelNV.addRow(rows);
            }

        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu !");
        }
    }

    private void fillComboboxChucVu() {
        DefaultComboBoxModel<String> modelChuCVu = new DefaultComboBoxModel<>();
        cboChucVu.setModel(modelChuCVu); // Đặt model mới cho JComboBox

        List<ChucVu> list = Cdao.selectAll();
        for (ChucVu bm : list) {
            // Thêm thuộc tính "loại bánh" vào ComboBox
            modelChuCVu.addElement(bm.getChucVu());
        }
    }

    private NhanVien getForm() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtMaNV.getText());
        nv.setHoTen(txtHoTen.getText());

        // Đọc giới tính từ radio buttons
        nv.setGioiTinh(rdoNam.isSelected());

        // Lấy ngày sinh từ JCalendar
        Date ngaySinhDate = new Date(jdcNgaySinh.getDate().getTime());
        nv.setNgaySinh((java.sql.Date) ngaySinhDate);

        nv.setSoDienThoai(txtSDT.getText());

        // Lấy ngày vào làm từ JCalendar
        Date ngayVaoLamDate = new Date(jdcNgayVaoLam.getDate().getTime());
        nv.setNgayVaoLam((java.sql.Date) ngayVaoLamDate);

        nv.setChucVu(cboChucVu.getSelectedItem().toString());
        nv.setTaiKhoan(txtTaiKhoan.getText());
        nv.setMatKhau(txtMatKhau.getText());

        return nv;
    }

    private void setForm(NhanVien nv) {
        txtMaNV.setText(nv.getMaNV());
        txtHoTen.setText(nv.getHoTen());

        // Chuyển đổi giới tính
        if (nv.isGioiTinh()) {
            rdoNam.setSelected(true);
            rdoNu.setSelected(false);
        } else {
            rdoNam.setSelected(false);
            rdoNu.setSelected(true);
        }

        // Chuyển đổi ngày sinh
        jdcNgaySinh.setDate(nv.getNgaySinh());

        txtSDT.setText(nv.getSoDienThoai());

        // Chuyển đổi ngày vào làm
        jdcNgayVaoLam.setDate(nv.getNgayVaoLam());

        cboChucVu.setSelectedItem(nv.getChucVu());
        txtTaiKhoan.setText(nv.getTaiKhoan());
        txtMatKhau.setText(nv.getMatKhau());
    }

    private void updateStatus() {
        boolean edit = this.row >= 0;
        boolean first = this.row == 0;
        boolean last = this.row == tblDataEm.getRowCount() - 1;

        // Trạng thái form
        txtMaNV.setEditable(!edit);
        cboChucVu.setEnabled(!edit);
        txtHoTen.setEditable(!edit);
        rdoNam.setEnabled(!edit);
        rdoNu.setEnabled(!edit);
        txtSDT.setEditable(!edit);
        jdcNgaySinh.setEnabled(!edit);
        jdcNgayVaoLam.setEnabled(!edit);
        cboChucVu.setEditable(!edit);
        txtTaiKhoan.setEditable(!edit);
        txtMatKhau.setEditable(!edit);
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
        txtMaNV.setText("");
        cboChucVu.setSelectedIndex(0);
        txtHoTen.setText("");
        txtSDT.setText("");
        txtTaiKhoan.setText("");
        txtMatKhau.setText("");
        jdcNgaySinh.setSelectableDateRange(null, null);
        jdcNgayVaoLam.setSelectableDateRange(null, null);
        rdoNam.setEnabled(false);
        rdoNu.setEnabled(false);
        this.row = -1;
        this.updateStatus();
    }

    private boolean checkAll() { //kiểm tra
        String maNV = txtMaNV.getText();
        String tenNV = txtHoTen.getText();
        String soDT = txtSDT.getText();
        String ngaySinh = jdcNgaySinh.getDateFormatString(); // Cần lấy giá trị ngày thực tế, không phải chuỗi định dạng
        String ngayVL = jdcNgayVaoLam.getDateFormatString(); // Cần lấy giá trị ngày thực tế, không phải chuỗi định dạng
        String chucVu = cboChucVu.getSelectedItem().toString(); // Lấy giá trị đã chọn từ combobox
        String taiKhoan = txtTaiKhoan.getText();
        String matKhau = txtMatKhau.getText();

        if (maNV.isEmpty() || tenNV.isEmpty() || soDT.isEmpty() || ngaySinh.isEmpty() || ngayVL.isEmpty() || taiKhoan.isEmpty() || matKhau.isEmpty()) {
            MsgBox.alert(this, "Vui lòng điền đầy đủ thông tin.");
            return false;
        }
        JDateChooser ngayVaoLamChooser = jdcNgayVaoLam;
        JDateChooser namSinhChooser = jdcNgaySinh;
        try {
            Integer.parseInt(soDT);
        } catch (NumberFormatException e) {
            MsgBox.alert(this, "Số điện thoại phải là số.");
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        roundPanel = new UI.swing.RoundPanel();
        jScrollPaneEmloy = new javax.swing.JScrollPane();
        tblDataEm = new UI.swing.table.Table();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        txtSDT = new javax.swing.JTextField();
        jdcNgayVaoLam = new com.toedter.calendar.JDateChooser();
        cboChucVu = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        btnAdd = new UI.mess.Button();
        btnEdit = new UI.mess.Button();
        btnDel = new UI.mess.Button();
        btnNew = new UI.mess.Button();
        btnLast = new UI.mess.Button();
        btnNext = new UI.mess.Button();
        btnPre = new UI.mess.Button();
        btnFirst = new UI.mess.Button();
        rdoNam = new radio_button.RadioButtonCustom();
        rdoNu = new radio_button.RadioButtonCustom();

        roundPanel.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel.setRound(10);
        roundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDataEm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Họ và tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Ngày vào làm", "Chức vụ", "Hình", "Tài khoản", "Mật khẩu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDataEm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataEmMouseClicked(evt);
            }
        });
        jScrollPaneEmloy.setViewportView(tblDataEm);

        roundPanel.add(jScrollPaneEmloy, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 361, 1090, 172));

        jLabel1.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel1.setText("Mã nhân viên");
        roundPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel2.setText("Họ tên");
        roundPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel3.setText("Giới tính");
        roundPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel4.setText("Ngày sinh");
        roundPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel5.setText("Số điện thoại");
        roundPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel6.setText("Ngày vào làm");
        roundPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel7.setText("Chức vụ");
        roundPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        roundPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 50, -1, -1));
        roundPanel.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 200, -1));
        roundPanel.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 200, -1));
        roundPanel.add(jdcNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 200, -1));
        roundPanel.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 200, -1));
        roundPanel.add(jdcNgayVaoLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 200, -1));

        roundPanel.add(cboChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 200, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel9.setText("Mật khẩu");
        roundPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, -1, -1));
        roundPanel.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 200, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel8.setText("Tài khoản");
        roundPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, -1, -1));
        roundPanel.add(txtTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 200, -1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        roundPanel.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 100, 40));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        roundPanel.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 600, 100, 40));

        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/del.png"))); // NOI18N
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        roundPanel.add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 600, 100, 40));

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/new.png"))); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        roundPanel.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 600, 110, 40));

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SkipNext.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        roundPanel.add(btnLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 600, 110, 40));

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/next.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        roundPanel.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 600, 110, 40));

        btnPre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });
        roundPanel.add(btnPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 600, 110, 40));

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Skip.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        roundPanel.add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 600, 110, 40));

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");
        roundPanel.add(rdoNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 60, -1));

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        roundPanel.add(rdoNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 70, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDataEmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataEmMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblDataEm.getSelectedRow();
            
            this.edit();
        }
    }//GEN-LAST:event_tblDataEmMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String maNV = txtMaNV.getText().trim(); // Lấy mã sản phẩm từ JTextField và loại bỏ khoảng trắng thừa

        if (maNV.isEmpty()) {
            // Kiểm tra xem mã sản phẩm có rỗng không
            MsgBox.alert(this, "Không được bỏ trống!");

            return;
        }

        // Kiểm tra xem mã sản phẩm đã tồn tại trong cơ sở dữ liệu chưa
        NhanVienDAO Ndao = new NhanVienDAO();
        NhanVien existingNV = Ndao.selectbyId(maNV);
        if (existingNV != null) {
            MsgBox.alert(this, "Mã nhân viên bị trùng !");

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

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        prev();
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        chonAnh();
    }//GEN-LAST:event_lblHinhMouseClicked

    private void insert() {
        
        NhanVien nv = getForm();
        try {
            Ndao.insert(nv);
            this.clear();
            MsgBox.alert(this, "Thêm mới thành công !");
            this.fillTable();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Thêm mới thất bại !");
            return;
        }
    }

    private void update() {
        NhanVien nv = getForm();
        try {
            Ndao.update(nv);
            this.fillTable();
            MsgBox.alert(this, "Cập nhật thành công !");
            fillTable();
            return;
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại !");
        }
    }

    private void delete() {

        String maBanh = (String) tblDataEm.getValueAt(row, 0);
        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa nhân viên này ?")) {
            try {
                Ndao.delete(maBanh);

                this.clear();
//                this.Img();
                MsgBox.alert(this, "Xóa thành công !");
                this.fillTable();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                MsgBox.alert(this, "Xóa thất bại !");
            }
        }
    }

    private void edit() {
        String maBanh = (String) tblDataEm.getValueAt(row, 0);
        NhanVien nv = Ndao.selectbyId(maBanh);
        this.setForm(nv);
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
        if (this.row < tblDataEm.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    private void last() {
        this.row = tblDataEm.getRowCount() - 1;
        this.edit();
    }

//    private void Img() {
//        ImageIcon icon = XImage.read("default_img.png");
//        lblHinh.setIcon(icon);
//        lblHinh.setToolTipText("default_img.png");
//    }
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneEmloy;
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    private com.toedter.calendar.JDateChooser jdcNgayVaoLam;
    private javax.swing.JLabel lblHinh;
    private radio_button.RadioButtonCustom rdoNam;
    private radio_button.RadioButtonCustom rdoNu;
    private UI.swing.RoundPanel roundPanel;
    private UI.swing.table.Table tblDataEm;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
