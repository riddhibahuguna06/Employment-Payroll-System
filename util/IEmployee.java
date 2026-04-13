package util;
import models.Employee;

import java.util.List;

import exceptions.DuplicateEmployeeException;
import exceptions.EmployeeNotFoundException;


public interface IEmployee {
    void addEmployee(Employee employee) throws DuplicateEmployeeException ;
    
    void updateEmployee(String employeeId , Employee updatedEmployee ) throws DuplicateEmployeeException;

    void removeEmployee(String employeeId) throws EmployeeNotFoundException ;

    Employee getEmployeeById(String employeeId ) throws EmployeeNotFoundException ;

    boolean isEmployeeExists(String employeeId) throws EmployeeNotFoundException ;

    int getTotalEmployee() ;

    List<Employee> getEmployeesByDepartment(String deptId);

    List<Employee> getAllEmployees();  

     
}
