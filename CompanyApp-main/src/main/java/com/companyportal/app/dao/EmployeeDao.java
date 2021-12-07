package com.companyportal.app.dao;

import java.util.List;

import com.companyportal.app.entity.Employee;

public interface EmployeeDao {

	void saveEmployeeData(Employee employee);

	List<Employee> getEmployeesData();

	void updateEmployeeData(Employee employee);
    void deleteEmployeeById(Integer employeeId);

	Employee getSingleEmployeeData(Integer employeeId);

	List<Employee> getSearchData(String string);

	
}
