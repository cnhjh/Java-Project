-- 创建表空间     表空间名            
--create tablespace text_hjh datafile 'D:\oracle\product\10.2.0\oradata\orcl\text_hjh.dbf'  size 100m 
create tablespace text_hjh datafile 'D:\oracle\product\10.2.0\oradata\orcl\text_hjh.dbf'  size 100m 
------创建用户
create user hjh identified by hjh default tablespace text_hjh;  
-----给用户授权
grant resource,connect,dba to hjh;

create tablespace entss
logging 
datafile 'D:\oracle\product\10.2.0\oradata\orcl\entss.dbf' 
size 200m 
autoextend on 
next 200m maxsize unlimited 
extent management local;
------创建用户
create user entss_hjh identified by entss_hjh default tablespace entss;  

-----给用户授权
grant resource,connect,dba to entss_hjh;


---导入数据库【命令窗口中执行】
imp entss_hjh/entss_hjh@orcl fromuser=entss touser=entss rows=y indexes=y commit=y buffer=65536 feedback=100000 ignore=n file=D:\workspace\2018010504514.dmp log=D:\workspace\2018010504514.log




--------------------------------  impdp数据库导入方式(广中医)   -----------------------------------
-- 创建目录(手动创建 D:\db_entss)
create directory alldb as 'D:\Alldb'; 
---创建表空间
create tablespace entss_gzy
logging 
datafile 'D:\oracle\product\10.2.0\oradata\orcl\entss_gzy.dbf' 
size 300m 
autoextend on 
next 300m maxsize unlimited 
extent management local;
---创建用户
create user entss_gzy identified by entss_gzy default tablespace entss_gzy;  
----给用户授权
grant resource,connect,dba to entss_gzy;
---授予用户使用文件读写的权限
Grant read,write on directory alldb to entss_gzy;

---导入数据库【命令窗口中执行】 
--impdp 用户名/密码@orcl DIRECTORY=目录名 DUMPFILE=目录内的.dmp文件  REMAP_SCHEMA=导出表的用户:导入的用户  remap_tablespace=导出表的表空间名（师姐那边的）:导入表空间名                    
impdp entss_gzy/entss_gzy@orcl DIRECTORY=alldb DUMPFILE=20180410142317.DMP  REMAP_SCHEMA=entss_gzy:entss_gzy remap_tablespace=entss_gzy:entss_gzy

------- entss 数据库导出
expdp entss_gzy/entss_gzy@orcl schemas=entss_gzy dumpfile=20180510entss_gzy.dmp logfile=entss_expdp.log DIRECTORY=alldb version=10.2.0.3.0

--四、plsql登录所导入的数据库用户，执行以下语句
-----将所有教师账号身份证号更新为空，密码更新为123，更新后可以用admin账户登录
update t_0001 set pw=md5('xfeng'||'123'),sfzh='';--若要改成其他密码，更改123为其他内容即可



------将所有学生账号身份证号更新为空，密码更新为123
update x_0001 set pw=md5('xfeng'||'123'),sfzh='';

--【注意：发给你们的数据库为学校真实的数据，供你们在本地测试使用，但请注意数据的保密性，不要随意泄漏学校的真实数据】


--五、执行ocral_wrap
--命令窗口中登录数据库用户： 
sqlplus entss_gzy0105/entss_gzy0105
sqlplus entss_gzy/entss_gzy
--执行过程文件 执行@+1130.sql的文件路径，如： 
@D:\oracle_wrap\1130.sql



select * from t_0001;--TEABH编号  ACCOUNT账号
select * from x_0001;
desc   x_0001   

-- 删除用户 （如删除失败可尝试重启 ORCL服务）
drop user entss_gzy_hjh cascade
-- 删除表空间
drop tablespace entss_gzy including contents and datafiles


---------------------------------- 获奖系统数据库 GDUT_AWARD ------------------------------------
---创建表空间
create tablespace gdut_award
logging 
datafile 'D:\oracle\product\10.2.0\oradata\orcl\gdut_award.dbf' 
size 200m 
autoextend on 
next 200m maxsize unlimited 
extent management local;
---创建用户
create user gdut_award identified by gdut_award default tablespace gdut_award;  
----给用户授权
grant resource,connect,dba to gdut_award;
---授予用户使用文件读写的权限
Grant read,write on directory alldb to gdut_award;

---导入数据库【命令窗口中执行】 
--impdp 用户名/密码@orcl DIRECTORY=目录名 DUMPFILE=目录内的.dmp文件  REMAP_SCHEMA=导出表的用户:导入的用户  remap_tablespace=导出表的表空间名（师姐那边的）:导入表空间名                   
impdp gdut_award/gdut_award@orcl DIRECTORY=alldb DUMPFILE=GDUT_AWARD.dmp  REMAP_SCHEMA=GDUT_AWARD:gdut_award remap_tablespace=GDUT_AWARD:gdut_award


-- 删除用户 （如删除失败可尝试重启 ORCL服务）
drop user gdut_award cascade
-- 删除表空间
drop tablespace gdut_award including contents and datafiles
.

--------------------------------  entss数据库导出 2018-03-19  ----------------------------------
--impdp 用户名/密码@orcl DIRECTORY=目录名 DUMPFILE=目录内的.dmp文件  REMAP_SCHEMA=导出表的表空间名:用户  remap_tablespace=导出表的表空间名（师姐那边的）:表空间名                   
impdp entss_gzy_hjh/entss_gzy_hjh@orcl DIRECTORY=entss DUMPFILE=2018010504514.dmp  REMAP_SCHEMA=entss_gzy:entss_gzy_hjh remap_tablespace=entss_gzy:entss_gzy

-- 2，expdp导出  schemas=entss_gzy_hjh（导出的用户）
expdp entss_gzy_hjh/entss_gzy_hjh@orcl schemas=entss_gzy_hjh dumpfile=20180319entss_gzy.dmp logfile=entss_expdp.log DIRECTORY=entss version=10.2.0.3.0





----------   我的数据库 ---------------
---创建表空间
create tablespace hjhsql
logging 
datafile 'D:\oracle\product\10.2.0\oradata\orcl\hjhsql.dbf' 
size 300m 
autoextend on 
next 300m maxsize unlimited 
extent management local;
---创建用户
create user hjh identified by hjh default tablespace hjhsql;  
----给用户授权
grant resource,connect,dba to hjh;
---授予用户使用文件读写的权限
Grant read,write on directory alldb to hjh;