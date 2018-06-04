-----------------------------------------------------
==================  day05  =========================
��ͼVIEW
--��ͼ�����ݿ����֮һ����SQL��������ֵĽ�ɫ���һ�¡�����
--��ͼ����һ����ʵ���ڵı���ֻ��һ����ѯ����Ӧ�Ľ����
--  v-����-����
create view v_emp_hjh_10
as
select empno,ename,sal,deptno
from emp_hjh
where deptno=10

desc v_emp_hjh_10
select *  from v_emp_hjh_10
------------------------------------------------------
--��ͼ��Ӧ���Ӳ�ѯ�е��ֶο���ָ����������������ͼ��Ӧ���ֶα���
--���������������һ���ֶ��Ǻ������߱��ʽ����ô���ֶα���ָ������
--create or replace view xxx ������ͬ���� ���滻
create or replace view v_emp_hjh_10
as
select empno id,ename name,sal salary,deptno
from emp_hjh
where deptno=10

desc v_emp_hjh_10
select * from v_emp_hjh_10
--------------------------
--��ͼ���ݶ�Ӧ���Ӳ�ѯ����Ϊ���Ӻ͸�����ͼ
--����ͼ����Ӧ���Ӳ�ѯ�����к��������ʽ�����飬ȥ�أ�������ѯ
--������ͼ�����˼���ͼ���Ǹ�����ͼ

--����ͼ���Խ���DML�������Ը���ͼ�Ĳ������Ƕ���ͼ
--������Դ�Ļ�������в�����������ͼ���������DML����

--�Լ���ͼ����DML����Ҳ����Υ��������Լ������
--����ͼ����DML��������ͼ�Ի��������ʱ��ֻ�ܶ���ͼ�ɼ����ֶν���

insert into v_emp_hjh_10
(id,name,salary,deptno)
values
(1001,'JACK',3000,10)
select * from v_emp_hjh_10
select * from emp_hjh

update v_emp_hjh_10
set salary=4000
where id=1001

--ɾ��JACK
delete from v_emp_hjh_10
where id=1001

select * from v_emp_hjh_10
select * from emp_hjh

--����ͼ�Ĳ���DML��������Ⱦ���������ݣ�����
--����ͼ����SML��������ͼ�Ի������Ӧ����DML������
--����ȴ�Ըü�¼���ɼ�

insert into v_emp_hjh_10
(id,name,salary,deptno)
values
(1001,'JACK',3000,20)

--���źŸĳ�20  ��Ⱦ---------------
update v_emp_hjh_10
set deptno=20

--delete ��ɾ������������Ⱦ����
delete from v_emp_hjh_10
where deptno=20




������Ⱦ
--Ϊ��ͼ��Ӽ��ѡ����Ա������ͼ���������µĻ������������Ⱦ
--with check option
--��ѡ��Ҫ�����ͼ����DML�����󡣸ü�¼�������ͼ�ɼ�

create or replace view v_emp_hjh_10
as
select empno id,ename name,sal salary,deptno
from emp_hjh
where deptno=10
with check option

insert into v_emp_hjh_10
(id,name,salary,deptno)
values
(1001,'JACK**',3000,10)
------------------------
ֻ��ѡ��
--with read only
--ֻ��ѡ��Ҫ����ͼ���ܽ��в�ѯ���������ܽ����κ�DML����
create or replace view v_emp_hjh_10
as
select empno id,ename name,sal salary,deptno
from emp_hjh
where deptno=10
with read only


delete from v_emp_hjh_10
where id=1001

select * from v_emp_hjh_10
select * from emp_hjh
=============================================
���õ����ݿ�������ֵ�
--user_objects:��¼�û����������������ݿ�

select object_name,object_type
from user_objects
where object_name like '%HJH'
--������ where object_type='VIEW'

--user_views:ר�ż�¼������������ͼ��Ϣ

select view_name,text
from user_views
where view_name like '%HJH%'---------------------------

--uesr_tables:ר�ż�¼��������������Ϣ
select table_name from user_tables
where table_name like '%HJH'

======================================================
ɾ����ͼ
drop view v_emp_hjh_10

����������ͼ
--����һ����ͼ������Ա�����ʼ���ز�����Ϣ
--������ÿ�����ŵ�ƽ�����ʣ������С�������ܺͣ�
--�Լ���Ӧ�Ĳ������ƣ����ű��
create  or replace view v_emp_hjh_salinfo
as
select avg(e.sal) avg_sal,
       max(e.sal) max_sal,
       min(e.sal) min_sal,
       sum(e.sal) sum_sal,
       d.dname,d.deptno,d.loc
from emp_hjh e,dept_hjh d
where e.deptno=d.deptno
group by d.dname,d.deptno,d.loc   ----GROUP BY ���Խ�������ո������ֶ�ֵһ����¼���з��顣

select * from v_emp_hjh_salinfo

============================================
============== ���� ---------------------- ����

����SEQUENCE
--���������ݿ����֮һ�������Ǹ���ָ���Ĺ�������һϵ�����֡�
--ͨ��ʹ���������ɵ�������Ϊ���е������ֶ��ṩֵʹ��
--
CREATE SEQUENCE seq_emp_hjh_id
START WITH 1
INCREMENT BY 1

--����֧������β�У�
NEXTVAL����ȡ���е���һ�����֣�������´��������У���ô���
START WITH ��ʼ���ء�֮���������ϴ����ɵ����ּ��ϲ������õ�
�������ɵ����ַ�����Ҫע�⣺�����ǲ��ܺ��˵ģ����Ҳ����������

CURRVAL����ȡ����������ɵ����֣��������������ٵ���NEXTVAL
����һ�����ֲſ���ʹ�ã�CURRVAL���ᵼ�����в���
--���е���һ������
SELECT seq_emp_hjh_id.NEXTVAL
FROM dual

--ʹ������ֵΪEMP�������ֶ��ṩֵ �����¼�¼��
INSERT INTO emp_hjh
(empno,ename,job,sal,deptno)
VALUES
(seq_emp_hjh_id.NEXTVAL,'JACK','CLERK',3000,10)
 
SELECT * FROM emp_hjh


--ɾ��һ������
DROP SEQUENCE seq_emp_hjh_id

���е������ֵ�
SELECT * FROM USER_SEQUENCES
==============================
-------- ����
����INDEX
--���������ݿ����֮һ����������߲�ѯЧ��
--�����Ĵ���ʱ�����ݿ�������ɵģ��������ݿ�
--�����ʵ���ʱ���Զ�ʹ������

CREATE INDEX idx_emp_hjh
ON emp_hjh(ename)

����������WHERE�к�ORDER BY �е��ֶ�Ҫ���������
����������DOSTINCT��ȥ�أ�������ֶ�Ҳ�������������
��Ҫע�⣻�����ִ������ֶΣ�����WHERE��ʹ��LIKE��ģ��������
���й���ʱ���ǲ����õ�������
--��������
CREATE INDEX idx_emp_hjh_job_sal
ON emp_hjh(job,sal)

select empno,ename,sal,job
FROM emp_hjh
ORDER BY job,sal
------------------
--����������
CREATE INDEX emp_hjh_ename_upper_idx
ON emp_hjh(UPPER(ename));

--�������ѯʱ���Զ�Ӧ�øս�����������Сд
select * FROM emp_hjh
where LOWER(ename) = 'king'
--��д
select * FROM emp_hjh
where upper(ename) = 'KING'
-----------------
--���������������ִ��DML��������Ҫ�ع�����
ALTER INDEX idx_emp_hjh REBUILD
--ɾ������
DROP INDEX idx_emp_hjh
===========================================
------- Լ��
�ǿ�Լ��
CREATE TABLE employees_hjh(
eid NUMBER(6),
name VARCHAR2(30)NOT NULL,
salary NUMBER(7,2),
hiredate DATE CONSTRAINT employees_hjh_hiredate_nn NOT NULL
)

DESC employees_hjh


-- ��ӷǿ�Լ��
ALTER TABLE employees_hjh 
MODIFY(eid NUMBER(6) NOT NULL)
-- ȡ���ǿ�Լ��
ALTER TABLE  employees_hjh
MODIFY(eid NUMBER(6) NULL)
--------------------------------------
Ψһ��Լ��
CREATE TABLE employees2_hjh(
eid NUMBER(6)UNIQUE,
name VARCHAR2(30),
email VARCHAR2(50),
salary NUMBER(7,2),
hiredate DATE,
CONSTRAINT employees2_hjh_email_uk UNIQUE(email)
);
-- �������
INSERT INTO employees2_hjh
(eid,name,email)
values
(null,'JACK',null)
(1,'JACK','jack520@tedu.cn')

--�鿴
DESC employees2_hjh
SELECT * FROM employees2_hjh

ɾ������
DELETE FROM  employees2_hjh
WHERE NAME='JACK'
ɾ����
DROP TABLE employees2_hjh

--����֮������Ψһ��Լ������
ALTER TABLE employees2_hjh
ADD CONSTRAINT employees2_hjh_name_uk UNIQUE(name);
---------------------------------------
����Լ��  
--һ�ű�ֻ����һ���ֶζ�������Լ��������Լ��Ҫ����ֶηǿ���Ψһ
CREATE TABLE employees3_hjh(
eid NUMBER(6) PRIMARY KEY,
name VARCHAR2(30),
email VARCHAR2(50),
salary NUMBER(7,2),
deptno NUMBER(4),
hiredate DATE
)


DESC employees3_hjh

-----------------------------------------------
���Լ��



DESC employees3_hjh


==============================================
���Լ��
--��Ӽ��Լ��
ALTER TABLE employees3_hjh
ADD CONSTRAINT employees3_hjh_salary_check
CHECK(salary>2000)

INSERT INTO employees3_hjh
(eid,name,salary,deptno)
VALUES
(520,'donna noble',2500,40)

UPDATE employees3_hjh
SET salary=1500
WHERE eid=520

DESC employees3_hjh
SELECT * FROM employees3_hjh
 





