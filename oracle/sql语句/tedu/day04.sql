--�Ӳ�ѯ
--�Ӳ�ѯ��һ����ѯ��䣬����Ƕ��������SQL����еģ�
--Ŀ���ǽ���ѯ�Ľ���ṩ������SQL���
�鿴˭�Ĺ��ʸ���CLARK�Ĺ��ʣ�
SELECT ename,sal  FROM emp_hjh
WHERE sal>(SELECT sal FROM emp_hjh
           WHERE ename='CLARK')
˭��CLARKͬ���ţ�
SELECT ename,deptno
FROM emp_hjh
WHERE deptno=(SELECT deptno
              FROM emp_hjh
              WHERE ename='CLARK')


--�鿴���ʸ���ƽ�����ʵ�Ա��
SELECT ename,sal
FROM emp_hjh
WHERE sal>(SELECT AVG(sal)
           FROM emp_hjh)


---------------------------------------
--��DDL��ʹ���Ӳ�ѯ�����Խ�һ���Ӳ�ѯ��
--�������������ٴ�������
CREATE TABLE employee_hjh
AS
SELECT  e.empno,e.ename,e.sal,e.job,
        d.deptno,d.dname,d.loc
FROM emp_hjh e,dept_hjh d   
WHERE e.deptno=d.deptno(+)

DROP TABLE  employee_hjh      
SELECT * FROM employee_hjh

--ʹ���Ӳ�ѯ�������ʱ�򣬲�ѯ���ٸ��ֶδ����ı���ж��ٸ��ֶΣ�
--�ֶ��������ѯ���ֶ�����һ�£������б�����������ͣ�����Ҳһ�£�
--������Ҫע����ǣ���ѯ���ֶ��Ǻ������߱��ʽ����ô����ֶ�
--�ĸ��ֶ��������������

--DDL��ʹ���Ӳ�ѯ
--��CLARK���ڲ��ŵ�Ա�������ϸ�10%
UPDATE emp_hjh
SET sal=sal*1.1
WHERE deptno=(SELECT deptno FROM emp_hjh
             WHERE ename='CLARK'
             )
SELECT * FROM emp_hjh
--------------------------------------
--�Ӳ�ѯ���ݲ�ѯ�����Ϊ��
--���е��У����е��У����ж����Ӳ�ѯ
--���е����Ӳ�ѯ �����ڹ��������У������Ӳ�ѯͨ����������ʹ��

--���ڶ��ж����Ӳ�ѯ���й���ʱ����Ҫ���IN��ANY��ALLʹ��

�鿴��ְλ��SALESMANͬ���ŵ�Ա����
SELECT ename,job,deptno
FROM emp_hjh
WHERE deptno IN (SELECT deptno FROM emp_hjh
             WHERE job='SALESMAN')
AND job<>'SALESMAN'

�鿴��ְλ��SALESMAN��CLERK���ʶ��ߵ�Ա��?

SELECT ename,sal,job
FROM emp_hjh
WHERE sal>ALL(SELECT sal FROM emp_hjh
              WHERE job IN('SALESMAN','CLERK')
              )
-----------------------------------------------------
--�г�����Ա���Ĳ�����Ϣ��
SELECT deptno,dname
FROM dept_hjh d
WHERE EXISTS (SELECT * FROM emp_hjh e
              WHERE d.deptno=e.deptno)

--EXISTS�ؼ���
--EXISTS ǰ����Լ� NOT  
�鿴��������Ա��(�쵼)��
m�쵼 n
SELECT m.ename,m.job,m.sal
FROM emp_hjh m
WHERE EXISTS(SELECT * FROM emp_hjh e
             WHERE e.mgr = m.empno)

--HAVING ��ʹ���Ӳ�ѯ��
�鿴ÿ�����ŵ����нˮ��ǰ����Ҫ����30�Ų��ŵ����нˮ��
SELECT MIN(sal),deptno
FROM  emp_hjh
GROUP BY deptno
HAVING MIN(sal)>(SELECT MIN(sal)
                 FROM emp_hjh
                 WHERE deptno=30)

--��FROM��ʹ���Ӳ�ѯ
--ͨ�������Ӳ�ѯ��FROM�־��г��֣������ǵ���һ�ű�ʹ�á�

�鿴�����Լ����ڲ���ƽ�����ʵ�Ա����
1.��ÿ�����ŵ�ƽ������
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
-------------  ��ҳ��ѯ --------------------------
--��ҳ��ѯ���ǽ����в�ѯ�������оַ����β�ѯ�������������ĺô�����
--����ѯ������������ʱ���Լ����ڴ濪�������ϵͳ��Ӧ���ȣ��������紫�䡣
--��ҳ�Ƿ��ԣ���ͬ���ݿⶼ�ṩ�˷�ҳ��ѯ�Ļ��ƣ������﷨�������ͬ

--ORACLE�������ṩ��һ��α����ROWNUM

--ORWNUM���������κ�һ�ű��У�����ÿ�ű����Բ�ѯ��¼���кţ���
--�кŵ������ǰ����ѯ���̽��еģ�ROWNUM�ֶξ���Ϊ�˸�����¼
--�ڽ�����в�����Ӧ���кţ���1��ʼ����

�鿴ְԱ��
SELECT ROWNUM,empno,ename,job,sal
FROM emp_hjh

�鿴���ű�
SELECT ROWNUM,deptno,dname,loc
FROM dept_hjh

---��Ҫע�⣬��ʹ��ROWNUM�Խ�������кŵĹ����У���Ҫʹ��
--ROWNUM������1�������ֵ��жϣ�����ò������
SELECT ROWNUM,empno,ename,job,sal
FROM emp_hjh
WHERE ROWNUM >1 

SELECT * FROM(
SELECT ROWNUM rn,empno,ename,job,sal
FROM emp_hjh)
WHERE rn BETWEEN 6 AND 10


�鿴��˾���������ĵ�6-10����
SELECT *
FROM(SELECT ROWNUM rn,t.*
     FROM(SELECT ename,job,sal
          FROM emp_hjh
          ORDER BY sal DESC) t)
WHERE rn BETWEEN 6 AND 10
--����������ʱʹ�����·���Ч�ʸ���
SELECT *FROM(SELECT ROWNUM rn,t.*
             FROM(SELECT ename,job,sal
                  FROM emp_hjh
                  ORDER BY sal DESC) t
             WHERE ROWNUM <=10
             )
WHERE rn >= 6 

--���㷶Χ�Ĺ�ʽ��
--PageSize:ÿҳ������ʾ����Ŀ��
--Page:ҳ��

start:(Page-1)*PageSize+1
end:PageSize*Page
----------------------------------------
------------  DECODE����  ----------------
--DECODE��������ʵ�ַ�֧�ṹ
SELECT ename,job,sal,
     DECODE(job,
           'MANAGER',sal*1.2,
           'ANALYST',sal*1.1,
           'SALESMAN',sal*1.05,
           sal
      )bonus
FROM emp_hjh;
--��DECODE�����������Ƶ���CASE��䣬ʵ�������� if-else �Ĳ���
SELECT ename,job,sal,
     CASE job WHEN 'MANAGER' THEN sal*1.2
              WHEN 'ANALYST' THEN sal*1.1
              WHEN 'SALESMAN' THEN sal*1.05
              ELSE sal END
              bonus
FROM emp_hjh;

--DECODE��GROUP BY �п���ʵ�ֽ��ֶβ�ֵͬ�ļ�¼��Ϊһ��
--��ְλ��ANALYST��MANAGER����һ�飬����ְλ����һ�飬�ֱ�ͳ������

--�Զ�������??????===========================================================
SELECT deptno,dname,loc
FROM dept_hjh
ORDER BY
DECODE(dname,'OPERATIONS',1,
              'ACCOUNTING',2,
              'SALES',3
              );

--------------------------------------
-----------  ������ -----------------
--���������Խ����������ָ�����ֶη���
--Ȼ�������ڰ���ָ�����ֶ�������ÿ��ļ�¼
--����һ���кš�

--ROW_NUMBER():������������Ψһ������
���ݲ���id����(PARTITION BY)��ʾ ����������(ORDER BY)
SELECT ename,job,sal,deptno,
ROW_NUMBER() OVER(
   PARTITION BY deptno
   ORDER BY sal DESC
) rank
FROM emp_hjh

--RANK() ��ͬ���ݷ�����ͬ���� ��Ծ����
SELECT ename,job,sal,deptno,
RANK() OVER(
   PARTITION BY deptno
   ORDER BY sal DESC
) rank
FROM emp_hjh

--DENSE_RANK():����������������Ψһ������
SELECT ename,job,sal,deptno,
DENSE_RANK() OVER(
   PARTITION BY deptno
   ORDER BY sal DESC
) rank
FROM emp_hjh


------------------------------------------
------------�������� ---------
--UNION �Զ��ϲ��ظ���¼
SELECT ename,job,sal 
FROM emp_hjh
WHERE job = 'MANAGER'
UNION
SELECT ename,job,sal
FROM emp_hjh
WHERE sal>2500;

--UNION ALL ����������������� �����ظ���¼
SELECT ename,job,sal
FROM emp_hjh
WHERE job='MANAGER'
UNION ALL
SELECT ename,job,sal 
FROM emp_hjh
WHERE sal >2500;

--INTERSECT ͬʱ��������������е����ݲ���ʾ���(������������е�����)
SELECT ename,job,sal
FROM emp_hjh
WHERE job='MANAGER'
INTERSECT
SELECT ename,job,sal
FROM emp_hjh
WHERE sal>2500

--MINUS ��һ����������ڣ��ڶ�������������ڵ����ݲű���ʾ����
--Ҳ���ǵ�һ���������ȥ�ڶ���������Ľ��
SELECT ename,job,sal
FROM emp_hjh
WHERE job='MANAGER'
MINUS
SELECT ename,job,sal
FROM emp_hjh
WHERE sal>=2500


---------------------------------------------------
================= �߼����麯�� =========================

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


ROLLUP��������
--ROLLUP�е�ÿһ������������Ҫ������ֶ�
--ROLLUP�Ὣ�����ֶ��������������ͳ��ֱ��һ���ֶζ�û�У�Ȼ��
--����Щ����ͳ�ƵĽ������һ���������ʾ

GROUP BY ROLLUP(a,b,c)
�ȼۣ�
GROUP BY a,b,c
UNION ALL
GROUP BY a,b
UNION ALL
GROUP BY a
UNION ALL
ȫ��
��һ������п���ÿ�죬ÿ�£�ÿ���Լ��ܹ���Ӫҵ��
SELECT year_id,month_id,day_id,SUM(sales_value)
FROM sales_hjh
GROUP BY ROLLUP(year_id,month_id,day_id)
ORDER BY year_id,month_id,day_id

CUBE()������
--��ÿ��������ÿ����϶�����һ�η��飬Ȼ������ͳ��
--�������һ���������ʾ������CUBE�������Ϊ2�Ĳ��������η�
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

GROUPING SETS()������
--GROUPING SETS��ÿһ��������һ�ַ��鷽ʽ
--���Ὣ��Щ����ͳ�ƵĽ������һ���������ʾ��

�鿴ÿ����ÿ��Ӫҵ�
SELECT year_id,month_id,day_id,SUM(sales_value)
FROM sales_hjh
GROUP BY GROUPING SETS(
    (year_id,month_id,day_id),
    (year_id,month_id)
    )
ORDER BY year_id,month_id,day_id

























