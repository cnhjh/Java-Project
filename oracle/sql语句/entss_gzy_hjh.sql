-- 获取当前学期
select xnxqdm from g_0012 where mrczxq='1';
select * from g_0012;


update v_k_0001 set zt = '0' where zt<>'2' and kcrwdm in('1020686')

select * from t_0001;--TEABH编号  ACCOUNT账号

select teabh,teaxm,account from t_0001 where teaxm='方熙茹';
select xsbh,xsxm,account from x_0001 where xsxm='胡晚月';


select * from x_0001;
select xsbh,xsxm,account from x_0001 where xsxm='陈锦玉';	


select teabh,teaxm,account from t_0001 where teaxm='李学征';--020167
select xsbh,xsxm,account from x_0001 where xsxm='郑文清';	--2017091005   2017091009

-- 学籍卡片
select xsdm,xsbh,xqmc,xjztmc,xsztmc,dqszj,xsxm,xbdm,yxmc,rxnf,zymc,bjmc,sydm,py,xsywxm,fxzymc,yhzh,dh,email,icq,wyyzmc,mmtip,jfdm,g04.zyfxmc 
from v_x_0001 t left join g_0004 g04 on t.zyfxdm=g04.zyfxdm  where xsdm=

select sydm,ksh,cym,mzdm,zzmmdm,zjlxdm,sfzh,jg,jgsf,jgsq,csrq,lysf,rxrq from x_0003  where sydm=
select * from x_0003
select xm,xbdm,csrq,jtdz from x_0003 where jtdz='广东省茂名市';

---------------------------- 上传授课内容
select dm,dmmc as mc from Z_0004--//查出教学环节
select teabh,teadm,teaxm,zcdm from t_0001--//查出教师信息
select dm,dmmc as mc from z_0020;--//查出教师职称信息
select jxcddm,jxcdmc from g_0008 where zt <> '0';--//查出教学场地信息
select dm,dmmc as mc from z_0085 --教学模式

-- 查看开课编号为1025288的教学日历
select * from k_0002 where kcrwdm = 1025288
-- 更新一条数据
update k_0002 set sknrjj='嘿嘿额' where kxh=10  and kcrwdm= 1025288;
commit;

update k_0002 set sknrjj='哔哔3' where kxh=10 and kcrwdm='1025288'

----------------	毕业设计管理模块添加校外指导教师管理子模块  ------------
-- 校外指导教师表  该表数据是在教师填报毕业题目时添加的；


select * from t_0001;--
-- 在  s_0001表中添加一个“校外指导教师” 菜单
--背景：毕业设计模块有校外指导教师表  bs_0012，该表数据是在教师填报毕业题目时添加的；

--要求：在毕业设计模块添加“校外指导教师” 子模块, 能够对校外指导教师进行维护。

--需求更改的内容：
--1.  在  s_0001表中添加一个“校外指导教师” 菜单
--2.  更改  XwzdteaAction.action, xwteafind.jsp, xwtealist.jsp, xwteaedit.jsp 几个文件，使用户可以完成校外指导教师的查询、添加、修改、删除、批量删除等各项功能；
--3.  注意，删除校外指导教师时需检查该  指导教师  是否在 bs_0002表中存在已审核通过（在bs_0001表中查询是否审核通过）指导的毕业题目；
select * from bs_0012;--校外指导教师表

----毕业设计模块更改
create table BS_0012
--(--校外指导教师表
  TEADM  VARCHAR2(12) not null,--校外指导教师代码
  TEAXM  VARCHAR2(60),--校外指导教师姓名
  SFZH   VARCHAR2(20),--身份证号
  GZDWMC VARCHAR2(100),--工作单位名称
  ZCDM   VARCHAR2(12),--职称代码
  XLDM   VARCHAR2(12),--学历代码
  CJR    VARCHAR2(60),--创建人
  CJSJ   VARCHAR2(20),--创建时间
  DH     VARCHAR2(20),--电话
  primary key(teadm)
);

insert into bs_0012(teadm,teaxm,sfzh,gzdwmc,zcdm,xldm,cjr,cjsj,dh) 
values(st_seq.nextval,'胡途','456789','广东工业大学','研究员',02,'小胡','2017-01-15','12345667')
select * from bs_0012;
update  bs_0012 set  xldm=1,cjr='小胡' where teadm=100001;
delete from bs_0012 where teadm in('100001')
delete from y_0002 where xkkzdm in('102099192')#0001#系统管理员#0


select teadm,teaxm,sfzh,gzdwmc,zcdm,xldm,cjr,cjsj,dh from  bs_0012 where 1=1
select * 
from (select row_.*, rownum r_ownum_ from (select teadm,teaxm,sfzh,gzdwmc,zcdm,xldm,cjr,cjsj,dh from  bs_0012  order by teadm asc nulls last) row_ where rownum <=50)where rownum_ >0
select teadm,teaxm,sfzh,gzdwmc,zcdm,xldm,cjr,cjsj,dh from  bs_0012
select * from (select row_.*, rownum rownum_ from (select teadm,teaxm,sfzh,gzdwmc,zcdm,xldm,cjr,cjsj,dh from  bs_0012  order by teadm asc nulls last) row_ where rownum <=50)where rownum_ >0
--->>- 添加校外教师管理三级目录
select * from bs_0001;
select * from s_0001 order by menuid;--导航栏目录
insert into s_0001 values(164,'校外指导教师','xwzdtea!xwteaFind.action',160,1,164,3,'gear'); 
update  s_0001 set  menuurl='xwzdtea!xwteaFind.action' where menuid=164
----<<--



alter table bs_0001 add(BYZDTEAS varchar2(100) not null);
-- 毕业题目添加字段
alter table bs_0001 add(zhxmlb char(1)); ---题目纵横向分类


select b1.bytmdm,b1.xnxqdm,b1.cjr
from bs_0002 b2,bs_0001 b1
where b1.bytmdm=b2.bytmdm


-->>>---------------------- 20170112 ----------------
create table Z_0098
---课程建设课程改革信息获奖级别字典表
(
  dm   VARCHAR2(2) not null,
  dmmc VARCHAR2(60) not null,
  xh   VARCHAR2(2) not null
);
insert into Z_0098 (dm, dmmc, xh)values ('01', '国家级', 1);
insert into Z_0098 (dm, dmmc, xh)values ('02', '省级', 2);
insert into Z_0098 (dm, dmmc, xh)values ('03', '市级', 3);
insert into Z_0098 (dm, dmmc, xh)values ('04', '县级', 4);
insert into Z_0098 (dm, dmmc, xh)values ('05', '校级', 5);
--<<<------------------------------------------------
select * from (select row_.*, rownum rownum_ from (select teadm,teaxm,sfzh,gzdwmc,zcdm,xldm,cjr,cjsj,dh from  bs_0012  order by teadm asc nulls last) row_ where rownum <=50)where rownum_ >0


select * from (select row_.*, rownum rownum_ from (select teadm,teaxm,sfzh,gzdwmc,zcdm,xldm,cjr,cjsj,dh from  bs_0012 where 1=1  order by teaxm asc, teadm asc  nulls last) row_ where rownum <=50)where rownum_ >0


select teadm,teabh,teaxm,xbmc,mzmc,yxmc,jysmc,sfzh,zchqsj,zcmc,zzmmmc,gwzkmc,dh,sffdy,ZGLBMC,XLMC,CSRQ 
from (
select T01.txpath,T01.TEADM,T01.YXDM,T01.JYSDM,T01.TEABH,T01.TEAXM,T01.TEAYWXM,T01.XBDM,T01.SYZXDM,
      T01.CYM,T01.PY,T01.MZDM,T01.SFZH,T01.CSRQ,T01.ZCDM,T01.ZZMMDM,T01.GWZKDM,T01.ZGLBDM,T01.XLDM,T01.DH,
      T01.DZ,T01.JG,T01.EMAIL,T01.ICQ,T01.ZHZT,T01.ACCOUNT,T01.PW,T01.MMTIP,T01.Sffdy,T01.Zchqsj,
			G02.BMMC AS YXMC, GJ.BMMC AS JYSMC, Z17.DMMC AS MZMC, Z18.DMMC AS XBMC, Z19.DMMC AS ZZMMMC,
      Z20.DMMC AS ZCMC, Z21.DMMC AS GWZKMC, z22.dmmc AS ZGLBMC, z66.dmmc AS XLMC 
from T_0001 T01 
    LEFT JOIN G_0002 G02 ON T01.YXDM = G02.BMDM
		LEFT JOIN G_0002 GJ ON T01.JYSDM = GJ.BMDM   
    LEFT JOIN Z_0018 Z18 ON T01.XBDM = Z18.DM 
    LEFT JOIN Z_0017 Z17 ON T01.MZDM = Z17.DM  
    LEFT JOIN Z_0019 Z19 ON T01.ZZMMDM = Z19.DM 
    LEFT JOIN Z_0020 Z20 ON T01.ZCDM = Z20.DM  
    LEFT JOIN Z_0021 Z21 ON T01.GWZKDM = Z21.DM  
    LEFT JOIN Z_0066 Z66 ON T01.XLDM = z66.dm 
    LEFT JOIN z_0022 z22 ON T01.Zglbdm=z22.dm
          

select * from Z_0066;     
select * from Z_0020;    
          
          
----->>>---------  左链接查询校外指导老师信息 包括学历和职称 ----------------          
select 
      b12.teadm,b12.teaxm,b12.sfzh,b12.gzdwmc,b12.zcdm,b12.xldm,b12.cjr,b12.cjsj,b12.dh,Z20.DMMC AS ZCMC,z66.dmmc AS XLMC 
from  bs_0012 b12
    LEFT JOIN Z_0020 Z20 ON b12.ZCDM = Z20.DM  
    LEFT JOIN Z_0066 Z66 ON b12.XLDM = z66.dm 
-----------<<<-----    -------------------

select teadm as dm,teaxm as mc,teabh,dwmc,lbmc 
		    from (select teadm,teaxm,teabh,yxmc dwmc,'校内教师' lbmc 
		    from v_t_0001 
		    union all 
		    select teadm,teaxm,dh teabh,gzdwmc dwmc,'校外教师' lbmc
		    from bs_0012) 

-- 内部系统任务排序      
select * from task ORDER BY task_createTime DESC ;

---------------->>> 毕业题目管理列表 -----------------------------------------
select bs05.rdrs,case when bs01.xxrs>nvl(bs05.rdrs,0) then '未确定' else '已确定' end as tmzt,
							   bs01.bytmdm,bs01.bytmmc,bs01.bytmywmc,bs01.byzdteas,g12.xnxqmc,
							   bs01.shztdm,g02.bmmc bysjyxmc,z50.dmmc tmlxmc,z51.dmmc tmxzmc,
							   z52.dmmc tmlymc,z53.dmmc bysjcdmc,xtqssj,xtjssj,shyj,xxrs 
						from bs_0001 bs01 inner join g_0012 g12 on bs01.xnxqdm = g12.xnxqdm 
										 inner join g_0002 g02 on bs01.bysjyxdm = g02.bmdm 
										 inner join z_0050 z50 on bs01.tmlxdm = z50.dm 
										 inner join z_0051 z51 on bs01.tmxzdm = z51.dm 
										 inner join z_0052 z52 on bs01.tmlydm = z52.dm 
										 inner join z_0053 z53 on bs01.bysjcddm = z53.dm 
										 left join(select bytmdm,count(1) rdrs from bs_0005 where zt='1' group by bytmdm) bs05 on bs01.bytmdm=bs05.bytmdm
--------------------<<< --------------------------------------------
select * from bs_0012
--审核
select * from bs_0002;
select * from bs_0001;
select * from BS_0009;

--------------->>>---- 删除校外指导老师前检查审核状态 -------------------------
select bs01.bytmdm,bs01.bytmmc,bs01.bytmywmc,bs01.byzdteas,bs01.shztdm
from bs_0001 bs01,bs_0002 bs02,bs_0012 bs12
where bs12.teadm in(300028273,100002) and
      bs12.teadm = bs02.teadm and 
      bs01.bytmdm = bs02.bytmdm
--------------<<<-----------------------------------------------------

-- 查询毕业题目
 select * from (select row_.*, rownum rownum_ 
 from ( select bs05.rdrs,case when bs01.xxrs>nvl(bs05.rdrs,0) then '未确定' else '已确定' 
 end as tmzt,bs01.bytmdm,bs01.bytmmc,bs01.bytmywmc,bs01.byzdteas,g12.xnxqmc,bs01.shztdm,g02.bmmc bysjyxmc,
 z50.dmmc tmlxmc,z51.dmmc tmxzmc,z52.dmmc tmlymc,z53.dmmc bysjcdmc,xtqssj,xtjssj,shyj,xxrs from bs_0001 bs01 
 inner join g_0012 g12 on bs01.xnxqdm = g12.xnxqdm  inner join g_0002 g02 on bs01.bysjyxdm = g02.bmdm  
 inner join z_0050 z50 on bs01.tmlxdm = z50.dm  inner join z_0051 z51 on bs01.tmxzdm = z51.dm  inner 
 join z_0052 z52 on bs01.tmlydm = z52.dm  inner join z_0053 z53 on bs01.bysjcddm = z53.dm  
 left join(select bytmdm,count(1) rdrs from bs_0005 where zt='1' group by bytmdm) bs05 on bs01.bytmdm=bs05.bytmdm  
 where 1=1  and g12.xnxqdm = '20171' 
 and ( instr (','||bysjyxdm||',','05') >0 )  
 order by xtjssj desc nulls last) row_ where rownum <=20)where rownum_ >0--系统管理员
 --^^^
 order by bytmmc desc nulls last) row_ where rownum <=50)where rownum_ >0--老师
 


2018-4-1
insert into s_0001 values('177','答辩成绩管理','dbcjgl!dbcjglFind.action','160','1','177','3','search');
select * from s_0001 where menuid='177';







-- 2018-4-4
  update s_0001 set menuurl='teabytm!bytmMenulist.action'  where menuid='408'


2018-4-8
insert into Z_0059 (dm, dmmc, xh)values ('03', '答辩小组评议', 3);
insert into Z_0059 (dm, dmmc, xh)values ('04', '总评成绩', 4);
select * from Z_0059


2018-4-10 将 v_bs_0005 视图改成如下
CREATE OR REPLACE VIEW V_BS_0005 AS
SELECT BS05.XTDM,
       BS05.XSDM,
       BS05.BYTMDM,
       BS05.ZT,
       BS05.APDM,
       X01.XSBH,
       X01.XSXM,
       X01.YXDM,
       X01.ZYDM,
       X01.BJDM,
       X01.DH,
       BS01.BYTMMC,
       BS01.BYTMYWMC,
       BS01.XNXQDM,
       BS01.BYZDTEAS,
       BS01.BYZDTEADMS,
       BS07.GROUPBH,
       BS07.GROUPMC,
       G11.KSND AS DQSZJ,
       G11.BJMC,
       G03.ZYMC,
       G03.XZ,
       G02.BMMC XSYXMC
FROM BS_0005 BS05 INNER JOIN X_0001 X01 ON BS05.XSDM = X01.XSDM
                  INNER JOIN BS_0001 BS01 ON BS05.BYTMDM = BS01.BYTMDM
                  LEFT JOIN BS_0010 BS10 ON BS05.APDM = BS10.APDM
                  LEFT JOIN BS_0007 BS07 ON BS10.GROUPDM = BS07.GROUPDM
                  LEFT JOIN G_0002 G02 ON X01.YXDM = G02.BMDM
                  LEFT JOIN G_0003 G03 ON X01.ZYDM = G03.ZYDM
                  LEFT JOIN G_0011 G11 ON X01.BJDM = G11.BJDM;


-- 2018-4-12
 update s_0001 set menuname='成绩变更' where menuid='412'
 update s_0001 set menuname='成绩变更审核' where menuid='329'
 
 
2018-4-11
在 v_k_p10 视图 加上 LEFT JOIN Z_0085 Z85 ON K02.JXMSDM = Z85.DM 并显示  Z85.DMMC AS JXMSMC

-- 2018-04-12 hjh
alter table bs_0006 add(czwt varchar(500));
-- 视图 v_bs_0006 添加 BS06.CZWT,

-- 2018-04-16
--视图 v_x_0007 增加 x01.sfzh,


---- 2018-04-16

--- 毕业设计评议成绩要记录等级成绩
alter table bs_0009 add(djcjdm varchar2(5)) ;


-- case when
select * from (select row_.*, rownum rownum_ from ( select jxbdm,jxbrs,kcmc,xmmc,kx,jxbmc,apmx,zc,xq,jcdm2,kssj,
apkcs,jkteaxms,zkteaxms,kcrwdm,ksrq  from (select jxbdm,max(jxbrs) jxbrs,
max(kcmc) kcmc,
(case when max(xmmc) is null then max(kcmc) else to_char(wm_concat(kcmc||'['||xmmc||']')) end)as kx,
max(xmmc) xmmc,
max(jxbmc) jxbmc,count(kscdapdm) apkcs,to_char(wm_concat(jxcdmc||'['||ksrs||'人]')) apmx,to_char(wm_concat(zc)) zc,to_char(wm_concat(xq)) xq,
to_char(wm_concat(jcdm2)) jcdm2,to_char(wm_concat(ksqssj||'--'||ksjssj)) kssj,max(kcrwdm) kcrwdm,to_char(wm_concat(jkteaxms)) jkteaxms,
to_char(wm_concat(zkteaxms)) zkteaxms,max(ksrq) ksrq  from ( select k03.jxbdm,e06.kscdapdm,max(k03.jxbrs) jxbrs,max(g13.kcmc) kcmc,max(k03.jxbmc) jxbmc, 
count(e05.xsdm) ksrs,max(g08.jxcdmc) jxcdmc, max(e06.zc) zc,max(e06.xq) xq,max(e06.jcdm2) jcdm2, max(e06.ksqssj) ksqssj,max(e06.ksjssj) ksjssj, 
max(k01.kcrwdm) kcrwdm, max(e06.jkteaxms) jkteaxms,max(k01.xmmc) xmmc, max(e06.zkteaxms) zkteaxms, max(g17.rq) ksrq from e_0005 e05 
inner join x_0001 x01 on e05.xsdm = x01.xsdm inner join e_0006 e06 on e05.kscdapdm = e06.kscdapdm inner join k_0001 k01 on e05.kcrwdm = k01.kcrwdm 
inner join k_0003 k03 on k01.jxbdm = k03.jxbdm inner join g_0013 g13 on k01.kcdm = g13.kcdm inner join g_0014 g14 on k01.kcptdm = g14.kcptdm 
inner join g_0008 g08 on e06.jxcddm = g08.jxcddm left join g_0017 g17 on g17.xnxqdm = e06.xnxqdm and g17.zc=e06.zc and g17.xqmc = e06.xq 
where 1=1  and e05.xnxqdm = '20172' group by k03.jxbdm,e06.kscdapdm  )group by jxbdm )where 1=1   order by jxbdm asc, jxbdm asc  nulls last) row_ where rownum <=50)where rownum_ >0


select xnxqdm,zc,xq,jcdm2,jxcddm,kcmc,bjmc,bjrs,jxcdmc,jkteaxms,sjbh,zkteaxms,ksrq,jcdm,kssj,ksaplxmc,kslbmc,ksrs,
xnxqmc,szxqmc,xmmc
--,kx
,(case when xmmc is null then max(kcmc) else to_char(wm_concat(kcmc||'['||xmmc||']')) end)as kx
 from ( select 
 e06.xnxqdm,e06.zc,
 e06.xq,e06.jcdm2,
 e06.jxcddm,bjmc,
 max(e06.jkteaxms) jkteaxms,
 max(e05.sjbh) as sjbh,
max(e06.zkteaxms) zkteaxms,
max(e06.jcdm) jcdm,
max(e06.ksqssj||'--'||e06.ksjssj) kssj
,max(z63.dmmc) as ksaplxmc,max(z60.dmmc) as kslbmc,
max(e06.ksrs) ksrs,
max(g12.xnxqmc) xnxqmc,
max(g01.xqmc) as szxqmc,
max(g17.rq) ksrq,
max(g08.jxcdmc) jxcdmc,
max(kcmc) kcmc,
count(e05.xsdm) as bjrs
,max(k01.xmmc) xmmc 
--,(case when k01.xmmc is null then max(kcmc) else to_char(wm_concat(kcmc||'['||k01.xmmc||']')) end)as kx
 from e_0006 e06 
 inner join e_0005 e05 on e06.kscdapdm = e05.kscdapdm  
 inner join k_0001 k01 on e05.kcrwdm = k01.kcrwdm
 inner join g_0008 g08 on e06.jxcddm = g08.jxcddm 
  inner join g_0010 g10 on g08.ssjzwdm = g10.jzwdm  
  inner join g_0001 g01 on g10.szxqdm = g01.xqdm  inner join g_0013 g13 on e05.kcdm = g13.kcdm  
  inner join x_0001 x01 on e05.xsdm = x01.xsdm  inner join g_0012 g12 on e06.xnxqdm = g12.xnxqdm  inner join z_0063 z63 on e06.ksaplxdm = z63.dm 
   inner join z_0060 z60 on e06.kslbdm = z60.dm  left join g_0011 g11 on x01.bjdm = g11.bjdm  left join g_0014 g14 on e05.kcptdm = g14.kcptdm  
   left join g_0017 g17 on e06.xnxqdm =g17.xnxqdm and e06.zc = g17.zc and e06.xq = g17.xqmc   where 1 = 1  and e06.xnxqdm = '20171' and e06.kslbdm = '01'  
   group by e06.xnxqdm,e06.zc,e06.xq,e06.jcdm2,e06.jxcddm,e05.kcdm,g11.bjmc ) order by zc,xq,jcdm,kcmc,jxcdmc,bjmc,bjrs




select * from e_0006;
select * from k_0001;
select kscdapdm from k_0001;
select kcrwdm from e_0005

select * from e_0006;
select kscdapdm from e_0006;
select kscdapdm from e_0005;
 













select * from (select row_.*, rownum rownum_ from ( select jxbdm,jxbrs,kcmc,xmmc,jxbmc,apmx,zc,xq,jcdm2,kssj,apkcs,jkteaxms,
zkteaxms,kcrwdm,ksrq  from (select jxbdm,max(jxbrs) jxbrs,
(case when xmmc is null then max(xmmc) else to_char(wm_concat(kcmc||'['||xmmc||']')) end)as cs,
max(xmmc) xmmc,
max(jxbmc) jxbmc,count(kscdapdm) apkcs,to_char(wm_concat(jxcdmc||'['||ksrs||'人]')) apmx,to_char(wm_concat(zc)) zc,to_char(wm_concat(xq)) xq,
to_char(wm_concat(jcdm2)) jcdm2,to_char(wm_concat(ksqssj||'--'||ksjssj)) kssj,max(kcrwdm) kcrwdm,to_char(wm_concat(jkteaxms)) jkteaxms,to_char(wm_concat(zkteaxms)) zkteaxms,
max(ksrq) ksrq  from ( select k03.jxbdm,e06.kscdapdm,max(k03.jxbrs) jxbrs,max(g13.kcmc) kcmc,max(k03.jxbmc) jxbmc, count(e05.xsdm) ksrs,max(g08.jxcdmc) jxcdmc, max(e06.zc) zc,
max(e06.xq) xq,max(e06.jcdm2) jcdm2, max(e06.ksqssj) ksqssj,max(e06.ksjssj) ksjssj, max(k01.kcrwdm) kcrwdm, max(e06.jkteaxms) jkteaxms,max(k01.xmmc) xmmc,
 max(e06.zkteaxms) zkteaxms, max(g17.rq) ksrq from e_0005 e05 inner join x_0001 x01 on e05.xsdm = x01.xsdm inner join e_0006 e06 on e05.kscdapdm = e06.kscdapdm 
 inner join k_0001 k01 on e05.kcrwdm = k01.kcrwdm inner join k_0003 k03 on k01.jxbdm = k03.jxbdm inner join g_0013 g13 on k01.kcdm = g13.kcdm 
 inner join g_0014 g14 on k01.kcptdm = g14.kcptdm inner join g_0008 g08 on e06.jxcddm = g08.jxcddm left join g_0017 g17 on g17.xnxqdm = e06.xnxqdm and g17.zc=e06.zc 
 and g17.xqmc = e06.xq where 1=1  and e05.xnxqdm = '20172' group by k03.jxbdm,e06.kscdapdm  )group by jxbdm )where 1=1   order by jxbdm asc, 
 jxbdm asc  nulls last) row_ where rownum <=50)where rownum_ >0