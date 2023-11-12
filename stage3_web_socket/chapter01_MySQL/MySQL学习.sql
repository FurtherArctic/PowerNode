show tables;

select count(COMM)
from emp;

select count(*)
from emp;

select count(distinct JOB)
from emp;

select max(SAL) as max_sal
from emp
where DEPTNO = 20;

select sum(COMM), sum(SAL), sum(SAL + COMM)
from emp;

select ENAME, max(sal)
from emp
where DEPTNO = 20
group by ENAME;

select ENAME, SAL, JOB, empno
from emp
where sal = (select max(SAL) from emp where DEPTNO = 20);

#部门20下有哪些职位，每个职位有多少人
select DEPTNO, JOB, count(*)
from emp
where DEPTNO = 20
group by JOB;

# 各个部门的人数
select DEPTNO, count(*)
from emp
group by deptno;

#各个部门各个职位的名称和人数

select JOB, deptno, count(*)
from emp
group by deptno, job;

select JOB, deptno, count(*)
from emp
group by job, DEPTNO;

select JOB, deptno, count(*)
from emp
group by job, DEPTNO
having count(*) > 1;

#查询平均工资在1600以上部门
select deptno, avg(sal)
from emp
group by deptno
having avg(sal) >= 1600;

# 需求：查询部门30下平局工资在1000元以上的职位信息，
# 要求按照职位平均工资降序排列
SELECT DEPTNO, JOB, COUNT(*) AS COUNT, AVG(SAL) AS AVG
from emp
where deptno = 30
GROUP BY JOB
HAVING AVG >= 1000
ORDER BY AVG DESC;
# 查询各个部门人数， 要求按照部门人数升序
select COUNT(*) AS COUNT, DEPTNO
FROM emp
GROUP BY DEPTNO
ORDER BY COUNT DESC;

SELECT *
FROM emp
ORDER BY DEPTNO ASC, SAL DESC, HIREDATE;

select *
FROM emp
order by SAL desc
limit 0,1;
# 部门10的信息及其拥有的职员信息
select *
from emp
         join dept
              on emp.DEPTNO = dept.DEPTNO
where emp.DEPTNO = 10;

select *
from emp
         join (select * from dept where DEPTNO = 10) t2
              on t2.DEPTNO = emp.DEPTNO;

# 部门10的职员收入情况以及工资等级
select DEPTNO, ENAME, SAL, salgrade.GRADE
from salgrade
         join emp on SAL between LOSAL and HISAL
where DEPTNO = 10;

# 展示各个部门名称以及部门下拥有的职员人数
select dept.DEPTNO, DNAME, count(*)
from dept
         join emp on emp.DEPTNO = dept.DEPTNO
group by dept.DEPTNO;
# 展示各个部门名称以及部门下拥有的职员人数（包含人数为0的部门）
select dept.DEPTNO, DNAME, count(emp.EMPNO)
from dept
         left join emp on emp.DEPTNO = dept.DEPTNO
group by dept.DEPTNO;

# 查询工资高于平均工资的职员
select EMPNO, ENAME, SAL
from emp
where sal > (select avg(SAL) from emp);

# 查询部门10下员工工资以及公司平均工资
select ENAME, SAL, deptno, (select avg(SAL) from emp) as avg_sal
from emp
where DEPTNO = 10;


# 联合合并方案

select score.name, 'java' as course, java_score as score
from score
union
select score.name, 'mysql' as course, mysql_score as score
from score
order by name;

show engines;
