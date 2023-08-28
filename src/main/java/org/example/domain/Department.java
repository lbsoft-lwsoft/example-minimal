package org.example.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Department {

  @Id
  private final UUID id;

  private final String name;

  @ManyToMany
  private final Set<Employee> employees = new HashSet<>();

  public Department(String name) {
    this.id = UUID.randomUUID();
    this.name = name;
  }


  public void addEmployee(Employee employee) {
    this.employees.add(employee);
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Set<Employee> getEmployees() {
    return Collections.unmodifiableSet(employees);
  }
}
