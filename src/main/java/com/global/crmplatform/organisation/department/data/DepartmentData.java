package com.global.crmplatform.organisation.department.data;

import lombok.Data;

@Data
public class DepartmentData {
	private Long id;
	private String deptName;
	private String deptDescription;
	private Long officeId;
}
