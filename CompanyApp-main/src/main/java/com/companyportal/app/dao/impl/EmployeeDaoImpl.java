package com.companyportal.app.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;


@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void saveEmployeeData(Employee employee) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();		
		session.persist(employee);
		session.getTransaction().commit();
		session.close();
	}

	public List<Employee> getEmployeesData() {
	List<Employee> empList = new ArrayList<Employee>();
	
	Session session=sessionFactory.openSession();
	empList=session.createQuery("From Employee").list();
	session.close();
	
	return empList;
	}

	@Override
	public void updateEmployeeData(Employee employee) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();		
		session.update(employee);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Employee employee=new Employee();
		employee.setEmployeeId(employeeId);
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Employee getSingleEmployeeData(Integer employeeId) {
		Session session=sessionFactory.openSession();
		Employee employee=session.get(Employee.class, employeeId);
		return employee;
	}

	@Override
	public List<Employee> getSearchData(String string) {
		Session session=sessionFactory.openSession();
		Query<Employee> query=session.createQuery("from Employee where name like :string");
		string="%"+string+"%";
		query.setParameter("string", string);
		List<Employee> list=query.list();
		session.close();
		return list;
	}

}
