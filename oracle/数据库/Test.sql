
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

��������SEQUENCE
--���������ݿ����֮һ�������Ǹ���ָ���Ĺ�������һϵ�����֡�
--ͨ��ʹ���������ɵ�������Ϊ���е������ֶ��ṩֵʹ��
--
create sequence emps_seq_hujinghao

insert into emps_hujinghao values(emps_seq_hujinghao.nextval,'����','�쵼',0,sysdate,18000.0,3000.0,1);
insert into emps_hujinghao values(emps_seq_hujinghao.nextval,'����','����',1,sysdate,7000.0,5000.0,1);
insert into emps_hujinghao values(emps_seq_hujinghao.nextval,'����','����',1,sysdate,8000.0,2000.0,1);
insert into emps_hujinghao values(emps_seq_hujinghao.nextval,'����','�г�',1,sysdate,6000.0,0,1);
insert into emps_hujinghao values(emps_seq_hujinghao.nextval,'����','�г�',1,sysdate,5000.0,0,1);
insert into emps_hujinghao values(emps_seq_hujinghao.nextval,'���','�г�',1,sysdate,4000.0,0,1);

ɾ����
drop table emps_hujinghao
ɾ�������ݣ�������ṹ
truncate table emps_hujinghao
�鿴��ṹ
desc emps_hujinghao
�鿴������
select * from emps_hujinghao
ɾ������
drop sequence emps_seq_hujinghao
==================================================================

