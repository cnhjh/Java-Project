-----------------------------------------------------
==================  day05  =========================
视图VIEW
--视图是数据库对象之一，在SQL语句中体现的角色与表一致。但是
--视图并非一张真实存在的表，它只是一个查询语句对应的结果集
--  v-表名-条件
create view v_emp_hjh_10
as
select empno,ename,sal,deptno
from emp_hjh
where deptno=10

desc v_emp_hjh_10
select *  from v_emp_hjh_10
------------------------------------------------------
--视图对应的子查询中的字段可以指定别名，这样该视图对应的字段别名
--就是这个别名，当一个字段是函数或者表达式，那么该字段必须指定别名
--create or replace view xxx 若已有同名表 则替换
create or replace view v_emp_hjh_10
as
select empno id,ename name,sal salary,deptno
from emp_hjh
where deptno=10

desc v_emp_hjh_10
select * from v_emp_hjh_10
--------------------------
--视图根据对应的子查询，分为简单视和复杂视图
--简单视图：对应的子查询不含有函数，表达式，分组，去重，关联查询
--复杂视图：除了简单视图就是复杂视图

--简单视图可以进行DML操作，对该视图的操作就是对视图
--数据来源的基础表进行操作，复杂视图不允许进行DML操作

--对简单视图进行DML操作也不能违反基础表约束条件
--对视图进行DML操作，视图对基础表操作时，只能对视图可见的字段进行

insert into v_emp_hjh_10
(id,name,salary,deptno)
values
(1001,'JACK',3000,10)
select * from v_emp_hjh_10
select * from emp_hjh

update v_emp_hjh_10
set salary=4000
where id=1001

--删除JACK
delete from v_emp_hjh_10
where id=1001

select * from v_emp_hjh_10
select * from emp_hjh

--对视图的不当DML操作会污染基础表数据，即：
--对视图进行SML操作后，视图对基础表对应进行DML操作，
--但是却对该记录不可见

insert into v_emp_hjh_10
(id,name,salary,deptno)
values
(1001,'JACK',3000,20)

--部门号改成20  污染---------------
update v_emp_hjh_10
set deptno=20

--delete （删除）不会有污染现象
delete from v_emp_hjh_10
where deptno=20




避免污染
--为视图添加检查选项，可以避免对视图操作而导致的基础表的数据污染
--with check option
--该选项要求对视图进行DML操作后。该记录必须对视图可见

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
只读选项
--with read only
--只读选项要求视图仅能进行查询操作，不能进行任何DML操作
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
常用的数据库的数据字典
--user_objects:记录用户创建过的所有数据库

select object_name,object_type
from user_objects
where object_name like '%HJH'
--看所有 where object_type='VIEW'

--user_views:专门记录曾经创建的视图信息

select view_name,text
from user_views
where view_name like '%HJH%'---------------------------

--uesr_tables:专门记录曾经创建过的信息
select table_name from user_tables
where table_name like '%HJH'

======================================================
删除视图
drop view v_emp_hjh_10

创建复杂视图
--创建一张视图，包含员工工资及相关部门信息
--包含：每个部门的平均工资，最大，最小，工资总和，
--以及对应的部门名称，部门编号
create  or replace view v_emp_hjh_salinfo
as
select avg(e.sal) avg_sal,
       max(e.sal) max_sal,
       min(e.sal) min_sal,
       sum(e.sal) sum_sal,
       d.dname,d.deptno,d.loc
from emp_hjh e,dept_hjh d
where e.deptno=d.deptno
group by d.dname,d.deptno,d.loc   ----GROUP BY 可以将结果按照给定的字段值一样记录进行分组。

select * from v_emp_hjh_salinfo

============================================
============== 序列 ---------------------- 下午

序列SEQUENCE
--序列是数据库对象之一，作用是根据指定的规则生成一系列数字。
--通常使用序列生成的数字是为表中的主键字段提供值使用
--
CREATE SEQUENCE seq_emp_hjh_id
START WITH 1
INCREMENT BY 1

--序列支持两个尾列：
NEXTVAL：获取序列的下一个数字，如果是新创建的序列，那么会从
START WITH 开始返回。之后则是用上次生成的数字加上步长来得到
本次生成的数字返回需要注意：序列是不能后退的，并且不受事务控制

CURRVAL：获取序列最后生成的数字，创建的序列至少调用NEXTVAL
生成一个数字才可以使用，CURRVAL不会导致序列步进
--序列的下一个数字
SELECT seq_emp_hjh_id.NEXTVAL
FROM dual

--使用序列值为EMP表主键字段提供值 插入新记录：
INSERT INTO emp_hjh
(empno,ename,job,sal,deptno)
VALUES
(seq_emp_hjh_id.NEXTVAL,'JACK','CLERK',3000,10)
 
SELECT * FROM emp_hjh


--删除一个序列
DROP SEQUENCE seq_emp_hjh_id

序列的数据字典
SELECT * FROM USER_SEQUENCES
==============================
-------- 索引
索引INDEX
--索引是数据库对象之一，作用是提高查询效率
--索引的创建时是数据库自行完成的，并且数据库
--会在适当的时候自动使用索引

CREATE INDEX idx_emp_hjh
ON emp_hjh(ename)

经常出现在WHERE中和ORDER BY 中的字段要添加索引。
经常出现在DOSTINCT（去重）后面的字段也可以添加索引。
需要注意；对于字串类型字段，若在WHERE中使用LIKE（模糊搜索）
进行过滤时，是不会用到索引的
--复合索引
CREATE INDEX idx_emp_hjh_job_sal
ON emp_hjh(job,sal)

select empno,ename,sal,job
FROM emp_hjh
ORDER BY job,sal
------------------
--函数加索引
CREATE INDEX emp_hjh_ename_upper_idx
ON emp_hjh(UPPER(ename));

--做下面查询时，自动应用刚建立的索引，小写
select * FROM emp_hjh
where LOWER(ename) = 'king'
--大写
select * FROM emp_hjh
where upper(ename) = 'KING'
-----------------
--如果经常在索引上执行DML操作，需要重构索引
ALTER INDEX idx_emp_hjh REBUILD
--删除索引
DROP INDEX idx_emp_hjh
===========================================
------- 约束
非空约束
CREATE TABLE employees_hjh(
eid NUMBER(6),
name VARCHAR2(30)NOT NULL,
salary NUMBER(7,2),
hiredate DATE CONSTRAINT employees_hjh_hiredate_nn NOT NULL
)

DESC employees_hjh


-- 添加非空约束
ALTER TABLE employees_hjh 
MODIFY(eid NUMBER(6) NOT NULL)
-- 取消非空约束
ALTER TABLE  employees_hjh
MODIFY(eid NUMBER(6) NULL)
--------------------------------------
唯一性约束
CREATE TABLE employees2_hjh(
eid NUMBER(6)UNIQUE,
name VARCHAR2(30),
email VARCHAR2(50),
salary NUMBER(7,2),
hiredate DATE,
CONSTRAINT employees2_hjh_email_uk UNIQUE(email)
);
-- 添加数据
INSERT INTO employees2_hjh
(eid,name,email)
values
(null,'JACK',null)
(1,'JACK','jack520@tedu.cn')

--查看
DESC employees2_hjh
SELECT * FROM employees2_hjh

删除数据
DELETE FROM  employees2_hjh
WHERE NAME='JACK'
删除表
DROP TABLE employees2_hjh

--建表之后增加唯一性约束条件
ALTER TABLE employees2_hjh
ADD CONSTRAINT employees2_hjh_name_uk UNIQUE(name);
---------------------------------------
主键约束  
--一张表只能有一个字段定义主键约束，主键约束要求该字段非空且唯一
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
外键约束



DESC employees3_hjh


==============================================
检查约束
--添加检查约束
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
 





