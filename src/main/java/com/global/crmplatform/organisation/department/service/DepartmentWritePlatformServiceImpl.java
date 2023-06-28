package com.global.crmplatform.organisation.department.service;

import com.global.crmplatform.organisation.department.domain.Department;
import com.global.crmplatform.organisation.department.domain.DepartmentRepository;
import com.global.crmplatform.organisation.department.exception.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentWritePlatformServiceImpl implements DepartmentWritePlatformService {
    @Autowired
    private final DepartmentRepository repository;

    public DepartmentWritePlatformServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Department createDepartment(final Department department) {
        try {
            Department entity = this.repository.save(department);
            return entity;
        } catch (DataIntegrityViolationException dve) {
            return null;
        }
    }


    @Override
    public Department updateDepartment(final Long entityId, final Department data) {

        try {
            final Optional<Department> department = this.repository.findById(entityId);
            if (department.isPresent()) {
                Department entity = this.repository.save(department.get());
                return entity;
            } else {
                throw new RuntimeException("Data not found");
            }

        } catch (DataIntegrityViolationException dve) {
            throw new RuntimeException("Data not found" + dve);
        }
    }


    @Override
    public void deleteDepartment(Long entityId) {

        try {
            final Optional<Department> department = this.repository.findById(entityId);
            department.get().delete();
            this.repository.save(department.get());
        } catch (DataIntegrityViolationException dve) {
			throw new DepartmentNotFoundException("No employee record exist for given id");
        }
    }

}

