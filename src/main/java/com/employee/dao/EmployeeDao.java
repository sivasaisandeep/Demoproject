package com.employee.dao;

import java.util.List;

import com.employee.model.EmployeePOJO;

public interface EmployeeDao {
	 void register(EmployeePOJO emp);	 
	 List<EmployeePOJO> listAll();
	 EmployeePOJO getEmployee(int id);
}
