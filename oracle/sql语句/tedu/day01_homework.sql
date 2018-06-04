--day01作业13题
--emp职员表



CREATE TABLE emp_hjh(
  empno NUMBER(4),
  ename VARCHAR2(10),
  job VARCHAR2(9),
  mgr NUMBER(4,0),
  hiredate DATE,
  sal NUMBER(7,2),
  comm NUMBER(7,2),
  deptno NUMBER(2,0)
);

--作业14题
--emp_hjh职员表
--(empno,ename,job,mgr,hiredate,sal,comm,depino)
-- empno员工ID，ename员工姓名，job职位，mgr员工管理者的ID，
-- hiredate 入职日期，sal薪资，commm ，deptno员工所在部门ID
--                         员工ID 员工姓名 职位  员工管理者的ID          入职日期              薪资    职效 员工所在部门ID 
--                         empno ename   job      mgr               hiredate               sal comm deptno
 INSERT INTO emp_hjh VALUES(7369,'SMITH','CLERK',7902,to_date('1980-12-17','YYYY-MM-DD'),800.00,NULL,20);
 INSERT INTO emp_hjh VALUES(7499,'ALLEN','SALESMAN',7698,to_date('1981-2-20','YYYY-MM-DD'),1600.00,300.00,30);
 INSERT INTO emp_hjh VALUES(7521,'WARO','SALESMAN',7698,to_date('1981-2-22','YYYY-MM-DD'),1250.00,500.00,30);
 INSERT INTO emp_hjh VALUES(7566,'JONES','MANAGER',7839,to_date('1981-4-2','YYYY-MM-DD'),2975.00,NULL,20);
 INSERT INTO emp_hjh VALUES(7654,'MARIN','SALESMAN',7698,to_date('1981-9-28','YYYY-MM-DD'),1250.00,1400.00,30);
 INSERT INTO emp_hjh VALUES(7698,'BLAKE','MANAGER',7839,to_date('1981-5-1','YYYY-MM-DD'),2850.00,NULL,30);
 INSERT INTO emp_hjh VALUES(7782,'CLARK','MANAGER',7839,to_date('1981-6-9','YYYY-MM-DD'),2450.00,NULL,10);
 INSERT INTO emp_hjh VALUES(7788,'SCOTT','ANALSYT',7566,to_date('1987-4-19','YYYY-MM-DD'),3000.00,NULL,20);
 INSERT INTO emp_hjh VALUES(7839,'KING','PRESIDENT',NULL,to_date('1981-11-17','YYYY-MM-DD'),5000.00,NULL,10);
 INSERT INTO emp_hjh VALUES(7844,'TURNER','SALESMAN',7698,to_date('1981-9-8','YYYY-MM-DD'),1500.00,0.00,30);
 INSERT INTO emp_hjh VALUES(7876,'ADAMS','CLERK',7788,to_date('1987-5-23','YYYY-MM-DD'),1100.00,NULL,20);
 INSERT INTO emp_hjh VALUES(7900,'JAMES','CLERK',7698,to_date('1981-12-3','YYYY-MM-DD'),950.00,NULL,30);
 INSERT INTO emp_hjh VALUES(7902,'FORO','ANALYST',7566,to_date('1981-12-3','YYYY-MM-DD'),3000.00,NULL,20);
 INSERT INTO emp_hjh VALUES(7934,'MILLER','CLERK',7782,to_date('1982-1-23','YYYY-MM-DD'),1300.00,NULL,10);
 
DESC emp_hjh
DROP TABLE emp_hjh
COMMIT
SELECT * FROM emp_hjh


 
 
--dept部门表
--deptno部门ID， dname部门名称， loc部门所在地
CREATE TABLE dept_hjh(
  deptno NUMBER(2),
  dname VARCHAR2(14),
  loc VARCHAR2(12)
);

INSERT INTO dept_hjh VALUES(10,'ACCOUNTING','NEW YORK');
INSERT INTO dept_hjh VALUES(20,'RESEARCH','DALLAS');
INSERT INTO dept_hjh VALUES(30,'SALES','CHICAGO');
INSERT INTO dept_hjh VALUES(40,'OPERATIONS','BOSTON');

COMMIT
DROP TABLE dept_hjh
SELECT * FROM dept_hjh

























