--子查询
--子查询是一条查询语句，它是嵌套在其他SQL语句中的，
--目的是将查询的结果提供给外层的SQL语句
查看谁的工资高于CLARK的工资？
SELECT ename,sal  FROM emp_hjh
WHERE sal>(SELECT sal FROM emp_hjh
           WHERE ename='CLARK')
谁和CLARK同部门？
SELECT ename,deptno
FROM emp_hjh
WHERE deptno=(SELECT deptno
              FROM emp_hjh
              WHERE ename='CLARK')


--查看工资高于平均工资的员工
SELECT ename,sal
FROM emp_hjh
WHERE sal>(SELECT AVG(sal)
           FROM emp_hjh)


---------------------------------------
--在DDL中使用子查询，可以将一个子查询的
--结果集当做表快速创建出来
CREATE TABLE employee_hjh
AS
SELECT  e.empno,e.ename,e.sal,e.job,
        d.deptno,d.dname,d.loc
FROM emp_hjh e,dept_hjh d   
WHERE e.deptno=d.deptno(+)

DROP TABLE  employee_hjh      
SELECT * FROM employee_hjh

--使用子查询创建表的时候，查询多少个字段创建的表就有多少个字段，
--字段名字与查询的字段名字一致（不含有表别名），类型，长度也一致，
--但是需要注意的是，查询的字段是函数或者表达式，那么这个字段
--的该字段名就是这个别名

--DDL中使用子查询
--将CLARK所在部门的员工工资上浮10%
UPDATE emp_hjh
SET sal=sal*1.1
WHERE deptno=(SELECT deptno FROM emp_hjh
             WHERE ename='CLARK'
             )
SELECT * FROM emp_hjh
--------------------------------------
--子查询根据查询结果分为：
--单行单列，多行单列，多行多列子查询
--其中单列子查询 常用在过滤条件中，多列子查询通常被当做表使用

--对于多行多列子查询进行过滤时，需要配合IN，ANY，ALL使用

查看与职位是SALESMAN同部门的员工？
SELECT ename,job,deptno
FROM emp_hjh
WHERE deptno IN (SELECT deptno FROM emp_hjh
             WHERE job='SALESMAN')
AND job<>'SALESMAN'

查看比职位是SALESMAN和CLERK工资都高的员工?

SELECT ename,sal,job
FROM emp_hjh
WHERE sal>ALL(SELECT sal FROM emp_hjh
              WHERE job IN('SALESMAN','CLERK')
              )
-----------------------------------------------------
--列出所有员工的部门信息？
SELECT deptno,dname
FROM dept_hjh d
WHERE EXISTS (SELECT * FROM emp_hjh e
              WHERE d.deptno=e.deptno)

--EXISTS关键字
--EXISTS 前面可以加 NOT  
查看有下属的员工(领导)？
m领导 n
SELECT m.ename,m.job,m.sal
FROM emp_hjh m
WHERE EXISTS(SELECT * FROM emp_hjh e
             WHERE e.mgr = m.empno)

--HAVING 中使用子查询：
查看每个部门的最低薪水，前提是要高于30号部门的最低薪水？
SELECT MIN(sal),deptno
FROM  emp_hjh
GROUP BY deptno
HAVING MIN(sal)>(SELECT MIN(sal)
                 FROM emp_hjh
                 WHERE deptno=30)

--在FROM中使用子查询
--通常多列子查询在FROM字句中出现，作用是当做一张表使用。

查看高于自己所在部门平均工资的员工？
1.算每个部门的平均工资
SELECT e.ename,e.sal,e.deptno
FROM emp_hjh e,(SELECT deptno,AVG(sal) avg_sal
                 FROM emp_hjh
                 GROUP BY deptno) x
WHERE e.deptno=x.deptno
AND e.sal>x.avg_sal

--------
SELECT e.ename,e.sal,
         (SELECT d.deptno
          FROM dept_hjh d
          WHERE d.deptno=e.deptno) deptno
FROM emp_hjh e
-------------------------------------------------
-------------  分页查询 --------------------------
--分页查询就是将表中查询出来的市局分批段查询出来。这样做的好处就是
--当查询的数据量过大时可以减少内存开销，提高系统响应数度，减少网络传输。
--分页是方言，不同数据库都提供了分页查询的机制，但是语法定义各不同

--ORACLE是依靠提供了一个伪例：ROWNUM

--ORWNUM不存在于任何一张表中，但是每张表都可以查询记录的行号，而
--行号的生成是伴随查询过程进行的，ROWNUM字段就是为了该条记录
--在结果集中产生对应的行号，从1开始递增

查看职员表
SELECT ROWNUM,empno,ename,job,sal
FROM emp_hjh

查看部门表
SELECT ROWNUM,deptno,dname,loc
FROM dept_hjh

---需要注意，在使用ROWNUM对结果集编行号的过程中，不要使用
--ROWNUM做大于1以上数字的判断，否则得不到结果
SELECT ROWNUM,empno,ename,job,sal
FROM emp_hjh
WHERE ROWNUM >1 

SELECT * FROM(
SELECT ROWNUM rn,empno,ename,job,sal
FROM emp_hjh)
WHERE rn BETWEEN 6 AND 10


查看公司工资排名的第6-10名？
SELECT *
FROM(SELECT ROWNUM rn,t.*
     FROM(SELECT ename,job,sal
          FROM emp_hjh
          ORDER BY sal DESC) t)
WHERE rn BETWEEN 6 AND 10
--当数据量大时使用以下方法效率更高
SELECT *FROM(SELECT ROWNUM rn,t.*
             FROM(SELECT ename,job,sal
                  FROM emp_hjh
                  ORDER BY sal DESC) t
             WHERE ROWNUM <=10
             )
WHERE rn >= 6 

--换算范围的公式：
--PageSize:每页可以显示的条目数
--Page:页数

start:(Page-1)*PageSize+1
end:PageSize*Page
----------------------------------------
------------  DECODE函数  ----------------
--DECODE函数可以实现分支结构
SELECT ename,job,sal,
     DECODE(job,
           'MANAGER',sal*1.2,
           'ANALYST',sal*1.1,
           'SALESMAN',sal*1.05,
           sal
      )bonus
FROM emp_hjh;
--和DECODE函数功能相似的有CASE语句，实现类似与 if-else 的操作
SELECT ename,job,sal,
     CASE job WHEN 'MANAGER' THEN sal*1.2
              WHEN 'ANALYST' THEN sal*1.1
              WHEN 'SALESMAN' THEN sal*1.05
              ELSE sal END
              bonus
FROM emp_hjh;

--DECODE在GROUP BY 中可以实现将字段不同值的记录分为一组
--将职位是ANALYST与MANAGER看作一组，其他职位做另一组，分别统计人数

--自定义排序??????===========================================================
SELECT deptno,dname,loc
FROM dept_hjh
ORDER BY
DECODE(dname,'OPERATIONS',1,
              'ACCOUNTING',2,
              'SALES',3
              );

--------------------------------------
-----------  排序函数 -----------------
--排序函数可以将结果集按照指定的字段分组
--然后组内在按照指定的字段排序后对每组的记录
--产生一个行号。

--ROW_NUMBER():生成内连续且唯一的数字
根据部门id分组(PARTITION BY)显示 工倒序排序(ORDER BY)
SELECT ename,job,sal,deptno,
ROW_NUMBER() OVER(
   PARTITION BY deptno
   ORDER BY sal DESC
) rank
FROM emp_hjh

--RANK() 相同数据返回相同排名 跳跃排序
SELECT ename,job,sal,deptno,
RANK() OVER(
   PARTITION BY deptno
   ORDER BY sal DESC
) rank
FROM emp_hjh

--DENSE_RANK():生成组内连续但不唯一的数组
SELECT ename,job,sal,deptno,
DENSE_RANK() OVER(
   PARTITION BY deptno
   ORDER BY sal DESC
) rank
FROM emp_hjh


------------------------------------------
------------集合排序 ---------
--UNION 自动合并重复记录
SELECT ename,job,sal 
FROM emp_hjh
WHERE job = 'MANAGER'
UNION
SELECT ename,job,sal
FROM emp_hjh
WHERE sal>2500;

--UNION ALL 返回两个结果所有行 包括重复记录
SELECT ename,job,sal
FROM emp_hjh
WHERE job='MANAGER'
UNION ALL
SELECT ename,job,sal 
FROM emp_hjh
WHERE sal >2500;

--INTERSECT 同时存在两个结果集中的数据猜显示输出(两个结果集都有的数据)
SELECT ename,job,sal
FROM emp_hjh
WHERE job='MANAGER'
INTERSECT
SELECT ename,job,sal
FROM emp_hjh
WHERE sal>2500

--MINUS 第一个结果集存在，第二个结果集不存在的数据才被显示出来
--也就是第一个结果集减去第二个结果集的结果
SELECT ename,job,sal
FROM emp_hjh
WHERE job='MANAGER'
MINUS
SELECT ename,job,sal
FROM emp_hjh
WHERE sal>=2500


---------------------------------------------------
================= 高级分组函数 =========================

--------------- ROLLUP ---------
CREATE TABLE sales_hjh(
  year_id NUMBER NOT NULL,
  month_id NUMBER NOT NULL,
  day_id NUMBER NOT NULL,
  sales_value NUMBER(10,2) NOT NULL
  );
INSERT INTO sales_hjh
SELECT TRUNC(DBMS_RANDOM.value(2010,2012)) AS year_id,
       TRUNC(DBMS_RANDOM.value(1,13)) AS monrh_id,
       TRUNC(DBMS_RANDOM.value(1,32)) AS day_id,
       ROUND(DBMS_RANDOM.value(1,100),2) AS seles_value
FROM dual
CONNECT BY level <= 1000;
COMMIT
SELECT * FROM sales_hjh


ROLLUP（）函数
--ROLLUP中的每一个参数就是需要分组的字段
--ROLLUP会将参数字段逐个递增并分组统计直至一个字段都没有，然后
--将这些分组统计的结果并在一个结果集显示

GROUP BY ROLLUP(a,b,c)
等价：
GROUP BY a,b,c
UNION ALL
GROUP BY a,b
UNION ALL
GROUP BY a
UNION ALL
全表
在一个结果中看到每天，每月，每年以及总共的营业额
SELECT year_id,month_id,day_id,SUM(sales_value)
FROM sales_hjh
GROUP BY ROLLUP(year_id,month_id,day_id)
ORDER BY year_id,month_id,day_id

CUBE()函数：
--将每个参数的每种组合都进行一次分组，然后将所有统计
--结果并在一个结果集显示，所以CUBE分组次数为2的参数个数次方
GROUP BY ROLLUP(a,b,c)
 a,b,c
 a,b
 b,c
 a
 b
 c

SELECT year_id,month_id,day_id,SUM(sales_value)
FROM sales_hjh
GROUP BY CUBE(year_id,month_id,day_id)
ORDER BY year_id,month_id,day_id

GROUPING SETS()函数：
--GROUPING SETS的每一个参数是一种分组方式
--它会将这些分组统计的结果并在一个结果集显示。

查看每天与每月营业额？
SELECT year_id,month_id,day_id,SUM(sales_value)
FROM sales_hjh
GROUP BY GROUPING SETS(
    (year_id,month_id,day_id),
    (year_id,month_id)
    )
ORDER BY year_id,month_id,day_id

























