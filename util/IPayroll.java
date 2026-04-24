package util;
import java.util.List;
import exceptions.EmployeeNotFoundException;
import exceptions.InvalidSalaryException;
import models.Salary;
import models.Employee;



public interface IPayroll {

    Salary calculateSalary(Employee employee)throws EmployeeNotFoundException , InvalidSalaryException;
   
    List<Salary> calculateSalariesofAll(String departmentId);

    Salary getEmployeeSalary(String employeeId) throws EmployeeNotFoundException ;

    List<Salary> getAllEmployeeSalaries(String departmentId) ;

    double getAverageSalary() throws InvalidSalaryException;

    double totalPayrollCost() ; s

}
