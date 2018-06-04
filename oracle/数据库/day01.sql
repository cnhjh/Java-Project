SQL语句不区分大小写
--SELECT SYSDATE FROM dual

--SQL语句分为：
--DDL,DML,TCL,DQL,DCL
==========================================================
--####################  DDL:数据定义语言 ----> 表增删改  字段增删改 #################### 
--DDL用于维护数据库对象使用
--数据库对象:表，视图，索引，序列。

--1:创建表
CREATE TABLE employee_hujinghao(
	id NUMBER(4),
	name VARCHAR2(20),
	gender CHAR(1),
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
)

--查看表结构 
--DESC XXXX
DESC employee_hujinghao
desc employee_hujinghao
--删除表
--DROP TABLE XXXX
DROP TABLE employee_hujinghao
drop table employee_hujinghao

--在数据库中，所有字段的默认值都是NULL，可以南通过DEFAULT关键字
--指定一个默认值。对于字符串而言，数据库中字面量是使用单引号括起来的
--这一点需要与java区分记忆。并且。虽然SQL语句本身不区分大小写，但是字符串值
--是区分大小写的。
--
CREATE TABLE employee_hujinghao(
   id NUMBER(4),
   name VARCHAR2(20),
   gender CHAR(1) DEFAULT 'M', 
   birth DATE,
   salary NUMBER(6,2) DEFAULT 3000,
   job VARCHAR2(30),
   deptno NUMBER(2)
);
desc table employee_hujinghao
select * from EMPLOYEE_HUJINGHAO

--NOT NULL约束
--当一个字段被NOT NULL 修饰后，该字段不允许为空
--与DEFAULT互斥。
--显示出来
CREATE TABLE employee_hujinghao(
    id NUMBER(4),
    name VARCHAR2(20) NOT NULL,
    gender VARCHAR2(20) DEFAULT 'M', 
    birth DATE,
    salary NUMBER(6,2) DEFAULT 3000,
    job VARCHAR2(30),
    deptno NUMBER(2)
);
--查看表结构
DESC employee_hujinghao
rename employee_hujinghao to myemp_hujinghao
desc myemp_hujinghao
--修改表
--1：修改表名
--2：修改表结构

--修改表名
--RENAME old_name TO mew_name
--如:
RENAME employee_hujinghao To myemp_hujinghao
DESC myemp_hujinghao
 
--改表结构 
--1：添加新的字段
--2：修改现有子段
--3：删除现有字段

-- 添加新字段
ALTER TABLE myemp_hujinghao ADD(hiredate DATE)
select * from myemp_hujinghao
    
--删除现有字段
ALTER TABLE myemp_hujinghao DROP( hiredate)


DESC myemp_hujinghao
--DROP TABLE myemp_hujinghao

--修改现有字段
--可以修改字段的类型，长度，默认值，非空约束
--但是应当在表中没有数据的时候进行,  否则尽量不要
--修改类型,长度尽量只增不减。否则可能会修改失败。
ALTER TABLE myemp_hujinghao MODIFY(job VARCHAR2(40))
=========================================================
-- ####################  DML语句：数据操作语言 --> 增，删，改表中数据 == DML是伴随事务（TCL）控制的 #################### 
--DML是用来增，删，改表中数据
--DML是伴随事务（TCL）控制的

--INSERT语句
--INSERT语句用于向表中插入新数据
INSERT INTO myemp_hujinghao(id,name,job,deptno) VALUES(1,'jack','CLERK',10)

COMMIT -- 提交

SELECT * FROM myemp_hujinghao-- * 要空格

 --不指定字段是全列插入，给定的值的类型顺序要与表中字段一致
 --id,name,gender,birth,sakary,job,depeno

 --
INSERT INTO myemp_hujinghao
VALUES
(2,'rose','F',SYSDATE,5000,'CLERK',10)

--插入日期类型数据时，可以使用数据库内置函数；
--TO_DATE(char1,char2)
--char1:一个具体日期的字符串
--chat2:指定的日期格式

INSERT INTO myemp_hujinghao
(id,name,birth)
VALUES
(3,'bob',TO_DATE('1996-01-01','YYYY-MM-DD'))
SELECT * FROM myemp_hujinghao
DESC myemp_hujinghao


--UPDATE语句：修改表中数据
--将id为2的员工性别改为“M”，部门改为“20”
UPDATE myemp_hujinghao
SET gender='M',deptno=20
WHERE id=2

SELECT * FROM myemp_hujinghao

--DELEET语句：删除数据
DELETE FROM myemp_hujinghao
WHERE salary>4000

SELECT * FROM myemp_hujinghao


--UPDATE语句与DELETE语句都需要使用WHERE添加过滤条件
--否则是对表中所有数据的操作

SELECT * FROM v$nls_parameters; 
SELECT * FROM v$nls_valid_values;












