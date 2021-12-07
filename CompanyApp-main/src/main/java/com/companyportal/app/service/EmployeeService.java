package com.companyportal.app.service;

import java.util.List;

import com.companyportal.app.entity.Employee;

public interface EmployeeService {

	public void saveEmployeeData(Employee employee);

	public List<Employee> getEmployeesData();
	
	void updateEmployeeData(Employee employee);
    void deleteEmployeeById(Integer employeeId);

	public Employee getSingleEmployeeData(Integer employeeId);

	public List<Employee> getSearchData(String string);
}
