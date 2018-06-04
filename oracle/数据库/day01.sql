SQL��䲻���ִ�Сд
--SELECT SYSDATE FROM dual

--SQL����Ϊ��
--DDL,DML,TCL,DQL,DCL
==========================================================
--####################  DDL:���ݶ������� ----> ����ɾ��  �ֶ���ɾ�� #################### 
--DDL����ά�����ݿ����ʹ��
--���ݿ����:����ͼ�����������С�

--1:������
CREATE TABLE employee_hujinghao(
	id NUMBER(4),
	name VARCHAR2(20),
	gender CHAR(1),
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
)

--�鿴��ṹ 
--DESC XXXX
DESC employee_hujinghao
desc employee_hujinghao
--ɾ����
--DROP TABLE XXXX
DROP TABLE employee_hujinghao
drop table employee_hujinghao

--�����ݿ��У������ֶε�Ĭ��ֵ����NULL��������ͨ��DEFAULT�ؼ���
--ָ��һ��Ĭ��ֵ�������ַ������ԣ����ݿ�����������ʹ�õ�������������
--��һ����Ҫ��java���ּ��䡣���ҡ���ȻSQL��䱾�����ִ�Сд�������ַ���ֵ
--�����ִ�Сд�ġ�
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

--NOT NULLԼ��
--��һ���ֶα�NOT NULL ���κ󣬸��ֶβ�����Ϊ��
--��DEFAULT���⡣
--��ʾ����
CREATE TABLE employee_hujinghao(
    id NUMBER(4),
    name VARCHAR2(20) NOT NULL,
    gender VARCHAR2(20) DEFAULT 'M', 
    birth DATE,
    salary NUMBER(6,2) DEFAULT 3000,
    job VARCHAR2(30),
    deptno NUMBER(2)
);
--�鿴��ṹ
DESC employee_hujinghao
rename employee_hujinghao to myemp_hujinghao
desc myemp_hujinghao
--�޸ı�
--1���޸ı���
--2���޸ı�ṹ

--�޸ı���
--RENAME old_name TO mew_name
--��:
RENAME employee_hujinghao To myemp_hujinghao
DESC myemp_hujinghao
 
--�ı�ṹ 
--1������µ��ֶ�
--2���޸������Ӷ�
--3��ɾ�������ֶ�

-- ������ֶ�
ALTER TABLE myemp_hujinghao ADD(hiredate DATE)
select * from myemp_hujinghao
    
--ɾ�������ֶ�
ALTER TABLE myemp_hujinghao DROP( hiredate)


DESC myemp_hujinghao
--DROP TABLE myemp_hujinghao

--�޸������ֶ�
--�����޸��ֶε����ͣ����ȣ�Ĭ��ֵ���ǿ�Լ��
--����Ӧ���ڱ���û�����ݵ�ʱ�����,  ��������Ҫ
--�޸�����,���Ⱦ���ֻ��������������ܻ��޸�ʧ�ܡ�
ALTER TABLE myemp_hujinghao MODIFY(job VARCHAR2(40))
=========================================================
-- ####################  DML��䣺���ݲ������� --> ����ɾ���ı������� == DML�ǰ�������TCL�����Ƶ� #################### 
--DML����������ɾ���ı�������
--DML�ǰ�������TCL�����Ƶ�

--INSERT���
--INSERT�����������в���������
INSERT INTO myemp_hujinghao(id,name,job,deptno) VALUES(1,'jack','CLERK',10)

COMMIT -- �ύ

SELECT * FROM myemp_hujinghao-- * Ҫ�ո�

 --��ָ���ֶ���ȫ�в��룬������ֵ������˳��Ҫ������ֶ�һ��
 --id,name,gender,birth,sakary,job,depeno

 --
INSERT INTO myemp_hujinghao
VALUES
(2,'rose','F',SYSDATE,5000,'CLERK',10)

--����������������ʱ������ʹ�����ݿ����ú�����
--TO_DATE(char1,char2)
--char1:һ���������ڵ��ַ���
--chat2:ָ�������ڸ�ʽ

INSERT INTO myemp_hujinghao
(id,name,birth)
VALUES
(3,'bob',TO_DATE('1996-01-01','YYYY-MM-DD'))
SELECT * FROM myemp_hujinghao
DESC myemp_hujinghao


--UPDATE��䣺�޸ı�������
--��idΪ2��Ա���Ա��Ϊ��M�������Ÿ�Ϊ��20��
UPDATE myemp_hujinghao
SET gender='M',deptno=20
WHERE id=2

SELECT * FROM myemp_hujinghao

--DELEET��䣺ɾ������
DELETE FROM myemp_hujinghao
WHERE salary>4000

SELECT * FROM myemp_hujinghao


--UPDATE�����DELETE��䶼��Ҫʹ��WHERE��ӹ�������
--�����ǶԱ����������ݵĲ���

SELECT * FROM v$nls_parameters; 
SELECT * FROM v$nls_valid_values;












