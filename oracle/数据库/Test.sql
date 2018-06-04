
create table emps_hujinghao(
  empno number(8) primary key,
  ename varchar2(20),
  job varchar2(20),
  mgr number(8),
  hiredate date,
  sal number(11,2),
  comm number(11,2),
  deptno number(8)
);

创建序列SEQUENCE
--序列是数据库对象之一，作用是根据指定的规则生成一系列数字。
--通常使用序列生成的数字是为表中的主键字段提供值使用
--
create sequence emps_seq_hujinghao

insert into emps_hujinghao values(emps_seq_hujinghao.nextval,'张三','领导',0,sysdate,18000.0,3000.0,1);
insert into emps_hujinghao values(emps_seq_hujinghao.nextval,'李四','销售',1,sysdate,7000.0,5000.0,1);
insert into emps_hujinghao values(emps_seq_hujinghao.nextval,'王五','销售',1,sysdate,8000.0,2000.0,1);
insert into emps_hujinghao values(emps_seq_hujinghao.nextval,'马六','市场',1,sysdate,6000.0,0,1);
insert into emps_hujinghao values(emps_seq_hujinghao.nextval,'周七','市场',1,sysdate,5000.0,0,1);
insert into emps_hujinghao values(emps_seq_hujinghao.nextval,'冯八','市场',1,sysdate,4000.0,0,1);

删除表
drop table emps_hujinghao
删除表数据，保留表结构
truncate table emps_hujinghao
查看表结构
desc emps_hujinghao
查看表数据
select * from emps_hujinghao
删除序列
drop sequence emps_seq_hujinghao
==================================================================

