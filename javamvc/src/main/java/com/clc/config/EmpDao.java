package com.clc.config;

import java.util.List;

public interface EmpDao {
	public boolean insertEmp(EmpEntity entity);
	public EmpEntity fetchEmp(int empId);
	public boolean removeEmp(int empId);
	public List<EmpEntity> fetchAllEmps();
	public EmpEntity modifyEmp(EmpEntity entity);
}
