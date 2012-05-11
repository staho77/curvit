--RUN cmd.exe AND ENTER sqlplus / as sysdba

CREATE TABLESPACE curvit DATAFILE 'D:\oraclexe\app\oracle\oradata\XE\curvit.dbf' SIZE 10M AUTOEXTEND ON NEXT 200K MAXSIZE 1000M;
create user curvit identified by xxx123 default tablespace curvit; 
grant create session to curvit; 
grant create table to curvit; 
grant create sequence to curvit; 
grant create view to curvit; 
grant create procedure to curvit; 
grant unlimited tablespace to curvit; 