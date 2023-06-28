package com.global.crmplatform.organisation.department.api;

import com.global.crmplatform.organisation.department.domain.Department;
import com.global.crmplatform.organisation.department.service.DepartmentReadPlatformService;
import com.global.crmplatform.organisation.department.service.DepartmentWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/departments")
public class DepartmentApiResource {

    private final Set<String> RESPONSE_DATA_PARAMETERS = new HashSet<String>(Arrays.asList("id", "departmentname", "description", "officeId"));
    private final String resourceNameForPermissions = "DEPARTMENT";
    @Autowired
    private final DepartmentReadPlatformService departmentReadPlatformService;

    @Autowired
    private final DepartmentWritePlatformService departmentWritePlatformService;

    public DepartmentApiResource(DepartmentReadPlatformService departmentReadPlatformService,
                                 DepartmentWritePlatformService departmentWritePlatformService) {
        this.departmentReadPlatformService = departmentReadPlatformService;
        this.departmentWritePlatformService = departmentWritePlatformService;
    }

    @PostMapping
    public Department createDepartments(final Department jsonRequestBody) {
        return departmentWritePlatformService.createDepartment(jsonRequestBody);
    }

    @GetMapping("/{deptid}")
    public Department retrieveDepartmentDataById(@PathVariable("deptid") final Long deptId) {
        final Department department = this.departmentReadPlatformService.retrieveDepartmentDataById(deptId);
        return department;
    }

    @GetMapping
    public List<Department> retrieveAllDepartmentData() {
        final List<Department> departmentdatas = this.departmentReadPlatformService.retrieveAllDepartmentData();
        return departmentdatas;
    }

    @GetMapping("/create")
    public List<Department> createDummyData() {

        Department dep=  Department.builder().
                deptName("Support").deleted("N").
                deptDescription(UUID.randomUUID().toString()).officeId(1l)
                .build();

         departmentWritePlatformService.createDepartment(dep);

        final List<Department> departmentdatas = this.departmentReadPlatformService.retrieveAllDepartmentData();
        return departmentdatas;
    }


    @PutMapping("/{deptid}")
    public Department updateDepartmentsById(@PathVariable("deptid") final Long deptId) {
        final Department department = this.departmentReadPlatformService.retrieveDepartmentDataById(deptId);
        return department;
    }

    @DeleteMapping("/{deptid}")
    public String deleteDepartment(@PathVariable("deptid") final Long deptId) {
        departmentWritePlatformService.deleteDepartment(deptId);
        return "OK";
    }

}