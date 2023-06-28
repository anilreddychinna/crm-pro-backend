package com.global.crmplatform.organisation.department.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long>,JpaSpecificationExecutor<Department> {

    List<Department> findByDeptName(String firstName);


}
