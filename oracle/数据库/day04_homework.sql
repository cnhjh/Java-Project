1:查看与CLARK相同职位的员工
SELECT ename,job
FROM emp_hjh
WHERE job=(SELECT job
           FROM emp_hjh
           WHERE ename='CLARK')


2:查看低于公司平均工资的员工
select ename,sal
from emp_hjh
where sal<(select avg(sal) 
           from emp_hjh)


3:查看与ALLEN同部门的员工
select ename,deptno
from emp_hjh
where deptno=(select deptno
              from emp_hjh
              where ename='ALLEN')


4:查看平均工资低于20号部门平均工资的部门平均工资---------
select deptno,avg(sal)
from emp_hjh
group by deptno
having avg(sal)<(
          select avg(sal)
          from emp_hjh
          where deptno=20)


5:查看低于自己所在部门平均工资的员工(每个员工的工资和自己部门的平均工资对比）
select e.ename,e.deptno,e.sal
from emp_hjh e,(select deptno,avg(sal) avg_sal
               from emp_hjh
               group by deptno) x
where e.deptno=x.deptno
and e.sal<x.avg_sal

6:查看公司工资排名的第1-5名
--1:
select *
from(select rownum rn,t.*from(select ename,sal
                         from emp_hjh
                         order by sal desc) t)
where rn between 1 and 5
--2:
select *
from(select rownum rn,t.*
                      from(select ename,sal
                      from emp_hjh 
                      order by sal desc) t
where rownum<=5)
where rn>=1


7:查看CLERK职位的人数和其他职位的总人数各多少?--------
select decode(job,'CLERK','C','other')job,count(*) job_cnt
from emp_hjh
group by decode(job,'CLERK','C','other')



8:查看每个职位的工资排名
select ename,job,sal,deptno,
row_number() over(
partition by job
order by sal desc) rank
from emp_hjh

9:查看每个职位的工资排名，若工资一致，排名一致
select ename,job,sal,deptno,
dense_rank() over(
partition by job
order by sal desc) rank
from emp_hjh

10:查看每个职位的工资排名，若工资一致，排名一致，不跳名次。
select ename,job,sal,deptno,
dense_rank() over(
 partition by job
 order by sal desc) rank
 from emp_hjh
11:分别查看:同部门同职位，同职位，以及所有员工的工资总和


12:分别查看:同部门同职位，同职位，同部门以及所有员工的工资总和


13:分别查看同部门同职位和同职位的员工的工资总和


14:查看公司最高工资的员工的名字以及所在部门名称


15:查看每个部门的最高工资的员工名字


from emp_hjh e
select max(sal)
from emp_hjh

16:查看有下属的员工信息
select e.ename,e.job,e.deptno
from emp_hjh e
where not exists(select * 
          from emp_hjh m
          where m.mgr=e.empno)








