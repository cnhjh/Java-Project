************************************   sql考试   ************************************
-- employees 职员
create table employees (
  EMPLOYEE_ID   NUMBER(6) PRIMARY KEY, -- 职员id
  FIRST_NAME VARCHAR2(20),  -- 名字
  LAST_NAME VARCHAR2(25), -- 姓氏
  EMAIL VARCHAR2(25), -- 邮箱
  PHONE_NUMBER    VARCHAR2(20), -- 手机号码
  HIRE_DATE  DATE, -- 入职日期
  JOB_ID VARCHAR2(10), -- 职位id    --jobs表：
  SALARY NUMBER(8,2), -- 薪水
  COMMISSION_PCT NUMBER(2,2), -- 百分比
  MANAGER_ID NUMBER(6), -- 管理者id
  DEPARTMENT_ID NUMBER(4) -- 部门id    --departments表：
);
INSERT INTO employees VALUES(7369,'景皓','胡','123@qq.com','12345678912',to_date('2017-05-29','YYYY-MM-DD'),'3',5620.00,null,7566,20);
INSERT INTO employees VALUES(7499,'小村','陈','12354@qq.com','12345678912',to_date('2015-4-29','YYYY-MM-DD'),'2',8620.00,null,7654,30);
INSERT INTO employees VALUES(7521,'敏华','张','12433@qq.com','12345678912',to_date('2017-05-02','YYYY-MM-DD'),'3',6620.00,null,7654,30);
INSERT INTO employees VALUES(7566,'老师','王','12233@qq.com','12345678912',to_date('2015-08-29','YYYY-MM-DD'),'2',9620.00,null,7654,20);
INSERT INTO employees VALUES(7654,'老师','马','1252433@qq.com','12345678912',to_date('2015-05-30','YYYY-MM-DD'),'1',25620.00,null,null,10);
INSERT INTO employees VALUES(7698,'国鹏','黄','124353@qq.com','12345678912',to_date('2015-08-29','YYYY-MM-DD'),'2',12620.00,null,7654,30);
INSERT INTO employees VALUES(7782,'国强','施','122423@qq.com','12345678912',to_date('2017-09-30','YYYY-MM-DD'),'3',7620.00,null,7566,10);
INSERT INTO employees VALUES(7783,'xiaochun','Chen','122423@qq.com','12345678912',to_date('2017-06-29','YYYY-MM-DD'),'3',7620.00,null,7566,10);
  
update EMPLOYEES set HIRE_DATE=to_date('2015-4-30','YYYY-MM-DD') where EMPLOYEE_ID = 7782
update EMPLOYEES set SALARY=9620.00 where EMPLOYEE_ID = 7566
update EMPLOYEES set  last_name='Chen' where EMPLOYEE_ID = 7782
drop table employees
select * from  employees;
-- jobs 职业
create table jobs(
  JOB_ID VARCHAR2(10),--id
  JOB_TITLE VARCHAR2(35),--职称
  MIN_SALARY NUMBER(6),--最低工资
  MAX_SALARY NUMBER(6)--最高工资
)

-- departments表： 部门
create table departments(
  DEPARTMENT_ID  NUMBER(4), -- 部门id
  DEPARTMENT_NAME VARCHAR2(30), --部门名称
  MANAGER_ID NUMBER(6), -- 经理，管理人员
  LOCATION_ID  NUMBER(4) -- 位置,地点  --locations 表
)

-- locations 表： 地点
create table locations(
  LOCATION_ID NUMBER(4), -- 地点id
  STREET_ADDRESS VARCHAR2(40), -- 您的街道地址, 您的住址
  POSTAL_CODE VARCHAR2(12), -- 邮政编码, 邮编, 邮递区号
  CITY VARCHAR2(30), --城市
  STATE_PROVINCE VARCHAR2(25), --所在的州
  COUNTRY_ID CHAR(2) --国家 故乡
)

-- job_grades 表： 职位等级
create table job_grades(
  GRADE_LEVEL VARCHAR2(3), --职等
  LOWEST_SAL NUMBER, -- 最低
  HIGHEST_SAL NUMBER --最高
)
-- 
-- 1. 查询每个月倒数第 2 天入职的员工的信息.
-- 2. 查询出 last_name 为 'Chen' 的 manager 的信息.
-- 3. 查询平均工资高于 8000 的部门 id 和它的平均工资.
-- 4. 查询工资最低的员工信息: last_name, salary
-- 5. 查询平均工资最低的部门信息
-- 6. 查询平均工资最低的部门信息和该部门的平均工资
-- 7. 查询平均工资最高的 job 信息
-- 8. 查询平均工资高于公司平均工资的部门有哪些?
-- 9. 查询出公司中所有 manager 的详细信息.
-- 10. 各个部门中 最高工资中最低的那个部门的 最低工资是多少
-- 11. 查询平均工资最高的部门的 manager 的详细信息: last_name,department_id, email, salary
-- 12. 查询 1999 年来公司的人所有员工的最高工资的那个员工的信息.
-- 13. 返回其它部门中比 job_id为‘IT_PROG’部门所有工资都低的员工的员工号、姓名、job_id 以及 salary
-- ************************answers*********************
-- 1. 查询每个月倒数第 2 天入职的员工的信息.
   
   
-- 2. 查询出 last_name 为 'Chen' 的 manager 的信息.
    -- 1). 通过两条 sql 查询: 通过'chen'查询manager的id，得到manager信息
      
      

    -- 2). 通过一条 sql 查询(自连接):
  
  
    --3).通过一条 sql 子查询 
 
 
    -- 3). 通过一条 sql 查询(子查询):


-- 3. 查询平均工资高于 8000 的部门 id 和它的平均工资.
    --MAX（），NIM（），SUM（），AVG（）--聚合函数又称为分组函数，多行函数。聚合函数的作用是对结果集指定字段的值进行统计工作,聚合数忽略NULL值
    --最大值 ，最小值  ， 总和 ，平均值
    --GROUP BY 可以将结果按照给定的字段值一样记录进行分组。配合聚合函数使用可以完成分组统计工作
    --HAVING 子句可以根据聚合函数进行过滤，并且是用来根据条件 ,过滤GROUP BY的分组 
  
            --过滤条件：平均工资超过8000的部门  聚合函数过滤应当是在WHERE之后进行的
-- 4. 查询工资最低的员工信息: last_name, salary
  
  
-- 5. 查询平均工资最低的部门信息


-- 6. 查询平均工资最低的部门信息和该部门的平均工资


-- 7. 查询平均工资最高的 job 信息
    -- 1). 按 job_id 分组, 查询最高的平均工资
   
   
    -- 2). 查询出平均工资等于 1) 的 job_id


    -- 3). 查询出 2) 对应的 job 信息
   
   
-- 8. 查询平均工资高于公司平均工资的部门有哪些?
    -- 1). 查询出公司的平均工资
 
 
    -- 2). 查询平均工资高于 1) 的部门 ID
  
  
-- 9. 查询出公司中所有 manager 的详细信息.
    -- 1). 查询出所有的 manager_id
   
   
    -- 2). 查询出 employee_id 为 1) 查询结果的那些员工的信息
  
  
-- 10. 各个部门中 最高工资中最低的那个部门的 最低工资是多少
    -- 1). 查询出各个部门的最高工资
    
    
    -- 2). 查询出 1) 对应的查询结果的最低值: 各个部门中最低的最高工
    资(无法查询对应的 department_id)
 
 
    -- 3). 查询出 2) 所对应的部门 id 是多少: 各个部门中最高工资等于
    -- 2) 的那个部门的 id
   
   
    -- 4). 查询出 3) 所在部门的最低工资
  
  
-- 11. 查询平均工资最高的部门的 manager 的详细信息: last_name,
    department_id, email, salary
    -- 1). 各个部门中, 查询平均工资最高的平均工资是多少
 
 
    -- 2). 各个部门中, 平均工资等于 1) 的那个部门的部门号是多少
 
 
    -- 3). 查询出 2) 对应的部门的 manager_id



    -- 4). 查询出 employee_id 为 3) 查询的 manager_id 的员工的last_name, department_id, email, salary
  
  
-- 12. 查询 1999 年来公司的人所有员工的最高工资的那个员工的信息.
    -- 1). 查询出 1999 年来公司的所有的员工的 salary
   
   
    -- 2). 查询出 1) 对应的结果的最大值
   
   
    -- 3). 查询工资等于 2) 对应的结果且 1999 年入职的员工信息
  
  
    
-- 13. 返回其它部门中比 job_id 为‘IT_PROG’部门所有工资都低的员工的员工号、姓名、job_id 以及 salary


    
    
    
************************************  高级子查询  ************************************
? 书写多列子查询
? 在 FROM 子句中使用子查询
? 在 SQL中使用单列子查询
? 书写相关子查询
? 使用 EXISTS 和 NOT EXISTS 操作符
? 使用子查询更新和删除数据
? 使用 WITH 子句
--多列子查询（不成对比较 & 成对比较）
-- 1. 查询与 141号或 174号员工的 manager_id和 department_id相同的其他员工的 employee_id, manager_id, department_id
[方式一]
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
[方式二]
    SELECT employee_id, manager_id, department_id
    FROM employees
    WHERE (manager_id, department_id) IN
    (SELECT manager_id, department_id
    FROM employees
    WHERE employee_id IN (141,174))
    AND employee_id NOT IN (141,174);
--在 FROM 子句中使用子查询
-- 2. 返回比本部门平均工资高的员工的 last_name, department_id,salary及平均工资
[方式一]
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
[方式二]
    SELECT a.last_name, a.salary,
    a.department_id, b.salavg
    FROM employees a, (SELECT department_id,
    AVG(salary) salavg
    FROM employees
    GROUP BY department_id) b
    WHERE a.department_id = b.department_id
    AND a.salary > b.salavg;
--单列子查询表达式
? Oracle8i 只在下列情况下可以使用, 例如:
– SELECT 语句 (FROM 和 WHERE 子句)
– INSERT 语句中的 VALUES列表中
? Oracle9i 中单列子查询表达式可在下列情况下使用:
– DECODE 和 CASE
– SELECT 中除 GROUP BY 子句以外的所有子句中
-- 3. 显式员工的 employee_id,last_name 和 location。其中，若员工department_id 与 location_id 为 1800 的 department_id 相同，则location为’Canada’,其余则为’USA’。
    SELECT employee_id, last_name,
    (CASE department_id
    WHEN (SELECT department_id FROM departments
    WHERE location_id = 1800)
    THEN 'Canada' ELSE 'USA' END) location
    FROM employees;
-- 4. 查 询 员 工 的 employee_id,last_name, 要 求 按 照 员 工 的department_name排序
    SELECT employee_id, last_name
    FROM employees e
    ORDER BY (SELECT department_name
    FROM departments d
    WHERE e.department_id = d.department_id);
--相关子查询
-- 5.查询员工中工资大于本部门平均工资的员工的 last_name,
    salary 和其 department_id
    SELECT last_name, salary, department_id
    FROM employees outer
    WHERE salary >
    (SELECT AVG(salary)
    FROM employees
    WHERE department_id =
    outer.department_id) ;
-- 6. 若 employees表中 employee_id与 job_history表中 employee_id相同的数目不小于 2，输出这些相同 id的员工的 employee_id,last_name和其 job_id
    SELECT e.employee_id, last_name,e.job_id
    FROM employees e
    WHERE 2 <= (SELECT COUNT(*)
    FROM job_history
    WHERE employee_id = e.employee_id);
--EXISTS 操作符
? EXISTS 操作符检查在子查询中是否存在满足条件的行
? 如果在子查询中存在满足条件的行:
– 不在子查询中继续查找
– 条件返回 TRUE
-- 7. 查询公司管理者的 employee_id,last_name,job_id,
    department_id信息
    SELECT employee_id, last_name, job_id, department_id
    FROM employees outer
    WHERE EXISTS ( SELECT 'X'
    FROM employees
    WHERE manager_id =
    outer.employee_id);
-- 8. 查 询 departments 表 中 ， 不 存 在 于 employees 表 中 的 部 门 的department_id和 department_name
    SELECT department_id, department_name
    FROM departments d
    WHERE NOT EXISTS (SELECT 'X'
    FROM employees
    WHERE department_id
    = d.department_id);
--关于数据更新
-- 9.修改表 employees,添加 department_name 列，赋予 department_id相应的部门名称。
    ALTER TABLE employees
    ADD(department_name VARCHAR2(14));
    UPDATE employees e
    SET department_name =
    (SELECT department_name
    FROM departments d
    WHERE e.department_id = d.department_id);
--关于数据删除
-- 10.删除表 employees中，其与 emp_history表皆有的数据
    DELETE FROM employees E
    WHERE employee_id in
    (SELECT employee_id
    FROM emp_history
    WHERE employee_id = E.employee_id);
--WITH 子句
11. 查询公司中各部门的总工资大于公司中各部门的平均总工资的部门信息
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
附加题目：
-- 12.查 询 员 工 的 last_name, department_id, salary.其 中 员 工 的salary,department_id与有奖金的任何一个员工的 salary,department_id相同即可
    select last_name, department_id, salary
    from employees
    where (salary,department_id) in (
    select salary,department_id
    from employees
    where commission_pct is not null
    )
-- 13.选 择 工 资 大 于 所 有 JOB_ID = 'SA_MAN'的 员 工 的 工 资 的 员 工 的last_name, job_id, salary
    select last_name, job_id, salary
    from employees
    where salary > all(
    select salary
    from employees
    where job_id = 'SA_MAN'
    )
-- 14.选择所有没有管理者的员工的 last_name
    select last_name
    from employees e1
    where not exists (
    select 'A'
    from employees e2
    where e1.manager_id = e2.employee_id
    )
-- 15. 查询 10，50，20号部门的 job_id，department_id并且department_id按 10，50，20的顺序排列
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
  




























