package com.mohit.dao;

import com.mohit.model.Employee;

public interface IEmployeeDAO {
	public void findAllEmployees();
	public void insertEmployee(Employee e);
   }