package com.powernode.entity;

public class Emp {
    private Integer empNo;
    private String eName;
    private String job;
    private Integer Mgr;
    private String HireDate;
    private Double sal;
    private Double comm;
    private Integer deptNo;

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return Mgr;
    }

    public void setMgr(Integer mgr) {
        Mgr = mgr;
    }

    public String getHireDate() {
        return HireDate;
    }

    public void setHireDate(String hireDate) {
        HireDate = hireDate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public Emp(Integer empNo, String eName, String job, Integer mgr, String hireDate, Double sal, Double comm, Integer deptNo) {
        this.empNo = empNo;
        this.eName = eName;
        this.job = job;
        this.Mgr = mgr;
        this.HireDate = hireDate;
        this.sal = sal;
        this.comm = comm;
        this.deptNo = deptNo;
    }

    public Emp() {
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empNo=" + empNo +
                ", eName='" + eName + '\'' +
                ", job='" + job + '\'' +
                ", Mgr='" + Mgr + '\'' +
                ", HireDate='" + HireDate + '\'' +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptNo=" + deptNo +
                '}';
    }
}
