package com.companyportal.app.service.impl;

import java.util.List;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private static int count;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public void saveEmployeeData(Employee employee) {
		
		
		employeeDao.saveEmployeeData(employee);
	}

	public List<Employee> getEmployeesData() {
		
		return employeeDao.getEmployeesData();
	}

	@Override
	public void updateEmployeeData(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.updateEmployeeData( employee);
	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployeeById( employeeId);
	}

	@Override
	public Employee getSingleEmployeeData(Integer employeeId) {
		return employeeDao.getSingleEmployeeData(employeeId);
	}

	@Override
	public List<Employee> getSearchData(String string) {
		return employeeDao.getSearchData(string);
	}

}
