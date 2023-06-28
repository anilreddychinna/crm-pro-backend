package com.global.crmplatform.organisation.department.service;

import com.global.crmplatform.organisation.department.domain.Department;

import java.util.List;

public interface DepartmentReadPlatformService {

	Department retrieveDepartmentDataById(Long deptId);
	
	List<Department> retrieveAllDepartmentData();

	List<Department> retrieveDepartmentName(String deptName);
}
