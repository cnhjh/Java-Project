1:创建一个视图，包含20号部门的员工信息，
   字段:empno,ename,sal,job,deptno
create or replace view v_emp_hjh_20
as
select  empno,ename,sal,job,deptno
from emp_hjh
where deptno=20

desc  v_emp_hjh_20
select * from v_emp_hjh_20
drop view  v_emp_hjh_20

2:创建一个序列seq_emp_no,从10开始，步进为10
create sequence seq_emp_no_hjh
start with 10
increment by 10


3:编写SQL语句查看seq_emp_no序列的下一个数字
select seq_emp_no_hjh.nextval 
from dual


4:编写SQL语句查看seq_emp_no序列的当前数字
select seq_emp_no_hjh.currval
from dual

--------------------------------------------------

5:为emp表的ename字段添加索引:idx_emp_ename 
create index idx_emp_ename
on emp_hjh(ename)



6:为emp表的LOWER(ename)字段添加索引:idx_emp_lower_ename
create index idx_emp_lower_ename
on emp_hjh(LOWER(ename))





7:为emp表的sal,comm添加多列索引
create index idx_emp_hjh_sal_comm
on emp_hjh(sal,comm)

--删除
drop index idx_emp_hjh_sal_comm
8:创建myemployee表，字段:
  id NUMBER(4) ,
  nameVARCHAR2(20),
  birthday DATE,
  telephone VARCHAR2(11),
  score NUMBER(9,2)
其中id作为主键，name要求不能为空,telephone需要唯一,score值必须>=0


create table myemployee_hjh(
  id NUMBER(4)primary key,
  name VARCHAR2(20) not null,
  birthday DATE,
  telephone VARCHAR2(11) unique,
  score NUMBER(9,2) 
)
--约束score>=0
alter table myemployee_hjh
add constraint myemployee_hjh_score_check
check(score>=0)

删除 drop table myemployee_hjh

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  