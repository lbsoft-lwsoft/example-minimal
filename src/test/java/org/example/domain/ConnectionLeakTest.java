package org.example.domain;

import io.ebean.DB;
import org.junit.jupiter.api.Test;

class ConnectionLeakTest {

    @Test
    void addEmployee() {
        final Department department = new Department("Test");
        final Employee employee = new Employee("Test", "Code");
        DB.save(employee);
        department.addEmployee(employee);
        DB.save(department);
        DB.find(Department.class, department.getId()).getEmployees().forEach(e -> System.out.println(e.getName()));
    }
}
