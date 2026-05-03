package services;
import util.IPayroll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exceptions.EmployeeNotFoundException;
import exceptions.EmptyPayrollException;
import exceptions.InvalidSalaryException;
import models.Employee;
import models.Salary;


public class PayrollServices implements IPayroll{

    private List<Employee>allEmps;

   public PayrollServices(EmployeeServices empService) {
    this.allEmps = empService.getAllEmployees(); 
}

    private HashMap<String , Salary>calculatedSalary = new HashMap<>(); // employeeId , salary
    

     @Override
     public Salary calculateSalary(Employee employee)throws EmployeeNotFoundException , InvalidSalaryException{

        if(employee == null){
            throw new EmployeeNotFoundException();
        }

        for(Employee e : allEmps){
            if(e.getEmployeeId().equals(employee.getEmployeeId())){
             
                Salary salary = new Salary( e.getBaseSalary(), e.getBonus() , e.getDeductions());
                calculatedSalary.put(e.getEmployeeId() , salary);
                return salary ;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
     }

     @Override
     public List<Salary> calculateAllSalaries(String employeeId)throws EmptyPayrollException{

        if(allEmps == null || allEmps.isEmpty()){
            throw new EmptyPayrollException("No employees in payrolll to calculate salaries");
        }
        calculatedSalary.clear();

            for(Employee e : allEmps){
                try{
                    calculateSalary(e);
                }catch(EmployeeNotFoundException ex){
                System.out.println("Could not calculate salary for" + e.getEmployeeId() + ":" + ex.getMessage());
                }catch(InvalidSalaryException ex){
                    System.out.println("Invalid salary " + e.getEmployeeId() + ":" + ex.getMessage());
                }
               
            }

            if(calculatedSalary.isEmpty()){
                throw new EmptyPayrollException("Could not calculate any salaries");
            }

            return new ArrayList<>(calculatedSalary.values());

     }

     @Override
     public Salary getEmployeeSalary(String employeeId) throws EmployeeNotFoundException{
     for(Employee e : allEmps){
        if(e.getEmployeeId().equals(employeeId)){
         return calculatedSalary.get(employeeId) ;
        }
        }
         throw new EmployeeNotFoundException("Employee with " + employeeId + " not found");
    }
     

     @Override
     public List<Salary> getAllEmployeeSalaries(String departmentId){
      return new ArrayList <>(calculatedSalary.values()) ;
     }

     @Override
     public double getAverageSalary() throws EmptyPayrollException{

        if(calculatedSalary.isEmpty()){
            throw new EmptyPayrollException("No salaries calculated. Calculate salaries first.");
        }
        double total = 0 ;
    for(Salary salary : calculatedSalary.values()) {
        total += salary.getNetSalary();
    }
    return total / calculatedSalary.size();
     }

     @Override
     public double totalPayrollCost() throws EmptyPayrollException{

        if(calculatedSalary.isEmpty()) {
        throw new EmptyPayrollException("No salaries calculated. Calculate salaries first.");
    }

    double total = 0;
    for(Salary salary : calculatedSalary.values()) {
        total += salary.getNetSalary();
    }
    
    return total;
     }
    
}
