package com.example.learn.spring.learnspring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learn.spring.learnspring.Entities.Employee;

@Repository
public interface  EmployeeRepository extends JpaRepository<Employee, Long> {

}
