--TAO USER ADMIN
CREATE USER Admin_Sach IDENTIFIED BY admin123
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP
QUOTA 1M ON USERS ;


--GAN QUYEN
GRANT UNLIMITED TABLESPACE TO ADMIN_SACH;
GRANT CREATE SESSION TO ADMIN_SACH WITH ADMIN OPTION;
GRANT CREATE TABLE TO  ADMIN_SACH;
GRANT ALTER SESSION ,CREATE VIEW,CREATE SYNONYM,CREATE DATABASE LINK,CREATE SEQUENCE TO  ADMIN_SACH;
GRANT  CREATE PROCEDURE,CREATE TRIGGER, CREATE PROFILE,CREATE ROLE,CREATE USER    TO  ADMIN_SACH;

--Gán quy?n SYSDBA CHO ADMIN_SACH
GRANT  SYSDBA TO  ADMIN_SACH;
GRANT EXECUTE ANY TYPE TO  ADMIN_SACH;
GRANT EXECUTE ON DBMS_STATS TO ADMIN_SACH;
GRANT SELECT ON DBA_USERS TO ADMIN_SACH;
GRANT CONNECT, RESOURCE, DBA TO ADMIN_SACH WITH ADMIN OPTION;
GRANT SYSOPER TO ADMIN_SACH;
GRANT CREATE ROLE TO ADMIN_SACH;

--Xem USER nào có quy?n h? th?ng
SELECT * FROM v$pwfile_users;

--t?o tables_space co ten TABLES_SACH de luu cac bang trong admin
CREATE TABLESPACE TABLES_SACH DATAFILE 'C:\app\Admin\oradata\orcl2\TABLES_SACH.DBF' SIZE 10M;
--Xóa TABLESPACE
drop TABLESPACE TABLE_HELO INCLUDING CONTENTS;

------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------
---------Xem các User c?a SYS
select *from dba_users;

alter user abc
default tablespace user
profile default
account unlock;
drop user abc cascade;

SELECT DBMS_OBFUSCATION_TOOLKIT.md5(input => UTL_I18N.STRING_TO_RAW (PASSWORD||'ABAC321654', 'AL32UTF8')) from DBA_USERS;

SELECT DBMS_OBFUSCATION_TOOLKIT.MD5 (input =>
UTL_RAW.CAST_TO_RAW ()) HASH_KEY FROM DBA_USERS;

select *from DBA_USERS;



select username, DBMS_OBFUSCATION_TOOLKIT.md5(input => UTL_I18N.STRING_TO_RAW (PASSWORD||'46728595335', 'AL32UTF8')),
            to_char(created, 'fmDD - MM - YYYY'), to_char(expiry_date, 'fmDD - MM - YYYY'), 
            account_status, to_char(last_login, 'fmDD - MM - YYYY HH24:MI:SS'), default_tablespace, profile
from dba_users order by 1;

drop user user_test cascade;

revoke create session from user_test;

--Xem các b?ng c?a User Admin_Sach
select owner, table_name from dba_tables where owner = 'ADMIN_SACH';

--Xem các b?ng c?a TableSpace_Name = TABLEs_SACH
SELECT table_name, owner, tablespace_name FROM all_tables where tablespace_name='TABLES_SACH';

--Xem thông tin c?a các b?ng C?a User ADMIN_SACH
select *from Admin_Sach.THONGTINSACH;
select *from Admin_Sach.NHANVIEN;
select *from Admin_Sach.NHACUNGCAP;

--Xem các process
select pid, sosid, execution_type, pname, username, serial#, terminal, program, traceid, background from v$process;

--Xem các instance
select instance_number, instance_name, host_name, version, startup_time, status, parallel, thread#, archiver, logins, database_status, instance_role, instance_mode
from v$instance;

--Xem datafiles
select file#, creation_change#, creation_time, ts#, rfile#, status, enabled, checkpoint_change#, checkpoint_time, online_time, name
from v$datafile;

--Xem database
select name, to_char(created, 'fmDD - MM - YYYY'),  Resetlogs_time, Prior_resetlogs_time, log_mode, controlfile_type,
            controlfile_created, controlfile_time, open_resetlogs, version_time, open_mode, protection_mode
from v$database;

--Xem ds các tablespace
select *from dba_data_files;
select file_name, file_id, tablespace_name, status, relative_fno, autoextensible, online_status
from dba_data_files;
select *from dba_tablespaces;---
select tablespace_name from dba_tablespaces;

select tablespace_name, block_size, initial_extent, min_extents, max_extents, max_size, status, contents, logging, force_logging, extent_management,
allocation_type, plugged_in, segment_space_management, retention
from dba_tablespaces;

select  *from v$tablespace;

--Xem profiles
select * from DBA_PROFILES order by 1;



select distinct profile from DBA_PROFILES order by 1;

--T?o profile g?m 4 tham s?: Th?i gian s? d?ng, s? l?n ??ng nh?p sai, s? l?n thay ??i pass, th?i gian khóa n?u nh?p sai
--Tao profile gom 4 tham so: Tg Su dung, So lan DN Sai, So lan thay doi pw, Tg Khoa
create profile my_profile limit
    CPU_PER_SESSION 10000
    FAILED_LOGIN_ATTEMPTS 3
    PASSWORD_REUSE_TIME 30
    PASSWORD_REUSE_MAX 10
    PASSWORD_LOCK_TIME 1;
    
    
DROP PROFILE my_profile CASCADE;

--Xem các quy?n c?a user
select privilege from DBA_SYS_PRIVS where grantee = 'ADMIN_SACH';

--Xem Session
select sid, serial#, username, status, server, osuser, process, machine, port, program, type, logon_time, resource_consumer_group 
                    from v$session where username is not null;
alter system kill session '16, 45092' immediate;
                    
select *from ADMIN_SACH.ThongTinSach;
insert into ADMIN_SACH.ThongTinSach(MaSach, TenSach)
values(3, N'ABC');
update ThongTinSach
set TenSach = 'xcvb'
where MaSach = 3;
delete from ADMIN_SACH.ThongTinSach where MaSach = 3;    

select username, to_char(last_login, 'DD/MM/YYYY  HH12:MM:SS') from dba_users where last_login is not null order by 2 DESC;
select *from v$CONTAINERS ;


--Xem các role trong database
select *from DBA_ROLES where role = 'NV2' ;
select *from DBA_ROLE_PRIVS;
select *from role_privs;

select *from dba_profiles order by 1;

select *from DBA_TAB_PRIVS where owner != 'sys';


select privilege from role_sys_privs where ROLE = 'NV'
order by 1;

--T?o nhòm quy?n
create role nv identified by nv;
--C?p quy?n cho nhóm quy?n
grant create session, create table, create procedure, create trigger to nv;
--Xóa role
drop role 'NHANVIEN';
