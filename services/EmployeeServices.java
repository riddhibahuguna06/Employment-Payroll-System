package services;

import models.Employee ;

import util.IEmployee ;
import java.util.ArrayList ;
import java.util.List;

import exceptions.EmployeeNotFoundException;
import exceptions.InvalidEmployeeException;
import exceptions.DepartmentNotFoundException;
import exceptions.DuplicateEmployeeException;

public class EmployeeServices implements IEmployee  {

    private ArrayList<Employee>employees = new ArrayList<>();

    @Override
    public void addEmployee(Employee employee) throws DuplicateEmployeeException{
        for(Employee e : employees){
            if (e.getEmployeeId().equals(employee.getEmployeeId())){
                throw new DuplicateEmployeeException("Employee with id " +employee.getEmployeeId() + " already exists");
            }
            }
            employees.add(employee);
        }

    @Override
    public void removeEmployee(String employeeId) throws EmployeeNotFoundException {
        Employee employeeToRemove = null ;

        for(Employee e : employees){
            if(e.getEmployeeId().equals(employeeId)){
                employeeToRemove = e ;
                break ;
            }
        }
        if(employeeToRemove == null){
            throw new EmployeeNotFoundException("Employee not found");
        }
        employees.remove(employeeToRemove);
    }
    
    @Override
    public Employee getEmployeeById(String employeeId ) throws EmployeeNotFoundException{

        for(Employee e : employees){
            if(e.getEmployeeId().equals(employeeId)){
                return e ;
            }
        }
        throw new EmployeeNotFoundException("Employee with id " + employeeId + " not found");
    }

    @Override
    public boolean isEmployeeExists(String employeeId){
        for(Employee e : employees){
            if(e.getEmployeeId().equals(employeeId)){
                return true;
            }
        }
        return false;

    }

     @Override
    public void updateEmployee(String employeeId , Employee updatedEmployee ) throws EmployeeNotFoundException, InvalidEmployeeException{

        Employee employeeToUpdate = null;
        for(Employee e: employees){
            if(e.getEmployeeId().equals(employeeId)){
                employeeToUpdate = e ;
                break;
            }
            }
            if(employeeToUpdate == null){
               throw new EmployeeNotFoundException("Employee not found");
            }
           
            validateEmployeeDetails(updatedEmployee);

            employeeToUpdate.setDepartmentName(updatedEmployee.getDepartmentName());
            employeeToUpdate.setEmployeeAge(updatedEmployee.getEmployeeAge());
            employeeToUpdate.setEmployeeName(updatedEmployee.getEmployeeName());
            employeeToUpdate.setMobileNumber(updatedEmployee.getMobileNumber());
            
            System.out.println("Employee updated sucessfully");

        }

            private void validateEmployeeDetails(Employee employee) throws InvalidEmployeeException{

                if(employee.getEmployeeName() == null || employee.getEmployeeName().isEmpty()){
                    throw new InvalidEmployeeException(" Name cannot be empty", " Employee Name");
                }

                if(employee.getDepartmentName() == null || employee.getDepartmentName().isEmpty()){
                    throw new InvalidEmployeeException("Department cannot be empty" ,"Department");
                }

                if(employee.getEmployeeAge() > 60 || employee.getEmployeeAge() < 20){
                    throw new InvalidEmployeeException("Age must be between 20-60" , "Age");
                }

                 if(employee.getMobileNumber() == null || employee.getMobileNumber().length() != 10) {
                    throw new InvalidEmployeeException("Mobile must be 10 digits", "Mobile number");
               }

        }

    @Override
    public  int getTotalEmployee(){
        return employees.size();
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String departmentName) throws DepartmentNotFoundException{
        List<Employee> result =new ArrayList<>();
        for(Employee e : employees){
            if(e.getDepartmentName().equals(departmentName)){
                result.add(e);
            }
        }
       if(result.isEmpty()){
        throw new DepartmentNotFoundException("Department not found");
       }
       return result;
    }

    @Override
    public List<Employee> getAllEmployees(){
        List<Employee>result = new ArrayList<>();
        for(Employee e : employees){
            result.add(e);
        }
        return result ;
    }

    }
