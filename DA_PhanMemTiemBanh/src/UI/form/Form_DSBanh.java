/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.form;

/**
 *
 * @author tienl
 */
public class Form_DSBanh extends javax.swing.JPanel {

    /**
     * Creates new form Form_DSBanh
     */
    public Form_DSBanh() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanelBill = new UI.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDataBill = new UI.swing.table.Table();
        btnFirst = new UI.mess.Button();
        btnLast = new UI.mess.Button();
        btnNext = new UI.mess.Button();
        btnPre = new UI.mess.Button();
        combobox1 = new combobox.Combobox();
        jLabel1 = new javax.swing.JLabel();

        roundPanelBill.setBackground(new java.awt.Color(255, 255, 255));
        roundPanelBill.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanelBill.setRound(10);
        roundPanelBill.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDataBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Loại bánh", "Tên bánh", "Số lượng còn lại", "Đơn vị tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDataBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataBillMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDataBill);

        roundPanelBill.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 1090, 350));

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Skip.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        roundPanelBill.add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 620, 110, 40));

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SkipNext.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        roundPanelBill.add(btnLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 620, 110, 40));

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/next.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        roundPanelBill.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 620, 110, 40));

        btnPre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });
        roundPanelBill.add(btnPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 620, 110, 40));
        roundPanelBill.add(combobox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 240, -1));

        jLabel1.setText("Loại bánh");
        roundPanelBill.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1114, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(roundPanelBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 726, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(roundPanelBill, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDataBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataBillMouseClicked

    }//GEN-LAST:event_tblDataBillMouseClicked

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed

    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed

    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed

    }//GEN-LAST:event_btnPreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.mess.Button btnFirst;
    private UI.mess.Button btnLast;
    private UI.mess.Button btnNext;
    private UI.mess.Button btnPre;
    private combobox.Combobox combobox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private UI.swing.RoundPanel roundPanelBill;
    private UI.swing.table.Table tblDataBill;
    // End of variables declaration//GEN-END:variables
}
