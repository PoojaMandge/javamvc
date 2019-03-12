package com.clc.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class EmpServiceImpl implements EmpService{

	@Autowired
	public EmpDaoImpl empdao;
	
	public void setEmpdao(EmpDaoImpl empdao) {
		this.empdao = empdao;
	}

	public EmpEntity convertBeanToEntity(EmpBean bean){
		EmpEntity entity = new EmpEntity();
		entity.setEmpAddress(bean.getEmpAddress());
		entity.setEmpAge(bean.getEmpAge());
		entity.setEmpId(bean.getEmpId());
		entity.setEmpName(bean.getEmpName());
		entity.setEmpSalary(bean.getEmpSalary());
		return entity;
	}
	
	public List<EmpBean> convertEntitiesToBeans(List<EmpEntity> entities){
		List<EmpBean> beans = new ArrayList<EmpBean>();
		for(EmpEntity entity :entities){
			beans.add(convertEntityToBean(entity));
		}
		return beans;
	}
	
	public EmpBean convertEntityToBean(EmpEntity entity){
	
		EmpBean bean = new EmpBean();
		bean.setEmpAddress(entity.getEmpAddress());
		bean.setEmpAge(entity.getEmpAge());
		bean.setEmpId(entity.getEmpId());
		bean.setEmpName(entity.getEmpName());
		bean.setEmpSalary(entity.getEmpSalary());
		return bean;
	}
	
	
	
	public boolean addEmp(EmpBean bean) {
		return empdao.insertEmp(convertBeanToEntity(bean));
	}

	public EmpBean getEmp(int empId) {
		System.out.println("aaa"+empId);
		return convertEntityToBean(empdao.fetchEmp(empId));
	}

	public boolean deleteEmp(int empId) {
		return empdao.removeEmp(empId);
	}

	public List<EmpBean> getAllEmps() {
		return convertEntitiesToBeans(empdao.fetchAllEmps());
	}

	public EmpBean updateEmp(EmpBean bean) {
		return convertEntityToBean(empdao.modifyEmp(convertBeanToEntity(bean)));
	}

}
