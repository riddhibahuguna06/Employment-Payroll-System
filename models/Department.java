package models;
import exceptions.InvalidDepartmentException;

public class Department {
    private String departmentName;
    private String departmentId;
    private String managerName ;
    private double departmentBudget ;


    public Department(String departmentName , String departmentId , String managerName , double departmentBudget) throws InvalidDepartmentException{

        validateDepartmentName( departmentName);
        validateDepartmenId( departmentId);
        validateManagerName(managerName);
        validateDepartmentBudget(departmentBudget);

        this.departmentName =departmentName;
        this.departmentId = departmentId ;
        this.managerName = managerName ;
        this.departmentBudget = departmentBudget;
    }

    private void validateDepartmentName(String departmentName)throws InvalidDepartmentException{

        if(departmentName == null || departmentName.trim().isEmpty()){
            throw new InvalidDepartmentException("Department name" , "Department name cannot be empty");
        }
    }

    private void validateDepartmenId(String id) throws InvalidDepartmentException{ 
        if(id == null || id.trim().isEmpty()) {
            throw new InvalidDepartmentException("Department id" , "Department id cannot be empty");
        }
    }

    private void validateManagerName(String name) throws InvalidDepartmentException{
    if(name == null || name.trim().isEmpty()) {
            throw new InvalidDepartmentException("Manager Name" , "Manager name cannot be empty" );
        }
    }

    private void validateDepartmentBudget(double budget)throws InvalidDepartmentException{
        if(budget < 0){
        throw new InvalidDepartmentException("Budget cannot be negative");
        }

        if(budget > 1000000){
            throw new InvalidDepartmentException("Budget exceeds the limit");
        }

        if(budget == 0){
            throw new InvalidDepartmentException("Budget cannot be 0");
        }
    }

    // getter methods

    public String getDepartmentName(){
        return departmentName ;
    }

    public String getDepartmentId(){
        return departmentId ;
    }

    public String getManagerName(){
        return managerName ;
    }

    public double getDepartmentBudget(){
        return departmentBudget ;
    }

    // setter methods

    public void setDepartmentName(String departmentName) throws InvalidDepartmentException{
       
        validateDepartmentName(departmentName);
        this.departmentName = departmentName ;
    }

    public void setManagerName(String name) throws InvalidDepartmentException{

        validateManagerName(name);
        this.managerName = name ;
    }

    public void setDepartmentBudget(double budget) throws InvalidDepartmentException{

        validateDepartmentBudget(budget);
        this.departmentBudget = budget;
    }

    public void displayDetails(){
        System.out.println("Department Name : " + departmentName);
        System.out.println("Department Id : " + departmentId);
        System.out.println("Department manager : " + managerName);
        System.out.println("Depatment Budget : " + departmentBudget);
    }

    @Override
    public String toString(){
        return "Department{" +
                "Department name = " + departmentName + '\'' +
                "Department id = " + departmentId + '\'' +
                "Manager name = "  + managerName + '\'' +
                "Department budget = " + departmentBudget + 
                 '}';
    }

    @Override 
    public boolean equals(Object o){
        if(this == o) return true ;
        if(o == null || getClass() != o.getClass()) return false ;

        Department department = (Department) o ;
        return departmentId.equals(department.departmentId);
    }

     @Override
    public int hashCode(){
        return departmentId.hashCode();
    }

    }

