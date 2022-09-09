/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.NhanVien_DAO;
import dao.System_DAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class frmDangNhap extends javax.swing.JFrame {


    public frmDangNhap() {
        initComponents();
        this.setTitle("ĐĂNG NHẬP");
        this.setSize(750, 470);
        this.setLocationRelativeTo(null);
        
        show_LSDN();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 40)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ĐĂNG NHẬP");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(12, 23, 723, 87);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/m.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 130, 24, 35);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/l.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 190, 24, 38);

        txtUser.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtUser.setText("Admin_sach");
        getContentPane().add(txtUser);
        txtUser.setBounds(210, 130, 367, 35);

        txtPass.setText("admin123");
        getContentPane().add(txtPass);
        txtPass.setBounds(210, 190, 367, 35);

        btnLogin.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log-in.png"))); // NOI18N
        btnLogin.setText("ĐĂNG NHẬP");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(240, 260, 250, 50);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Lần đăng nhập cuối cùng:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 380, 700, 22);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/backgound.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 750, 422);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        NhanVien_DAO dao = new NhanVien_DAO();
        if (txtUser.getText().equals("sys")){
            if (dao.check_dn(txtUser.getText().trim() + " as sysdba", txtPass.getText())){
                MainFrame home = new MainFrame(txtUser.getText().trim() + " as sysdba", txtPass.getText());
                home.setVisible(true);
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu sai", "Cảnh báo",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
            if (dao.check_dn(txtUser.getText().trim(), txtPass.getText())){
                MainFrame home = new MainFrame(txtUser.getText(), txtPass.getText());
                home.setVisible(true);
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu sai", "Cảnh báo",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed


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
            java.util.logging.Logger.getLogger(frmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    public void show_LSDN(){
        String ls = System_DAO.show_LS_DN();
        if (ls.length() > 0){
            jLabel3.setText("Lần đăng nhập cuối cùng: " + ls);
        }
    }
}
