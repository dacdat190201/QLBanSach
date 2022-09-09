/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import connect_database.OracleProvider;
import dao.CT_HDBan_DAO;
import dao.CT_HDNhap_DAO;
import dao.HDBan_DAO;
import dao.HDNhap_DAO;
import dao.KhachHang_DAO;
import dao.NhaCungCap_DAO;
import dao.NhanVien_DAO;
import dao.Sach_DAO;
import dao.System_DAO;
import doi_tuong.KhachHang;
import doi_tuong.NhaCungCap;
import doi_tuong.NhanVien;
import doi_tuong.Sach;
import doi_tuong.TonKho;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import load_img.ImageHelper;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;

/**
 *
 * @author Admin
 */
public class MainFrame extends javax.swing.JFrame {

    CardLayout cardlayout;
    SimpleDateFormat sdf = new SimpleDateFormat("yy/MMMM/dd");
    //-------tabmenu
    DefaultTableModel dtmProcess;
    DefaultTableModel dtmInstance;
    DefaultTableModel dtmDatabase;
    DefaultTableModel dtmDatafiles;
    DefaultTableModel dtmSession;
    DefaultTableModel dtmTablespace;
    DefaultTableModel dtmUser;
    DefaultTableModel dtmPhanQuyenUser;
    DefaultTableModel dtmProfiles;
    DefaultTableModel dtmPhanQuyenNhomQuyen;
    DefaultTableModel dtmDSLSDN;
    DefaultTableModel dtmDSPolicy;
    DefaultTableModel dtmDSAudit;
    
    
    //-------pnTrangChu
    DefaultTableModel dtmTrangChu_thongtinsach;
    DefaultTableModel dtmTrangChu_thongtindonhang;
    
    //-------pnNhanVien
    DefaultTableModel dtmNhanVien;
    InputStream personalImage;
    
    //-------pnNCC
    DefaultTableModel dtmNCC;
    
    //-------pnSach
    DefaultTableModel dtmSach;
    
    //-------pnHDBan
    DefaultTableModel dtmHDBan;
    DefaultTableModel dtmCT_HDBan;
    
    //-------pnHDNhap
    DefaultTableModel dtmHDNhap;
    DefaultTableModel dtmCT_HDNhap;
    
    //-------pnKhachHang
    DefaultTableModel dtmKhachHang;
    
    public MainFrame() {
        initComponents();
        this.setTitle("CỬA HÀNG BÁN SÁCH");
        this.setExtendedState(MAXIMIZED_BOTH);
        //-------------------------TABMENU
        
        OracleProvider.connect_database("sys as dba", "123");
        
        pnKTAudit.removeAll();
        cardlayout = (CardLayout)pnGiaoDien.getLayout();
    }
    
    String user = "";
    String pass = "";
    public MainFrame(String user, String pass){
        initComponents();
        this.setTitle("CỬA HÀNG BÁN SÁCH");
        this.setExtendedState(MAXIMIZED_BOTH);
        pnKTAudit.removeAll();
        this.user = user;
        this.pass = pass;
        cardlayout = (CardLayout)pnGiaoDien.getLayout();
        //-------TABMENU
        if (this.user.equals("Admin_sach")){
            mnuLSDN.setEnabled(true);
        }else {
            mnuLSDN.setEnabled(false);
            quyen_NhanVien();
        }
        //-------pnTrangChu
        dtmTrangChu_thongtinsach = (DefaultTableModel)tblThongTinSach.getModel();
        dtmTrangChu_thongtindonhang = (DefaultTableModel)tblCTDonHang.getModel();
        dtmTrangChu_thongtindonhang.setRowCount(0);
        show_DS_Sach(user, pass);           
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        btnQuanLy = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnTrangChu = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnNCC = new javax.swing.JButton();
        btnSach = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnHDBanSach = new javax.swing.JButton();
        btnHDNhapSach = new javax.swing.JButton();
        pnGiaoDien = new javax.swing.JPanel();
        pnTrangChu = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txtThongTinTK = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblThongTinSach = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        btnMuaSach = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblCTDonHang = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        btnHuyMuaSach = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        txtTongTienHD = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        pnNhanVien = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtGioiTinhNV = new javax.swing.JTextField();
        txtSDTNV = new javax.swing.JTextField();
        txtEmailNv = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        lblAnhNhanVien = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        btnLuuNV = new javax.swing.JButton();
        btnXoaNV = new javax.swing.JButton();
        btnSuaNV = new javax.swing.JButton();
        btnThemNV = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblDSNhanVien = new javax.swing.JTable();
        pnNCC = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblDSNCC = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txtMaNCC = new javax.swing.JTextField();
        txtLienHeNCC = new javax.swing.JTextField();
        txtDiaChiNCC = new javax.swing.JTextField();
        txtTenNCC = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        btnThemNCC = new javax.swing.JButton();
        btnLuuNCC = new javax.swing.JButton();
        btnSuaNCC = new javax.swing.JButton();
        btnXoaNCC = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        pnSach = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblDSSach = new javax.swing.JTable();
        jPanel28 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtMaS = new javax.swing.JTextField();
        txtTenS = new javax.swing.JTextField();
        txtTacGia = new javax.swing.JTextField();
        txtNamXB = new javax.swing.JTextField();
        txtGiamGia = new javax.swing.JTextField();
        txtTonKho = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtNhaXuatBan = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        cboTheLoaiSach = new javax.swing.JComboBox<>();
        jPanel29 = new javax.swing.JPanel();
        btnXoaSach = new javax.swing.JButton();
        btnLuuSach = new javax.swing.JButton();
        btnSuaSach = new javax.swing.JButton();
        btnThemSach = new javax.swing.JButton();
        pnKhachHang = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtNgaySinhKH = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        jPanel41 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        btnXoaKH = new javax.swing.JButton();
        btnLuuKH = new javax.swing.JButton();
        btnSuaKH = new javax.swing.JButton();
        btnThemKH = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tblDSKhachHang = new javax.swing.JTable();
        pnHDBan = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblDSDonBan = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        btnTK_HDBan = new javax.swing.JButton();
        btnLM_HDBan = new javax.swing.JButton();
        radTK_HDBan_Ngay = new javax.swing.JRadioButton();
        radTK_HDBan_maKH = new javax.swing.JRadioButton();
        txt_tk_makh = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tblCTDonBan = new javax.swing.JTable();
        jLabel54 = new javax.swing.JLabel();
        btnBanSach = new javax.swing.JButton();
        pnHDNhap = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblDSDonNhap = new javax.swing.JTable();
        jPanel35 = new javax.swing.JPanel();
        btnTK_HDNhap = new javax.swing.JButton();
        btnLM_HDNhap = new javax.swing.JButton();
        radTK_HDNhap_Ngay = new javax.swing.JRadioButton();
        radTK_HDNhap_MaNV = new javax.swing.JRadioButton();
        txt_tk_manv = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tblCT_DonNhap = new javax.swing.JTable();
        jLabel55 = new javax.swing.JLabel();
        pnTabMenu = new javax.swing.JPanel();
        pnKTAudit = new javax.swing.JTabbedPane();
        pnProcess = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        tbl_instance = new javax.swing.JTable();
        jPanel44 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_process = new javax.swing.JTable();
        pnDatabase = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDATABASE = new javax.swing.JTable();
        jPanel46 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane23 = new javax.swing.JScrollPane();
        tblDatafile = new javax.swing.JTable();
        pnSession = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtSID = new javax.swing.JTextField();
        txtSerial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUserSession = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnHuySession = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSesssion1 = new javax.swing.JTable();
        pnTaoTablespace = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtTablespace_name = new javax.swing.JTextField();
        btnTaoTablespace = new javax.swing.JButton();
        btnXoaTBLSpace = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblDSTablespace = new javax.swing.JTable();
        pnPhanQuyenUser = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        txtUserPhanQuyen = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnGanQuyenUser = new javax.swing.JButton();
        btnThuHoiQuyenUser = new javax.swing.JButton();
        jScrollPane22 = new javax.swing.JScrollPane();
        lst_QuyenUser = new javax.swing.JList<>();
        jPanel49 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDSQuyenUser = new javax.swing.JTable();
        pnTaoProfile = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtProfileName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSoLanThayDoiPW = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtTGSuDung = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        txtSoLanDNSai = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTGKhoaTK = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnTaoMoiProfile = new javax.swing.JButton();
        btnXoaProfile = new javax.swing.JButton();
        jPanel50 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblDSProfile = new javax.swing.JTable();
        pnTaoUser = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnTaoUser = new javax.swing.JButton();
        btnXoaUser = new javax.swing.JButton();
        btnSuaUser = new javax.swing.JButton();
        jPanel42 = new javax.swing.JPanel();
        cboTrangThaiUser = new javax.swing.JComboBox<>();
        cboTablespace = new javax.swing.JComboBox<>();
        cboProfile = new javax.swing.JComboBox<>();
        jPanel51 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        pnTaoNhomQuyen = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        txtTaoNhomQuyen = new javax.swing.JButton();
        txtXoaNhomQuyen = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtTenNhomQuyen = new javax.swing.JTextField();
        txtGanQuyenNhomQuyen = new javax.swing.JButton();
        jScrollPane24 = new javax.swing.JScrollPane();
        lst_DSPhanQuyenNhomQuyen = new javax.swing.JList<>();
        jPanel52 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblDSQuyen = new javax.swing.JTable();
        pnLS_DangNhap = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        tblDSLSDN = new javax.swing.JTable();
        jPanel34 = new javax.swing.JPanel();
        pnTaoPolicy = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblDSPolicy = new javax.swing.JTable();
        jPanel55 = new javax.swing.JPanel();
        btnTaoPolicy = new javax.swing.JButton();
        btnXoaPolicy = new javax.swing.JButton();
        jPanel54 = new javax.swing.JPanel();
        jScrollPane26 = new javax.swing.JScrollPane();
        tblAuditTrail = new javax.swing.JTable();
        jPanel56 = new javax.swing.JPanel();
        btnAuditngay = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        mnuHeThong = new javax.swing.JMenu();
        mnuDX = new javax.swing.JMenuItem();
        mnuThoat = new javax.swing.JMenuItem();
        mnuLSDN = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        mnuProcess = new javax.swing.JMenuItem();
        mnuDatabase = new javax.swing.JMenuItem();
        mnuSession = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuTaoTablespace = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mnuPhanQuyenUser = new javax.swing.JMenuItem();
        mnuTaoNhomQuye = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnuPolicy = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        mnuSaoLuu = new javax.swing.JMenuItem();
        mnuExport = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btnQuanLy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/man-in-suit-and-tie.png"))); // NOI18N
        btnQuanLy.setText("QUẢN LÝ");
        btnQuanLy.setFocusable(false);
        btnQuanLy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQuanLy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQuanLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyActionPerformed(evt);
            }
        });
        jToolBar1.add(btnQuanLy);
        jToolBar1.add(jSeparator1);

        btnTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/homepage.png"))); // NOI18N
        btnTrangChu.setText("TRANG CHỦ");
        btnTrangChu.setFocusable(false);
        btnTrangChu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTrangChu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });
        jToolBar1.add(btnTrangChu);

        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/staff.png"))); // NOI18N
        btnNhanVien.setText("NHÂN VIÊN");
        btnNhanVien.setFocusable(false);
        btnNhanVien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNhanVien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNhanVien);
        jToolBar1.add(jSeparator3);

        btnNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/employee.png"))); // NOI18N
        btnNCC.setText("NHÀ CUNG CẤP");
        btnNCC.setFocusable(false);
        btnNCC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNCC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNCCActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNCC);

        btnSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/book (1).png"))); // NOI18N
        btnSach.setText("SÁCH");
        btnSach.setFocusable(false);
        btnSach.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSach.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSachActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSach);

        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rating.png"))); // NOI18N
        btnKhachHang.setText("KHÁCH HÀNG");
        btnKhachHang.setFocusable(false);
        btnKhachHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhachHang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKhachHang);
        jToolBar1.add(jSeparator2);

        btnHDBanSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bill (1).png"))); // NOI18N
        btnHDBanSach.setText("HÓA ĐƠN BÁN SÁCH");
        btnHDBanSach.setFocusable(false);
        btnHDBanSach.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHDBanSach.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHDBanSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHDBanSachActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHDBanSach);

        btnHDNhapSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bill (2).png"))); // NOI18N
        btnHDNhapSach.setText("HÓA ĐƠN NHẬP SÁCH");
        btnHDNhapSach.setFocusable(false);
        btnHDNhapSach.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHDNhapSach.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHDNhapSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHDNhapSachActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHDNhapSach);

        pnGiaoDien.setLayout(new java.awt.CardLayout());

        pnTrangChu.setBackground(new java.awt.Color(204, 255, 204));

        jLabel29.setBackground(new java.awt.Color(204, 255, 204));
        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("TRANG CHỦ");

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tìm kiếm sách", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel30.setText("Nhập thông tin tìm kiếm:");

        txtThongTinTK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnTimKiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/magnifier.png"))); // NOI18N
        btnTimKiem.setText("TÌM KIẾM");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(363, 363, 363)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(txtThongTinTK, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(617, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThongTinTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(204, 255, 204));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin sách", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        tblThongTinSach.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblThongTinSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Tác giả", "Nhà xuất bản", "Năm xuất bản", "Tên loại", "Giảm giá", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(tblThongTinSach);

        jPanel16.setBackground(new java.awt.Color(204, 255, 204));

        btnMuaSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnMuaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/shopping-cart.png"))); // NOI18N
        btnMuaSach.setText("MUA");
        btnMuaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuaSachActionPerformed(evt);
            }
        });

        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reload.png"))); // NOI18N
        btnLamMoi.setText("LÀM MỚI");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMuaSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnMuaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel15.setBackground(new java.awt.Color(204, 255, 204));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Chi tiết đơn hàng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        tblCTDonHang.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblCTDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Số lượng", "Giá bán", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(tblCTDonHang);

        jPanel17.setBackground(new java.awt.Color(204, 255, 204));

        btnHuyMuaSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnHuyMuaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/garbage.png"))); // NOI18N
        btnHuyMuaSach.setText("XÓA KHỎI HÓA ĐƠN");
        btnHuyMuaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyMuaSachActionPerformed(evt);
            }
        });

        btnThanhToan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallet.png"))); // NOI18N
        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHuyMuaSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnHuyMuaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        txtTongTienHD.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel33.setText("Tổng tiền hóa đơn:");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(txtTongTienHD, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane12))
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTienHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnTrangChuLayout = new javax.swing.GroupLayout(pnTrangChu);
        pnTrangChu.setLayout(pnTrangChuLayout);
        pnTrangChuLayout.setHorizontalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnTrangChuLayout.setVerticalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pnGiaoDien.add(pnTrangChu, "pnTrangChu");

        pnNhanVien.setBackground(new java.awt.Color(204, 255, 204));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("NHÂN VIÊN");

        jPanel18.setBackground(new java.awt.Color(204, 255, 204));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel32.setText("Tên nhân viên:");

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel34.setText("Mã nhân viên:");

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel35.setText("Ngày sinh:");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel36.setText("Giới tính:");

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel37.setText("Số điện thoại:");

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel38.setText("Email:");

        txtMaNV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTenNV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtNgaySinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtGioiTinhNV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtSDTNV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtEmailNv.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(454, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmailNv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtGioiTinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailNv, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGioiTinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );

        jPanel19.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        jPanel20.setBackground(new java.awt.Color(204, 204, 0));

        lblAnhNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhNhanVienMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnhNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnhNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );

        jPanel21.setBackground(new java.awt.Color(204, 255, 204));

        btnLuuNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save-file.png"))); // NOI18N
        btnLuuNV.setText("LƯU");
        btnLuuNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuNVActionPerformed(evt);
            }
        });

        btnXoaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/garbage.png"))); // NOI18N
        btnXoaNV.setText("XÓA");
        btnXoaNV.setToolTipText("");
        btnXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNVActionPerformed(evt);
            }
        });

        btnSuaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/renewable-energy.png"))); // NOI18N
        btnSuaNV.setText("SỬA");
        btnSuaNV.setToolTipText("");
        btnSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNVActionPerformed(evt);
            }
        });

        btnThemNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-friend.png"))); // NOI18N
        btnThemNV.setText("THÊM");
        btnThemNV.setToolTipText("");
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(btnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLuuNV, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuuNV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(204, 255, 204));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách nhân viên", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        tblDSNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblDSNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Giới tính", "Email", "Số điện thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNhanVienMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tblDSNhanVien);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnNhanVienLayout = new javax.swing.GroupLayout(pnNhanVien);
        pnNhanVien.setLayout(pnNhanVienLayout);
        pnNhanVienLayout.setHorizontalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnNhanVienLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNhanVienLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(504, 504, 504))
        );
        pnNhanVienLayout.setVerticalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnNhanVienLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNhanVienLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)))
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pnGiaoDien.add(pnNhanVien, "pnNhanVien");

        pnNCC.setBackground(new java.awt.Color(204, 255, 204));

        jLabel39.setBackground(new java.awt.Color(204, 204, 204));
        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("NHÀ CUNG CẤP");

        jPanel23.setBackground(new java.awt.Color(204, 255, 204));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách nhà cung cấp", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        tblDSNCC.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblDSNCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNCCMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tblDSNCC);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel24.setBackground(new java.awt.Color(204, 255, 204));
        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin chi tiết", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel40.setText("Mã nhà cung cấp:");

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel41.setText("Tên nhà cung cấp:");

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel42.setText("Liên hệ:");

        jLabel44.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel44.setText("Địa chỉ:");

        txtMaNCC.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtLienHeNCC.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtDiaChiNCC.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTenNCC.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jPanel25.setBackground(new java.awt.Color(204, 255, 204));

        btnThemNCC.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnThemNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-friend.png"))); // NOI18N
        btnThemNCC.setText("THÊM");
        btnThemNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNCCActionPerformed(evt);
            }
        });

        btnLuuNCC.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnLuuNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save-file.png"))); // NOI18N
        btnLuuNCC.setText("LƯU");
        btnLuuNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuNCCActionPerformed(evt);
            }
        });

        btnSuaNCC.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnSuaNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/renewable-energy.png"))); // NOI18N
        btnSuaNCC.setText("SỬA");
        btnSuaNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNCCActionPerformed(evt);
            }
        });

        btnXoaNCC.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnXoaNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/garbage.png"))); // NOI18N
        btnXoaNCC.setText("XÓA");
        btnXoaNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNCCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSuaNCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLuuNCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addComponent(btnThemNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLuuNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLienHeNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDiaChiNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtLienHeNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChiNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnNCCLayout = new javax.swing.GroupLayout(pnNCC);
        pnNCC.setLayout(pnNCCLayout);
        pnNCCLayout.setHorizontalGroup(
            pnNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNCCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnNCCLayout.setVerticalGroup(
            pnNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNCCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pnGiaoDien.add(pnNCC, "pnNCC");

        pnSach.setBackground(new java.awt.Color(204, 255, 204));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("SÁCH");

        jPanel27.setBackground(new java.awt.Color(204, 255, 204));
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách Sách", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        tblDSSach.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblDSSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Tác giả", "Nhà xuất bản", "Năm xuất bản", "Giảm giá", "Giá bán", "Tên loại", "Số lượng tồn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSSachMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tblDSSach);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel28.setBackground(new java.awt.Color(204, 255, 204));
        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin sách", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jLabel46.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel46.setText("Mã sách:");

        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel47.setText("Tên sách:");

        jLabel48.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel48.setText("Tác giả");

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel49.setText("Năm xuất bản");

        jLabel50.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel50.setText("Giảm giá:");

        jLabel51.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel51.setText("Giá bán:");

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel52.setText("Thể loại:");

        jLabel53.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel53.setText("Tồn kho:");

        txtMaS.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTenS.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTacGia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtNamXB.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtGiamGia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTonKho.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtGiaBan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtNhaXuatBan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel58.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel58.setText("Nhà xuất bản:");

        cboTheLoaiSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(377, 377, 377)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txtNhaXuatBan))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamXB, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenS, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaS, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamXB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel29.setBackground(new java.awt.Color(204, 255, 204));

        btnXoaSach.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnXoaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/garbage.png"))); // NOI18N
        btnXoaSach.setText("XÓA");
        btnXoaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSachActionPerformed(evt);
            }
        });

        btnLuuSach.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnLuuSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save-file.png"))); // NOI18N
        btnLuuSach.setText("LƯU");
        btnLuuSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuSachActionPerformed(evt);
            }
        });

        btnSuaSach.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnSuaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/renewable-energy.png"))); // NOI18N
        btnSuaSach.setText("SỬA");
        btnSuaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSachActionPerformed(evt);
            }
        });

        btnThemSach.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnThemSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnThemSach.setText("THÊM");
        btnThemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(417, 417, 417)
                .addComponent(btnThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLuuSach, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuuSach, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnSachLayout = new javax.swing.GroupLayout(pnSach);
        pnSach.setLayout(pnSachLayout);
        pnSachLayout.setHorizontalGroup(
            pnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 1866, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnSachLayout.setVerticalGroup(
            pnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pnGiaoDien.add(pnSach, "pnSach");

        pnKhachHang.setBackground(new java.awt.Color(204, 255, 204));

        jPanel38.setBackground(new java.awt.Color(204, 255, 204));
        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin chi tiết", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel28.setText("Mã khách hàng:");

        jLabel56.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel56.setText("Tên khách hàng:");

        jLabel57.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel57.setText("Số điện thoại:");

        jLabel59.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel59.setText("Địa chỉ:");

        jLabel60.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel60.setText("Ngày sinh");

        txtMaKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtSDT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtNgaySinhKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtDiaChi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTenKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jPanel41.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi)
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNgaySinhKH, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(387, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinhKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel61.setBackground(new java.awt.Color(204, 204, 255));
        jLabel61.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("KHÁCH HÀNG");

        jPanel39.setBackground(new java.awt.Color(204, 255, 204));

        btnXoaKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnXoaKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/garbage.png"))); // NOI18N
        btnXoaKH.setText("XÓA");
        btnXoaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKHActionPerformed(evt);
            }
        });

        btnLuuKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnLuuKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save-file.png"))); // NOI18N
        btnLuuKH.setText("LƯU");
        btnLuuKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuKHActionPerformed(evt);
            }
        });

        btnSuaKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnSuaKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/renewable-energy.png"))); // NOI18N
        btnSuaKH.setText("SỬA");
        btnSuaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKHActionPerformed(evt);
            }
        });

        btnThemKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnThemKH.setText("THÊM");
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLuuKH, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLuuKH, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSuaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel40.setBackground(new java.awt.Color(204, 255, 204));
        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách khách hàng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        tblDSKhachHang.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblDSKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Họ tên", "Địa chỉ", "Số điện thoại", "Ngày sinh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSKhachHangMouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(tblDSKhachHang);

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane20)
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnKhachHangLayout = new javax.swing.GroupLayout(pnKhachHang);
        pnKhachHang.setLayout(pnKhachHangLayout);
        pnKhachHangLayout.setHorizontalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKhachHangLayout.createSequentialGroup()
                        .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnKhachHangLayout.createSequentialGroup()
                        .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, 1819, Short.MAX_VALUE)
                        .addGap(59, 59, 59))
                    .addComponent(jPanel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnKhachHangLayout.setVerticalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pnGiaoDien.add(pnKhachHang, "pnKhachHang");

        pnHDBan.setBackground(new java.awt.Color(204, 255, 204));

        jPanel30.setBackground(new java.awt.Color(204, 255, 204));
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách đơn bán", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        tblDSDonBan.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblDSDonBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu", "Mã nhân viên", "Mã khách hàng", "Ngày lập hóa đơn", "Tổng số lượng", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSDonBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSDonBanMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(tblDSDonBan);

        jPanel31.setBackground(new java.awt.Color(204, 255, 204));
        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tìm kiếm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        btnTK_HDBan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnTK_HDBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/magnifier.png"))); // NOI18N
        btnTK_HDBan.setText("TÌM KIẾM");
        btnTK_HDBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTK_HDBanActionPerformed(evt);
            }
        });

        btnLM_HDBan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnLM_HDBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reload.png"))); // NOI18N
        btnLM_HDBan.setText("LÀM MỚI");
        btnLM_HDBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLM_HDBanActionPerformed(evt);
            }
        });

        buttonGroup1.add(radTK_HDBan_Ngay);
        radTK_HDBan_Ngay.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        radTK_HDBan_Ngay.setText("Theo ngày");
        radTK_HDBan_Ngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radTK_HDBan_NgayActionPerformed(evt);
            }
        });

        buttonGroup1.add(radTK_HDBan_maKH);
        radTK_HDBan_maKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        radTK_HDBan_maKH.setText("Theo mã khách hàng");
        radTK_HDBan_maKH.setToolTipText("");
        radTK_HDBan_maKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radTK_HDBan_maKHActionPerformed(evt);
            }
        });

        txt_tk_makh.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnLM_HDBan, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radTK_HDBan_maKH)
                                    .addComponent(radTK_HDBan_Ngay))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTK_HDBan, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(txt_tk_makh, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(radTK_HDBan_Ngay)
                .addGap(18, 18, 18)
                .addComponent(radTK_HDBan_maKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tk_makh, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnTK_HDBan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLM_HDBan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 1479, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel32.setBackground(new java.awt.Color(204, 255, 204));
        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Chi tiết đơn hàng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        tblCTDonBan.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblCTDonBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu", "Mã sách", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane17.setViewportView(tblCTDonBan);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17)
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel54.setBackground(new java.awt.Color(153, 255, 204));
        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("HÓA ĐƠN BÁN SÁCH");

        btnBanSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnBanSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dollar-sign.png"))); // NOI18N
        btnBanSach.setText("BÁN SÁCH");
        btnBanSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnHDBanLayout = new javax.swing.GroupLayout(pnHDBan);
        pnHDBan.setLayout(pnHDBanLayout);
        pnHDBanLayout.setHorizontalGroup(
            pnHDBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHDBanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnHDBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1866, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHDBanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBanSach, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(792, 792, 792))
        );
        pnHDBanLayout.setVerticalGroup(
            pnHDBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHDBanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBanSach, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnGiaoDien.add(pnHDBan, "pnHDBan");

        pnHDNhap.setBackground(new java.awt.Color(204, 255, 204));

        jPanel33.setBackground(new java.awt.Color(204, 255, 204));
        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách đơn nhập", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        tblDSDonNhap.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblDSDonNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu nhập", "Mã nhà cung cấp", "Mã nhân viên", "Ngày lập đơn", "Tổng số lượng", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSDonNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSDonNhapMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(tblDSDonNhap);

        jPanel35.setBackground(new java.awt.Color(204, 255, 204));
        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tìm kiếm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        btnTK_HDNhap.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnTK_HDNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/magnifier.png"))); // NOI18N
        btnTK_HDNhap.setText("TÌM KIẾM");
        btnTK_HDNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTK_HDNhapActionPerformed(evt);
            }
        });

        btnLM_HDNhap.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnLM_HDNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reload.png"))); // NOI18N
        btnLM_HDNhap.setText("LÀM MỚI");
        btnLM_HDNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLM_HDNhapActionPerformed(evt);
            }
        });

        buttonGroup1.add(radTK_HDNhap_Ngay);
        radTK_HDNhap_Ngay.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        radTK_HDNhap_Ngay.setText("Theo ngày");
        radTK_HDNhap_Ngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radTK_HDNhap_NgayActionPerformed(evt);
            }
        });

        buttonGroup1.add(radTK_HDNhap_MaNV);
        radTK_HDNhap_MaNV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        radTK_HDNhap_MaNV.setText("Theo mã nhân viên");
        radTK_HDNhap_MaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radTK_HDNhap_MaNVActionPerformed(evt);
            }
        });

        txt_tk_manv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTK_HDNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLM_HDNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radTK_HDNhap_MaNV)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(txt_tk_manv, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(radTK_HDNhap_Ngay))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(radTK_HDNhap_Ngay)
                .addGap(18, 18, 18)
                .addComponent(radTK_HDNhap_MaNV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tk_manv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnTK_HDNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLM_HDNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 1479, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel36.setBackground(new java.awt.Color(204, 255, 204));
        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Chi tiết đơn hàng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        tblCT_DonNhap.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblCT_DonNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu nhập", "Mã sách", "Số lượng", "Đơn giá nhập", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane19.setViewportView(tblCT_DonNhap);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19)
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel55.setBackground(new java.awt.Color(255, 255, 153));
        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("HÓA ĐƠN NHẬP SÁCH");

        javax.swing.GroupLayout pnHDNhapLayout = new javax.swing.GroupLayout(pnHDNhap);
        pnHDNhap.setLayout(pnHDNhapLayout);
        pnHDNhapLayout.setHorizontalGroup(
            pnHDNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHDNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnHDNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1866, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnHDNhapLayout.setVerticalGroup(
            pnHDNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHDNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnGiaoDien.add(pnHDNhap, "pnHDNhap");

        pnTabMenu.setBackground(new java.awt.Color(204, 255, 204));

        pnProcess.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN CÁC PROCESS - INSTANCE");

        jPanel43.setBackground(new java.awt.Color(204, 255, 204));
        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin Instance", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        tbl_instance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "INSTANCE_NUMBER", "INSTANCE_NAME", "HOST_NAME", "VERSION", "STARTUP_TIME", "STATUS", "PARALLEL", "THREAD#", "ARCHIVER", "LOGINS", "DATABASE_STATUS", "INSTANCE_ROLE", "INSTANCE_MODE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane21.setViewportView(tbl_instance);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane21)
                .addContainerGap())
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel44.setBackground(new java.awt.Color(204, 255, 204));
        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin Process", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        tbl_process.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PID", "SOSID", "EXECUTION_TYPE", "PNAME", "USERNAME", "SERIAL#", "TERMINAL", "PROGRAM", "TRACEID", "BACKGROUND"
            }
        ));
        jScrollPane1.setViewportView(tbl_process);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnProcessLayout = new javax.swing.GroupLayout(pnProcess);
        pnProcess.setLayout(pnProcessLayout);
        pnProcessLayout.setHorizontalGroup(
            pnProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnProcessLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1849, Short.MAX_VALUE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnProcessLayout.setVerticalGroup(
            pnProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProcessLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnKTAudit.addTab("tab1", pnProcess);

        pnDatabase.setBackground(new java.awt.Color(204, 255, 204));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("THÔNG TIN DATABASE - DATAFILES");

        jPanel45.setBackground(new java.awt.Color(204, 255, 204));
        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin Database", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        tblDATABASE.setAutoCreateRowSorter(true);
        tblDATABASE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Create", "Resetlogs_time", "Prior_resetlogs_time", "Log_mode", "Controlfile_type", "Controlfile_create", "Controlfile_time", "Open_resetlogs", "Version_time", "Open_mode", "Protection_mode"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDATABASE);

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel46.setBackground(new java.awt.Color(204, 255, 204));
        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin Datafiles", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jScrollPane23.setBackground(new java.awt.Color(204, 255, 204));

        tblDatafile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NAME", "FILE#", "CREATION_CHANGE#", "CREATION_TIME", "TS#", "RFILE#", "STATUS", "ENABLED", "CHECKPOINT_CHANGE#", "CHECKPOINT_TIME", "ONLINE_TIME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane23.setViewportView(tblDatafile);
        if (tblDatafile.getColumnModel().getColumnCount() > 0) {
            tblDatafile.getColumnModel().getColumn(0).setMinWidth(300);
            tblDatafile.getColumnModel().getColumn(1).setMinWidth(100);
            tblDatafile.getColumnModel().getColumn(1).setMaxWidth(100);
            tblDatafile.getColumnModel().getColumn(4).setMinWidth(100);
            tblDatafile.getColumnModel().getColumn(4).setMaxWidth(100);
            tblDatafile.getColumnModel().getColumn(5).setMinWidth(100);
            tblDatafile.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jScrollPane5.setViewportView(jScrollPane23);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnDatabaseLayout = new javax.swing.GroupLayout(pnDatabase);
        pnDatabase.setLayout(pnDatabaseLayout);
        pnDatabaseLayout.setHorizontalGroup(
            pnDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatabaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1849, Short.MAX_VALUE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnDatabaseLayout.setVerticalGroup(
            pnDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatabaseLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnKTAudit.addTab("tab3", pnDatabase);

        pnSession.setBackground(new java.awt.Color(204, 255, 204));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("THÔNG TIN CÁC SESSION");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Hủy bỏ Session", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("SID:");

        txtSID.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtSerial.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Serial:");

        txtUserSession.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("User:");

        btnHuySession.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnHuySession.setText("HỦY SESSION");
        btnHuySession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuySessionActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton4.setText("THOÁT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtUserSession, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSID, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(222, 222, 222)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHuySession, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(714, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSerial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtUserSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHuySession, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel47.setBackground(new java.awt.Color(204, 255, 204));
        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin Session", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        tblSesssion1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "SID", "USER#", "USERNAME", "STATUS", "SERVER", "OSUSER", "PROCESS", "MACHINE", "PORT", "PROGRAM", "TYPE", "LOGON_TIME", "RESOURCE_CONSUMER _GROUP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSesssion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSesssion1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblSesssion1);

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnSessionLayout = new javax.swing.GroupLayout(pnSession);
        pnSession.setLayout(pnSessionLayout);
        pnSessionLayout.setHorizontalGroup(
            pnSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSessionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnSessionLayout.setVerticalGroup(
            pnSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSessionLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );

        pnKTAudit.addTab("tab5", pnSession);

        pnTaoTablespace.setBackground(new java.awt.Color(204, 255, 204));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("THÔNG TIN TABLESPACE");

        jPanel8.setBackground(new java.awt.Color(204, 255, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin Tablespace", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        jPanel9.setBackground(new java.awt.Color(204, 255, 204));
        jPanel9.setPreferredSize(new java.awt.Dimension(500, 103));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel9);

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel13.setText("Tablespace_Name:");

        txtTablespace_name.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnTaoTablespace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/xn.png"))); // NOI18N
        btnTaoTablespace.setText("TẠO MỚI");
        btnTaoTablespace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoTablespaceActionPerformed(evt);
            }
        });

        btnXoaTBLSpace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/garbage.png"))); // NOI18N
        btnXoaTBLSpace.setText("XÓA TABLESPACE");
        btnXoaTBLSpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTBLSpaceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTablespace_name, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTaoTablespace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaTBLSpace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(btnTaoTablespace, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaTBLSpace, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTablespace_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel7);

        jPanel10.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel10);

        jPanel48.setBackground(new java.awt.Color(204, 255, 204));
        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách Tablespace", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jScrollPane9.setBackground(new java.awt.Color(204, 255, 204));

        tblDSTablespace.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "TABLSPACE_NAME", "BLOCK_SIZE", "INITIAL_EXTENT", "MIN_EXTENTS", "MAX_EXTENTS", "MAX_SIZE", "STATUS", "CONTENTS", "LOGGING", "FORCE_LOGGING", "EXTENT_MANAGEMENT", "ALLOCATION_TYPE", "PLUGGED_IN", "SEGMENT_SPACE_MANAGEMENT", "RETENTION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tblDSTablespace);

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9)
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnTaoTablespaceLayout = new javax.swing.GroupLayout(pnTaoTablespace);
        pnTaoTablespace.setLayout(pnTaoTablespaceLayout);
        pnTaoTablespaceLayout.setHorizontalGroup(
            pnTaoTablespaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTaoTablespaceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTaoTablespaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnTaoTablespaceLayout.setVerticalGroup(
            pnTaoTablespaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTaoTablespaceLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnKTAudit.addTab("tab8", pnTaoTablespace);

        pnPhanQuyenUser.setBackground(new java.awt.Color(204, 255, 204));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("PHÂN QUYỀN USER");

        jPanel12.setBackground(new java.awt.Color(204, 255, 204));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Phân quyền User", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        txtUserPhanQuyen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setText("Quyền:");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel24.setText("Username:");

        btnGanQuyenUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/assign.png"))); // NOI18N
        btnGanQuyenUser.setText("GÁN QUYỀN");
        btnGanQuyenUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGanQuyenUserActionPerformed(evt);
            }
        });

        btnThuHoiQuyenUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/assignment.png"))); // NOI18N
        btnThuHoiQuyenUser.setText("THU HỒI QUYỀN");
        btnThuHoiQuyenUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThuHoiQuyenUserActionPerformed(evt);
            }
        });

        lst_QuyenUser.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jScrollPane22.setViewportView(lst_QuyenUser);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(35, 35, 35)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUserPhanQuyen, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(jScrollPane22))
                .addGap(110, 110, 110)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThuHoiQuyenUser, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGanQuyenUser, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(734, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUserPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(btnGanQuyenUser, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(btnThuHoiQuyenUser, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        jPanel49.setBackground(new java.awt.Color(204, 255, 204));
        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách User", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jScrollPane4.setBackground(new java.awt.Color(204, 255, 204));

        tblDSQuyenUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Username", "Ngày tạo", "Ngày hết hạn", "Trạng thái", "Lần đăng nhập cuối", "Tablespace", "Profile"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSQuyenUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSQuyenUserMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDSQuyenUser);

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnPhanQuyenUserLayout = new javax.swing.GroupLayout(pnPhanQuyenUser);
        pnPhanQuyenUser.setLayout(pnPhanQuyenUserLayout);
        pnPhanQuyenUserLayout.setHorizontalGroup(
            pnPhanQuyenUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPhanQuyenUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPhanQuyenUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnPhanQuyenUserLayout.setVerticalGroup(
            pnPhanQuyenUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPhanQuyenUserLayout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnKTAudit.addTab("tab11", pnPhanQuyenUser);

        pnTaoProfile.setBackground(new java.awt.Color(204, 255, 204));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("TẠO PROFILE");

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin Profiles", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        txtProfileName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Profile Name:");

        txtSoLanThayDoiPW.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Số lần thay đổi Password:");

        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel43.setText("Thời gian sử dụng: ");

        txtTGSuDung.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 235, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTGSuDung)
                    .addComponent(txtProfileName, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(txtSoLanThayDoiPW)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProfileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLanThayDoiPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTGSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        txtSoLanDNSai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("          Số lần đăng nhập sai:");

        txtTGKhoaTK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("          Thời gian khóa tài khoản:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoLanDNSai, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(txtTGKhoaTK)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLanDNSai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTGKhoaTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));

        btnTaoMoiProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/page.png"))); // NOI18N
        btnTaoMoiProfile.setText("TẠO MỚI");
        btnTaoMoiProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiProfileActionPerformed(evt);
            }
        });

        btnXoaProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/garbage.png"))); // NOI18N
        btnXoaProfile.setText("XÓA PROFILE");
        btnXoaProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTaoMoiProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                .addGap(0, 390, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnTaoMoiProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6);

        jPanel50.setBackground(new java.awt.Color(204, 255, 204));
        jPanel50.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách Proflies", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jScrollPane8.setBackground(new java.awt.Color(204, 255, 204));

        tblDSProfile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PROFILE", "RESOURCE_NAME", "RESOURCE_TYPE", "LIMIT", "COMMON"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblDSProfile);

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnTaoProfileLayout = new javax.swing.GroupLayout(pnTaoProfile);
        pnTaoProfile.setLayout(pnTaoProfileLayout);
        pnTaoProfileLayout.setHorizontalGroup(
            pnTaoProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnTaoProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTaoProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnTaoProfileLayout.setVerticalGroup(
            pnTaoProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTaoProfileLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnKTAudit.addTab("tab6", pnTaoProfile);

        pnTaoUser.setBackground(new java.awt.Color(204, 255, 204));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("THÔNG TIN USER");

        jPanel11.setBackground(new java.awt.Color(204, 255, 204));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin User", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Username:");

        txtUsername.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setText("Trạng thái:");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText("Tablespace:");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setText("Profile:");

        btnTaoUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-friend.png"))); // NOI18N
        btnTaoUser.setText("TẠO USER");
        btnTaoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoUserActionPerformed(evt);
            }
        });

        btnXoaUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/garbage.png"))); // NOI18N
        btnXoaUser.setText("XÓA");
        btnXoaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaUserActionPerformed(evt);
            }
        });

        btnSuaUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exchange.png"))); // NOI18N
        btnSuaUser.setText("SỬA");
        btnSuaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaUserActionPerformed(evt);
            }
        });

        jPanel42.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );

        cboTrangThaiUser.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cboTrangThaiUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EXPIRED & LOCKED", "OPEN" }));

        cboTablespace.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        cboProfile.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsername)
                    .addComponent(cboProfile, 0, 198, Short.MAX_VALUE))
                .addGap(103, 103, 103)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboTablespace, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTrangThaiUser, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTaoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(329, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(cboTrangThaiUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(cboTablespace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(cboProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnTaoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel51.setBackground(new java.awt.Color(204, 255, 204));
        jPanel51.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách & Thông tin User", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jScrollPane3.setBackground(new java.awt.Color(204, 255, 204));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Username", "Password", "Ngày tạo", "Ngày hết hạn", "Trạng thái", "Lần đăng nhập cuối", "Tablespace", "Profile"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblUser);

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnTaoUserLayout = new javax.swing.GroupLayout(pnTaoUser);
        pnTaoUser.setLayout(pnTaoUserLayout);
        pnTaoUserLayout.setHorizontalGroup(
            pnTaoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTaoUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTaoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnTaoUserLayout.setVerticalGroup(
            pnTaoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTaoUserLayout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );

        pnKTAudit.addTab("tab9", pnTaoUser);

        pnTaoNhomQuyen.setBackground(new java.awt.Color(204, 255, 204));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("TẠO - XÓA - PHÂN QUYỀN CHO NHÓM QUYỀN");

        jPanel13.setBackground(new java.awt.Color(204, 255, 204));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin Quyền:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        txtTaoNhomQuyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rating.png"))); // NOI18N
        txtTaoNhomQuyen.setText("TẠO NHÓM QUYỀN");
        txtTaoNhomQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaoNhomQuyenActionPerformed(evt);
            }
        });

        txtXoaNhomQuyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/garbage.png"))); // NOI18N
        txtXoaNhomQuyen.setText("XÓA NHÓM QUYỀN");
        txtXoaNhomQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXoaNhomQuyenActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel26.setText("Danh sách quyền:");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel27.setText("Tên nhóm quyền:");
        jLabel27.setToolTipText("");

        txtTenNhomQuyen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtGanQuyenNhomQuyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/assign.png"))); // NOI18N
        txtGanQuyenNhomQuyen.setText("GÁN QUYỀN CHO NHÓM");
        txtGanQuyenNhomQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGanQuyenNhomQuyenActionPerformed(evt);
            }
        });

        lst_DSPhanQuyenNhomQuyen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jScrollPane24.setViewportView(lst_DSPhanQuyenNhomQuyen);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenNhomQuyen)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtXoaNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTaoNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGanQuyenNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)))
                    .addComponent(txtTaoNhomQuyen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(txtXoaNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGanQuyenNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel52.setBackground(new java.awt.Color(204, 255, 204));
        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách Nhóm quyền", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jScrollPane10.setBackground(new java.awt.Color(204, 255, 204));

        tblDSQuyen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ROLE", "PASSWORD_REQUIRED", "AUTHENTICATION_TYPE", "COMMON", "ORACLE_MAINTAINED"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSQuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSQuyenMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblDSQuyen);
        if (tblDSQuyen.getColumnModel().getColumnCount() > 0) {
            tblDSQuyen.getColumnModel().getColumn(4).setHeaderValue("ORACLE_MAINTAINED");
        }

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10)
                .addContainerGap())
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnTaoNhomQuyenLayout = new javax.swing.GroupLayout(pnTaoNhomQuyen);
        pnTaoNhomQuyen.setLayout(pnTaoNhomQuyenLayout);
        pnTaoNhomQuyenLayout.setHorizontalGroup(
            pnTaoNhomQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 1873, Short.MAX_VALUE)
            .addGroup(pnTaoNhomQuyenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTaoNhomQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnTaoNhomQuyenLayout.setVerticalGroup(
            pnTaoNhomQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTaoNhomQuyenLayout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnKTAudit.addTab("tab12", pnTaoNhomQuyen);

        pnLS_DangNhap.setBackground(new java.awt.Color(204, 255, 204));

        jLabel62.setBackground(new java.awt.Color(204, 255, 204));
        jLabel62.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("LỊCH SỬ ĐĂNG NHẬP");

        jPanel53.setBackground(new java.awt.Color(204, 255, 204));
        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách User Đăng nhập - Đăng xuất", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jScrollPane25.setBackground(new java.awt.Color(204, 255, 204));

        tblDSLSDN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "USER_NAME", "ACTIVITY", "LOGON_DATE", "LOGON_TIME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSLSDN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSLSDNMouseClicked(evt);
            }
        });
        jScrollPane25.setViewportView(tblDSLSDN);

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane25)
                .addContainerGap())
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnLS_DangNhapLayout = new javax.swing.GroupLayout(pnLS_DangNhap);
        pnLS_DangNhap.setLayout(pnLS_DangNhapLayout);
        pnLS_DangNhapLayout.setHorizontalGroup(
            pnLS_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, 1873, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLS_DangNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnLS_DangNhapLayout.setVerticalGroup(
            pnLS_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLS_DangNhapLayout.createSequentialGroup()
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnKTAudit.addTab("tab9", pnLS_DangNhap);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1873, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 894, Short.MAX_VALUE)
        );

        pnKTAudit.addTab("tab11", jPanel34);

        pnTaoPolicy.setBackground(new java.awt.Color(204, 255, 204));

        jLabel63.setBackground(new java.awt.Color(204, 255, 204));
        jLabel63.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("QUẢN LÝ AUDIT DỮ LIỆU");

        jPanel37.setBackground(new java.awt.Color(255, 204, 204));
        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tạo Policy", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane7.setToolTipText("");

        tblDSPolicy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "OBJECT_SCHEMA", "OBJECT_NAME", "POLICY_OWN", "POLICY_NAME", "ENABLED", "SEL", "INS", "UPD", "DEL", "AUDIT_TRAIL", "POLICY_COLUMN_OPTIONS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblDSPolicy);

        btnTaoPolicy.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnTaoPolicy.setText("TẠO POLICY");
        btnTaoPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPolicyActionPerformed(evt);
            }
        });

        btnXoaPolicy.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnXoaPolicy.setText("XÓA POLICY");
        btnXoaPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPolicyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTaoPolicy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaPolicy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnTaoPolicy, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaPolicy, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addGap(18, 18, 18)
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel54.setBackground(new java.awt.Color(153, 255, 204));
        jPanel54.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Kiểm tra Audit", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jScrollPane26.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        tblAuditTrail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "TIMESTAMP", "DB_USER", "OS_USER", "USERHOST", "OBJECT_SCHEMA", "OBJECT_NAME", "POLICY_NAME", "SQL_TEXT", "STATEMENT_TYPE", "EXTENDED_TIMESTAMP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane26.setViewportView(tblAuditTrail);

        btnAuditngay.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnAuditngay.setText("AUDIT TRONG NGÀY");
        btnAuditngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuditngayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAuditngay, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(btnAuditngay, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane26)
                .addGap(18, 18, 18)
                .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnTaoPolicyLayout = new javax.swing.GroupLayout(pnTaoPolicy);
        pnTaoPolicy.setLayout(pnTaoPolicyLayout);
        pnTaoPolicyLayout.setHorizontalGroup(
            pnTaoPolicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 1873, Short.MAX_VALUE)
            .addGroup(pnTaoPolicyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTaoPolicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnTaoPolicyLayout.setVerticalGroup(
            pnTaoPolicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTaoPolicyLayout.createSequentialGroup()
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 360, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );

        pnKTAudit.addTab("tab10", pnTaoPolicy);

        javax.swing.GroupLayout pnTabMenuLayout = new javax.swing.GroupLayout(pnTabMenu);
        pnTabMenu.setLayout(pnTabMenuLayout);
        pnTabMenuLayout.setHorizontalGroup(
            pnTabMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTabMenuLayout.createSequentialGroup()
                .addComponent(pnKTAudit)
                .addContainerGap())
        );
        pnTabMenuLayout.setVerticalGroup(
            pnTabMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTabMenuLayout.createSequentialGroup()
                .addComponent(pnKTAudit, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pnGiaoDien.add(pnTabMenu, "pnTabMenu");

        mnuHeThong.setMnemonic('f');
        mnuHeThong.setText("Hệ thống");

        mnuDX.setMnemonic('o');
        mnuDX.setText("Đăng xuất");
        mnuDX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDXActionPerformed(evt);
            }
        });
        mnuHeThong.add(mnuDX);

        mnuThoat.setMnemonic('s');
        mnuThoat.setText("Thoát");
        mnuThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuThoatActionPerformed(evt);
            }
        });
        mnuHeThong.add(mnuThoat);

        menuBar.add(mnuHeThong);

        mnuLSDN.setMnemonic('e');
        mnuLSDN.setText("Quản lý");

        jMenu1.setText("Thông tin");

        mnuProcess.setText("Process & Instance");
        mnuProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProcessActionPerformed(evt);
            }
        });
        jMenu1.add(mnuProcess);

        mnuDatabase.setText("Database & Datafile");
        mnuDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDatabaseActionPerformed(evt);
            }
        });
        jMenu1.add(mnuDatabase);

        mnuSession.setText("Session");
        mnuSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSessionActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSession);

        mnuLSDN.add(jMenu1);

        jMenuItem1.setText("Profiles");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuLSDN.add(jMenuItem1);

        mnuTaoTablespace.setMnemonic('y');
        mnuTaoTablespace.setText("Tạo Tablespace");
        mnuTaoTablespace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTaoTablespaceActionPerformed(evt);
            }
        });
        mnuLSDN.add(mnuTaoTablespace);

        jMenuItem2.setText("User");
        jMenuItem2.setToolTipText("");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuLSDN.add(jMenuItem2);

        jMenu4.setText("Nhóm quyền");

        mnuPhanQuyenUser.setText("Phân quyền - Thu hồi quyền User");
        mnuPhanQuyenUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPhanQuyenUserActionPerformed(evt);
            }
        });
        jMenu4.add(mnuPhanQuyenUser);

        mnuTaoNhomQuye.setText("Tạo - Xóa nhóm quyền");
        mnuTaoNhomQuye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTaoNhomQuyeActionPerformed(evt);
            }
        });
        jMenu4.add(mnuTaoNhomQuye);

        mnuLSDN.add(jMenu4);

        jMenuItem3.setText("Lịch sử đăng nhập");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuLSDN.add(jMenuItem3);

        mnuPolicy.setText("Policy");
        mnuPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPolicyActionPerformed(evt);
            }
        });
        mnuLSDN.add(mnuPolicy);

        menuBar.add(mnuLSDN);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Trợ giúp");

        mnuSaoLuu.setMnemonic('c');
        mnuSaoLuu.setText("Sao lưu dữ liệu");
        helpMenu.add(mnuSaoLuu);

        mnuExport.setMnemonic('a');
        mnuExport.setText("Export - Import");
        mnuExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExportActionPerformed(evt);
            }
        });
        helpMenu.add(mnuExport);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnGiaoDien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnGiaoDien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuThoatActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát chương trình ?", "Thông báo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
            return;
        System.exit(0);
    }//GEN-LAST:event_mnuThoatActionPerformed

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnTrangChu");
        //-------pnTrangChu
        dtmTrangChu_thongtinsach = (DefaultTableModel)tblThongTinSach.getModel();
        dtmTrangChu_thongtindonhang = (DefaultTableModel)tblCTDonHang.getModel();
        dtmTrangChu_thongtindonhang.setRowCount(0);
        show_DS_Sach(user, pass);        
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnNhanVien");
        //-------pnNhanVien
        dtmNhanVien = (DefaultTableModel)tblDSNhanVien.getModel();
        show_DS_NhanVien(user, pass);
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/nv1_1.jpg"));
        icon = new ImageIcon(ImageHelper.resize(icon.getImage(), 245, 272));        
        lblAnhNhanVien.setIcon(icon);        
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void mnuProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProcessActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnTabMenu");
        pnProcess.setName("Thông tin Process & Instance");
        pnKTAudit.add(pnProcess);
        pnKTAudit.setSelectedComponent(pnProcess);
        
        dtmProcess = (DefaultTableModel)tbl_process.getModel();
        dtmProcess.setRowCount(0);
        System_DAO.show_DS_Process(dtmProcess);
        
        dtmInstance = (DefaultTableModel)tbl_instance.getModel();
        dtmInstance.setRowCount(0);
        System_DAO.show_DS_Instance(dtmInstance);
    }//GEN-LAST:event_mnuProcessActionPerformed

    private void mnuDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDatabaseActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnTabMenu");
        pnDatabase.setName("Thông tin Database & Datafile");
        pnKTAudit.add(pnDatabase);
        pnKTAudit.setSelectedComponent(pnDatabase);
        dtmDatabase = (DefaultTableModel)tblDATABASE.getModel();
        dtmDatabase.setRowCount(0);
        System_DAO.show_DS_Database(dtmDatabase);    
        dtmDatafiles = (DefaultTableModel)tblDatafile.getModel();
        dtmDatafiles.setRowCount(0);
        System_DAO.show_DS_Datafiles(dtmDatafiles);
    }//GEN-LAST:event_mnuDatabaseActionPerformed

    private void mnuSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSessionActionPerformed
        // TODO add your handling code here:
        dtmSession = (DefaultTableModel)tblSesssion1.getModel();
        dtmSession.setRowCount(0);
        System_DAO.show_DS_Session(dtmSession);
        tblSesssion1.setRowSelectionInterval(0, 0);
        txtSID.setText(tblSesssion1.getValueAt(0, 0).toString());
        txtSerial.setText(tblSesssion1.getValueAt(0, 1).toString());
        txtUserSession.setText(tblSesssion1.getValueAt(0, 2).toString());
        cardlayout.show(pnGiaoDien, "pnTabMenu");
        pnSession.setName("Thông tin Session");
        pnKTAudit.add(pnSession);
        pnKTAudit.setSelectedComponent(pnSession);
    }//GEN-LAST:event_mnuSessionActionPerformed

    private void mnuTaoTablespaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTaoTablespaceActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnTabMenu");
        pnTaoTablespace.setName("Tạo Tablespace");
        pnKTAudit.add(pnTaoTablespace);
        pnKTAudit.setSelectedComponent(pnTaoTablespace);
        dtmTablespace = (DefaultTableModel)tblDSTablespace.getModel();
        dtmTablespace.setRowCount(0);
        System_DAO.show_DS_Tablespace(dtmTablespace);
    }//GEN-LAST:event_mnuTaoTablespaceActionPerformed

    private void mnuPhanQuyenUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPhanQuyenUserActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnTabMenu");
        pnPhanQuyenUser.setName("Phân quyền User");
        pnKTAudit.add(pnPhanQuyenUser);
        pnKTAudit.setSelectedComponent(pnPhanQuyenUser);
        dtmPhanQuyenUser = (DefaultTableModel)tblDSQuyenUser.getModel();
        dtmPhanQuyenUser.setRowCount(0);
        System_DAO.show_DS_User(dtmPhanQuyenUser);        
    }//GEN-LAST:event_mnuPhanQuyenUserActionPerformed

    private void mnuTaoNhomQuyeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTaoNhomQuyeActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnTabMenu");
        pnTaoNhomQuyen.setName("Tạo nhóm quyền");
        pnKTAudit.add(pnTaoNhomQuyen);
        pnKTAudit.setSelectedComponent(pnTaoNhomQuyen);
        dtmPhanQuyenNhomQuyen = (DefaultTableModel)tblDSQuyen.getModel();
        dtmPhanQuyenNhomQuyen.setRowCount(0);
        System_DAO.show_DS_Role(dtmPhanQuyenNhomQuyen);        
    }//GEN-LAST:event_mnuTaoNhomQuyeActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnTabMenu");
        pnTaoProfile.setName("Tạo Profile");
        pnKTAudit.add(pnTaoProfile);
        pnKTAudit.setSelectedComponent(pnTaoProfile);
        dtmProfiles = (DefaultTableModel)tblDSProfile.getModel();
        dtmProfiles.setRowCount(0);
        System_DAO.show_DS_Profile(dtmProfiles);         
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        cboProfile.removeAllItems();
        cboTablespace.removeAllItems();
        cardlayout.show(pnGiaoDien, "pnTabMenu");
        pnTaoUser.setName("Tạo User");
        pnKTAudit.add(pnTaoUser);
        pnKTAudit.setSelectedComponent(pnTaoUser);
        
        dtmUser = (DefaultTableModel)tblUser.getModel();
        dtmUser.setRowCount(0);
        System_DAO.show_DS_User(dtmUser);

        System_DAO.get_tablespace_name(cboTablespace);
        System_DAO.get_profile(cboProfile);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnThuHoiQuyenUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThuHoiQuyenUserActionPerformed
        // TODO add your handling code here:
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn Thu hồi quyền [" + lst_QuyenUser.getSelectedValue() + "] của User ["
                + txtUserPhanQuyen.getText() + "] không ?" , "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (kq == JOptionPane.NO_OPTION)
            return;
        String revoke_quyen = lst_QuyenUser.getSelectedValue();
        if (System_DAO.revoke_grant_user(txtUserPhanQuyen.getText(), revoke_quyen)){
            JOptionPane.showMessageDialog(this, "Thu hồi thành công", "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
            System_DAO.show_DS_User(dtmPhanQuyenUser);
        }else {
            JOptionPane.showMessageDialog(this, "Thu hồi không thành công", "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);        
            System_DAO.show_DS_User(dtmPhanQuyenUser);
        }
    }//GEN-LAST:event_btnThuHoiQuyenUserActionPerformed

    private void txtXoaNhomQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXoaNhomQuyenActionPerformed
        // TODO add your handling code here:
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn Xóa ROLE [" + txtTenNhomQuyen.getText() + "] không ?" , 
                "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (kq == JOptionPane.NO_OPTION)
            return;
        if (System_DAO.delete_role(txtTenNhomQuyen.getText())){
            JOptionPane.showMessageDialog(this, "Xóa Role thành công", "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
            System_DAO.show_DS_Role(dtmPhanQuyenNhomQuyen);        
        }else {
            JOptionPane.showMessageDialog(this, "Xóa Role không thành công", "Thông báo", 
                    JOptionPane.WARNING_MESSAGE);
            System_DAO.show_DS_Role(dtmPhanQuyenNhomQuyen);        
        }
    }//GEN-LAST:event_txtXoaNhomQuyenActionPerformed

    private void btnNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNCCActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnNCC");
        //-------pnNCC
        dtmNCC = (DefaultTableModel)tblDSNCC.getModel();
        show_DS_NhaCungCap(user, pass);        
    }//GEN-LAST:event_btnNCCActionPerformed

    private void btnSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSachActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnSach");
        //-------pnSach
        dtmSach = (DefaultTableModel)tblDSSach.getModel();
        show_DS_ThongTinSach(user, pass);        
    }//GEN-LAST:event_btnSachActionPerformed

    private void btnHDBanSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHDBanSachActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnHDBan");
        //-------pnHDBan
        txt_tk_makh.setEditable(false);
        dtmHDBan = (DefaultTableModel)tblDSDonBan.getModel();
        dtmCT_HDBan = (DefaultTableModel)tblCTDonBan.getModel();
        show_DS_HDBan(user, pass);
        tblDSDonBan.setRowSelectionInterval(0, 0);
        show_DS_CT_HDBan(user, pass);
        
    }//GEN-LAST:event_btnHDBanSachActionPerformed

    private void btnHDNhapSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHDNhapSachActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnHDNhap");
        //-------pnHDNhap
        txt_tk_manv.setEditable(false);
        dtmHDNhap = (DefaultTableModel)tblDSDonNhap.getModel();
        dtmCT_HDNhap = (DefaultTableModel)tblCT_DonNhap.getModel();
        show_DS_HDNhap(user, pass);
        tblDSDonNhap.setRowSelectionInterval(0, 0);
        show_DS_CT_HDNhap(user, pass);        
    }//GEN-LAST:event_btnHDNhapSachActionPerformed

    private void btnThemNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNCCActionPerformed
        // TODO add your handling code here:
        txtMaNCC.setText("");
        txtTenNCC.setText("");
        txtDiaChiNCC.setText("");
        txtLienHeNCC.setText("");  
        txtMaNCC.requestFocus();
    }//GEN-LAST:event_btnThemNCCActionPerformed

    private void btnLuuNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuNCCActionPerformed
        // TODO add your handling code here:
        if (NhaCungCap_DAO.check_NCC(txtMaNCC.getText(), user, pass)){
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật thông tin Nhà cung cấp [ " + txtTenNCC.getText() + " ] không ?",
                    "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
                return;
            NhaCungCap ncc = new NhaCungCap();
            ncc.setMaNCC(txtMaNCC.getText());
            ncc.setTenNCC(txtTenNCC.getText());
            ncc.setDiaChiNCC(txtDiaChiNCC.getText());
            ncc.setSdtNCC(txtLienHeNCC.getText());
            if (NhaCungCap_DAO.update_NCC(ncc, user, pass)){
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhà cung cấp thành công !");
                show_DS_NhaCungCap(user, pass);
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhà cung cấp không thành công !");
                show_DS_NhaCungCap(user, pass);
            }
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm Nhà cung cấp [ " + txtTenNCC.getText() + " ] không ?",
                    "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
                return;
            NhaCungCap ncc = new NhaCungCap();
            ncc.setMaNCC(txtMaNCC.getText());
            ncc.setTenNCC(txtTenNCC.getText());
            ncc.setDiaChiNCC(txtDiaChiNCC.getText());
            ncc.setSdtNCC(txtLienHeNCC.getText());
            if (NhaCungCap_DAO.insert_NCC(ncc, user, pass)){
                JOptionPane.showMessageDialog(this, "Thêm nhà cung cấp thành công !");
                show_DS_NhaCungCap(user, pass);
            } else {
                JOptionPane.showMessageDialog(this, "Thêm nhà cung cấp không thành công !");
                show_DS_NhaCungCap(user, pass);
            }
        }
        txtMaNCC.setEditable(true);
    }//GEN-LAST:event_btnLuuNCCActionPerformed

    private void btnSuaNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNCCActionPerformed
        // TODO add your handling code here:
        txtMaNCC.setEditable(false);
        txtTenNCC.requestFocus();
        txtTenNCC.selectAll();
    }//GEN-LAST:event_btnSuaNCCActionPerformed

    private void btnXoaNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNCCActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa thông tin Nhà cung cấp [ " + txtTenNCC.getText() + " ] không ?",
                    "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
            return;
        if (NhaCungCap_DAO.delete_NCC(txtMaNCC.getText(), user, pass)){
            JOptionPane.showMessageDialog(this, "Xóa nhà cung cấp thành công !");
            show_DS_NhaCungCap(user, pass);
        } else {
            JOptionPane.showMessageDialog(this, "Xóa nhà cung cấp không thành công !");
            show_DS_NhaCungCap(user, pass);
        }
    }//GEN-LAST:event_btnXoaNCCActionPerformed

    private void btnXoaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSachActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa thông tin sach [ " + txtTenS.getText() + " ] không ?",
                    "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
            return;
        if (Sach_DAO.delete_Sach(txtMaS.getText(), user, pass)){
            JOptionPane.showMessageDialog(this, "Xóa sách thành công !");
            show_DS_ThongTinSach(user, pass);
        } else {
            JOptionPane.showMessageDialog(this, "Xóa sách không thành công !");
            show_DS_ThongTinSach(user, pass);
        }
    }//GEN-LAST:event_btnXoaSachActionPerformed

    private void btnLuuSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuSachActionPerformed
        // TODO add your handling code here:
        //---Lấy mã thể loại
        int tl = Sach_DAO.get_theLoai(cboTheLoaiSach.getSelectedItem().toString(), user, pass);
        if (Sach_DAO.check_Sach(txtMaS.getText(), user, pass)){
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật thông tin sách [ " + txtMaS.getText() + " ] không ?",
                    "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
                return;
            Sach sach = new Sach();
            sach.setMaSach(txtMaS.getText());
            sach.setTenSach(txtTenS.getText());
            sach.setTacGia(txtTacGia.getText());
            sach.setNhaXB(txtNhaXuatBan.getText());
            sach.setNamXB(Integer.parseInt(txtNamXB.getText()));
            sach.setMaLoai(tl);
            sach.setGiamGia(Float.parseFloat(txtGiamGia.getText()));
            sach.setGiaBan(Integer.parseInt(txtGiaBan.getText()));
            sach.setTonKho(Integer.parseInt(txtTonKho.getText()));
            if (Sach_DAO.update_sach(sach, user, pass)){
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin sách thành công !");
                show_DS_ThongTinSach(user, pass);
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin sách không thành công !");
                show_DS_ThongTinSach(user, pass);
            }
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn Thêm thông tin sách [ " + txtMaS.getText() + " ] không ?",
                    "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
                return;
            Sach sach = new Sach();
            sach.setMaSach(txtMaS.getText());
            sach.setTenSach(txtTenS.getText());
            sach.setTacGia(txtTacGia.getText());
            sach.setNhaXB(txtNhaXuatBan.getText());
            sach.setNamXB(Integer.parseInt(txtNamXB.getText()));
            sach.setMaLoai(tl);
            sach.setGiamGia(Float.parseFloat(txtGiamGia.getText()));
            sach.setGiaBan(Integer.parseInt(txtGiaBan.getText()));
            if (Sach_DAO.insert_Sach(sach, Integer.parseInt(txtTonKho.getText()), user, pass)){
                JOptionPane.showMessageDialog(this, "Thêm thông tin sách thành công !");
                show_DS_ThongTinSach(user, pass);
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thông tin sách không thành công !");
                show_DS_ThongTinSach(user, pass);
            }
        }
        
        txtMaS.setEditable(true);
    }//GEN-LAST:event_btnLuuSachActionPerformed

    private void btnSuaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSachActionPerformed
        // TODO add your handling code here:
        txtMaS.setEditable(false);
        txtTenS.requestFocus();
        txtTenS.selectAll();
    }//GEN-LAST:event_btnSuaSachActionPerformed

    private void btnThemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSachActionPerformed
        // TODO add your handling code here:
        txtMaS.setText("");
        txtTenS.setText("");
        txtTacGia.setText("");
        txtNhaXuatBan.setText("");
        txtNamXB.setText("");
        txtGiamGia.setText("");
        txtGiaBan.setText("");
        txtTonKho.setText("");
        txtMaS.requestFocus();
    }//GEN-LAST:event_btnThemSachActionPerformed

    private void btnXoaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKHActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa thông tin Khách hàng [ " + txtTenKH.getText() + " ] không ?",
                    "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
            return;
        if (KhachHang_DAO.delete_KhachHang(txtMaKH.getText(), user, pass)){
            JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công !");
            show_DS_KhachHang(user, pass);
        } else {
            JOptionPane.showMessageDialog(this, "Xóa khách hàng không thành công !");
            show_DS_KhachHang(user, pass);
        }
    }//GEN-LAST:event_btnXoaKHActionPerformed

    private void btnLuuKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuKHActionPerformed
        // TODO add your handling code here:
        if (KhachHang_DAO.check_KH(txtMaKH.getText(), user, pass)){
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật thông tin khách hàng [ " + txtMaKH.getText() + " ] không !",
                    "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
                return;
            KhachHang kh = new KhachHang();
            kh.setMaKH(txtMaKH.getText());
            kh.setHoTen(txtTenKH.getText());
            kh.setDiaChiKH(txtDiaChi.getText());
            kh.setSdtKH(txtSDT.getText());
            kh.setNgaySinh(txtNgaySinhKH.getText());
            if (KhachHang_DAO.update_KhachHang(kh, user, pass)){
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin khách hàng thành công !");
                show_DS_KhachHang(user, pass);
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin khách hàng không thành công !");
                show_DS_KhachHang(user, pass);
            }
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu thông tin khách hàng [ " + txtMaKH.getText() + " ] không !",
                    "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
                return;
            KhachHang kh = new KhachHang();
            kh.setMaKH(txtMaKH.getText());
            kh.setHoTen(txtTenKH.getText());
            kh.setDiaChiKH(txtDiaChi.getText());
            kh.setSdtKH(txtSDT.getText());
            kh.setNgaySinh(txtNgaySinhKH.getText());
            if (KhachHang_DAO.insert_KhachHang(kh, user, pass)){
                JOptionPane.showMessageDialog(this, "Lưu thông tin khách hàng thành công !");
                show_DS_KhachHang(user, pass);
                btnLuuKH.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Lưu thông tin khách hàng không thành công !");
                show_DS_KhachHang(user, pass);
            }
        }
        
        txtMaKH.setEditable(true);
    }//GEN-LAST:event_btnLuuKHActionPerformed

    private void btnSuaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKHActionPerformed
        // TODO add your handling code here:
        txtMaKH.setEditable(false);
        txtTenKH.requestFocus();
        txtTenKH.selectAll();
    }//GEN-LAST:event_btnSuaKHActionPerformed

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        // TODO add your handling code here:
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtNgaySinhKH.setText("");
        txtMaKH.requestFocus();
        btnLuuKH.setEnabled(true);
    }//GEN-LAST:event_btnThemKHActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnKhachHang");
        //-------pnKhachHang
        dtmKhachHang = (DefaultTableModel) tblDSKhachHang.getModel();
        show_DS_KhachHang(user, pass);        
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnQuanLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnTabMenu");
    }//GEN-LAST:event_btnQuanLyActionPerformed

    private void mnuDXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDXActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn đăng xuất khỏi chương trình ?", "Thông báo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
            return;
        this.dispose();
        frmDangNhap dn = new frmDangNhap();
        dn.setVisible(true);
    }//GEN-LAST:event_mnuDXActionPerformed

    private void tblDSDonNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSDonNhapMouseClicked
        // TODO add your handling code here:
        int rowSL = tblDSDonNhap.getSelectedRow();
        CT_HDNhap_DAO.show_DS_CTHDNhap(dtmCT_HDNhap, /*user*/ "Admin_Sach", /*pass*/ "admin123", tblDSDonNhap.getValueAt(rowSL, 0).toString());
    }//GEN-LAST:event_tblDSDonNhapMouseClicked

    private void tblDSDonBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSDonBanMouseClicked
        // TODO add your handling code here:
        int rowSL = tblDSDonBan.getSelectedRow();
        CT_HDBan_DAO.show_CT_HDBan(dtmCT_HDBan, /*user*/ "Admin_Sach", /*pass*/ "admin123", tblDSDonBan.getValueAt(rowSL, 0).toString());
    }//GEN-LAST:event_tblDSDonBanMouseClicked

    private void tblDSNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNhanVienMouseClicked
        // TODO add your handling code here:
        int rowSL = tblDSNhanVien.getSelectedRow();
        String manv = tblDSNhanVien.getValueAt(rowSL, 0).toString();
        txtMaNV.setText(tblDSNhanVien.getValueAt(rowSL, 0).toString());
        txtTenNV.setText(tblDSNhanVien.getValueAt(rowSL, 1).toString());
        txtNgaySinh.setText(tblDSNhanVien.getValueAt(rowSL, 2).toString());
        txtGioiTinhNV.setText(tblDSNhanVien.getValueAt(rowSL, 3).toString());
        txtEmailNv.setText(tblDSNhanVien.getValueAt(rowSL, 4).toString());
        txtSDTNV.setText(tblDSNhanVien.getValueAt(rowSL, 5).toString());
        //Ảnh
        InputStream ig = NhanVien_DAO.getNV(manv);
        if (ig != null){
            try {
                Image img = ImageHelper.createImageFromByteArray(ig, "jpg");
                ImageIcon icon = new ImageIcon(img);
                icon = new ImageIcon(ImageHelper.resize(icon.getImage(), 250, 270));        
                lblAnhNhanVien.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            personalImage = ig;
            ImageIcon icon = new ImageIcon(getClass().getResource("/img/nv1_1.jpg"));
            icon = new ImageIcon(ImageHelper.resize(icon.getImage(), 250, 270)); 
            lblAnhNhanVien.setIcon(icon); 
        }        
    }//GEN-LAST:event_tblDSNhanVienMouseClicked

    private void tblDSNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNCCMouseClicked
        // TODO add your handling code here:
        int rowSL = tblDSNCC.getSelectedRow();
        txtMaNCC.setText(tblDSNCC.getValueAt(rowSL, 0).toString());
        txtTenNCC.setText(tblDSNCC.getValueAt(rowSL, 1).toString());
        txtDiaChiNCC.setText(tblDSNCC.getValueAt(rowSL, 2).toString());
        txtLienHeNCC.setText(tblDSNCC.getValueAt(rowSL, 3).toString());
    }//GEN-LAST:event_tblDSNCCMouseClicked

    private void tblDSSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSSachMouseClicked
        // TODO add your handling code here:
        int rsl = tblDSSach.getSelectedRow();
        txtMaS.setText(tblDSSach.getValueAt(rsl, 0).toString());
        txtTenS.setText(tblDSSach.getValueAt(rsl, 1).toString());
        txtTacGia.setText(tblDSSach.getValueAt(rsl, 2).toString());
        txtNhaXuatBan.setText(tblDSSach.getValueAt(rsl, 3).toString());
        txtNamXB.setText(tblDSSach.getValueAt(rsl, 4).toString());
        cboTheLoaiSach.setSelectedItem(tblDSSach.getValueAt(rsl, 7));
        txtGiamGia.setText(tblDSSach.getValueAt(rsl, 5).toString());
        txtGiaBan.setText(tblDSSach.getValueAt(rsl, 6).toString());
        txtTonKho.setText(tblDSSach.getValueAt(rsl, 8).toString());
    }//GEN-LAST:event_tblDSSachMouseClicked

    private void tblDSKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSKhachHangMouseClicked
        // TODO add your handling code here:
        int rsl = tblDSKhachHang.getSelectedRow();
        txtMaKH.setText(tblDSKhachHang.getValueAt(rsl, 0).toString());
        txtTenKH.setText(tblDSKhachHang.getValueAt(rsl, 1).toString());
        txtDiaChi.setText(tblDSKhachHang.getValueAt(rsl, 2).toString());
        txtSDT.setText(tblDSKhachHang.getValueAt(rsl, 3).toString());
        txtNgaySinhKH.setText(tblDSKhachHang.getValueAt(rsl, 4).toString());
    }//GEN-LAST:event_tblDSKhachHangMouseClicked

    private void btnBanSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanSachActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnTrangChu");
    }//GEN-LAST:event_btnBanSachActionPerformed
    int tongtien = 0;
    private void btnMuaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuaSachActionPerformed
        // TODO add your handling code here:
        FrameSoLuongSachMua mua = new FrameSoLuongSachMua(this, true);
        mua.setVisible(true);
        int sluongMua = mua.getSoLuong();
        int rsl = tblThongTinSach.getSelectedRow();
        String masach = tblThongTinSach.getValueAt(rsl, 0).toString();
        String tensach = tblThongTinSach.getValueAt(rsl, 1).toString();
        int giaban = Integer.parseInt(tblThongTinSach.getValueAt(rsl, 7).toString());
        int thanhtien = sluongMua * giaban;
        Vector<Object> vec = new Vector<Object>();
        vec.add(masach);
        vec.add(tensach);
        vec.add(sluongMua);
        vec.add(giaban);
        vec.add(thanhtien);
        dtmTrangChu_thongtindonhang.addRow(vec);
        tongtien += thanhtien;
        txtTongTienHD.setText("" + tongtien);
        
    }//GEN-LAST:event_btnMuaSachActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        show_DS_Sach(user, pass);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnHuyMuaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyMuaSachActionPerformed
        // TODO add your handling code here:
        int rowSL = tblCTDonHang.getSelectedRow();
        int tl = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa sách [" + tblCTDonHang.getValueAt(rowSL, 1) + "] không ?",
                "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (tl == JOptionPane.NO_OPTION) return;
        tongtien -= Integer.parseInt(tblCTDonHang.getValueAt(rowSL, 4).toString());
        txtTongTienHD.setText("" + tongtien);
        dtmTrangChu_thongtindonhang.removeRow(rowSL);
    }//GEN-LAST:event_btnHuyMuaSachActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        double md = Math.random();
        int mso= (int)  (1000 + md * 1000  + 1);
        
        LocalDateTime tg = LocalDateTime.now();
        String gio = tg.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH));
        
        MaNV_MaKH nhap = new MaNV_MaKH(this, true);
        nhap.setVisible(true);
        String manv = nhap.getMaNV();
        String makh = nhap.getMaKH();
        
        int n = tblCTDonHang.getRowCount();
        int tongsl = 0;
        String[] masach = new String[n];
        int[] soluongsachmua = new int[n];
        int[] dongia = new int[n];
        int[] thanhtien = new int[n];
        
        for (int i = 0; i < n; i++) {
            masach[i] = tblCTDonHang.getValueAt(i, 0).toString();
            soluongsachmua[i] = Integer.parseInt(tblCTDonHang.getValueAt(i, 2).toString());
            dongia[i] = Integer.parseInt(tblCTDonHang.getValueAt(i, 3).toString());
            thanhtien[i] = Integer.parseInt(tblCTDonHang.getValueAt(i, 4).toString());
            tongsl += Integer.parseInt(tblCTDonHang.getValueAt(i, 2).toString());
        }
        int tongtienHD = Integer.parseInt(txtTongTienHD.getText());
        if (HDBan_DAO.insert_HDBan(mso, manv, makh, gio, tongsl, tongtienHD, user, pass)){
            for (int i = 0; i < n; i++) {
                if (CT_HDBan_DAO.insert_CT_HDBan(mso, masach[i], soluongsachmua[i], dongia[i], thanhtien[i], user, pass)){
                    if (Sach_DAO.update_TOnKho(soluongsachmua[i], masach[i], user, pass)){
                    }
                }
            }
                JOptionPane.showMessageDialog(this, "Thanh toán thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Thanh toán KHÔNG thành công !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn In hóa đơn ?", "Thông báo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
            return;
        else {
            xuat_hoa_don(mso);
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed
        // TODO add your handling code here:
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtNgaySinh.setText("");
        txtGioiTinhNV.setText("");
        txtEmailNv.setText("");
        txtSDTNV.setText("");
        txtMaNV.requestFocus();
    }//GEN-LAST:event_btnThemNVActionPerformed

    private void btnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNVActionPerformed
        // TODO add your handling code here:
        txtMaNV.setEditable(false);
        txtTenNV.requestFocus();
        txtTenNV.selectAll();
    }//GEN-LAST:event_btnSuaNVActionPerformed

    private void btnLuuNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuNVActionPerformed
        // TODO add your handling code here:
        if (NhanVien_DAO.check_NhanVien_TonTai(txtMaNV.getText(), user, pass)){
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật thông tin nhân viên [ " + txtMaNV.getText() + " ] không ?",
                    "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) 
                return;
            else {
                //UPDATE THÔNG TIN NHÂN VIÊN
                NhanVien nv = new NhanVien();
                nv.setMaNV(txtMaNV.getText());
                nv.setTenNV(txtTenNV.getText());
                nv.setNgaySinh(txtNgaySinh.getText());
                nv.setGioiTinh(txtGioiTinhNV.getText());
                nv.setEmailNV(txtEmailNv.getText());
                nv.setSdtNV(txtSDTNV.getText());
                nv.setAnhNV(personalImage);
                
                if (nv.getAnhNV() != null){
                    boolean ck = NhanVien_DAO.update_NhanVien_Anh(nv, user, pass);
                }
                if (NhanVien_DAO.update_NhanVien(nv, user, pass)){
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhân viên thành công !", "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE);
                    show_DS_NhanVien(user, pass);
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin không thành công !", "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE);
                    show_DS_NhanVien(user, pass);
                }
            }
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu thông tin nhân viên [ " + txtMaNV.getText() + " ] không ?",
                    "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) 
                return;
            else {
                //INSERT THÔNG TIN NHÂN VIÊN
                NhanVien nv = new NhanVien();
                nv.setMaNV(txtMaNV.getText());
                nv.setTenNV(txtTenNV.getText());
                nv.setNgaySinh(txtNgaySinh.getText());
                nv.setGioiTinh(txtGioiTinhNV.getText());
                nv.setEmailNV(txtEmailNv.getText());
                nv.setSdtNV(txtSDTNV.getText());
                nv.setAnhNV(personalImage);
                
                if (NhanVien_DAO.insert_NhanVien(nv, user, pass)){
                    JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công !", "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE);
                    show_DS_NhanVien(user, pass);
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm không thành công !", "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE);
                    show_DS_NhanVien(user, pass);
                }
            }
        }
        
        txtMaNV.setEditable(true);
    }//GEN-LAST:event_btnLuuNVActionPerformed

    private void lblAnhNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhNhanVienMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()){
                    return true;
                }else {
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }
            @Override
            public String getDescription() {
                return "Image File (*.jpg)";
            }
        });
        if (chooser.showOpenDialog(this) == JFileChooser.CANCEL_OPTION){
            return;
        }
        File file = chooser.getSelectedFile();
        try {
            InputStream imge = new FileInputStream(file.getPath());
            personalImage = imge;
            ImageIcon icon = new ImageIcon(file.getPath());
            Image img = ImageHelper.resize(icon.getImage(), 245, 272);
            ImageIcon resizeIcon = new ImageIcon(img);
            lblAnhNhanVien.setIcon(resizeIcon);

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lblAnhNhanVienMouseClicked

    private void btnXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNVActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhân viên [ " + txtMaNV.getText() + " ] không ?",
                "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
            return;
        if (NhanVien_DAO.delete_NhanVien(txtMaNV.getText(), user, pass)){
            JOptionPane.showMessageDialog(this, "Đã xóa nhân viên thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            show_DS_NhanVien(user, pass);
        }
        else {
            JOptionPane.showMessageDialog(this, "Đã xóa nhân viên không thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            show_DS_NhanVien(user, pass);
        }
    }//GEN-LAST:event_btnXoaNVActionPerformed

    private void btnTK_HDBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTK_HDBanActionPerformed
        // TODO add your handling code here:
        if (radTK_HDBan_Ngay.isSelected()){
            DiaLogLich chonngay = new DiaLogLich(this, true);
            chonngay.setVisible(true);
            if (!chonngay.isKq())
                return;
            String ngay = chonngay.getNgay() + "/" + chonngay.getThang()+ "/" + chonngay.getNam();
            if ((HDBan_DAO.tim_HDBan_theoNgay(dtmHDBan, ngay, user, pass))){
                HDBan_DAO.tim_HDBan_theoNgay(dtmHDBan, ngay, user, pass);
            }else {
                JOptionPane.showMessageDialog(this, "Không có hóa đơn nào được lập trong ngày [" + ngay + "]", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
                show_DS_HDBan(user, pass);
            }            
            return;
        }
        if (radTK_HDBan_maKH.isSelected()){
            if (KhachHang_DAO.check_KH(txt_tk_makh.getText(), user, pass)){
                if ((HDBan_DAO.tim_HDBan_theoMaKH(dtmHDBan, txt_tk_makh.getText(), user, pass))){
                    HDBan_DAO.tim_HDBan_theoMaKH(dtmHDBan, txt_tk_makh.getText(), user, pass);
                }else {
                    JOptionPane.showMessageDialog(this, "Không có hóa đơn nào được tìm thấy !", "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE);
                    show_DS_HDBan(user, pass);
                }        
            }else {
                JOptionPane.showMessageDialog(this, "Không có khách hàng [" + txt_tk_makh.getText() + "] ?", "Cảnh báo",
                        JOptionPane.WARNING_MESSAGE);
                show_DS_HDBan(user, pass); 
            }
            return;
        }
    }//GEN-LAST:event_btnTK_HDBanActionPerformed

    private void btnLM_HDBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLM_HDBanActionPerformed
        // TODO add your handling code here:
        show_DS_HDBan(user, pass);
        show_DS_CT_HDBan(user, pass);
    }//GEN-LAST:event_btnLM_HDBanActionPerformed

    private void btnLM_HDNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLM_HDNhapActionPerformed
        // TODO add your handling code here:
        show_DS_HDNhap(user, pass);
        show_DS_CT_HDNhap(user, pass);
    }//GEN-LAST:event_btnLM_HDNhapActionPerformed

    private void txtGanQuyenNhomQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGanQuyenNhomQuyenActionPerformed
        // TODO add your handling code here:
        frmGanQuyenUser gan_quyen  = new frmGanQuyenUser(this, true, txtTenNhomQuyen.getText(), true);
        gan_quyen.setVisible(true);
        System_DAO.show_DS_Role(dtmPhanQuyenNhomQuyen);
    }//GEN-LAST:event_txtGanQuyenNhomQuyenActionPerformed

    private void tblDSQuyenUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSQuyenUserMouseClicked
        // TODO add your handling code here:
        int rsl = tblDSQuyenUser.getSelectedRow();
        txtUserPhanQuyen.setText(tblDSQuyenUser.getValueAt(rsl, 0).toString());
        String username = tblDSQuyenUser.getValueAt(rsl, 0).toString();
        String[] lst = System_DAO.show_DS_Quyen_User_Click(username);
        lst_QuyenUser.setListData(lst);
    }//GEN-LAST:event_tblDSQuyenUserMouseClicked

    private void tblSesssion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSesssion1MouseClicked
        // TODO add your handling code here:
        int rsl = tblSesssion1.getSelectedRow();
        txtSID.setText(tblSesssion1.getValueAt(rsl, 0).toString());
        txtSerial.setText(tblSesssion1.getValueAt(rsl, 1).toString());
        txtUserSession.setText(tblSesssion1.getValueAt(rsl, 2).toString());
    }//GEN-LAST:event_tblSesssion1MouseClicked

    private void btnHuySessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuySessionActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn Hủy Session [ " + txtSID.getText() + " ] không ?",
                "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
            return;
        if (System_DAO.kill_Session(txtSID.getText(), txtSerial.getText())){
            JOptionPane.showMessageDialog(this, "Hủy Session thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            dtmSession.setRowCount(0);
            System_DAO.show_DS_Session(dtmSession);
        } else {
            JOptionPane.showMessageDialog(this, "Hủy Session không thành công !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            dtmSession.setRowCount(0);
            System_DAO.show_DS_Session(dtmSession);  
        }
    }//GEN-LAST:event_btnHuySessionActionPerformed

    private void btnTaoTablespaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoTablespaceActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn Tạo Tablespace [ " + txtTablespace_name.getText() + " ] không ?",
                "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
            return;
        if (System_DAO.create_tablesapce(txtTablespace_name.getText())){
            JOptionPane.showMessageDialog(this, "Tạo Tablespace thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            dtmTablespace.setRowCount(0);
            System_DAO.show_DS_Tablespace(dtmTablespace);
        } else {
            JOptionPane.showMessageDialog(this, "Tạo Tablespace không thành công !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            dtmTablespace.setRowCount(0);
            System_DAO.show_DS_Tablespace(dtmTablespace);
        }
    }//GEN-LAST:event_btnTaoTablespaceActionPerformed

    private void btnTaoMoiProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiProfileActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn Tạo Profile [ " + txtProfileName.getText() + " ] không ?",
                "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
            return;
        if (System_DAO.create_profile(txtProfileName.getText(), txtTGSuDung.getText(), txtSoLanDNSai.getText(),
                txtSoLanThayDoiPW.getText(), txtTGKhoaTK.getText())){
            JOptionPane.showMessageDialog(this, "Tạo Profile thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            dtmProfiles.setRowCount(0);
            System_DAO.show_DS_Profile(dtmProfiles);
        } else {
            JOptionPane.showMessageDialog(this, "Tạo Profile không thành công !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            dtmProfiles.setRowCount(0);
            System_DAO.show_DS_Profile(dtmProfiles);
        } 
    }//GEN-LAST:event_btnTaoMoiProfileActionPerformed

    private void btnXoaProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaProfileActionPerformed
        // TODO add your handling code here:
        int rsl = tblDSProfile.getSelectedRow();
        String ten_profile = tblDSProfile.getValueAt(rsl, 0).toString();
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn Xóa Profile [ " + ten_profile + " ] không ?",
                "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
            return;
        if (System_DAO.delete_profile(ten_profile)){
            JOptionPane.showMessageDialog(this, "Xóa Profile thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            dtmProfiles.setRowCount(0);
            System_DAO.show_DS_Profile(dtmProfiles);
        } else {
            JOptionPane.showMessageDialog(this, "Xóa Profile không thành công !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            dtmProfiles.setRowCount(0);
            System_DAO.show_DS_Profile(dtmProfiles);
        }         
    }//GEN-LAST:event_btnXoaProfileActionPerformed

    private void btnTaoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoUserActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn Tạo User [ " + txtUsername.getText() + " ] không ?",
                "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
            return;
        if (System_DAO.create_user(txtUsername.getText(), cboTablespace.getSelectedItem().toString(), 
                cboProfile.getSelectedItem().toString())){
            JOptionPane.showMessageDialog(this, "Tạo User thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
             dtmUser.setRowCount(0);
            System_DAO.show_DS_User(dtmUser);
        } else {
            JOptionPane.showMessageDialog(this, "Tạo User không thành công !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            dtmUser.setRowCount(0);
            System_DAO.show_DS_User(dtmUser);
        } 
    }//GEN-LAST:event_btnTaoUserActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        // TODO add your handling code here:
        int rsl = tblUser.getSelectedRow();
        txtUsername.setText(tblUser.getValueAt(rsl, 0).toString());
        cboTrangThaiUser.setSelectedItem(tblUser.getValueAt(rsl, 3));
        cboTablespace.setSelectedItem(tblUser.getValueAt(rsl, 5));
        cboProfile.setSelectedItem(tblUser.getValueAt(rsl, 6));
    }//GEN-LAST:event_tblUserMouseClicked

    private void btnXoaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaUserActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn Xóa User [ " + txtUsername.getText() + " ] không ?",
                "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
            return;
        if (System_DAO.delete_user(txtUsername.getText())){
            JOptionPane.showMessageDialog(this, "Xóa User thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
             dtmUser.setRowCount(0);
            System_DAO.show_DS_User(dtmUser);
        } else {
            JOptionPane.showMessageDialog(this, "Xóa User không thành công !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            dtmUser.setRowCount(0);
            System_DAO.show_DS_User(dtmUser);
        }        
    }//GEN-LAST:event_btnXoaUserActionPerformed

    private void btnSuaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaUserActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn Cập nhật User [ " + txtUsername.getText() + " ] không ?",
                "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
            return;
        if (System_DAO.update_user(txtUsername.getText(), cboTrangThaiUser.getSelectedItem().toString(),
                cboTablespace.getSelectedItem().toString(), cboProfile.getSelectedItem().toString())){
            JOptionPane.showMessageDialog(this, "Cập nhật User thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
             dtmUser.setRowCount(0);
            System_DAO.show_DS_User(dtmUser);
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật User không thành công !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            dtmUser.setRowCount(0);
            System_DAO.show_DS_User(dtmUser);
        }
    }//GEN-LAST:event_btnSuaUserActionPerformed

    private void btnGanQuyenUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGanQuyenUserActionPerformed
        // TODO add your handling code here:
        frmGanQuyenUser gan_quyen  = new frmGanQuyenUser(this, true, txtUserPhanQuyen.getText(), false);
        gan_quyen.setVisible(true);
        System_DAO.show_DS_User(dtmPhanQuyenUser);
    }//GEN-LAST:event_btnGanQuyenUserActionPerformed

    private void tblDSQuyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSQuyenMouseClicked
        // TODO add your handling code here:
        int rsl = tblDSQuyen.getSelectedRow();
        txtTenNhomQuyen.setText(tblDSQuyen.getValueAt(rsl, 0).toString());
        String role_name = tblDSQuyen.getValueAt(rsl, 0).toString();
        String[] lst = System_DAO.show_DS_Quyen_Role_Click(role_name);
        if (lst.length > 0)
            lst_DSPhanQuyenNhomQuyen.setListData(lst);        
        else{
            lst = new String[] {"Chưa được gán quyền"};
                   
            lst_DSPhanQuyenNhomQuyen.setListData(lst);
        } 
            
    }//GEN-LAST:event_tblDSQuyenMouseClicked

    private void txtTaoNhomQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaoNhomQuyenActionPerformed
        // TODO add your handling code here:
        frmCreateRole createRole = new frmCreateRole(this, true);
        createRole.setVisible(true);
        System_DAO.show_DS_Role(dtmPhanQuyenNhomQuyen);
    }//GEN-LAST:event_txtTaoNhomQuyenActionPerformed

    private void btnXoaTBLSpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTBLSpaceActionPerformed
        // TODO add your handling code here:
        int rsl = tblDSTablespace.getSelectedRow();
        String tablespace_name = tblDSTablespace.getValueAt(rsl, 0).toString();
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn Xóa Tablespace [ " + tablespace_name + " ] không ?",
                "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
            return;
        if (System_DAO.delete_tablespace(tablespace_name)){
            JOptionPane.showMessageDialog(this, "Xóa Tablespace thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            dtmTablespace.setRowCount(0);
            System_DAO.show_DS_Tablespace(dtmTablespace);
        }else {
            JOptionPane.showMessageDialog(this, "Xóa Tablespace không thành công !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            dtmTablespace.setRowCount(0);
            System_DAO.show_DS_Tablespace(dtmTablespace);
        }
    }//GEN-LAST:event_btnXoaTBLSpaceActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String tk = txtThongTinTK.getText();
        if (Sach_DAO.find_sach(dtmTrangChu_thongtinsach, tk, user, pass)){
            Sach_DAO.find_sach(dtmTrangChu_thongtinsach, tk, user, pass);
        }else {
            JOptionPane.showMessageDialog(this, "Không có sách cần tìm !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            show_DS_Sach(user, pass);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblDSLSDNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSLSDNMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDSLSDNMouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnTabMenu");
        pnLS_DangNhap.setName("Lịch sử đăng nhập");
        pnKTAudit.add(pnLS_DangNhap);
        pnKTAudit.setSelectedComponent(pnLS_DangNhap); 
        dtmDSLSDN = (DefaultTableModel)tblDSLSDN.getModel();
        dtmDSLSDN.setRowCount(0);
        System_DAO.show_DS_LS_DN(dtmDSLSDN);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void radTK_HDBan_maKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radTK_HDBan_maKHActionPerformed
        // TODO add your handling code here:
        txt_tk_makh.setEditable(true);
        txt_tk_makh.requestFocus();
        txt_tk_makh.selectAll();
    }//GEN-LAST:event_radTK_HDBan_maKHActionPerformed

    private void radTK_HDBan_NgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radTK_HDBan_NgayActionPerformed
        // TODO add your handling code here:
        txt_tk_makh.setEditable(false);
        
    }//GEN-LAST:event_radTK_HDBan_NgayActionPerformed

    private void radTK_HDNhap_NgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radTK_HDNhap_NgayActionPerformed
        // TODO add your handling code here:
        txt_tk_manv.setEditable(false);
    }//GEN-LAST:event_radTK_HDNhap_NgayActionPerformed

    private void radTK_HDNhap_MaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radTK_HDNhap_MaNVActionPerformed
        // TODO add your handling code here:
        txt_tk_manv.setEditable(true);
        txt_tk_manv.requestFocus();
        txt_tk_manv.selectAll();
    }//GEN-LAST:event_radTK_HDNhap_MaNVActionPerformed

    private void btnTK_HDNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTK_HDNhapActionPerformed
        // TODO add your handling code here:
        if (radTK_HDNhap_Ngay.isSelected()){
            DiaLogLich chonngay = new DiaLogLich(this, true);
            chonngay.setVisible(true);
            if (!chonngay.isKq())
                return;
            String ngay = chonngay.getNgay() + "/" + chonngay.getThang()+ "/" + chonngay.getNam();
            if ((HDNhap_DAO.tk_hdn_ngay(dtmHDNhap, ngay, user, pass))){
                HDNhap_DAO.tk_hdn_ngay(dtmHDNhap, ngay, user, pass);
            }else {
                JOptionPane.showMessageDialog(this, "Không có hóa đơn nào được lập trong ngày [" + ngay + "]", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
                show_DS_HDNhap(user, pass);
            }            
            return;
        }
        if (radTK_HDNhap_MaNV.isSelected()){
            if (HDNhap_DAO.tk_hdn_manv(dtmHDNhap, txt_tk_manv.getText(), user, pass)){
                HDNhap_DAO.tk_hdn_manv(dtmHDNhap, txt_tk_manv.getText(), user, pass);
            }else {
                JOptionPane.showMessageDialog(this, "Không có hóa đơn nào được tìm thấy !", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
                show_DS_HDNhap(user, pass);
            }        

            return;
        }
    }//GEN-LAST:event_btnTK_HDNhapActionPerformed

    private void mnuPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPolicyActionPerformed
        // TODO add your handling code here:
        cardlayout.show(pnGiaoDien, "pnTabMenu");
        pnTaoPolicy.setName("Tạo Policy");
        pnKTAudit.add(pnTaoPolicy);
        pnKTAudit.setSelectedComponent(pnTaoPolicy); 
        
        dtmDSPolicy = (DefaultTableModel) tblDSPolicy.getModel();
        System_DAO.show_DS_Policy(dtmDSPolicy);
        
        dtmDSAudit = (DefaultTableModel) tblAuditTrail.getModel();
        System_DAO.show_DS_Audit(dtmDSAudit);
    }//GEN-LAST:event_mnuPolicyActionPerformed

    private void btnAuditngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuditngayActionPerformed
        // TODO add your handling code here:
        System_DAO.show_DS_Audit_Ngay(dtmDSAudit);
    }//GEN-LAST:event_btnAuditngayActionPerformed

    private void btnTaoPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoPolicyActionPerformed
        // TODO add your handling code here:
        dialog_Tao_policy create_pl = new dialog_Tao_policy(this, true);
        create_pl.setVisible(true);
        System_DAO.show_DS_Policy(dtmDSPolicy);
    }//GEN-LAST:event_btnTaoPolicyActionPerformed

    private void btnXoaPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPolicyActionPerformed
        // TODO add your handling code here:
        int rsl = tblDSPolicy.getSelectedRow();
        String object_schema = tblDSPolicy.getValueAt(rsl, 0).toString().trim();
        String object_name = tblDSPolicy.getValueAt(rsl, 1).toString().trim();
        String policy_name = tblDSPolicy.getValueAt(rsl, 3).toString().trim();
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa Policy [" + policy_name + "] không ?", "Thông báo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
            return;
        if (System_DAO.drop_policy(object_schema, object_name, policy_name)){
            JOptionPane.showMessageDialog(this, "Xóa Policy thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            System_DAO.show_DS_Policy(dtmDSPolicy);
        }else {
            JOptionPane.showMessageDialog(this, "Xóa Policy KHÔNG thành công !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            System_DAO.show_DS_Policy(dtmDSPolicy);
        }

    }//GEN-LAST:event_btnXoaPolicyActionPerformed

    private void mnuExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExportActionPerformed
        // TODO add your handling code here:
        xuat_ds_nhanvien();
    }//GEN-LAST:event_mnuExportActionPerformed


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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAuditngay;
    private javax.swing.JButton btnBanSach;
    private javax.swing.JButton btnGanQuyenUser;
    private javax.swing.JButton btnHDBanSach;
    private javax.swing.JButton btnHDNhapSach;
    private javax.swing.JButton btnHuyMuaSach;
    private javax.swing.JButton btnHuySession;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnLM_HDBan;
    private javax.swing.JButton btnLM_HDNhap;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLuuKH;
    private javax.swing.JButton btnLuuNCC;
    private javax.swing.JButton btnLuuNV;
    private javax.swing.JButton btnLuuSach;
    private javax.swing.JButton btnMuaSach;
    private javax.swing.JButton btnNCC;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnQuanLy;
    private javax.swing.JButton btnSach;
    private javax.swing.JButton btnSuaKH;
    private javax.swing.JButton btnSuaNCC;
    private javax.swing.JButton btnSuaNV;
    private javax.swing.JButton btnSuaSach;
    private javax.swing.JButton btnSuaUser;
    private javax.swing.JButton btnTK_HDBan;
    private javax.swing.JButton btnTK_HDNhap;
    private javax.swing.JButton btnTaoMoiProfile;
    private javax.swing.JButton btnTaoPolicy;
    private javax.swing.JButton btnTaoTablespace;
    private javax.swing.JButton btnTaoUser;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnThemNCC;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JButton btnThemSach;
    private javax.swing.JButton btnThuHoiQuyenUser;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnXoaKH;
    private javax.swing.JButton btnXoaNCC;
    private javax.swing.JButton btnXoaNV;
    private javax.swing.JButton btnXoaPolicy;
    private javax.swing.JButton btnXoaProfile;
    private javax.swing.JButton btnXoaSach;
    private javax.swing.JButton btnXoaTBLSpace;
    private javax.swing.JButton btnXoaUser;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboProfile;
    private javax.swing.JComboBox<String> cboTablespace;
    private javax.swing.JComboBox<String> cboTheLoaiSach;
    private javax.swing.JComboBox<String> cboTrangThaiUser;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblAnhNhanVien;
    private javax.swing.JList<String> lst_DSPhanQuyenNhomQuyen;
    private javax.swing.JList<String> lst_QuyenUser;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mnuDX;
    private javax.swing.JMenuItem mnuDatabase;
    private javax.swing.JMenuItem mnuExport;
    private javax.swing.JMenu mnuHeThong;
    private javax.swing.JMenu mnuLSDN;
    private javax.swing.JMenuItem mnuPhanQuyenUser;
    private javax.swing.JMenuItem mnuPolicy;
    private javax.swing.JMenuItem mnuProcess;
    private javax.swing.JMenuItem mnuSaoLuu;
    private javax.swing.JMenuItem mnuSession;
    private javax.swing.JMenuItem mnuTaoNhomQuye;
    private javax.swing.JMenuItem mnuTaoTablespace;
    private javax.swing.JMenuItem mnuThoat;
    private javax.swing.JPanel pnDatabase;
    private javax.swing.JPanel pnGiaoDien;
    private javax.swing.JPanel pnHDBan;
    private javax.swing.JPanel pnHDNhap;
    private javax.swing.JTabbedPane pnKTAudit;
    private javax.swing.JPanel pnKhachHang;
    private javax.swing.JPanel pnLS_DangNhap;
    private javax.swing.JPanel pnNCC;
    private javax.swing.JPanel pnNhanVien;
    private javax.swing.JPanel pnPhanQuyenUser;
    private javax.swing.JPanel pnProcess;
    private javax.swing.JPanel pnSach;
    private javax.swing.JPanel pnSession;
    private javax.swing.JPanel pnTabMenu;
    private javax.swing.JPanel pnTaoNhomQuyen;
    private javax.swing.JPanel pnTaoPolicy;
    private javax.swing.JPanel pnTaoProfile;
    private javax.swing.JPanel pnTaoTablespace;
    private javax.swing.JPanel pnTaoUser;
    private javax.swing.JPanel pnTrangChu;
    private javax.swing.JRadioButton radTK_HDBan_Ngay;
    private javax.swing.JRadioButton radTK_HDBan_maKH;
    private javax.swing.JRadioButton radTK_HDNhap_MaNV;
    private javax.swing.JRadioButton radTK_HDNhap_Ngay;
    private javax.swing.JTable tblAuditTrail;
    private javax.swing.JTable tblCTDonBan;
    private javax.swing.JTable tblCTDonHang;
    private javax.swing.JTable tblCT_DonNhap;
    private javax.swing.JTable tblDATABASE;
    private javax.swing.JTable tblDSDonBan;
    private javax.swing.JTable tblDSDonNhap;
    private javax.swing.JTable tblDSKhachHang;
    private javax.swing.JTable tblDSLSDN;
    private javax.swing.JTable tblDSNCC;
    private javax.swing.JTable tblDSNhanVien;
    private javax.swing.JTable tblDSPolicy;
    private javax.swing.JTable tblDSProfile;
    private javax.swing.JTable tblDSQuyen;
    private javax.swing.JTable tblDSQuyenUser;
    private javax.swing.JTable tblDSSach;
    private javax.swing.JTable tblDSTablespace;
    private javax.swing.JTable tblDatafile;
    private javax.swing.JTable tblSesssion1;
    private javax.swing.JTable tblThongTinSach;
    private javax.swing.JTable tblUser;
    private javax.swing.JTable tbl_instance;
    private javax.swing.JTable tbl_process;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDiaChiNCC;
    private javax.swing.JTextField txtEmailNv;
    private javax.swing.JButton txtGanQuyenNhomQuyen;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtGioiTinhNV;
    private javax.swing.JTextField txtLienHeNCC;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaS;
    private javax.swing.JTextField txtNamXB;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNgaySinhKH;
    private javax.swing.JTextField txtNhaXuatBan;
    private javax.swing.JTextField txtProfileName;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSDTNV;
    private javax.swing.JTextField txtSID;
    private javax.swing.JTextField txtSerial;
    private javax.swing.JTextField txtSoLanDNSai;
    private javax.swing.JTextField txtSoLanThayDoiPW;
    private javax.swing.JTextField txtTGKhoaTK;
    private javax.swing.JTextField txtTGSuDung;
    private javax.swing.JTextField txtTablespace_name;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JButton txtTaoNhomQuyen;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenNCC;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTenNhomQuyen;
    private javax.swing.JTextField txtTenS;
    private javax.swing.JTextField txtThongTinTK;
    private javax.swing.JTextField txtTonKho;
    private javax.swing.JTextField txtTongTienHD;
    private javax.swing.JTextField txtUserPhanQuyen;
    private javax.swing.JTextField txtUserSession;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JButton txtXoaNhomQuyen;
    private javax.swing.JTextField txt_tk_makh;
    private javax.swing.JTextField txt_tk_manv;
    // End of variables declaration//GEN-END:variables

    private void show_DS_Sach(String user, String pass) {
        dtmTrangChu_thongtinsach.setRowCount(0);

        Sach_DAO.show_DS_Sach_TrangChu(dtmTrangChu_thongtinsach, user, pass );   
    }

    private void show_DS_NhanVien(String user, String pass) {
        dtmNhanVien.setRowCount(0);
        
        NhanVien_DAO.show_DSNhanVien(dtmNhanVien, user, pass);
        show_MacDinh_NhanVien();
    }
    
    private void show_MacDinh_NhanVien(){
        tblDSNhanVien.setRowSelectionInterval(0, 0);
        txtMaNV.setText(tblDSNhanVien.getValueAt(0, 0).toString());
        txtTenNV.setText(tblDSNhanVien.getValueAt(0, 1).toString());
        txtNgaySinh.setText(tblDSNhanVien.getValueAt(0, 2).toString());
        txtGioiTinhNV.setText(tblDSNhanVien.getValueAt(0, 3).toString());
        txtEmailNv.setText(tblDSNhanVien.getValueAt(0, 4).toString());
        txtSDTNV.setText(tblDSNhanVien.getValueAt(0, 5).toString());
        //Ảnh
    }

    private void show_DS_NhaCungCap(String user, String pass) {
        dtmNCC.setRowCount(0);
        
        NhaCungCap_DAO.show_DSNhaCUngCap(dtmNCC, user, pass);
        show_MacDinh_NhaCungCap();
    }
    
    private void show_MacDinh_NhaCungCap(){
        tblDSNCC.setRowSelectionInterval(0, 0);
        txtMaNCC.setText(tblDSNCC.getValueAt(0, 0).toString());
        txtTenNCC.setText(tblDSNCC.getValueAt(0, 1).toString());
        txtDiaChiNCC.setText(tblDSNCC.getValueAt(0, 2).toString());
        txtLienHeNCC.setText(tblDSNCC.getValueAt(0, 3).toString());
    }

    private void show_DS_ThongTinSach(String user, String pass) {
        dtmSach.setRowCount(0);
        
        Sach_DAO.show_DS_Sach(dtmSach, user, pass);
        show_MacDinh_ThongTinSach();
    }
    
    private void show_MacDinh_ThongTinSach(){
        tblDSSach.setRowSelectionInterval(0, 0);
        txtMaS.setText(tblDSSach.getValueAt(0, 0).toString());
        txtTenS.setText(tblDSSach.getValueAt(0, 1).toString());
        txtTacGia.setText(tblDSSach.getValueAt(0, 2).toString());
        txtNhaXuatBan.setText(tblDSSach.getValueAt(0, 3).toString());
        txtNamXB.setText(tblDSSach.getValueAt(0, 4).toString());
        cboTheLoaiSach.setSelectedItem(tblDSSach.getValueAt(0, 7));
        txtGiamGia.setText(tblDSSach.getValueAt(0, 5).toString());
        txtGiaBan.setText(tblDSSach.getValueAt(0, 6).toString());
        txtTonKho.setText(tblDSSach.getValueAt(0, 8).toString());
        
        Sach_DAO.load_cboTheLoai(cboTheLoaiSach, user, pass);
    }

    private void show_DS_HDBan(String user, String pass) {
        
        HDBan_DAO.show_DS_HDBan(dtmHDBan, user, pass);
    }

    private void show_DS_CT_HDBan(String user, String pass) {
        tblDSDonBan.setRowSelectionInterval(0, 0);
        CT_HDBan_DAO.show_CT_HDBan(dtmCT_HDBan, user, pass, tblDSDonBan.getValueAt(0, 0).toString());
    }

    private void show_DS_KhachHang(String user, String pass) {
        dtmKhachHang.setRowCount(0);
        
        KhachHang_DAO.show_DS_KhachHang(dtmKhachHang, user, pass);
        show_MacDinh_KhachHang();
    }
    
    private void show_MacDinh_KhachHang(){
        tblDSKhachHang.setRowSelectionInterval(0, 0);
        txtMaKH.setText(tblDSKhachHang.getValueAt(0, 0).toString());
        txtTenKH.setText(tblDSKhachHang.getValueAt(0, 1).toString());
        txtDiaChi.setText(tblDSKhachHang.getValueAt(0, 2).toString());
        txtSDT.setText(tblDSKhachHang.getValueAt(0, 3).toString());
        txtNgaySinhKH.setText(tblDSKhachHang.getValueAt(0, 4).toString());
    }

    private void show_DS_HDNhap(String user, String pass) {
        dtmHDNhap.setRowCount(0);
        
        HDNhap_DAO.show_DS_HDNhap(dtmHDNhap, user, pass);
    }

    private void show_DS_CT_HDNhap(String user, String pass) {
        tblDSDonNhap.setRowSelectionInterval(0, 0);
        CT_HDNhap_DAO.show_DS_CTHDNhap(dtmCT_HDNhap, user, pass, tblDSDonNhap.getValueAt(0, 0).toString());
    }

    private void quyen_NhanVien() {
        //pnNhanVien
        btnNhanVien.setVisible(false);
        //pnNCC
        btnThemNCC.setVisible(false);
        btnSuaNCC.setVisible(false);
        btnLuuNCC.setVisible(false);
        btnXoaNCC.setVisible(false);        
        //pnSach
        btnThemSach.setVisible(false);
        btnSuaSach.setVisible(false);
        btnLuuSach.setVisible(false);
        btnXoaSach.setVisible(false);        
        //pnKhachHang
        btnSuaKH.setEnabled(false);
        btnXoaKH.setEnabled(false);   
        btnLuuKH.setEnabled(false);
    }

    private void xuat_hoa_don(int madonhang){
        try {
            Connection con = OracleProvider.connect_database(user, pass);
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("src/gui/hoa_don.jrxml");
            map.put("MAPHIEUDH", madonhang);
            JasperPrint p = JasperFillManager.fillReport(report, map, con);
            JasperViewer.viewReport(p, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void xuat_ds_nhanvien(){
        try {
            Connection con = OracleProvider.connect_database(user, pass);
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("src/gui/ds_nhan_vien.jrxml");
            JasperPrint p = JasperFillManager.fillReport(report, map, con);
            JasperViewer.viewReport(p, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
