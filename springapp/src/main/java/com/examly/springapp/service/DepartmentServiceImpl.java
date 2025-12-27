package com.examly.springapp.service;

import com.examly.springapp.model.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final Map<Long, Department> departmentStore = new HashMap<>();
    private long idCounter = 1;

    @Override
    public Department addDepartment(Department department) {
        department.setDepartmentId(idCounter++);
        departmentStore.put(department.getDepartmentId(), department);
        return department;
    }

    @Override
    public List<Department> getAllDepartments() {
        return new ArrayList<>(departmentStore.values());
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentStore.get(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        department.setDepartmentId(id);
        departmentStore.put(id, department);
        return department;
    }
    @Override
public Page<Department> getDepartmentsWithPagination(Pageable pageable) {
    List<Department> departments = new ArrayList<>(departmentStore.values());
    return new PageImpl<>(departments, pageable, departments.size());
}

}
