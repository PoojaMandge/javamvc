package com.clc.config;

public class EmpBean {

	private int empId;
	private String empName;
	private String empAddress;
	private int empAge;
	private double empSalary;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "\n EmpBean [empId=" + empId + ", empName=" + empName
				+ ", empAddress=" + empAddress + ", empAge=" + empAge
				+ ", empSalary=" + empSalary + "]";
	}
	public EmpBean(int empId, String empName, String empAddress,
			int empAge, double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empAge = empAge;
		this.empSalary = empSalary;
	}
	public EmpBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

	

}
