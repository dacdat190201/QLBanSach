--=======================Thông tin NHÂN VIÊN 
CREATE TABLE NHANVIEN
(
	MaNV nchar(10) not null,
	TenNV nvarchar2(50),
	NgaySinh DATE,
	GioiTinh NVARCHAR2(5),
	Email NVARCHAR2(100),
	SoDT CHAR(12),
    HinhAnh BLOB,
    CONSTRAINT PK_NHANVIEN PRIMARY KEY (MaNV)
)
--Ch? n?i l?u tr? các b?ng
    TABLESPACE TABLES_SACH    
;
--=======================Thông tin KHÁCH HÀNG
CREATE TABLE KHACHHANG
(
	MaKH nchar(10) not null,
	HoTen nvarchar2(50),
	DiaChi nvarchar2(50),
	SoDT nchar(20),
	NgaySinh date,
    CONSTRAINT PK_KHACHHANG PRIMARY KEY (MaKH)
)
    TABLESPACE TABLES_SACH 
;
--==================================Qu?n lí thông tin sách
CREATE TABLE THELOAI(
	MaLoai INT NOT NULL ,
	TenLoai NVARCHAR2(50),
    CONSTRAINT PK_THELOAI PRIMARY KEY (MaLoai)
 )
    TABLESPACE TABLES_SACH 
 ;
CREATE TABLE THONGTINSACH
(
	MaSach nchar(10) not null, 
	TenSach nvarchar2(100),
	TacGia nvarchar2(100),
	NhaXB nvarchar2(100),
	NamXB int,
    MaLoai INT,
	GiamGia float,
    GiaBan NUMBER(8,2),
	constraint PK_THONGTINSACH primary key (MaSach),
    constraint FK_THONGTINSACH_THELOAI foreign key(MaLoai) references THELOAI(MaLoai) 
)
    TABLESPACE TABLES_SACH 
;
--==================================Qu?n lí thông tin nh?p sách vào
CREATE TABLE NHACUNGCAP
(
	MaNCC nchar(10) not null,
	TenNCC nvarchar2(100),
	DiaChi nvarchar2(250),
	DienThoai nchar(15),
	constraint PK_NHACUNGCAP primary key (MaNCC) 
)
    TABLESPACE TABLES_SACH 
;

CREATE TABLE PHIEUNHAPHANG
(
	MaPhieuNhapHang nchar(10) not null,
	MaNCC nchar(10),
	MaNV nchar(10),
	NgayLap_PN date,
	TongSL NUMBER,
    --Ví d?, s? (8,2) là s? có 6 ch? s? tr??c ph?n th?p phân và 2 ch? s? sau ph?n th?p phân.
	TongTien_NH NUMBER(8,2),
	constraint PK_PHIEUNHAPHANG primary key (MaPhieuNhapHang),
    constraint FK_PHIEUNHAPHANG_NHANVIEN foreign key(MaNV) references NHANVIEN(MaNV),
     constraint FK_PHIEUNHAPHANGg_NHACUNGCAP foreign key(MaNCC) references NHACUNGCAP(MaNCC)
)
    TABLESPACE TABLES_SACH 
;
CREATE TABLE CT_PHIEUNHAPHANG
(
	MaSach Nchar(10) not null,
	MaPhieuNhapHang nchar(10) not null,
	Sluong number,
	DonGiaNhap NUMBER(8,2) check(DonGiaNhap >= 0),
	TongTien NUMBER(8,2),
	constraint PK_CT_PHIEUNHAPHANG  primary key (MaSach, MaPhieuNhapHang),
    constraint FK_CT_PHIEUNHAPHANG_PNH foreign key (MaPhieuNhapHang) references PHIEUNHAPHANG(MaPhieuNhapHang),
	constraint FK_CT_PHIEUNHAPHANG_TTS foreign key (MaSach) references THONGTINSACH(MaSach)
)
   TABLESPACE TABLES_SACH 
;

CREATE TABLE SACHTONKHO
(
	MaSach nchar(10) not null,
	SoLuongTon Number,
	constraint PK_SACHTONKHO primary key (MaSach)
)
   TABLESPACE TABLES_SACH 
;
--=======================Qu?n lí ??n ??t Hàng
CREATE TABLE PHIEUDATHANG
(
	MaPhieuDH int not null,
    MaNV nchar(10),
	MaKH nchar(10),
	NgayLap_DH DATE,
	Tong_SL_Dat NUMBER,
	TongTien NUMBER(8,2) check(TongTien >= 0),
	constraint PK_PHIEUDATHANG primary key (MaPhieuDH), 
    constraint FK_PHIEUDATHANG_NV foreign key (MaNV) references NHANVIEN(MaNV),
    constraint FK_PHIEUDATHANG_KH foreign key(MaKH) references KHACHHANG(MaKH)
)
    TABLESPACE TABLES_SACH
;

CREATE TABLE CT_PHIEUDATHANG
(
	MaPhieuDH int not null,
	MaSach nchar(10) not null ,
	SoLuong number,
	DonGia  NUMBER(8,2) check(DonGia >= 0),
	ThanhTien NUMBER(8,2) check(ThanhTien >= 0),
    constraint PK_CT_PHIEUDATHANG primary key (MaPhieuDH,MaSach),
    constraint FK_CT_PHIEUDATHANG_PDT foreign key(MaPhieuDH) references PHIEUDATHANG(MaPhieuDH),
    constraint FK_CT_PHIEUDATHANG_TTS foreign key(MaSach) references THONGTINSACH(MaSach)
)
    TABLESPACE TABLES_SACH 
;
--------------------------------------------------------------------------------
--tao cau lenh tu dongtang id moi khi them vao bang the loai 
CREATE SEQUENCE ID_THELOAI
    MINVALUE 1
    MAXVALUE 10000
    START WITH 1
    INCREMENT BY 1;
--DROP  SEQUENCE ID_THELOAI
--Ch?ng ta d?ng mot trigger  DE KICH HOAT Sequence 
CREATE OR REPLACE TRIGGER AUTO_ID_THELOAI_TRIGGER
BEFORE INSERT
ON THELOAI
FOR EACH ROW
    BEGIN
      SELECT ID_THELOAI.NEXTVAL
      INTO   :new.MALOAI
      FROM   dual;
    END;
------------------------------------------------------------them du lieu b?ng NV
INSERT INTO NHANVIEN
VALUES ('NV001', N'Nguyen Tuan Anh',TO_DATE('21/9/1989', 'DD/MM/YYYY'), N'Nam', N'nguyentuananh@gmail.com', '0937940673',NULL);
INSERT INTO NHANVIEN
VALUES('NV002', N'Bui Thi Ai Ly', TO_DATE('21/6/2001', 'DD/MM/YYYY'), N'Nu', N'aily@gmail.com', '0920392050',null);
INSERT INTO NHANVIEN
VALUES('NV003', N'Pham Tuan Dat', TO_DATE('1/3/1989', 'DD/MM/YYYY'), N'Nam', N'tuandat@gmail.com', '0920392050',null);
INSERT INTO NHANVIEN
VALUES('NV004', N'Nguyen Dac Dat', TO_DATE('15/9/1989', 'DD/MM/YYYY'), N'Nam', N'datdac@gmail.com', '0920392050',null);

------------------------------------------------------------them du lieu b?ng KH
INSERT INTO KhachHang
VALUES  ('KH01','Nguyen Van A','731 Tran Hung Dao, Q5, TpHCM','0321654987',TO_DATE('1/5/1999', 'DD/MM/YYYY'));
INSERT INTO KhachHang
VALUES  ('KH02','Tran Ngoc Han','23/5 Nguyen Trai, Q5, TpHCM','0987456321',TO_DATE('03/04/1974', 'DD/MM/YYYY'));
INSERT INTO KhachHang
VALUES  ('KH03','Tran Ngoc Linh','45 Nguyen Canh Chan, Q1, TpHCM','0123456798',TO_DATE('12/06/1980', 'DD/MM/YYYY'));
INSERT INTO KhachHang
VALUES  ('KH04','Tran Minh Long','50/34 Le Dai Hanh, Q10, TpHCM','0321654789',TO_DATE('09/03/1965', 'DD/MM/YYYY'));
INSERT INTO KhachHang
VALUES  ('KH05','Le Nhat Minh','34 Truong Dinh, Q3, TpHCM','0123654987',TO_DATE('10/03/1950', 'DD/MM/YYYY'));
INSERT INTO KhachHang
VALUES  ('KH06','Le Hoai Thuong','227 Nguyen Van Cu, Q5, TpHCM','0256479831',TO_DATE('31/12/1981', 'DD/MM/YYYY'));
INSERT INTO KhachHang
VALUES  ('KH07','Nguyen Van Tam','32/3 Tran Binh Trong, Q5, TpHCM','0123597418',TO_DATE('06/04/1971', 'DD/MM/YYYY'));

-------------------------------------------------------them du lieu b?ng THELOAI
INSERT INTO THELOAI VALUES (1, N'Sach Giao Khoa');
INSERT INTO THELOAI VALUES (2, N'Sach Kinh Te');
INSERT INTO THELOAI VALUES (3, N'Sach Van Hoc Trong Nuoc');
INSERT INTO THELOAI VALUES (4, N'Sach Van Hoc Ngoai Nuoc');
INSERT INTO THELOAI VALUES (5, N'Sach Khoa Hoc');
INSERT INTO THELOAI VALUES (6, N'Sach Thieu Nhi');
INSERT INTO THELOAI VALUES (7, N'Sach Phat Trien Ban Than');
INSERT INTO THELOAI VALUES (8, N'Sach Tin Hoc - Ngoai Ngu');

------------------------------------------------them du lieu b?ng THONG TIN SACH
INSERT INTO ThongTinSach VALUES ('S010', N'Sach tu nhien', N'Pha Tu Da', N'Nha Xuat Ban Gia Dinh', 2018,1,0,23000 );
INSERT INTO ThongTinSach VALUES	('S011',N'Toan a2',N'Dinh Xuan Ngoc',N'Nha Xuat Ban Giao Duc',2018,3,0,23000);
INSERT INTO ThongTinSach VALUES ('S012',N'Hat giong toi loi',N'Nguyen Van Vu',N'Kim Dong',1999,2,0,31000);
INSERT INTO ThongTinSach VALUES	('S013',N'Tom and Jerry',N'Tran Van Tuan',N'Nha xuat ban Tre',1980,6,0,25600);
INSERT INTO ThongTinSach VALUES ('S014',N'Truyen Doremon',N'Ho The Anh',N'Nha xuat ban Tre',1990,6,0,80000);
INSERT INTO ThongTinSach VALUES ('S015',N'Tam ly hoc ',N'Doan Thi Hoa',N'Nha xuat ban lao dong',2001,1,0,21010);
INSERT INTO ThongTinSach VALUES	('S016',N'Ngu Phap Tieng Anh',N'Nguyen Anh Dao',N'Tu Dien Bach Khoa',2008,8,0,24500);
INSERT INTO ThongTinSach VALUES ('S017',N'Bat tre dong xanh',N'Nguyen Hoang Nam',N' Khoa hoc va ky thuat',2013,5,0,82000);
INSERT INTO ThongTinSach VALUES ('S018',N'Toi ac tru tri',N'Tran Van Tuan',N'Nha xuat ban Tu phap',2002,7,0,65700);
INSERT INTO ThongTinSach VALUES	('S019', N'Hoi Xuan', N'Nguyen Tien Huy', N'Nha xuat ban Tre', 2019,8,0,21300);	

----------------------------------------------------them du lieu b?ng NHACUNGCAP
INSERT INTO NhaCungCap
VALUES('NCC01', N'Nha cung cap Binh Duong', N'Di An, Thu Dau 1, Binh Duong','0123684273');
INSERT INTO NhaCungCap
VALUES	('NCC02',N'Nha cung cap TP.HCM',N'Quan 11, TPHCM','0371231011');
INSERT INTO NhaCungCap
VALUES	('NCC03',N'Nha cung cap Binh Chanh',N'Quan Binh Chanh, TP.HCM','0232391209');
INSERT INTO NhaCungCap
VALUES	('NCC04',N'Nha cung cap Ha Noi',N'12 Nguyen Thi Sau, Ha Noi','0823481910');
INSERT INTO NhaCungCap
VALUES	('NCC05',N'Nha cung cap Ninh Thuan',N'Nguyen Thai Tong,Ninh Thuan','0321456987');
INSERT INTO NhaCungCap
VALUES	('NCC06',N'Nha cung cap Tay Ninh ',N'11 Vo Sau,Tay Ninh','0234731209');
INSERT INTO NhaCungCap
VALUES  ('NCC07',N'Nha cung cap Dong Nai',N'1123 Hoang Hoa Tham ,Dong Nai','0123456897');

-------------------------------------------------them du lieu b?ng PHIEUNHAPHANG
INSERT INTO PHIEUNHAPHANG
VALUES ('NH1','NCC01','NV001',TO_DATE('21/9/2020', 'DD/MM/YYYY'),4,43000);
INSERT INTO PHIEUNHAPHANG
VALUES('NH2','NCC02','NV002',TO_DATE('21/4/2020', 'DD/MM/YYYY'),12,69000);
INSERT INTO PHIEUNHAPHANG
VALUES	('NH3','NCC03','NV003',TO_DATE('11/01/2021', 'DD/MM/YYYY'),65,77000);
INSERT INTO PHIEUNHAPHANG
VALUES	('NH4','NCC01','NV003',TO_DATE('26/09/2010', 'DD/MM/YYYY'),20,54000);
INSERT INTO PHIEUNHAPHANG
VALUES	('NH5','NCC05','NV001',TO_DATE('13/7/2010', 'DD/MM/YYYY'),102,102000);

INSERT INTO CT_PHIEUNHAPHANG
VALUES('S014','NH1',2,29000,58000);
INSERT INTO CT_PHIEUNHAPHANG
VALUES('S011','NH4',2,15000,30000);
INSERT INTO CT_PHIEUNHAPHANG
VALUES('S012','NH1',4,20000,11000);
INSERT INTO CT_PHIEUNHAPHANG
VALUES('S013','NH2',50,10000,26500);
INSERT INTO CT_PHIEUNHAPHANG
VALUES('S014','NH3',150,14000,31500);
INSERT INTO CT_PHIEUNHAPHANG
VALUES('S015','NH3',10,21000,21000);
INSERT INTO CT_PHIEUNHAPHANG
VALUES('S016','NH5',50,30000,43000);

----------------------------------------------------them du lieu b?ng SL TON KHO
INSERT INTO SachTonKho
VALUES	('S010',100);
INSERT INTO SachTonKho
VALUES	('S011',200);
INSERT INTO SachTonKho
VALUES	('S012',300);
INSERT INTO SachTonKho
VALUES	('S013',400);
INSERT INTO SachTonKho
VALUES	('S014',150);
INSERT INTO SachTonKho
VALUES	('S015',250);
INSERT INTO SachTonKho
VALUES	('S016',250);
INSERT INTO SachTonKho
VALUES	('S017',250);
INSERT INTO SachTonKho
VALUES	('S018',250);
INSERT INTO SachTonKho
VALUES	('S019',250);
select * from thongtinsach;
--------------------------------------------------them du lieu b?ng don ban hang
select * from CT_PHIEUDATHANG;
select * from PHIEUDATHANG;
INSERT INTO PHIEUDATHANG VALUES(1,'NV001','KH01',TO_DATE('1/4/2020 09:47:33', 'DD/MM/YYYY HH:MI:SS'),6,200000);
INSERT INTO PHIEUDATHANG VALUES(2,'NV003','KH03',TO_DATE('23/5/2020 09:47:33', 'DD/MM/YYYY HH:MI:SS'),8,600000);
INSERT INTO PHIEUDATHANG  VALUES(3,'NV002','KH01',TO_DATE('15/05/2021 09:47:33', 'DD/MM/YYYY HH:MI:SS'),3,400000);
INSERT INTO PHIEUDATHANG VALUES(5,'NV003','KH04',TO_DATE('08/06/2021 09:47:33', 'DD/MM/YYYY HH:MI:SS'),4,600000);
INSERT INTO PHIEUDATHANG  VALUES(6,'NV001','KH03',TO_DATE('13/09/2021 09:47:33', 'DD/MM/YYYY HH:MI:SS'),2,400000);

INSERT INTO CT_PHIEUDATHANG VALUES(1,'S015',2,100000,2*100000);
INSERT INTO CT_PHIEUDATHANG VALUES(2,'S012',2,300000,2*300000);
INSERT INTO CT_PHIEUDATHANG VALUES(3,'S019',1,400000,400000);
INSERT INTO CT_PHIEUDATHANG VALUES(5,'S014',3,200000,3*200000);
INSERT INTO CT_PHIEUDATHANG VALUES(6,'S012',1,400000,400000);

----------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------
select *from NHANVIEN;
select *from NHACUNGCAP;
select *from THONGTINSACH;
select *from PHIEUNHAPHANG;
select *from CT_PHIEUNHAPHANG;
select *from SACHTONKHO;
select *from PHIEUDATHANG;
select *from CT_PHIEUDATHANG;
select *from KHACHHANG;

delete from CT_PHIEUDATHANG;
delete from PHIEUDATHANG;
delete from SACHTONKHO;
delete from CT_PHIEUNHAPHANG;
delete from PHIEUNHAPHANG;
delete from NHACUNGCAP;
delete from THONGTINSACH;
delete from THELOAI;
delete from nhanvien; 
delete from KHACHHANG;

drop table CT_PHIEUDATHANG;
drop table PHIEUDATHANG;
drop table SACHTONKHO;
drop table CT_PHIEUNHAPHANG;
drop table PHIEUNHAPHANG;
drop table NHACUNGCAP;
drop table THONGTINSACH;
drop table THELOAI;
drop table nhanvien;

----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------TAO TRIGGER GHI NHAN LICH SU DANG NHAP _ DANG XUAT 
--XEM THONG TIN AI USER DANG NHAP
CREATE TABLE event_users_log (
  user_name VARCHAR2(30),
  activity VARCHAR2(20),
  logon_date  VARCHAR2 (15),
  logon_time VARCHAR2 (15)
);

--XEM THONG TIN AI USER DANG XUAT
CREATE OR REPLACE TRIGGER event_logon_trigger
  AFTER LOGON
  ON DATABASE
BEGIN
  INSERT INTO event_users_log (user_name, activity, logon_date,logon_time)
  VALUES (USER, 'LOGON', TO_CHAR(SYSDATE,'DD/MM/YYYY'),TO_CHAR(SYSDATE,'HH24:MI:SS'));
END;

--XEM THONG TIN AI USER DANG XUAT
CREATE OR REPLACE TRIGGER event_logoff_trigger
  BEFORE LOGOFF
  ON DATABASE
BEGIN
  INSERT INTO event_users_log (user_name, activity, logon_date,logon_time)
  VALUES (USER, 'LOGOFF', TO_CHAR(SYSDATE,'DD/MM/YYYY'),TO_CHAR(SYSDATE,'HH24:MI:SS'));
END;

select * from ADMIN_SACH.event_users_log where activity = 'LOGON'
order by logon_date DESC, logon_time DESC
offset 1 rows fetch next 1 rows only;

----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------
---------------------TAO CAC ROLE NHANVIEN - QUANLY-------------------------------------------------------------
--TAO NHOM QUYEN
CREATE ROLE role_NHANVIEN;
CREATE ROLE role_QUANLY;
--XOA NHOM QUYEN
DROP ROLE role_NhanVien;
----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------
------------------GAN QUYEN CHO ROLE role_NHANVIEN--------------------------------------------------------------
GRANT SELECT,INSERT ON KHACHHANG TO role_NHANVIEN;
GRANT SELECT ON NHANVIEN TO role_NHANVIEN;
GRANT SELECT ON THONGTINSACH TO role_NHANVIEN;
GRANT SELECT ON THELOAI TO role_NHANVIEN;
GRANT SELECT ON NHACUNGCAP TO role_NHANVIEN;
GRANT SELECT,INSERT,UPDATE ON PHIEUNHAPHANG TO role_NHANVIEN;
GRANT SELECT ON CT_PHIEUNHAPHANG TO role_NHANVIEN;
GRANT SELECT ON SACHTONKHO TO role_NHANVIEN;
GRANT SELECT,INSERT,UPDATE ON PHIEUDATHANG TO role_NHANVIEN;
GRANT SELECT ON CT_PHIEUDATHANG TO role_NHANVIEN;
----==========================GAN QUYEN THUC THI TREN
GRANT EXECUTE ON return_table TO role_NHANVIEN;
GRANT EXECUTE ON Return_TableDHKH TO role_NHANVIEN;
GRANT EXECUTE ON Return_TableDHNV TO role_NHANVIEN;
GRANT EXECUTE ON Return_Table_TK_Ngay TO role_NHANVIEN;
GRANT EXECUTE ON tk_sach TO role_NHANVIEN;
GRANT EXECUTE ON tk_sach_gia_ban TO role_NHANVIEN;
GRANT EXECUTE ON tk_nhap_hang_ngay TO role_NHANVIEN;
GRANT EXECUTE ON tk_nhap_hang_manv TO role_NHANVIEN;

----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------
------------------GAN QUYEN CHO ROLE role_QUANLY----------------------------------------------------------------
GRANT SELECT,INSERT,UPDATE,DELETE ON THELOAI TO role_QUANLY;
GRANT SELECT,INSERT,UPDATE,DELETE ON NHANVIEN TO role_QUANLY;
GRANT SELECT,INSERT,UPDATE,DELETE ON THONGTINSACH TO role_QUANLY;
GRANT SELECT,INSERT,UPDATE,DELETE ON KHACHHANG TO role_QUANLY;
GRANT SELECT,INSERT,UPDATE,DELETE ON NHACUNGCAP TO role_QUANLY;
GRANT SELECT,INSERT,UPDATE,DELETE ON PHIEUNHAPHANG TO role_QUANLY;
GRANT SELECT,INSERT,UPDATE,DELETE ON CT_PHIEUNHAPHANG TO role_QUANLY;
GRANT SELECT,INSERT,UPDATE,DELETE ON SACHTONKHO TO role_QUANLY;
GRANT SELECT,INSERT,UPDATE,DELETE ON PHIEUDATHANG TO role_QUANLY;
GRANT SELECT,INSERT,UPDATE,DELETE ON CT_PHIEUDATHANG TO role_QUANLY;
----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------
--------------------------------TAO CAC USER NHAN VIEN----------------------------------------------------------
--------------------------------------------------------------
CREATE USER NV_AILY IDENTIFIED BY aily
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP
QUOTA 1M ON USERS ;
--------------------------------------------------------------
CREATE USER NV_DACDAT IDENTIFIED BY dacdat
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP
QUOTA 1M ON USERS ;
--------------------------------------------------------------
CREATE USER NV_TUANDAT IDENTIFIED BY tuandat
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP
QUOTA 1M ON USERS ;
--------------------------------------------------------------
--------------------------------------------------------------
----------------GAN QUYEN TAO KET NOI CHO USER----------------
GRANT CREATE SESSION TO NV_AILY;
GRANT CREATE SESSION TO NV_DACDAT;
GRANT CREATE  SESSION TO NV_TUANDAT;
----------------GAN ROLE CHO USERS
GRANT role_NHANVIEN TO NV_TUANDAT;
GRANT role_NHANVIEN TO NV_DACDAT;
GRANT role_NHANVIEN TO NV_AILY;
----------------THU HOI QUYEN USER
REVOKE  role_NHANVIEN FROM NV_AILY;
REVOKE  role_NHANVIEN FROM NV_DACDAT;
REVOKE  role_NHANVIEN FROM NV_TUANDAT;
 
----------------TAO PROFILE CHO CAC USER
CREATE PROFILE "PROFILE_NHANVIEN" LIMIT
    FAILED_LOGIN_ATTEMPTS 3 --slan co gang ket noi  hong
    password_life_time 60 --tg toi thieu su dung mot mk
    password_grace_time 7 --tg gia han ke tu sau khi mk het han
    password_reuse_max UNLIMITED; --tg tai sudung mk la vo han
----------------XOA PROFILE 
DROP PROFILE "PROFILE_NHANVIEN" CASCADE;
----------------GAN PROFILE
ALTER USER NV_AILY  PROFILE PROFILE_NHANVIEN;
        
----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------
--------------------------------TAO CAC FUNCTION TIM KIEM, HIEN THI---------------------------------------------
----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------
----------------------------------------FUNCTION TIM KIEM SACH THEO TEN SACH, TAC GIA
create or replace type tim_kiem_sach as object(
    v_MaSach         nvarchar2(100),
    v_TenSach      nvarchar2(100),
    v_TacGia       nvarchar2(100),
    v_NhaXB        nvarchar2(100),
    v_NamXB        int,
    v_TenLoai      nvarchar2(100),
    v_GiamGia      float,
    v_GiaBan       NUMBER(8,2)
)
create or replace type ds_sach is table of tim_kiem_sach;
------TIM KIEM THEO TEN - TAC GIA
create or replace function tk_sach(dieu_kien in nvarchar2)
return ds_sach 
as
    ds ds_sach;
begin
    select tim_kiem_sach(a.MaSach,a.TenSach,a.TacGia,a.NhaXB,a.NamXB,c.TenLoai,a.GiamGia,a.GiaBan)
    bulk collect into ds
    from ThongTinSach a,SachTonKho b,TheLoai c
    where a.MaSach=b.MaSach AND a.MaLoai=c.MaLoai
    and (a.TenSach = (tk_sach.dieu_kien) or a.TacGia = (tk_sach.dieu_kien));
    
    return ds;
end tk_sach;
select *from table(ADMIN_SACH.tk_sach('Doan Thi Hoa')); 

------TIM KIEM THEO GIA BAN
create or replace function tk_sach_gia_ban(dieu_kien in number)
return ds_sach 
as
    ds ds_sach;
begin
    select tim_kiem_sach(a.MaSach,a.TenSach,a.TacGia,a.NhaXB,a.NamXB,c.TenLoai,a.GiamGia,a.GiaBan)
    bulk collect into ds
    from ThongTinSach a,SachTonKho b,TheLoai c
    where a.MaSach=b.MaSach AND a.MaLoai=c.MaLoai
    and (a.GiaBan = (tk_sach_gia_ban.dieu_kien));
    
    return ds;
end tk_sach_gia_ban;
select *from table(ADMIN_SACH.tk_sach_gia_ban(80000));

--------------------------------------------------------------
------------------------------FUNCTION HIEN THI THONG TIN SACH
CREATE OR REPLACE TYPE kieu_dl_trave as object (
    v_MaSach         nvarchar2(100),
    v_TenSach      nvarchar2(100),
    v_TacGia       nvarchar2(100),
    v_NhaXB        nvarchar2(100),
    v_NamXB        int,
    v_GiamGia      float,
    v_GiaBan       NUMBER(8,2),
    v_TenLoai      nvarchar2(100),
    v_SoLuongTon   INT 
)
CREATE OR REPLACE TYPE  t_table as table of kieu_dl_trave;
CREATE OR REPLACE FUNCTION return_table RETURN t_table
AS
   l_strings   t_table;
BEGIN
    SELECT kieu_dl_trave(a.MaSach,a.TenSach,a.TacGia,a.NhaXB,a.NamXB,a.GiamGia,a.GiaBan,c.TenLoai,b.SoLuongTon  )
    BULK COLLECT INTO  l_strings
    from ThongTinSach a,SachTonKho b,TheLoai c
    where a.MaSach=b.MaSach AND a.MaLoai=c.MaLoai
    order by a.MaSach;
    RETURN l_strings;
END;
SELECT * FROM TABLE (ADMIN_SACH.return_table());

select v_MaSach, v_TenSach, v_TacGia, v_NhaXB, v_NamXB, v_TenLoai, v_GiamGia, v_GiaBan
from table (ADMIN_SACH.return_table());
--xóa
drop type     t_table;
drop type   kieu_dl_trave;
drop function return_table;

--------------------------------------------------------------------------------
----------------------------------------TIM KIEM DON DAT HANG THEO MA KHACH HANG
Create Or Replace Type Timkiem_DH_MaKH As Object (
    V_Maphieudh        Nchar(10),
    V_Manv       Nchar(10),
     V_Makh       Nchar(10),
    V_Ngaylap_dh Date,
    V_Tong_Sl_Dat Number,
     V_TongTien Number(8)
);
Create Or Replace Type  TimDHKH_Table As Table Of Timkiem_DH_MaKH;
Create Or Replace Function Return_TableDHKH(MaKH In Nchar) 
RETURN TimDHKH_Table
As
   l_strings  TimDHKH_Table;
Begin
    SELECT  Timkiem_DH_MaKH(a.MaPhieuDH, a.MaNV, a.MaKH,a.NgayLap_DH,a.Tong_Sl_Dat,a.TongTien)
    Bulk Collect Into  l_Strings
    From Phieudathang A
    where a.MaKH=(Return_TableDHKH.MaKH);
    Return L_Strings;
End;
Select V_Maphieudh,V_Manv,V_Makh,To_Char(V_Ngaylap_Dh,'DD/MM/YYYY'),V_Tong_Sl_Dat,V_Tongtien   
From Table (ADMIN_SACH.Return_TableDHKH('KH01'));

----------------------------------------------------------------------------------------
----------------------------------------FUNCTION TIM KIEM DON DAT HANG THEO MA NHAN VIEN
Create Or Replace Type Timkiem_DH_MaNV As Object (
    V_Maphieudh        Nchar(10),
    V_Manv       Nchar(10),
     V_Makh       Nchar(10),
    V_Ngaylap_dh Date,
    V_Tong_Sl_Dat Number,
     V_TongTien Number(8)
);
Create Or Replace Type  TimDHNV_Table As Table Of Timkiem_DH_MaNV;
Create Or Replace Function Return_TableDHNV(MaNV In Nchar) 
RETURN TimDHNV_Table
As
   l_strings  TimDHNV_Table;
Begin
    SELECT  Timkiem_DH_MaNV(a.MaPhieuDH, a.MaNV, a.MaKH,a.NgayLap_DH,a.Tong_Sl_Dat,a.TongTien)
    Bulk Collect Into  l_Strings
    From Phieudathang A
    where a.MaNV=(Return_TableDHNV.MaNV);
    Return L_Strings;
End;
Select V_Maphieudh,V_Manv,V_Makh,To_Char(V_Ngaylap_Dh,'DD/MM/YYYY'),V_Tong_Sl_Dat,V_Tongtien   
From Table (ADMIN_SACH.Return_TableDHNV('NV001'));

-------------------------------------------------------------------------------------
----------------------------------------FUNCTION TIM KIEM DON HANG THEO NGAY DAT HANG
Create Or Replace Type Timkiem_Dhnb As Object (
    V_Maphieudh        Nchar(10),
    V_Manv       Nchar(10),
     V_Makh       Nchar(10),
    V_Ngaylap_dh Date,
    V_Tong_Sl_Dat Number,
     V_TongTien Number(8)
);
Create Or Replace Type  Timdhnb_Table As Table Of Timkiem_Dhnb;

Create Or Replace Function Return_Table_TK_Ngay(Ngaylap_Dh In Date) 
RETURN Timdhnb_Table
As
   l_strings   Timdhnb_Table;
Begin
    SELECT Timkiem_dhnb(a.MaPhieuDH, a.MaNV, a.MaKH,a.NgayLap_DH,a.Tong_Sl_Dat,a.TongTien)
    Bulk Collect Into  L_Strings
    From Phieudathang A
    where to_char(a.NGAYLAP_DH, 'DD/MM/YYYY') = to_date((Return_Table_TK_Ngay.NgayLap_DH), 'DD/MM/YYYY');
    Return L_Strings;
End;
Select V_Maphieudh,V_Manv,V_Makh,To_Char(V_Ngaylap_Dh,'DD/MM/YYYY'),V_Tong_Sl_Dat,V_Tongtien
From Table (ADMIN_SACH.Return_Table_TK_Ngay('23/5/2020'));

drop type     Timkiem_Dhnb;
drop type   Timdhnb_Table;
drop function Return_Table_TK_Ngay;

--------------------------------------------------------------------------------------
----------------------------------------FUNCTION TIM KIEM DON HANG THEO NGAY NHAP HANG
Create Or Replace Type Don_nhap_sach As Object (
    V_Maphieunhap        Nchar(10),
    V_MaNCC       Nchar(10),
    V_Manv       Nchar(10),
    V_Ngaylap_pn Date,
    V_Tong_Sl_Nhap Number,
    V_TongTien_nhap Number(8)
);
Create Or Replace Type  tk_don_nhap_hang As Table Of Don_nhap_sach;
---TIM KIEM DON NHAP HANG THEO NGAY
Create Or Replace Function tk_nhap_hang_ngay(Ngaylap_pn In Date) 
RETURN tk_don_nhap_hang
As
   l_strings   tk_don_nhap_hang;
Begin
    SELECT Don_nhap_sach(a.MAPHIEUNHAPHANG, a.MANCC, a.MANV, a.NGAYLAP_PN, a.TONGSL, a.TONGTIEN_NH)
    Bulk Collect Into  L_Strings
    From PHIEUNHAPHANG A
    where to_char(a.NGAYLAP_PN, 'DD/MM/YYYY') = to_date((tk_nhap_hang_ngay.Ngaylap_pn), 'DD/MM/YYYY');
    Return L_Strings;
End;
Select V_Maphieunhap,V_MaNCC,V_Manv,To_Char(V_Ngaylap_pn,'DD/MM/YYYY'),V_Tong_Sl_Nhap,V_TongTien_nhap
From Table (ADMIN_SACH.tk_nhap_hang_ngay('21/04/2020'));

---TIM KIEM DON NHAP HANG THEO MANV
Create Or Replace Function tk_nhap_hang_manv(MaNV In nchar) 
RETURN tk_don_nhap_hang
As
   l_strings   tk_don_nhap_hang;
Begin
    SELECT Don_nhap_sach(a.MAPHIEUNHAPHANG, a.MANCC, a.MANV, a.NGAYLAP_PN, a.TONGSL, a.TONGTIEN_NH)
    Bulk Collect Into  L_Strings
    From PHIEUNHAPHANG A
    where A.MANV = (tk_nhap_hang_manv.MaNV);
    Return L_Strings;
End;
Select V_Maphieunhap,V_MaNCC,V_Manv,To_Char(V_Ngaylap_pn,'DD/MM/YYYY'),V_Tong_Sl_Nhap,V_TongTien_nhap
From Table (ADMIN_SACH.tk_nhap_hang_manv('NV001'));


























