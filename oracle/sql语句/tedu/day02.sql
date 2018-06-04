
--------------------------------------------------                   


DQL�����ݿ��ѯ����
--��Ҫ���־�����������ɣ�
--SELECT���ӣ�����ָ�����ֶΣ�������԰������е��ֶΣ����ʽ������.

--FROM���ӣ�����ָ��������Դ�ı�

SELECT * FROM emp_hjh
SELECT ename, job, sal, deptno
FROM emp_hjh

SELECT ename,sal,sal*12
FROM emp_hjh

--����ʹ��WHERE�־���ӹ�������������ѯ��������������
--�鿴����������
--�鿴���ʸ���2000��Ա����Ϣ��
SELECT ename,sal,deptno
FROM emp_hjh
WHERE sal>2000

�ַ�������---------------------------------------------
-----1��CONCAT��char1.char2)
--�����ַ�����char1��char2��

SELECT CONCAT(ename,sal)
FROM emp_hjh

SELECT CONCAT(CONCAT(ename,','),sal)
FROM emp_hjh

--"||"Ҳ�����������ַ���ʹ�õ�
SELECT ename||','||sal
FROM emp_hjh

---------------------------------

-----2:LEMGTH(char)
--�鿴�����ַ����ĳ���

--�鿴ÿ��Ա�����ֵĵ��ʸ���
SELECT ename,LENGTH(ename)
FROM emp_hjh

--�鿴������5����ĸ��Ա������˭��
SELECT ename,sal,deptno
FROM emp_hjh
WHERE LENGTH(ename)=5

----------------------------------

-----3:UPPER,LOWER,INITCAF
--���ַ���ת��Ϊȫ��д��ȫСд������ĸ��д
--dual��αװ����ѯ���������κα��������޹�ʱ
--������FROM�Ӿ���ʹ��αװ
SELECT UPPER('helloworld'),
       LOWER('HELLOWORLD'),
       INITCAP('HELLO WORLD')
FROM dual

SELECT ename,sal,deptno
FROM emp_hjh
WHERE ename=UPPER('smith')

-------------------------

----4:TRIM,LTRIM,RTRIM
--ȥ���ַ������ߵ�ָ���ظ��ַ����򵥶�ȥ����ߣ�����ȡ���ұߡ�

SELECT TRIM('e' FROM 'eeeeliteeee')
FROM dual


SELECT LTRIM( 'eeeeliteeee','e')
FROM dual

SELECT RTRIM( 'eeeeliteeee','e')
FROM dual

-----LTRIM,RIRTMɾ����ʽ�Ǵ�����ң�
--ֻҪ�ַ��ǵڶ�������ָ�����ַ�֮һ��ȥ��
SELECT LTRIM( 'efsefsefsseffsliteeee','fes')
FROM dual

SELECT RTRIM( 'eeeelitfesffeeffsse','fes')
FROM dual

-------------------------------
5:LPAD,RPAD
--��λ����
--LPAD��char1,n,char2)
--��LPADΪ����Ҫ��char1��ʾnλ���ȡ�������������ಹ�����ɸ�char2��ĸ
--�Դﵽ�ó��ȡ�char2�ַ������ǵ�һ��һ���ַ���
--��char1����nλ�������ʼ��ȡ��nλ
SELECT ename,LPAD(sal,6,' ')
FROM emp_hjh

SELECT ename,RPAD(sal,6,'$')
FROM emp_hjh

--------------------------

6:SUBSTR(char,m[,n])
--��ȡ�ַ���char���ӵ�m���ַ���ʼ��ȡ����n��ָ����
--��n����ʵ�ʿ��Խ�ȡ�ĳ���ʱ�����ʾ��ȡ���ַ���ĩβ��
--nΪ��ȡ���ַ������ȡ�
--��Ҫע�⣬�����ݿ����±��Ǵ�1��ʼ�ģ�

SELECT 
  SUBSTR('thinking in java',-7,1000)
FROM dual 

SELECT 
  SUBSTR('thinking in java',10,2)
FROM dual  

--��m����������ӵ���λ�ÿ�ʼ��ȡ��
SELECT 
  SUBSTR('thinking in java',-7,2)
FROM dual  
--n��Ϊ�������򷵻�(null)
SELECT 
  SUBSTR('thinking in java',-7,-2)
FROM dual 

----------------------------

7:INSTR(char1,shar2[,m[,n]])
--����char2��char1�е�λ��
--m��n��ָ��Ĭ��ֵ����1.
--m��ʾ�ӵڼ����ַ���ʼ���ҡ�
--n��ʾ�ڼ��γ���

SELECT
  INSTR('thinking in java','in') INSTR
FROM dual

SELECT
  INSTR('thinking in java','in',4,2)
FROM dual

--char1û�ҵ�char2�򷵻�0
SELECT
  INSTR('thinking in java','in',4,3)
FROM dual

------------------------------------------------------
------------------------------------------------------
1��ROUND(m,n)
--��m�����������룬����С�����nλ��
--��Ϊ0���Ǳ�������Ϊ��
--��nΪ���������Ǳ���ʮλ���ϵ�λ��
SELECT ROUND(45.678,2) FROM DUAL;
SELECT ROUND(45.678,0) FROM DUAL;
SELECT ROUND(45.678,-2) FROM DUAL;

---------------------------
----2:TRUNC����
--��ȡ���֣�����������ROUNDһ��
SELECT TRUNC(45.678,2) FROM DUAL;
SELECT TRUNC(45.678,0) FROM DUAL;
SELECT TRUNC(45.678,-1) FROM DUAL;
SELECT TRUNC(45.678,-2) FROM DUAL;

----3:DOM(m,n)
--����������������m����n��
--n��Ϊ0������ֱ�ӷ���m��ֵ

SELECT MOD(13,4)
FROM dual

-----------------------------
--4:CELL,FLOOR
--����ȡ��������ȡ��
--CEIL�����ش��ڲ�������Сֵ
--FLOOR������С�ڲ��������ֵ
SELECT CEIL(45.678) FROM dual
SELECT FLOOR(45.678) FROM dual

--------------------------------
--��������
--DATE��TIMESTAMP
--DATE�����ֽڡ��ֱ�棺���ͣ��꣬�£��գ��ǣ��֣���
--TIMESTAMP��7-11�ֽڣ�ǰ����DATEһ�£���4���ֽڴ��룬
--���µľ��ȣ������Ա�ʾ���롣

--���õ����ڹؼ���
--SYSDATE��SYSTIMESTAMP
--��Ӧ����·���ú��� ���ض�Ӧ�ĵ�ǰϵͳʱ�䡣
SELECT SYSDATE FROM dual
SELECT SYSTIMESTAMP FROM dual
-------------------------------------------------
---����ת������
--1��TO_DATE()
--���������ַ�������ָ�����ڸ�ʽ����
--Ϊһ��DATE��������

--�����ڸ�ʽ�У�������Ӣ�ĺͷ��ŵ������ַ�����Ҫʹ��˫����������


SELECT
 TO_DATE('2008��08��08�� 20:08:08','YYYY"��"MM"��"DD"��" HH24:MI:SS')
 FROM dual

------------------------------------
----2��TO_CHAR()
--��һ��DATE����ָ�������ڸ�ʽת��Ϊ�ַ���
--TO_CHARҲ���Խ�����ת��Ϊ�ַ��������ǳ��õľ��ǽ����ڽ�����Ӧת��

SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS')
FROM dual

SELECT TO_CHAR(SYSDATE,'YYYY"��"MM"��"DD"��" HH24:MI:SS')
FROM dual
----------------------------------------
--���ڿ��Խ��м��㣺
--��������֮���������Ϊ��Ӧ������
--��һ�����ڼӼ�һ�����ֽ����ͬ�Ӽ�������

--�鿴ÿ��Ա����ְ����������죿
SELECT ename,SYSDATE-hiredate
FROM emp_hjh

--�������ղ鿴������Ϊֹ���˶����죿
SELECT SYSDATE-to_date('1996-2-25','YYYY-MM-DD')
FROM dual

--�鿴һ�����Ժ�����һ��
SELECT SYSDATE+100
FROM dual
----------------------
--�鿴�����ǽ���ĵڼ���
--��ǰϵͳʱ�䣺
--SELECT SYSDATE
--FROM dual
SELECT SYSDATE
FROM dual
SELECT SYSDATE-to_date('2011-1-1','YYYY-MM-DD')
FROM dual

---------------------------------------------------------
--RRҲ����λ����ʾ�꣬��YY�Ĳ�֮ͬ������:��ʹ��TO_DATE������һ���ַ���
--����λ����ת��Ϊ��Ӧ���ʱYY��RR������,YY�õ�ǰϵͳʱ����Ϊʵ�ʣ�
--��RR����ݸ������뵱ǰϵͳʱ������ͽ�����Ӧ�жϾ���

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
--���ڳ��ú���
--1��LASR_(date)���ظ����������ڵ��µ����� 

--�����µ�����һ��
SELECT LAST_DAY(SYSDATE)
FROM dual
--------------------------------
--2:ADD_MONTHS(date,i)
--�Ը�������ָ�����¡���Ϊ�������Ǽ�ȥָ������

--�鿴ÿ��Ա����ְ20��������������죿
SELECT ename,ADD_MONTHS(hiredate,12*20)
FROM emp_hjh
---------------------------------
----3:MONRHS_BETWEEN(date1,date2)
--������������֮�������£������Ǹ���date1-date2�õ��ġ�

--�鿴ÿ��Ա����ְ������ٸ���
SELECT ename,MONTHS_BETWEEN(SYSDATE,hiredate)
FROM emp_hjh
--------------------------------
----4:NEXT_DAY(date,i)
--i��Ӧ������Ϊ��1-7�ֱ��ʾ����-������
--NEXT_DAY���ظ������ڵڶ��쿪ʼһ��֮�ڵ�ָ���ܼ������ڣ�

SELECT NEXT_DAY(SYSDATE,4)
FROM dual
------------------------------------
--:LEAST,GREATEST
--����Сֵ�����ֵ
--���ǿ��ԱȽϴ�С�����ݶ�������Ϊ�����������Ĳ������������в���������Ҫͳһ��
--�������ڶ��ԣ����ֵ����������ڣ���Сֵ����������ڡ�

SELECT LEAST(SYSDATE,TO_DATE('2008-08-08','YYYY-MM-DD'))
FROM dual

SELECT GREATEST(SYSDATE,TO_DATE('2008-08-08','YYYY-MM-DD'))
FROM dual
----------------------------------------
----6:EXTRACT()
--��ȡָ��������ָ��������ֵ
SELECT EXTRACT(YEAR FROM SYSDATE)
FROM dual

--�鿴82����ְ��Ա����
SELECT ename,sal,hiredate
FROM emp_hjh
WHERE EXTRACT(YEAR FROM hiredate)=1982

=======================================================================
--����NULLֵ
CREATE TABLE student_hjh(
  id NUMBER(4),
  name CHAR(20),
  gender CHAR(1)
 ); 
DROP TABLE student_hjh
SELECT * FROM student_hjh
INSERT INTO student_hjh VALUES(1000,'��Ī��','F');
INSERT INTO student_hjh VALUES(1001,'��ƽ֮',NULL);
INSERT INTO student_hjh(id,name) VALUES(1002,'���޼�');
SELECT * FROM student_hjh

--����ΪNULL
UPDATE student_hjh
SET gender = NULL
WHERE id = 1000
SELECT * FROM student_hjh

--�����������ж�NULL��ֵ
--�ж�Ҫʹ�� IS NULL �� IS NOT NULL
DELETE FROM student_hjh
WHERE gender IS NOT NULL
SELECT * FROM student_hjh 

---------------------------------------------
--NULL�ļ��㣺
--�ַ�����NULL���ӵ���ʲôҲû��
--NULL����������������NUL

--�鿴ÿ��Ա��������(����+ְЧ��
SELECT ename,sal,comm,sal+comm
FROM emp_hjh

--��ֵ������
--NVL(arg1,arg2)
--��arg1ΪNULL����������arg2��ֵ��
--��arg1��ΪNULL����������arg1����
--����NVL�����ǽ�NULL�滻Ϊһ����NULLֵ
SELECT
ename,sal,comm,sal+NVL(comm,0)
FROM emp_hjh

SELECT
ename,sal,comm,NVL2(comm,comm+sal,sal)
FROM emp_hjh

--�鿴ÿ��Ա����ְЧ������м�Ч������ʾΪ���м�Ч����ΪNULL������ʾΪ��û�м�Ч��
--NVL2(arg1,arg2,arg3)
--NVL2����ʵ��NVL�Ĺ���
--��arg1��ΪNULLʱ����������arg2��
--��arg1ΪNULLʱ����������arg3
SELECT 
ename,sal,comm,NVL2(comm,'�м�Ч','û�м�Ч')
FROM emp_hjh




