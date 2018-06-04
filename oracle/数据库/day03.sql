---------------------------day03 SQL查询
--列别名
--当SELECT句子中一个字段是函数或者表达式。那么在结果集中该字段名字
--就是这个函数，或者表达式，可读性差，这样在结果集合中会使用
--该别名作为该字段的名字，应当养成一个好习惯，即：
--凡是表达式或函数都指定一个别名
SELECT ename,sal+NVL(comm,0) sal
FROM emp_hjh
--别名不区分大小写，若希望别名区分大小写或者别
--名中包含空格，那么需要使用双引号将其括起来
SELECT ename,sal+NVL(comm,0) "S al"
FROM emp_hjh

-----------------------------
--使用<,>,>=,<=,!=,<>,=
SELECT ename,sal FROM emp_hjh
WHERE sal<2000;
--部门不属于10的员工信息（<> 等于）
SELECT ename,sal,job FROM emp_hjh
WHERE deptno<>10

SELECT ename,sal,hiredate FROM emp_hjh
WHERE hiredate > to_date('1982-1-1','YYYY-MM-DD')

---------------------
--使用AND，OR关键字
--用于连接多个条件使用
SELECT ename,sal,job  FROM emp_hjh
WHERE sal>1000 AND job='SLERK'

SELECT ename,sal,job  FROM emp_hjh
WHERE sal>1000 OR job='CLERK'

--OR的优先级低于AND，所以若希望提高OR的优先级，可以使用括号
--查看工资高于1000，并且职位是'SALESMAN'或者'CLERK'的员工
SELECT ename,sal,job  
FROM emp_hjh
WHERE sal>1000 AND job='SALESMAN' OR job='CLERK'

SELECT ename,sal,job  
FROM emp_hjh
WHERE sal>1000 AND (job='SALESMAN' OR job='CLERK')
-------------------------------------------------------------
--LIKE用于模糊匹配字符串
--支持两个通配符：
--%：0到多个字符（任意个字符）
--_：单一的一个字符

--查看名字第二给字母是A的员工信息？
SELECT ename,sal,deptno
FROM emp_hjh
WHERE ename LIKE '_A%'
--名字当中含有字母K的员工
SELECT ename,sal,deptno
FROM emp_hjh
WHERE ename LIKE '%K%'
--名字当中第三个字母为A 并且 名字为五个字符的员工
SELECT ename,sal,deptno
FROM emp_hjh
WHERE ename LIKE '__A__'
--名字为S结尾的员工
SELECT ename,sal,deptno
FROM emp_hjh
WHERE ename LIKE '%S'

--------------------------------------
--IN(list)和NOT IN(listr)
--判断在列表中和不在列表中
--IN和NOT IN常被用在查询上使用。

--查看职位是SLERK和SALESMAN的员工？
SELECT ename,job,sal
FROM emp_hjh
WHERE job IN('CLERK','SALESMAN')
---------------------------------------
BETWEEN...AND...
--判断在一个区间范围内
--左边小右边大

--查看工资在1500到3000之间的员工？
SELECT ename,sal
FROM emp_hjh
WHERE sal BETWEEN 1500 AND 3000

--查看工资在1000-3000之间，20和30号部门名字中含有A的员工
SELECT ename,sal,deptno,job
FROM emp_hjh
WHERE sal BETWEEN 1000 AND 3000 
AND deptno IN(20,30)
AND ename LIKE '%A%'
----------------------------------------
--使用IS NULL 和 NOT NULL
--空值NULL是一个特殊字符
SELECT ename,sal,comm
FROM emp_hjh
WHERE comm IS NULL
--------------------------------------
--  ANY(list),ALL(list)
--  ANY,ALL 是配合>,>=,<,<=使用的
--  >ANY(list):大于列表之一，大于最小
--  <ANY(list):小于列表之一，小于最大
--  >ALL(list):大于列表所有，大于最大
--  <ALL(list):小于列表所有，小于最小
--ANY，ALL的列表中不会给定固定值，没有实际意义，
--他们通常配合子查询使用
SELECT empno,ename,job,sal,deptno
FROM emp_hjh
WHERE sal>ANY(3500,4000,4500)

SELECT empno,ename,job,sal,deptno
FROM emp_hjh
WHERE sal<ALL(3500,4000,4500)
-----------------------------------------------
--DISTINCT关键字
--DISTINCT可以将结果集中指定字段值一样的记录，去掉重复值

--查看公司有那些职位
SELECT 
DISTINCT job   FROM emp_hjh
--可以按照多字段去重；那么这些字段的组合没有
--重复记录出现在结果集中
SELECT DISTINCT deptno,job 
FROM emp_hjh
-------------------------------------------------------------
---------------------排序---------------------------------
--ORDER BY字句
--ORDER BY用于对查询的结果集按照指字段的值进行排序
--貔貅分为：升序（ASC），降序(DESC)
--默认为升序
--ORDER BY 必须定义在SELECT语句中的最后一个句子上
SELECT ename,sal,job
FROM emp_hjh
ORDER BY sal DESC
--查看20号部门的工资
SELECT ename,sal,deptno
FROM emp_hjh
WHERE deptno=20
ORDER BY sal DESC

SELECT ename,sal,deptno
FROM emp_hjh

--多字段排序时，ORDER BY 是有排序的优先级的，首先按照第一个字段先进行排序，
--当该字段中记录值重复时，再将这些记录按照第二个字段排序，依此类推

--查看员工部门降序和工资降序
SELECT  ename,deptno,sal
FROM emp_hjh
ORDER BY deptno DESC,sal DESC

--若排序的字段中含有NULL值，NULL被认定为最大值，
SELECT ename,comm
FROM emp_hjh
ORDER BY comm

--------------------------------------------------------
----------------聚合函数------------------------------------
--聚合函数又称为分组函数，多行函数。
--聚合函数的作用是对结果集指定字段的值进行统计工作
--MAX（），NIM（），SUM（），AVG（）
--最大值 ，最小值  ， 总和 ，平均值

--还有一个是对记录 数的统计  
--COUNT（）
SELECT MAX(sal) FROM emp_hjh

SELECT MAX(sal),MIN(sal),
       SUM(sal),AVG(sal)
FROM emp_hjh

--查看公司有多少人   三个方法
SELECT COUNT(ename) FROM emp_hjh
SELECT COUNT(*) FROM emp_hjh
SELECT COUNT(1) FROM emp_hjh
SELECT 1 FROM emp_hjh

--聚合数忽略NULL值
SELECT SUM(comm),AVG(comm)
FROM emp_hjh

SELECT AVG(NVL(comm,0))
FROM emp_hjh
----------------------------------------------------------
----------------分组----------------------------------
--GROUP BY子句
--GROUP BY 可以将结果按照给定的字段值一样记录进行分组。
--配合聚合函数使用可以完成分组统计工作

--查看每个部门的平均工资
SELECT AVG(sal),deptno FROM emp_hjh
GROUP BY deptno

--当SELECT中含有聚合函数中时，那么凡不在聚合函数中的单独字段，
--都需要出现GROUP BY字句中

--查看每种职位的最高工资与最低工资是多少
SELECT MAX(sal),MIN(sal),job
FROM emp_hjh
GROUP BY job

--GROUP BY按照字段分组时，是将这些
--字段值组合一样的记录看做一组。

--统计同部门，同职位的员工各有多少人？
SELECT COUNT(*),deptno,job
FROM emp_hjh
GROUP BY deptno,job

--查看部门的平均工资，前提是该部门的平均工资高于2000?
SELECT 
AVG(sal),deptno FROM emp_hjh
WHERE AVG(sal)>2000
GROUP BY deptno

--上面的SQL语句会抛异常，WHERE字句中是不能使用聚合函数作为过滤条件的，
--原因在于过滤的实际不对
--WHERE是伴随查询表中数据逐行进行过滤使用的，
--用来确定结果集中可以查询出的条目录数。
--而聚合函数是建立在查询=出来的数据基础上进行统计才能得到结果，
--所以使用聚合函数过滤应当是在WHERE之后进行的

--HAVING 子句可以根据聚合函数进行过滤，并且是用来根据条件
--过滤GROUP BY的分组

SELECT AVG(sal),deptno
FROM emp_hjh
GROUP BY deptno
HAVING AVG(sal)>2000 


--查看平均工资高于2000的那些部门的最高工资是多少？
SELECT 
MAX(sal),deptno
FROM emp_hjh
GROUP BY deptno
HAVING AVG(sal)>2000

-------------------------------------------------------
--------------关联查询------------------------------
--关联查询的结果中的字段来自多张表，这就需要在查询
--的时候联合多张表进行查询，根据给定的连接条件将
--表与表的数据建立对应关系，在分别从这些记录中提取
--要查询的字段开形成结果集中的每条记录

--查看每个员工的名字以及其所在部门的名字？

--当在关联查询的字段在这些表中都出现时，
--需要使用表名来明确字段所属表，可以为表名取一个
--别名开简化复杂度
SELECT ename,dname
FROM emp_hjh ,dept_hjh 
WHERE emp_hjh.deptno=dept_hjh.deptno

SELECT e.ename,e.deptno,d.dname
FROM emp_hjh e,dept_hjh d
WHERE e.deptno=d.deptno
--------------------------------------
--在进行关联查询时若有过滤要求，那么过滤条件必须与连接条件同时成立。
--查看NEW YORK工作的员工都有谁
SELECT e.ename,e.deptno,
       d.dname, d.loc
FROM emp_hjh e,dept_hjh d
WHERE e.deptno=d.deptno
AND d.loc='NEW YORK'

-- 关联查询中不指定连接条件或者连接条件无效时，
--会产生"笛卡尔积"，这通常是一个无意的结果集
SELECT e.ename,d.dname
FROM emp_hjh e,dept_hjh d

--N表查询至少要有N-1个连接条件。

--内连接
--内连接也是用来完成关联查询的。
--采用JOIN...ON...的形式关联多表
--不满足关联条件的记录不会被查询出来

SELECT e.ename,d.dname
FROM emp_hjh e,dept_hjh d
WHERE e.deptno=d.deptno

--查看每个员工的名字以及其所在部门名称

SELECT e.ename,d.dname
FROM emp_hjh e JOIN dept_hjh d
ON e.deptno=d.deptno

--将SCOTT的部门号改为50
update emp_hjh
set deptno=50
where ename='SCOTT'
------------------------------------------

--外连接
--外连接在关联查询中除了可以将满足连接条件的记录查询出来之外，
--还可以将不满足连接条件的记录查询出来。
--外连接分为：
--左外连接，右外链接，全外连接
--左外连接：以JOIN左侧做为驱动表，该表记录都要
--查询出来，当某条件记录不满足连接条件时，那么结果集
--中该条记录来自JOIN右侧的字段全部为NULL
--LEFT OUTER JOIN , RIGHT OUTER JOIN , FULL OUTER JOIN    
-- 左外连接           右外连接            全外连接
SELECT e.ename,e.job,e.sal,
       d.dname,d.loc
FROM emp_hjh e FULL OUTER JOIN dept_hjh d
ON e.deptno=d.deptno

SELECT e.ename,d.dname
FROM emp_hjh e,dept_hjh d
WHERE e.deptno(+)=d.deptno
----------------------------------
--自连接
--自连接指的是当前的一条市局可以对应当前自己的多条数据
--自连接是为了解决数据的属性相同，但是本身又存在上下级关系
--的树状结构的数据

--查看每个员工以及其领导的名字
SELECT e.ename,m.ename
FROM emp_hjh e,emp_hjh m
WHERE e.mgr=m.empno(+)

SELECT e.ename,m.ename
FROM emp_hjh e LEFT OUTER JOIN emp_hjh m
ON e.mgr=m.empno


















