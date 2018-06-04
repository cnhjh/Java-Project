---------------------------day03 SQL��ѯ
--�б���
--��SELECT������һ���ֶ��Ǻ������߱��ʽ����ô�ڽ�����и��ֶ�����
--����������������߱��ʽ���ɶ��Բ�����ڽ�������л�ʹ��
--�ñ�����Ϊ���ֶε����֣�Ӧ������һ����ϰ�ߣ�����
--���Ǳ��ʽ������ָ��һ������
SELECT ename,sal+NVL(comm,0) sal
FROM emp_hjh
--���������ִ�Сд����ϣ���������ִ�Сд���߱�
--���а����ո���ô��Ҫʹ��˫���Ž���������
SELECT ename,sal+NVL(comm,0) "S al"
FROM emp_hjh

-----------------------------
--ʹ��<,>,>=,<=,!=,<>,=
SELECT ename,sal FROM emp_hjh
WHERE sal<2000;
--���Ų�����10��Ա����Ϣ��<> ���ڣ�
SELECT ename,sal,job FROM emp_hjh
WHERE deptno<>10

SELECT ename,sal,hiredate FROM emp_hjh
WHERE hiredate > to_date('1982-1-1','YYYY-MM-DD')

---------------------
--ʹ��AND��OR�ؼ���
--�������Ӷ������ʹ��
SELECT ename,sal,job  FROM emp_hjh
WHERE sal>1000 AND job='SLERK'

SELECT ename,sal,job  FROM emp_hjh
WHERE sal>1000 OR job='CLERK'

--OR�����ȼ�����AND��������ϣ�����OR�����ȼ�������ʹ������
--�鿴���ʸ���1000������ְλ��'SALESMAN'����'CLERK'��Ա��
SELECT ename,sal,job  
FROM emp_hjh
WHERE sal>1000 AND job='SALESMAN' OR job='CLERK'

SELECT ename,sal,job  
FROM emp_hjh
WHERE sal>1000 AND (job='SALESMAN' OR job='CLERK')
-------------------------------------------------------------
--LIKE����ģ��ƥ���ַ���
--֧������ͨ�����
--%��0������ַ���������ַ���
--_����һ��һ���ַ�

--�鿴���ֵڶ�����ĸ��A��Ա����Ϣ��
SELECT ename,sal,deptno
FROM emp_hjh
WHERE ename LIKE '_A%'
--���ֵ��к�����ĸK��Ա��
SELECT ename,sal,deptno
FROM emp_hjh
WHERE ename LIKE '%K%'
--���ֵ��е�������ĸΪA ���� ����Ϊ����ַ���Ա��
SELECT ename,sal,deptno
FROM emp_hjh
WHERE ename LIKE '__A__'
--����ΪS��β��Ա��
SELECT ename,sal,deptno
FROM emp_hjh
WHERE ename LIKE '%S'

--------------------------------------
--IN(list)��NOT IN(listr)
--�ж����б��кͲ����б���
--IN��NOT IN�������ڲ�ѯ��ʹ�á�

--�鿴ְλ��SLERK��SALESMAN��Ա����
SELECT ename,job,sal
FROM emp_hjh
WHERE job IN('CLERK','SALESMAN')
---------------------------------------
BETWEEN...AND...
--�ж���һ�����䷶Χ��
--���С�ұߴ�

--�鿴������1500��3000֮���Ա����
SELECT ename,sal
FROM emp_hjh
WHERE sal BETWEEN 1500 AND 3000

--�鿴������1000-3000֮�䣬20��30�Ų��������к���A��Ա��
SELECT ename,sal,deptno,job
FROM emp_hjh
WHERE sal BETWEEN 1000 AND 3000 
AND deptno IN(20,30)
AND ename LIKE '%A%'
----------------------------------------
--ʹ��IS NULL �� NOT NULL
--��ֵNULL��һ�������ַ�
SELECT ename,sal,comm
FROM emp_hjh
WHERE comm IS NULL
--------------------------------------
--  ANY(list),ALL(list)
--  ANY,ALL �����>,>=,<,<=ʹ�õ�
--  >ANY(list):�����б�֮һ��������С
--  <ANY(list):С���б�֮һ��С�����
--  >ALL(list):�����б����У��������
--  <ALL(list):С���б����У�С����С
--ANY��ALL���б��в�������̶�ֵ��û��ʵ�����壬
--����ͨ������Ӳ�ѯʹ��
SELECT empno,ename,job,sal,deptno
FROM emp_hjh
WHERE sal>ANY(3500,4000,4500)

SELECT empno,ename,job,sal,deptno
FROM emp_hjh
WHERE sal<ALL(3500,4000,4500)
-----------------------------------------------
--DISTINCT�ؼ���
--DISTINCT���Խ��������ָ���ֶ�ֵһ���ļ�¼��ȥ���ظ�ֵ

--�鿴��˾����Щְλ
SELECT 
DISTINCT job   FROM emp_hjh
--���԰��ն��ֶ�ȥ�أ���ô��Щ�ֶε����û��
--�ظ���¼�����ڽ������
SELECT DISTINCT deptno,job 
FROM emp_hjh
-------------------------------------------------------------
---------------------����---------------------------------
--ORDER BY�־�
--ORDER BY���ڶԲ�ѯ�Ľ��������ָ�ֶε�ֵ��������
--������Ϊ������ASC��������(DESC)
--Ĭ��Ϊ����
--ORDER BY ���붨����SELECT����е����һ��������
SELECT ename,sal,job
FROM emp_hjh
ORDER BY sal DESC
--�鿴20�Ų��ŵĹ���
SELECT ename,sal,deptno
FROM emp_hjh
WHERE deptno=20
ORDER BY sal DESC

SELECT ename,sal,deptno
FROM emp_hjh

--���ֶ�����ʱ��ORDER BY ������������ȼ��ģ����Ȱ��յ�һ���ֶ��Ƚ�������
--�����ֶ��м�¼ֵ�ظ�ʱ���ٽ���Щ��¼���յڶ����ֶ�������������

--�鿴Ա�����Ž���͹��ʽ���
SELECT  ename,deptno,sal
FROM emp_hjh
ORDER BY deptno DESC,sal DESC

--��������ֶ��к���NULLֵ��NULL���϶�Ϊ���ֵ��
SELECT ename,comm
FROM emp_hjh
ORDER BY comm

--------------------------------------------------------
----------------�ۺϺ���------------------------------------
--�ۺϺ����ֳ�Ϊ���麯�������к�����
--�ۺϺ����������ǶԽ����ָ���ֶε�ֵ����ͳ�ƹ���
--MAX������NIM������SUM������AVG����
--���ֵ ����Сֵ  �� �ܺ� ��ƽ��ֵ

--����һ���ǶԼ�¼ ����ͳ��  
--COUNT����
SELECT MAX(sal) FROM emp_hjh

SELECT MAX(sal),MIN(sal),
       SUM(sal),AVG(sal)
FROM emp_hjh

--�鿴��˾�ж�����   ��������
SELECT COUNT(ename) FROM emp_hjh
SELECT COUNT(*) FROM emp_hjh
SELECT COUNT(1) FROM emp_hjh
SELECT 1 FROM emp_hjh

--�ۺ�������NULLֵ
SELECT SUM(comm),AVG(comm)
FROM emp_hjh

SELECT AVG(NVL(comm,0))
FROM emp_hjh
----------------------------------------------------------
----------------����----------------------------------
--GROUP BY�Ӿ�
--GROUP BY ���Խ�������ո������ֶ�ֵһ����¼���з��顣
--��ϾۺϺ���ʹ�ÿ�����ɷ���ͳ�ƹ���

--�鿴ÿ�����ŵ�ƽ������
SELECT AVG(sal),deptno FROM emp_hjh
GROUP BY deptno

--��SELECT�к��оۺϺ�����ʱ����ô�����ھۺϺ����еĵ����ֶΣ�
--����Ҫ����GROUP BY�־���

--�鿴ÿ��ְλ����߹�������͹����Ƕ���
SELECT MAX(sal),MIN(sal),job
FROM emp_hjh
GROUP BY job

--GROUP BY�����ֶη���ʱ���ǽ���Щ
--�ֶ�ֵ���һ���ļ�¼����һ�顣

--ͳ��ͬ���ţ�ְͬλ��Ա�����ж����ˣ�
SELECT COUNT(*),deptno,job
FROM emp_hjh
GROUP BY deptno,job

--�鿴���ŵ�ƽ�����ʣ�ǰ���Ǹò��ŵ�ƽ�����ʸ���2000?
SELECT 
AVG(sal),deptno FROM emp_hjh
WHERE AVG(sal)>2000
GROUP BY deptno

--�����SQL�������쳣��WHERE�־����ǲ���ʹ�þۺϺ�����Ϊ���������ģ�
--ԭ�����ڹ��˵�ʵ�ʲ���
--WHERE�ǰ����ѯ�����������н��й���ʹ�õģ�
--����ȷ��������п��Բ�ѯ������Ŀ¼����
--���ۺϺ����ǽ����ڲ�ѯ=���������ݻ����Ͻ���ͳ�Ʋ��ܵõ������
--����ʹ�þۺϺ�������Ӧ������WHERE֮����е�

--HAVING �Ӿ���Ը��ݾۺϺ������й��ˣ�������������������
--����GROUP BY�ķ���

SELECT AVG(sal),deptno
FROM emp_hjh
GROUP BY deptno
HAVING AVG(sal)>2000 


--�鿴ƽ�����ʸ���2000����Щ���ŵ���߹����Ƕ��٣�
SELECT 
MAX(sal),deptno
FROM emp_hjh
GROUP BY deptno
HAVING AVG(sal)>2000

-------------------------------------------------------
--------------������ѯ------------------------------
--������ѯ�Ľ���е��ֶ����Զ��ű������Ҫ�ڲ�ѯ
--��ʱ�����϶��ű���в�ѯ�����ݸ���������������
--���������ݽ�����Ӧ��ϵ���ڷֱ����Щ��¼����ȡ
--Ҫ��ѯ���ֶο��γɽ�����е�ÿ����¼

--�鿴ÿ��Ա���������Լ������ڲ��ŵ����֣�

--���ڹ�����ѯ���ֶ�����Щ���ж�����ʱ��
--��Ҫʹ�ñ�������ȷ�ֶ�����������Ϊ����ȡһ��
--�������򻯸��Ӷ�
SELECT ename,dname
FROM emp_hjh ,dept_hjh 
WHERE emp_hjh.deptno=dept_hjh.deptno

SELECT e.ename,e.deptno,d.dname
FROM emp_hjh e,dept_hjh d
WHERE e.deptno=d.deptno
--------------------------------------
--�ڽ��й�����ѯʱ���й���Ҫ����ô����������������������ͬʱ������
--�鿴NEW YORK������Ա������˭
SELECT e.ename,e.deptno,
       d.dname, d.loc
FROM emp_hjh e,dept_hjh d
WHERE e.deptno=d.deptno
AND d.loc='NEW YORK'

-- ������ѯ�в�ָ������������������������Чʱ��
--�����"�ѿ�����"����ͨ����һ������Ľ����
SELECT e.ename,d.dname
FROM emp_hjh e,dept_hjh d

--N���ѯ����Ҫ��N-1������������

--������
--������Ҳ��������ɹ�����ѯ�ġ�
--����JOIN...ON...����ʽ�������
--��������������ļ�¼���ᱻ��ѯ����

SELECT e.ename,d.dname
FROM emp_hjh e,dept_hjh d
WHERE e.deptno=d.deptno

--�鿴ÿ��Ա���������Լ������ڲ�������

SELECT e.ename,d.dname
FROM emp_hjh e JOIN dept_hjh d
ON e.deptno=d.deptno

--��SCOTT�Ĳ��źŸ�Ϊ50
update emp_hjh
set deptno=50
where ename='SCOTT'
------------------------------------------

--������
--�������ڹ�����ѯ�г��˿��Խ��������������ļ�¼��ѯ����֮�⣬
--�����Խ����������������ļ�¼��ѯ������
--�����ӷ�Ϊ��
--�������ӣ��������ӣ�ȫ������
--�������ӣ���JOIN�����Ϊ�������ñ��¼��Ҫ
--��ѯ��������ĳ������¼��������������ʱ����ô�����
--�и�����¼����JOIN�Ҳ���ֶ�ȫ��ΪNULL
--LEFT OUTER JOIN , RIGHT OUTER JOIN , FULL OUTER JOIN    
-- ��������           ��������            ȫ������
SELECT e.ename,e.job,e.sal,
       d.dname,d.loc
FROM emp_hjh e FULL OUTER JOIN dept_hjh d
ON e.deptno=d.deptno

SELECT e.ename,d.dname
FROM emp_hjh e,dept_hjh d
WHERE e.deptno(+)=d.deptno
----------------------------------
--������
--������ָ���ǵ�ǰ��һ���оֿ��Զ�Ӧ��ǰ�Լ��Ķ�������
--��������Ϊ�˽�����ݵ�������ͬ�����Ǳ����ִ������¼���ϵ
--����״�ṹ������

--�鿴ÿ��Ա���Լ����쵼������
SELECT e.ename,m.ename
FROM emp_hjh e,emp_hjh m
WHERE e.mgr=m.empno(+)

SELECT e.ename,m.ename
FROM emp_hjh e LEFT OUTER JOIN emp_hjh m
ON e.mgr=m.empno


















