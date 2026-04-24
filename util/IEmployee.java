package util;
import models.Employee;

import java.util.List;

import exceptions.DuplicateEmployeeException;
import exceptions.EmployeeNotFoundException;
import exceptions.InvalidEmployeeException;
import exceptions.DepartmentNotFoundException;


public interface IEmployee {
    void addEmployee(Employee employee) throws DuplicateEmployeeException ;
    
    void updateEmployee(String employeeId , Employee updatedEmployee ) throws EmployeeNotFoundException, InvalidEmployeeException;

    void removeEmployee(String employeeId) throws EmployeeNotFoundException ;

    Employee getEmployeeById(String employeeId ) throws EmployeeNotFoundException ;
    
    boolean isEmployeeExists(String employeeId) ;

    int getTotalEmployee() ;

    List<Employee> getEmployeesByDepartment(String departmentName) throws DepartmentNotFoundException;

    List<Employee> getAllEmployees(); 

     
}
