************************************   sql����   ************************************
-- employees ְԱ
create table employees (
  EMPLOYEE_ID   NUMBER(6) PRIMARY KEY, -- ְԱid
  FIRST_NAME VARCHAR2(20),  -- ����
  LAST_NAME VARCHAR2(25), -- ����
  EMAIL VARCHAR2(25), -- ����
  PHONE_NUMBER    VARCHAR2(20), -- �ֻ�����
  HIRE_DATE  DATE, -- ��ְ����
  JOB_ID VARCHAR2(10), -- ְλid    --jobs��
  SALARY NUMBER(8,2), -- нˮ
  COMMISSION_PCT NUMBER(2,2), -- �ٷֱ�
  MANAGER_ID NUMBER(6), -- ������id
  DEPARTMENT_ID NUMBER(4) -- ����id    --departments��
);
INSERT INTO employees VALUES(7369,'���','��','123@qq.com','12345678912',to_date('2017-05-29','YYYY-MM-DD'),'3',5620.00,null,7566,20);
INSERT INTO employees VALUES(7499,'С��','��','12354@qq.com','12345678912',to_date('2015-4-29','YYYY-MM-DD'),'2',8620.00,null,7654,30);
INSERT INTO employees VALUES(7521,'����','��','12433@qq.com','12345678912',to_date('2017-05-02','YYYY-MM-DD'),'3',6620.00,null,7654,30);
INSERT INTO employees VALUES(7566,'��ʦ','��','12233@qq.com','12345678912',to_date('2015-08-29','YYYY-MM-DD'),'2',9620.00,null,7654,20);
INSERT INTO employees VALUES(7654,'��ʦ','��','1252433@qq.com','12345678912',to_date('2015-05-30','YYYY-MM-DD'),'1',25620.00,null,null,10);
INSERT INTO employees VALUES(7698,'����','��','124353@qq.com','12345678912',to_date('2015-08-29','YYYY-MM-DD'),'2',12620.00,null,7654,30);
INSERT INTO employees VALUES(7782,'��ǿ','ʩ','122423@qq.com','12345678912',to_date('2017-09-30','YYYY-MM-DD'),'3',7620.00,null,7566,10);
INSERT INTO employees VALUES(7783,'xiaochun','Chen','122423@qq.com','12345678912',to_date('2017-06-29','YYYY-MM-DD'),'3',7620.00,null,7566,10);
  
update EMPLOYEES set HIRE_DATE=to_date('2015-4-30','YYYY-MM-DD') where EMPLOYEE_ID = 7782
update EMPLOYEES set SALARY=9620.00 where EMPLOYEE_ID = 7566
update EMPLOYEES set  last_name='Chen' where EMPLOYEE_ID = 7782
drop table employees
select * from  employees;
-- jobs ְҵ
create table jobs(
  JOB_ID VARCHAR2(10),--id
  JOB_TITLE VARCHAR2(35),--ְ��
  MIN_SALARY NUMBER(6),--��͹���
  MAX_SALARY NUMBER(6)--��߹���
)

-- departments�� ����
create table departments(
  DEPARTMENT_ID  NUMBER(4), -- ����id
  DEPARTMENT_NAME VARCHAR2(30), --��������
  MANAGER_ID NUMBER(6), -- ����������Ա
  LOCATION_ID  NUMBER(4) -- λ��,�ص�  --locations ��
)

-- locations �� �ص�
create table locations(
  LOCATION_ID NUMBER(4), -- �ص�id
  STREET_ADDRESS VARCHAR2(40), -- ���Ľֵ���ַ, ����סַ
  POSTAL_CODE VARCHAR2(12), -- ��������, �ʱ�, �ʵ�����
  CITY VARCHAR2(30), --����
  STATE_PROVINCE VARCHAR2(25), --���ڵ���
  COUNTRY_ID CHAR(2) --���� ����
)

-- job_grades �� ְλ�ȼ�
create table job_grades(
  GRADE_LEVEL VARCHAR2(3), --ְ��
  LOWEST_SAL NUMBER, -- ���
  HIGHEST_SAL NUMBER --���
)
-- 
-- 1. ��ѯÿ���µ����� 2 ����ְ��Ա������Ϣ.
-- 2. ��ѯ�� last_name Ϊ 'Chen' �� manager ����Ϣ.
-- 3. ��ѯƽ�����ʸ��� 8000 �Ĳ��� id ������ƽ������.
-- 4. ��ѯ������͵�Ա����Ϣ: last_name, salary
-- 5. ��ѯƽ��������͵Ĳ�����Ϣ
-- 6. ��ѯƽ��������͵Ĳ�����Ϣ�͸ò��ŵ�ƽ������
-- 7. ��ѯƽ��������ߵ� job ��Ϣ
-- 8. ��ѯƽ�����ʸ��ڹ�˾ƽ�����ʵĲ�������Щ?
-- 9. ��ѯ����˾������ manager ����ϸ��Ϣ.
-- 10. ���������� ��߹�������͵��Ǹ����ŵ� ��͹����Ƕ���
-- 11. ��ѯƽ��������ߵĲ��ŵ� manager ����ϸ��Ϣ: last_name,department_id, email, salary
-- 12. ��ѯ 1999 ������˾��������Ա������߹��ʵ��Ǹ�Ա������Ϣ.
-- 13. �������������б� job_idΪ��IT_PROG���������й��ʶ��͵�Ա����Ա���š�������job_id �Լ� salary
-- ************************answers*********************
-- 1. ��ѯÿ���µ����� 2 ����ְ��Ա������Ϣ.
   
   
-- 2. ��ѯ�� last_name Ϊ 'Chen' �� manager ����Ϣ.
    -- 1). ͨ������ sql ��ѯ: ͨ��'chen'��ѯmanager��id���õ�manager��Ϣ
      
      

    -- 2). ͨ��һ�� sql ��ѯ(������):
  
  
    --3).ͨ��һ�� sql �Ӳ�ѯ 
 
 
    -- 3). ͨ��һ�� sql ��ѯ(�Ӳ�ѯ):


-- 3. ��ѯƽ�����ʸ��� 8000 �Ĳ��� id ������ƽ������.
    --MAX������NIM������SUM������AVG����--�ۺϺ����ֳ�Ϊ���麯�������к������ۺϺ����������ǶԽ����ָ���ֶε�ֵ����ͳ�ƹ���,�ۺ�������NULLֵ
    --���ֵ ����Сֵ  �� �ܺ� ��ƽ��ֵ
    --GROUP BY ���Խ�������ո������ֶ�ֵһ����¼���з��顣��ϾۺϺ���ʹ�ÿ�����ɷ���ͳ�ƹ���
    --HAVING �Ӿ���Ը��ݾۺϺ������й��ˣ������������������� ,����GROUP BY�ķ��� 
  
            --����������ƽ�����ʳ���8000�Ĳ���  �ۺϺ�������Ӧ������WHERE֮����е�
-- 4. ��ѯ������͵�Ա����Ϣ: last_name, salary
  
  
-- 5. ��ѯƽ��������͵Ĳ�����Ϣ


-- 6. ��ѯƽ��������͵Ĳ�����Ϣ�͸ò��ŵ�ƽ������


-- 7. ��ѯƽ��������ߵ� job ��Ϣ
    -- 1). �� job_id ����, ��ѯ��ߵ�ƽ������
   
   
    -- 2). ��ѯ��ƽ�����ʵ��� 1) �� job_id


    -- 3). ��ѯ�� 2) ��Ӧ�� job ��Ϣ
   
   
-- 8. ��ѯƽ�����ʸ��ڹ�˾ƽ�����ʵĲ�������Щ?
    -- 1). ��ѯ����˾��ƽ������
 
 
    -- 2). ��ѯƽ�����ʸ��� 1) �Ĳ��� ID
  
  
-- 9. ��ѯ����˾������ manager ����ϸ��Ϣ.
    -- 1). ��ѯ�����е� manager_id
   
   
    -- 2). ��ѯ�� employee_id Ϊ 1) ��ѯ�������ЩԱ������Ϣ
  
  
-- 10. ���������� ��߹�������͵��Ǹ����ŵ� ��͹����Ƕ���
    -- 1). ��ѯ���������ŵ���߹���
    
    
    -- 2). ��ѯ�� 1) ��Ӧ�Ĳ�ѯ��������ֵ: ������������͵���߹�
    ��(�޷���ѯ��Ӧ�� department_id)
 
 
    -- 3). ��ѯ�� 2) ����Ӧ�Ĳ��� id �Ƕ���: ������������߹��ʵ���
    -- 2) ���Ǹ����ŵ� id
   
   
    -- 4). ��ѯ�� 3) ���ڲ��ŵ���͹���
  
  
-- 11. ��ѯƽ��������ߵĲ��ŵ� manager ����ϸ��Ϣ: last_name,
    department_id, email, salary
    -- 1). ����������, ��ѯƽ��������ߵ�ƽ�������Ƕ���
 
 
    -- 2). ����������, ƽ�����ʵ��� 1) ���Ǹ����ŵĲ��ź��Ƕ���
 
 
    -- 3). ��ѯ�� 2) ��Ӧ�Ĳ��ŵ� manager_id



    -- 4). ��ѯ�� employee_id Ϊ 3) ��ѯ�� manager_id ��Ա����last_name, department_id, email, salary
  
  
-- 12. ��ѯ 1999 ������˾��������Ա������߹��ʵ��Ǹ�Ա������Ϣ.
    -- 1). ��ѯ�� 1999 ������˾�����е�Ա���� salary
   
   
    -- 2). ��ѯ�� 1) ��Ӧ�Ľ�������ֵ
   
   
    -- 3). ��ѯ���ʵ��� 2) ��Ӧ�Ľ���� 1999 ����ְ��Ա����Ϣ
  
  
    
-- 13. �������������б� job_id Ϊ��IT_PROG���������й��ʶ��͵�Ա����Ա���š�������job_id �Լ� salary


    
    
    
************************************  �߼��Ӳ�ѯ  ************************************
? ��д�����Ӳ�ѯ
? �� FROM �Ӿ���ʹ���Ӳ�ѯ
? �� SQL��ʹ�õ����Ӳ�ѯ
? ��д����Ӳ�ѯ
? ʹ�� EXISTS �� NOT EXISTS ������
? ʹ���Ӳ�ѯ���º�ɾ������
? ʹ�� WITH �Ӿ�
--�����Ӳ�ѯ�����ɶԱȽ� & �ɶԱȽϣ�
-- 1. ��ѯ�� 141�Ż� 174��Ա���� manager_id�� department_id��ͬ������Ա���� employee_id, manager_id, department_id
[��ʽһ]
    SELECT employee_id, manager_id, department_id
    FROM employees
    WHERE manager_id IN
    (SELECT manager_id
    FROM employees
    WHERE employee_id IN (174,141))
    AND department_id IN
    (SELECT department_id
    FROM employees
    WHERE employee_id IN (174,141))
    AND employee_id NOT IN(174,141);
[��ʽ��]
    SELECT employee_id, manager_id, department_id
    FROM employees
    WHERE (manager_id, department_id) IN
    (SELECT manager_id, department_id
    FROM employees
    WHERE employee_id IN (141,174))
    AND employee_id NOT IN (141,174);
--�� FROM �Ӿ���ʹ���Ӳ�ѯ
-- 2. ���رȱ�����ƽ�����ʸߵ�Ա���� last_name, department_id,salary��ƽ������
[��ʽһ]
    select last_name,department_id,salary,
    (select avg(salary)from employees e3
    where e1.department_id = e3.department_id
    group by department_id) avg_salary
    from employees e1
    where salary >
    (select avg(salary)
    from employees e2
    where e1.department_id = e2.department_id
    --group by department_id
    )
[��ʽ��]
    SELECT a.last_name, a.salary,
    a.department_id, b.salavg
    FROM employees a, (SELECT department_id,
    AVG(salary) salavg
    FROM employees
    GROUP BY department_id) b
    WHERE a.department_id = b.department_id
    AND a.salary > b.salavg;
--�����Ӳ�ѯ���ʽ
? Oracle8i ֻ����������¿���ʹ��, ����:
�C SELECT ��� (FROM �� WHERE �Ӿ�)
�C INSERT ����е� VALUES�б���
? Oracle9i �е����Ӳ�ѯ���ʽ�������������ʹ��:
�C DECODE �� CASE
�C SELECT �г� GROUP BY �Ӿ�����������Ӿ���
-- 3. ��ʽԱ���� employee_id,last_name �� location�����У���Ա��department_id �� location_id Ϊ 1800 �� department_id ��ͬ����locationΪ��Canada��,������Ϊ��USA����
    SELECT employee_id, last_name,
    (CASE department_id
    WHEN (SELECT department_id FROM departments
    WHERE location_id = 1800)
    THEN 'Canada' ELSE 'USA' END) location
    FROM employees;
-- 4. �� ѯ Ա �� �� employee_id,last_name, Ҫ �� �� �� Ա �� ��department_name����
    SELECT employee_id, last_name
    FROM employees e
    ORDER BY (SELECT department_name
    FROM departments d
    WHERE e.department_id = d.department_id);
--����Ӳ�ѯ
-- 5.��ѯԱ���й��ʴ��ڱ�����ƽ�����ʵ�Ա���� last_name,
    salary ���� department_id
    SELECT last_name, salary, department_id
    FROM employees outer
    WHERE salary >
    (SELECT AVG(salary)
    FROM employees
    WHERE department_id =
    outer.department_id) ;
-- 6. �� employees���� employee_id�� job_history���� employee_id��ͬ����Ŀ��С�� 2�������Щ��ͬ id��Ա���� employee_id,last_name���� job_id
    SELECT e.employee_id, last_name,e.job_id
    FROM employees e
    WHERE 2 <= (SELECT COUNT(*)
    FROM job_history
    WHERE employee_id = e.employee_id);
--EXISTS ������
? EXISTS ������������Ӳ�ѯ���Ƿ����������������
? ������Ӳ�ѯ�д���������������:
�C �����Ӳ�ѯ�м�������
�C �������� TRUE
-- 7. ��ѯ��˾�����ߵ� employee_id,last_name,job_id,
    department_id��Ϣ
    SELECT employee_id, last_name, job_id, department_id
    FROM employees outer
    WHERE EXISTS ( SELECT 'X'
    FROM employees
    WHERE manager_id =
    outer.employee_id);
-- 8. �� ѯ departments �� �� �� �� �� �� �� employees �� �� �� �� �� ��department_id�� department_name
    SELECT department_id, department_name
    FROM departments d
    WHERE NOT EXISTS (SELECT 'X'
    FROM employees
    WHERE department_id
    = d.department_id);
--�������ݸ���
-- 9.�޸ı� employees,��� department_name �У����� department_id��Ӧ�Ĳ������ơ�
    ALTER TABLE employees
    ADD(department_name VARCHAR2(14));
    UPDATE employees e
    SET department_name =
    (SELECT department_name
    FROM departments d
    WHERE e.department_id = d.department_id);
--��������ɾ��
-- 10.ɾ���� employees�У����� emp_history����е�����
    DELETE FROM employees E
    WHERE employee_id in
    (SELECT employee_id
    FROM emp_history
    WHERE employee_id = E.employee_id);
--WITH �Ӿ�
11. ��ѯ��˾�и����ŵ��ܹ��ʴ��ڹ�˾�и����ŵ�ƽ���ܹ��ʵĲ�����Ϣ
    WITH
    dept_costs AS (
    SELECT d.department_name, SUM(e.salary) AS dept_total
    FROM employees e, departments d
    WHERE e.department_id = d.department_id
    GROUP BY d.department_name),
    avg_cost AS (
    SELECT SUM(dept_total)/COUNT(*) AS dept_avg
    FROM dept_costs)
    SELECT *
    FROM dept_costs
    WHERE dept_total >
    (SELECT dept_avg
    FROM avg_cost)
    ORDER BY department_name;
������Ŀ��
-- 12.�� ѯ Ա �� �� last_name, department_id, salary.�� �� Ա �� ��salary,department_id���н�����κ�һ��Ա���� salary,department_id��ͬ����
    select last_name, department_id, salary
    from employees
    where (salary,department_id) in (
    select salary,department_id
    from employees
    where commission_pct is not null
    )
-- 13.ѡ �� �� �� �� �� �� �� JOB_ID = 'SA_MAN'�� Ա �� �� �� �� �� Ա �� ��last_name, job_id, salary
    select last_name, job_id, salary
    from employees
    where salary > all(
    select salary
    from employees
    where job_id = 'SA_MAN'
    )
-- 14.ѡ������û�й����ߵ�Ա���� last_name
    select last_name
    from employees e1
    where not exists (
    select 'A'
    from employees e2
    where e1.manager_id = e2.employee_id
    )
-- 15. ��ѯ 10��50��20�Ų��ŵ� job_id��department_id����department_id�� 10��50��20��˳������
    Column dummy noprint;
    select job_id , department_id ,1 dummy
    from employees
    where department_id = 10
    union
    select job_id , department_id , 2
    from employees
    where department_id = 50
    union
    select job_id , department_id , 3
    from employees
    where department_id= 20
    order by 3
  




























