package com.restapi.emp.service.impl;

import com.restapi.emp.dto.EmployeeDto;
import com.restapi.emp.entity.Department;
import com.restapi.emp.entity.Employee;
import com.restapi.emp.exception.ResourceNotFoundException;
import com.restapi.emp.mapper.EmployeeMapper;
import com.restapi.emp.repository.DepartmentRepository;
import com.restapi.emp.repository.EmployeeRepository;
import com.restapi.emp.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private DepartmentRepository departmentRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto); // dto => entity

        // EmployeeDTo에 포함된 departmentId로 department 객체가 있는지를 먼저 체크.
        Department department = departmentRepository.findById(employeeDto.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department is not exists with id: " +
                                employeeDto.getDepartmentId(),
                                HttpStatus.NOT_FOUND));

        // employee와 department 연결.
        employee.setDepartment(department);
        
        // employee를 저장
        Employee savedEmployee = employeeRepository.save(employee);
        
        // Employee를 EmployeeDto로 변환.
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeDto getEmployeeById(Long employeeId) {
       return employeeRepository.findById(employeeId)
                .map(EmployeeMapper::mapToEmployeeDto)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee is not exists with given id : " + employeeId,
                                HttpStatus.NOT_FOUND));

    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .toList();
                //.map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                //.collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<EmployeeDto> getAllEmployeesDepartment() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::mapToEmployeeDepartmentDto)
                .toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee is not exists with given id: " + employeeId,
                                HttpStatus.NOT_FOUND)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Department department = departmentRepository.findById(updatedEmployee.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Department is not exists with id: " + updatedEmployee.getDepartmentId(),
                                HttpStatus.NOT_FOUND
                                ));

        employee.setDepartment(department);

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee is not exists with given id: " + employeeId,
                        HttpStatus.NOT_FOUND)
        );

        employeeRepository.delete(employee);
    }
}