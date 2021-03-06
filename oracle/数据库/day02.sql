
--------------------------------------------------                   

--####################  DQL：数据库查询语言 select  ， from #################### 
DQL：数据库查询语言
--必要的字句由两部分组成：
--SELECT句子：用来指定的字段，这里可以包含表中的字段，表达式：函数.

--FROM句子：用来指定数据来源的表

SELECT * FROM emp_hjh
SELECT ename, job, sal, deptno FROM emp_hjh

SELECT ename,sal,sal*12
FROM emp_hjh

--可以使用WHERE字句添加过滤条件，来查询满足条件的数据
--查看条件的数据
--查看工资高于2000的员工信息？
SELECT ename,sal,deptno
FROM emp_hjh
WHERE sal>2000

字符串函数---------------------------------------------
-----1：CONCAT（char1.char2)
--连接字符串（char1，char2）

SELECT CONCAT(ename,sal)
FROM emp_hjh

SELECT CONCAT(CONCAT(ename,','),sal)
FROM emp_hjh

--"||"也是用来连接字符串使用的
SELECT ename||','||sal
FROM emp_hjh

---------------------------------

-----2:LEMGTH(char)
--查看给定字符串的长度

--查看每个员工名字的单词个数
SELECT ename,LENGTH(ename)
FROM emp_hjh

--查看名字是5个字母的员工都有谁？
SELECT ename,sal,deptno
FROM emp_hjh
WHERE LENGTH(ename)=5

----------------------------------

-----3:UPPER,LOWER,INITCAF
--将字符串转换为全大写，全小写，首字母大写
--dual：伪装，查询的数据与任何表中数据无关时
--可以在FROM子句中使用伪装

SELECT ename,sal,deptno
FROM emp_hjh
WHERE ename=UPPER('smith')

-------------------------

----4:TRIM,LTRIM,RTRIM
--去除字符串两边的指定重复字符，或单独去除左边，单独取出右边。

SELECT TRIM('e' FROM 'eeeeliteeee')
FROM dual


SELECT LTRIM( 'eeeeliteeee','e')
FROM dual

SELECT RTRIM( 'eeeeliteeee','e')
FROM dual

-----LTRIM,RIRTM删除方式是从左或右，
--只要字符是第二个参数指定的字符之一就去除
SELECT LTRIM( 'efsefsefsseffsliteeee','fes')
FROM dual

SELECT RTRIM( 'eeeelitfesffeeffsse','fes')
FROM dual

-------------------------------
5:LPAD,RPAD
--补位函数
--LPAD（char1,n,char2)
--以LPAD为例，要将char1显示n位长度。若不足则在左侧补充若干个char2字母
--以达到该长度。char2字符必须是单一的一个字符。
--若char1超过n位，则从左开始截取到n位
select ename,sal from emp_hjh

SELECT ename,LPAD(sal,6,' ')
FROM emp_hjh

SELECT ename,RPAD(sal,6,'$')
FROM emp_hjh

--------------------------

6:SUBSTR(char,m[,n])
--截取字符串char，从第m个字符开始截取，若n不指定，
--或n超过实际可以截取的长度时，则表示截取到字符串末尾。
--n为截取的字符串长度。
--需要注意，在数据库中下标是从1开始的！

SELECT 
  SUBSTR('thinking in java',-7,1000)
FROM dual 

SELECT 
  SUBSTR('thinking in java',10,2)
FROM dual  

--当m若负数，则从倒数位置开始截取。
SELECT 
  SUBSTR('thinking in java',-7,2)
FROM dual  
--n若为负数，则返回(null)
SELECT 
  SUBSTR('thinking in java',-7,-2)
FROM dual 

----------------------------

7:INSTR(char1,shar2[,m[,n]])
--查找char2在char1中的位置
--m，n不指定默认值都是1.
--m表示从第几个字符开始查找。
--n表示第几次出现

SELECT
  INSTR('thinking in java','in') INSTR
FROM dual

SELECT
  INSTR('thinking in java','in',4,2)
FROM dual

--char1没找到char2则返回0
SELECT
  INSTR('thinking in java','in',4,3)
FROM dual

------------------------------------------------------
------------------------------------------------------
1：ROUND(m,n)
--对m进行四舍五入，保留小数点后n位。
--若为0则是保留整数为。
--若n为负数，则是保留十位以上的位数
SELECT ROUND(45.678,2) FROM DUAL;
SELECT ROUND(45.678,0) FROM DUAL;
SELECT ROUND(45.678,-2) FROM DUAL;
SELECT ROUND(445.678,-2) FROM DUAL;
---------------------------
----2:TRUNC函数
--截取数字，参数意义与ROUND一致
SELECT TRUNC(45.678,2) FROM DUAL;
SELECT TRUNC(45.678,0) FROM DUAL;
SELECT TRUNC(45.678,-1) FROM DUAL;
SELECT TRUNC(45.678,-2) FROM DUAL;

----3:MOD(m,n)
--求余数，计算依据m除以n，
--n若为0，函数直接返回m的值

SELECT MOD(13,4)
FROM dual

-----------------------------
--4:CELL,FLOOR
--向上取整与向下取整
--CEIL：返回大于参数的最小值
--FLOOR：返回小于参数的最大值
SELECT CEIL(45.678) FROM dual
SELECT FLOOR(45.678) FROM dual

--------------------------------
--日期类型
--DATE与TIMESTAMP
--DATE：七字节。分别存：世纪，年，月，日，是，分，秒
--TIMESTAMP：7-11字节，前面与DATE一致，后4个字节存秒，
--以下的精度，最多可以表示到秒。

--常用的日期关键字
--SYSDATE，SYSTIMESTAMP
--对应数据路内置函数 返回对应的当前系统时间。
SELECT SYSDATE FROM dual
SELECT SYSTIMESTAMP FROM dual
-------------------------------------------------
---日期转换函数
--1：TO_DATE()
--将给定的字符串按照指定日期格式解析
--为一个DATE类型数据

--在日期格式中，凡不是英文和符号的其他字符都需要使用双引号括起来


SELECT
 TO_DATE('2008年08月08日 20:08:08','YYYY"年"MM"月"DD"日" HH24:MI:SS')
 FROM dual

------------------------------------
----2：TO_CHAR()
--将一个DATE按照指定的日期格式转换为字符串
--TO_CHAR也可以将数字转换为字符串，但是常用的就是将日期进行相应转换

SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS')
FROM dual

SELECT TO_CHAR(SYSDATE,'YYYY"年"MM"月"DD"日" HH24:MI:SS')
FROM dual
----------------------------------------
--日期可以进行计算：
--两个日期之间相减，差为相应的天数
--对一个日期加减一个数字结果等同加减了天数

--查看每个员工入职至今过多少天？
SELECT ename,SYSDATE-hiredate
FROM emp_hjh

--根据生日查看到今天为止活了多少天？
SELECT SYSDATE-to_date('1996-2-25','YYYY-MM-DD')
FROM dual

--查看一百天以后是那一天
SELECT SYSDATE+100
FROM dual
----------------------
--查看今天是今年的第几天
--当前系统时间：
--SELECT SYSDATE
--FROM dual
SELECT SYSDATE
FROM dual
SELECT SYSDATE-to_date('2011-1-1','YYYY-MM-DD')
FROM dual

---------------------------------------------------------
--RR也是两位数表示年，与YY的不同之处在于:当使用TO_DATE函数将一个字符串
--中两位数字转换为对应年的时YY与RR区别是,YY用当前系统时间作为实际，
--而RR会根据该数字与当前系统时间的世纪进行相应判断决定

SELECT
TO_CHAR( TO_DATE('87-08-02','YY-MM-DD'),
   'YYYY-MM-DD')
FROM dual
------
SELECT
TO_CHAR( TO_DATE('89-08-02','RR-MM-DD'),
   'YYYY-MM-DD')
FROM dual
   
-------------------------------------------------------
--日期常用函数
--1：LASR_(date)返回给定日期所在的月底日期 

--当月月底是哪一天
SELECT LAST_DAY(SYSDATE)
FROM dual
--------------------------------
--2:ADD_MONTHS(date,i)
--对给定日期指定的月。若为负数则是减去指定的月

--查看每个员工入职20周年纪念日是哪天？
SELECT ename,ADD_MONTHS(hiredate,12*20)
FROM emp_hjh
---------------------------------
----3:MONRHS_BETWEEN(date1,date2)
--计算两个日期之间相差的月，计算是根据date1-date2得到的。

--查看每个员工入职至今多少个月
SELECT ename,MONTHS_BETWEEN(SYSDATE,hiredate)
FROM emp_hjh
--------------------------------
----4:NEXT_DAY(date,i)
--i对应的数字为：1-7分别表示周日-周六。
--NEXT_DAY返回给定日期第二天开始一周之内的指定周几的日期，

SELECT NEXT_DAY(SYSDATE,4)
FROM dual
------------------------------------
--:LEAST,GREATEST
--求最小值与最大值
--凡是可以比较大小的数据都可以作为这两个函数的参数。但是所有参数的类型要统一。
--对于日期而言，最大值即最晚的日期，最小值即最早的日期。

SELECT LEAST(SYSDATE,TO_DATE('2008-08-08','YYYY-MM-DD'))
FROM dual

SELECT GREATEST(SYSDATE,TO_DATE('2008-08-08','YYYY-MM-DD'))
FROM dual
----------------------------------------
----6:EXTRACT()
--获取指定日期中指定分量的值
SELECT EXTRACT(YEAR FROM SYSDATE)
FROM dual

--查看82年入职的员工？
SELECT ename,sal,hiredate
FROM emp_hjh
WHERE EXTRACT(YEAR FROM hiredate)=1982

=======================================================================
--插入NULL值
CREATE TABLE student_hjh(
  id NUMBER(4),
  name CHAR(20),
  gender CHAR(1)
 ); 
DROP TABLE student_hjh
SELECT * FROM student_hjh
INSERT INTO student_hjh VALUES(1000,'李莫愁','F');
INSERT INTO student_hjh VALUES(1001,'林平之',NULL);
INSERT INTO student_hjh(id,name) VALUES(1002,'张无忌');
SELECT * FROM student_hjh

--更新为NULL
UPDATE student_hjh
SET gender = NULL
WHERE id = 1000
SELECT * FROM student_hjh

--过滤条件中判断NULL的值
--判断要使用 IS NULL 或 IS NOT NULL
DELETE FROM student_hjh
WHERE gender IS NOT NULL
SELECT * FROM student_hjh 

---------------------------------------------
--NULL的计算：
--字符串与NULL连接等于什么也没做
--NULL与数字运算结果还是NUL

--查看每个员工的收入(工资+职效）
SELECT ename,sal,comm,sal+comm
FROM emp_hjh

--空值函数：
--NVL(arg1,arg2)
--若arg1为NULL，函数返回arg2的值，
--若arg1不为NULL，函数返回arg1自身
--所以NVL函数是将NULL替换为一个非NULL值
SELECT
ename,sal,comm,sal+NVL(comm,0)
FROM emp_hjh

SELECT
ename,sal,comm,NVL2(comm,comm+sal,sal)
FROM emp_hjh

--查看每个员工的职效情况，有绩效的则显示为“有绩效”，为NULL的则显示为“没有绩效”
--NVL2(arg1,arg2,arg3)
--NVL2可以实现NVL的功能
--当arg1不为NULL时，函数返回arg2，
--当arg1为NULL时，函数返回arg3
SELECT 
ename,sal,comm,NVL2(comm,'有绩效','没有绩效')
FROM emp_hjh




