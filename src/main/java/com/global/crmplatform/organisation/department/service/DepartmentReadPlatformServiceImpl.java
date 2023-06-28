package com.global.crmplatform.organisation.department.service;

import com.global.crmplatform.organisation.department.domain.Department;
import com.global.crmplatform.organisation.department.domain.DepartmentRepository;
import com.global.crmplatform.organisation.department.exception.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentReadPlatformServiceImpl implements DepartmentReadPlatformService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department retrieveDepartmentDataById(Long deptId) {
        try {
            Optional<Department> dept = departmentRepository.findById(deptId);
            if (dept.isPresent()) {
                return dept.get();
            } else {
                throw new DepartmentNotFoundException(deptId);
            }
        } catch (EmptyResultDataAccessException accessException) {
            throw new DepartmentNotFoundException(deptId);
        }
    }

    @Override
    public List<Department> retrieveAllDepartmentData() {
        try {
            List<Department> deptList = departmentRepository.findAll();
            if (!deptList.isEmpty()) {
                return deptList;
            } else {
                throw new DepartmentNotFoundException(1l);
            }
        } catch (EmptyResultDataAccessException accessException) {
            throw new DepartmentNotFoundException(1l);
        }
    }

    @Override
    public List<Department> retrieveDepartmentName(final String deptName) {
        try {
            List<Department> dept = departmentRepository.findByDeptName(deptName);
            if (!dept.isEmpty()) {
                return dept;
            } else {
                throw new DepartmentNotFoundException(deptName);
            }
        } catch (EmptyResultDataAccessException accessException) {
            throw new DepartmentNotFoundException(deptName);
        }

    }
}
