package com.clc.config;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDaoImpl implements EmpDao{
	@Autowired
	SessionFactory sfactory;

	public void setSfactory(SessionFactory sfactory) {
		this.sfactory = sfactory;
	}

	public boolean insertEmp(EmpEntity entity) {
		System.out.println("insertEmp Info inside DAOimpl" +entity);
		Session session = null;
		Transaction tr=null;
		try{
		session = sfactory.openSession();
		tr = session.beginTransaction();
		session.save(entity);
		cleanup(session,tr);
		return true;
		}catch(Exception e){
			tr.rollback();
			return false;
		}
	}

	private void cleanup(Session session, Transaction tr) {
		if(session!=null){
			if(tr!=null){
				session.flush();
				tr.commit();
			}
			session.close();
		}
	}

	public EmpEntity fetchEmp(int empId) {
		System.out.println("fetchEmp Info inside DAOimpl" +empId);
		Session session = null;
		try{
		session = sfactory.openSession();
		EmpEntity entity =session.get(EmpEntity.class, empId);
		cleanup(session,null);
		return entity;
		}catch(Exception e){
			return null;
		}
	}

	public boolean removeEmp(int empId) {
		Session session = null;
		Transaction tr=null;
		EmpEntity entity = fetchEmp(empId);
		if(entity!=null){
			try{
				session = sfactory.openSession();
				tr = session.beginTransaction();
				session.delete(entity);
				cleanup(session,tr);
				return true;
				}catch(Exception e){
					tr.rollback();
				}
		}
		return false;
	}

	public List<EmpEntity> fetchAllEmps() {
		Session session = null;
		try{
		session = sfactory.openSession();
		List<EmpEntity> entities = session.createCriteria(EmpEntity.class).list();
		cleanup(session,null);
		return entities;
		}catch(Exception e){
			return null;
		}
	}

	public EmpEntity modifyEmp(EmpEntity entity) {
		Session session = null;
		Transaction tr=null;
		EmpEntity dbEntity  = fetchEmp(entity.getEmpId());
		if(dbEntity!=null){
			try{
				session = sfactory.openSession();
				tr = session.beginTransaction();
				dbEntity.setEmpAddress(entity.getEmpAddress());
				dbEntity.setEmpAge(entity.getEmpAge());
				dbEntity.setEmpName(entity.getEmpName());
				dbEntity.setEmpSalary(entity.getEmpSalary());
				EmpEntity updatedEn = (EmpEntity) session.merge(dbEntity);
				cleanup(session,tr);
				return updatedEn;
				}catch(Exception e){
					tr.rollback();
				}
		}
		
		return null;
		
	}
	
	

}
