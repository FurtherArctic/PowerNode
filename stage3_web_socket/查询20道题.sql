# 1.取得每个部门最高薪水的人员名单
select ENAME, DEPTNO, SAL, max_sal
from emp
         join (select max(SAL) as max_sal, deptno as deptno1 from emp group by DEPTNO) as MaxSal
              on DEPTNO = deptno1
where max_sal = SAL;

# 2.哪些人的薪水在部门的平均薪水之上
select ENAME, emp.DEPTNO, SAL, avg_sal
from (select DEPTNO, avg(SAL) as avg_sal from emp group by DEPTNO) as AvgSAL
         join emp on AvgSAL.DEPTNO = emp.DEPTNO
where SAL > avg_sal;

# 3.取得部门中（所有人的）平均的薪水等级
select deptno, avg(GRADE)
from (select GRADE, DEPTNO
      from salgrade
               join emp on SAL between LOSAL and HISAL) as D_AVG_GRADE
group by deptno;

select Avg(GRADE), DEPTNO
from salgrade
         join emp on SAL between LOSAL and HISAL
group by DEPTNO;

# 4.不准用组函数（Max），取得最高薪水
select SAL
from emp
order by SAL desc
limit 0,1;
# 4.2 不准用组函数（Max），取得第三名薪水
select distinct SAL
from emp
order by SAL desc
limit 2,1;

select SAL
from emp
group by SAL
order by SAL desc
limit 2,1;

# 5.取得平均薪水最高的部门的部门编号

select DEPTNO
from emp
group by DEPTNO
having avg(SAL) = (select avg(SAL)
                   from emp
                   group by DEPTNO
                   order by avg(SAL) desc
                   limit 0,1);

# 6.取得平均薪水最高的部门的部门名称
select emp.DEPTNO, DNAME, avg(SAL)
from emp
         join dept ON emp.DEPTNO = dept.DEPTNO
group by DEPTNO
having avg(SAL) = (select avg(SAL)
                   from emp
                   group by DEPTNO
                   order by avg(SAL) desc
                   limit 0,1);

# 7.求平均薪水的等级最低的部门的部门名称
# 7.1制造包含部门编号，平均工资，工资等级的表
select DEPTNO, avg_sal, GRADE
from (select avg(SAL) as avg_sal, DEPTNO
      from emp
      group by DEPTNO
      order by avg_sal) as t1
         join salgrade on t1.avg_sal between LOSAL and HISAL;

# 7.2获取最低等级
select min(GRADE)
from (select avg(SAL) as avg_sal, DEPTNO
      from emp
      group by DEPTNO
      order by avg_sal) as t1
         join salgrade on t1.avg_sal between LOSAL and HISAL;

# 7.3根据最低等级定位部门编号，然后join部门信息表获取部门名称，on后面多个条件用and连接
select dept.DEPTNO, DNAME, GRADE, avg_sal
from salgrade
         join (select avg(SAL) as avg_sal, DEPTNO
               from emp
               group by DEPTNO
               order by avg_sal) as t1
         join dept
              on t1.avg_sal between LOSAL and HISAL and t1.DEPTNO = dept.DEPTNO
where grade = (select max(GRADE)
               from (select avg(SAL) as avg_sal, DEPTNO
                     from emp
                     group by DEPTNO
                     order by avg_sal) as t1
                        join salgrade on t1.avg_sal between LOSAL
                   and HISAL)
order by avg_sal;

# 8.取得比普通员工(员工代码没有在mgr字段上出现的)的最高薪水还要高的领导人姓名

select EMPNO, ENAME, JOB, SAL
from emp
where SAL > (select max(SAL)
             from emp
             where EMPNO not in (select mgr from emp where MGR is not null));

# 9.取得薪水最高的前五名员工的信息(1)
select ENAME, t1.SAL
from emp
         join (select SAL
               from emp
               group by SAL
               order by SAL desc
               limit 0,5) as t1 on t1.SAL = emp.SAL
order by t1.SAL desc;

# 9.取得薪水最高的前五名员工的信息(2)
select ENAME, SAL
from emp
where SAL in (select SAL
              from (select SAL
                    from emp
                    group by SAL
                    order by SAL desc
                    limit 0,5) as t1)
order by SAL desc;

# 10.取得薪水最高的6-10名员工的信息
select ENAME, SAL
from emp
where SAL in (select SAL
              from (select SAL
                    from emp
                    group by SAL
                    order by SAL desc
                    limit 5,5) as t1)
order by SAL desc;

# 11.取得最后入职的5名员工
select ENAME, HIREDATE
from emp
where HIREDATE in (select HIREDATE
                   from (select HIREDATE
                         from emp
                         order by HIREDATE desc
                         limit 0,5) as t1)
order by HIREDATE desc;

#12、取得每个薪水等级有多少员工
select GRADE
from emp
         join salgrade on SAL between LOSAL and HISAL;

select GRADE, count(*)
from emp
         join salgrade on SAL between LOSAL and HISAL
group by GRADE
order by GRADE;

# 14.列出所有员工及领导的名字
select e1.ENAME as 员工姓名, ifnull(e2.ENAME, '没有上级') as 领导姓名
from emp e1
         left join emp e2 on e1.MGR = e2.EMPNO;

# 15.列出受雇日期早于其直接上级的所有员工的编号,姓名,部门名称
select e1.EMPNO as s_empno,
       e1.ENAME as s_ename,
       DNAME
from emp e1
         join emp e2
         join dept
              on e1.MGR = e2.EMPNO and e1.DEPTNO = dept.DEPTNO
where e1.HIREDATE < e2.HIREDATE;

# 13 建表
create table S
(
    sno   varchar(20) not null,
    sname varchar(30) not null
);

create table C
(
    cno      varchar(20) not null,
    cname    varchar(30) not null,
    cteacher varchar(20)
);

create table SC
(
    sno     varchar(20) not null,
    cno     varchar(20) not null,
    SCGRADE varchar(20)
);

INSERT INTO C (CNO, CNAME, CTEACHER)
VALUES ('1', '语文', '张');
INSERT INTO C (CNO, CNAME, CTEACHER)
VALUES ('2', '政治', '王');
INSERT INTO C (CNO, CNAME, CTEACHER)
VALUES ('3', '英语', '李');
INSERT INTO C (CNO, CNAME, CTEACHER)
VALUES ('4', '数学', '赵');
INSERT INTO C (CNO, CNAME, CTEACHER)
VALUES ('5', '物理', '黎明');
commit;

INSERT INTO S (SNO, SNAME)
VALUES ('1', '学生1');
INSERT INTO S (SNO, SNAME)
VALUES ('2', '学生2');
INSERT INTO S (SNO, SNAME)
VALUES ('3', '学生3');
INSERT INTO S (SNO, SNAME)
VALUES ('4', '学生4');
commit;

INSERT INTO SC (SNO, CNO, SCGRADE)
VALUES ('1', '1', '40');
INSERT INTO SC (SNO, CNO, SCGRADE)
VALUES ('1', '2', '30');
INSERT INTO SC (SNO, CNO, SCGRADE)
VALUES ('1', '3', '20');
INSERT INTO SC (SNO, CNO, SCGRADE)
VALUES ('1', '4', '80');
INSERT INTO SC (SNO, CNO, SCGRADE)
VALUES ('1', '5', '60');
INSERT INTO SC (SNO, CNO, SCGRADE)
VALUES ('2', '1', '60');
INSERT INTO SC (SNO, CNO, SCGRADE)
VALUES ('2', '2', '60');
INSERT INTO SC (SNO, CNO, SCGRADE)
VALUES ('2', '3', '60');
INSERT INTO SC (SNO, CNO, SCGRADE)
VALUES ('2', '4', '60');
INSERT INTO SC (SNO, CNO, SCGRADE)
VALUES ('2', '5', '40');
INSERT INTO SC (SNO, CNO, SCGRADE)
VALUES ('3', '1', '60');
INSERT INTO SC (SNO, CNO, SCGRADE)
VALUES ('3', '3', '80');
commit;

# 13.1 找出没选过“黎明”老师的所有学生姓名（反隶属关系-差集）。
# 第一步：找出选过黎明的学生
select sname
from sc
         join S on s.sno = sc.sno
where cno in (select cno from C where cteacher = '黎明');

# 第二步：剥离选过黎明的学生
select *
from S
where sname not in (select sname
                    from sc
                             join S on s.sno = sc.sno
                    where cno in (select cno from C where cteacher = '黎明'));

# 13.2 列出2门以上（含2门）不及格学生姓名及平均成绩（反推法）。
select S.sno, sname, num, avg_g
from S
         join
     (select sno, count(*) as num
      from SC
      where SCGRADE < 60
      group by sno) as t1
         join
     (select sno, avg(SCGRADE) as avg_g
      from sc
      group by sno) as t2
     on S.sno = t1.sno
         and t1.sno = t2.sno
where num >= 2;

# 13.3-1即学过1号课程又学过2号课所有学生的姓名（自关联，列转行）。
select S.sno, S.sname, t1.cno, t2.cno
from S
         join SC t1
         join SC t2
              on t1.sno = t2.sno
                  and t1.cno = '1'
                  and t2.cno = '2'
                  and S.sno = t1.sno;

# 13.3-2即学过1号课程又学过2号课所有学生的姓名（交集）。
select t1.sno, t1.sname, t1.cno, t2.cno
from (select S.sno, sname, SCGRADE, cno
      from s
               join sc on s.sno = sc.sno
      where cno = 1) as t1
         join (select S.sno, sname, SCGRADE, cno
               from s
                        join sc on s.sno = sc.sno
               where cno = 2) as t2
              on t1.sno = t2.sno;

# 16 列出部门名称和这些部门的员工信息,同时列出那些没有员工的部门(外连接过滤）。
select DNAME,
       EMPNO,
       ENAME,
       JOB,
       MGR,
       HIREDATE,
       SAL,
       COMM,
       e.DEPTNO
from dept
         left join
     emp e on dept.DEPTNO = e.DEPTNO;

# 17 列出至少有5个员工的所有部门

select DEPTNO, count(*)
from emp

group by DEPTNO
having count(*) >= 5;

# 18 列出薪金比"SMITH"多的所有员工信息
select *
from emp
where SAL > (select SAL from emp where ENAME = 'SMITH');

# 19、列出所有"CLERK"(办事员)的姓名及其部门名称,部门的人数
select ENAME, DNAME, num
from emp
         join dept
         join (select DEPTNO, count(*) as num
               from emp
               group by DEPTNO) as t1
              on emp.DEPTNO = dept.DEPTNO
                  and dept.DEPTNO = t1.DEPTNO
where JOB = 'clerk';

# 20、列出最低薪金大于1500的各种工作及从事此工作的全部雇员人数.

select job, min(SAL) min_sal, count(*) num
from emp
group by JOB
having min(SAL) > 1500;


# 联合合并

select EMPNO, ENAME
from emp;

select DEPTNO, DNAME
from dept;

select EMPNO, ENAME
from emp
union
select DEPTNO, DNAME
from dept;

