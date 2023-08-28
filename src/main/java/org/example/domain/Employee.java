package org.example.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class Employee {

  @Id
  private final UUID id;

  private final String name;

  private final String code;

  @ManyToMany
  @JoinTable(name="employee_department",
          joinColumns=
          @JoinColumn(name="employee_id", referencedColumnName="id"),
          inverseJoinColumns=
          @JoinColumn(name="department_id", referencedColumnName="id")
  )
  private final Set<Department> departments = new HashSet<>();

  public Employee(String name, String code) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.code = code;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCode() {
    return code;
  }

  public Set<Department> getDepartments() {
    return departments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return Objects.equals(code, employee.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }
}
