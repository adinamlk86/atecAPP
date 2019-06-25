package com.atec.mapper;

import com.atec.dto.EmployeeDTO;
import com.atec.model.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface EmployeeMapper {

    EmployeeDTO toEmployeeDTO(Employee employee);

    List<EmployeeDTO> toEmployeeDTOs(List<Employee> employees);

    Employee toEmployee(EmployeeDTO employeeDTO);
}
