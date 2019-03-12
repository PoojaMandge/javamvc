package com.clc.config;

import java.util.List;

public interface EmpService {
	public boolean addEmp(EmpBean bean);
	public EmpBean getEmp(int empId);
	public boolean deleteEmp(int empId);
	public List<EmpBean> getAllEmps();
	public EmpBean updateEmp(EmpBean bean);
}
