package com.global.crmplatform.organisation.department.service;

import com.global.crmplatform.organisation.department.domain.Department;

public interface DepartmentWritePlatformService {
    Department createDepartment(Department data);

    Department updateDepartment(Long entityId, Department data);

    void deleteDepartment(Long entityId);
}
