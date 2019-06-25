package com.atec.service;

import com.atec.dto.EmployeeDTO;
import com.atec.mapper.EmployeeMapper;
import com.atec.model.Employee;
import com.atec.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeMapper mapper;

    @Transactional(readOnly = true)
    public List<EmployeeDTO> getAll(){
        List<Employee> dbEmployees = repository.findAll();

        return mapper.toEmployeeDTOs(dbEmployees);
    }


}
