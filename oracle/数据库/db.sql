
--主键约束 primary key 非空且唯一
create table emps_hjh (
	empno		number(8)	primary key,
	ename		varchar(20),
	job			varchar(20),
	mgr			number(8),
	hiredate	date,
	sal			number(11,2),
	comm		number(11,2),
	deptno		number(8)
);
select * from emps_hjh;
update emps_hjh set ename='唐三藏' where empno=27;
create sequence emps_seq_hjh;
--                         员工ID                 员工姓名 职位  员工管理者的ID   入职日期   薪资  职效 员工所在部门ID 
--                         empno                 ename   job      mgr       hiredate  sal comm deptno
insert into emps_hjh values(emps_seq_hjh.nextval,'张三','领导',0,sysdate,18000.0,3000.0,1);
insert into emps_hjh values(emps_seq_hjh.nextval,'李四','销售',1,sysdate,7000.0,5000.0,1);
insert into emps_hjh values(emps_seq_hjh.nextval,'王五','销售',1,sysdate,8000.0,2000.0,1);
insert into emps_hjh values(emps_seq_hjh.nextval,'周七','市场',1,sysdate,5000.0,0,1);
insert into emps_hjh values(emps_seq_hjh.nextval,'冯八','市场',1,sysdate,4000.0,0,1);
commit;		
try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);//给它一个接口  取消自动提交事务
			
			String sql = "insert into emps_hjh values(emps_seq_hjh.nextval,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			//给问号赋值发送数据
			for(int i=1;i<=108;i++){
				ps.setString(1,"好汉"+i);
				ps.setString(2,"打劫");
				ps.setInt(3,0);
				ps.setDate(4,Date.valueOf("2017-08-22"));
				ps.setDouble(5,3000.0);
				ps.setDouble(6,9000.0);
				ps.setInt(7, 3);
				//将此数据暂存到ps对象上  
				ps.addBatch();
				if(i%50==0){//i整数等于50时发送
					//将ps上暂存的50条数据发送给数据库
					ps.executeBatch();
					//将ps上的50条数据清空，以便下一轮发送
					ps.clearBatch();
				}
			}
			//为了避免有零头数据，在单独发送一次
			ps.executeBatch();
			conn.commit();//手动提交
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.rollback(conn);//回滚
		} finally {
			DBUtil.close(conn);
		}

//查看
select * from emps_hjh
DESC emps_hjh

--------------------------------------------------------
--用户，使用者 帐号 密码
create table users_hjh(
  id number(8),
  username varchar2(30),
  password varchar2(30)
);

insert into users_hjh values(1,'tarena','123');
commit;

-------
-- 万能密码 'a' or 'b'='b'
select * from users_hjh where username='zhangsan'
and password='a' or 'b'='b';

select * from users_hjh
desc 
-----------------------------------------------------
--帐目，账单    
--卡号 姓名 余额
create table accounts_hjh (
	id varchar2(20),
	name varchar2(30),
	money number(11,2)
);

insert into accounts_hjh values('00001','张三',9000.0);
insert into accounts_hjh values('00002','李四',4000.0);
commit;

select * from accounts_hjh
------------------------------------------------------
--部门表  deptno自动生成
create table depts_hjh (
	deptno number(8)	primary key,
	dname varchar(20),
	loc varchar(100)
);

create sequence depts_seq_hjh;

insert into depts_hjh values(depts_seq_hjh.nextval,'销售部','北京');
insert into depts_hjh values(depts_seq_hjh.nextval,'市场部','上海');
insert into depts_hjh values(depts_seq_hjh.nextval,'开发部','广州');
commit;

select * from depts_hjh
select * from emps_hjh
order by empno desc


--分页查询 
select * from (
select e.*,rownum r from(
        select * from emps_hjh
        order by empno) e
)where r between 11 and 20;

page

