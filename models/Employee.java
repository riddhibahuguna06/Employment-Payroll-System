package models;

import exceptions.InvalidEmployeeException;

public class Employee {

    private String employeeId;
    private String employeeName;
    private String mobileNumber;
    private String departmentName;
    private int employeeAge;

    public Employee(String employeeId, String employeeName, String departmentName, 
                    String mobileNumber, int employeeAge) throws InvalidEmployeeException {
        
        validateEmployeeId(employeeId);
        validateEmployeeName(employeeName);
        validateMobileNumber(mobileNumber);
        validateDepartmentName(departmentName);
        validateAge(employeeAge);

        this.employeeId = employeeId;
        this.employeeName = employeeName;  
        this.mobileNumber = mobileNumber;
        this.departmentName = departmentName;
        this.employeeAge = employeeAge;
    }

    // VALIDATION METHODS
    private void validateEmployeeId(String id) throws InvalidEmployeeException {
        if(id == null || id.trim().isEmpty()){
            throw new InvalidEmployeeException("employeeId", "Employee ID cannot be empty");
        }
    }

    private void validateEmployeeName(String name) throws InvalidEmployeeException {
        if(name == null || name.trim().isEmpty()){
            throw new InvalidEmployeeException("employeeName", "Employee name cannot be empty");
        }
    }

    private void validateMobileNumber(String mobile) throws InvalidEmployeeException {
        if(mobile == null || mobile.trim().isEmpty()){
            throw new InvalidEmployeeException("mobileNumber", "Mobile number cannot be empty");
        }
    }

    private void validateDepartmentName(String dept) throws InvalidEmployeeException {
        if(dept == null || dept.trim().isEmpty()){
            throw new InvalidEmployeeException("departmentName", "Department name cannot be empty");
        }
    }

    private void validateAge(int age) throws InvalidEmployeeException {
        if(age < 20 || age > 60){
            throw new InvalidEmployeeException("age", "Age must be between 20 to 60");
        }
    }

    // GETTERS
    public String getEmployeeName(){
        return employeeName;
    }

    public String getEmployeeId(){
        return employeeId;  
    }

    public String getMobileNumber(){ 
        return mobileNumber;
    }

    public String getDepartmentName(){
        return departmentName;
    }

    public int getEmployeeAge(){
        return employeeAge;
    }

    // SETTERS WITH VALIDATION
    public void setEmployeeName(String name) throws InvalidEmployeeException {
        validateEmployeeName(name);
        this.employeeName = name;
    }

    public void setEmployeeId(String id) throws InvalidEmployeeException{

        validateEmployeeId(id) ;
        this.employeeId = id ;
    }

    public void setMobileNumber(String mobile) throws InvalidEmployeeException {
        validateMobileNumber(mobile);
        this.mobileNumber = mobile;
    }

    public void setDepartmentName(String dept) throws InvalidEmployeeException {
        validateDepartmentName(dept);
        this.departmentName = dept;
    }

    public void setEmployeeAge(int age) throws InvalidEmployeeException {
        validateAge(age);
        this.employeeAge = age;
    }

    // DISPLAY METHOD
    public void displayDetails(){
        System.out.println("========== EMPLOYEE DETAILS ==========");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Department: " + departmentName);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Age: " + employeeAge);
        System.out.println("=====================================");
    }
  
    // toString() METHOD 
    @Override 
    public String toString(){
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", employeeAge=" + employeeAge +
                '}';
    }

    // equals()  //  prevent 2 same employee with same info to be written
    @Override
    public boolean equals(Object o){
        if(this == o) return true;  
        if(o == null || getClass() != o.getClass()) return false;
        
        Employee employee = (Employee) o;  
        
        return employeeId.equals(employee.employeeId);
    }

    // hashCode() METHOD 
    @Override
    public int hashCode(){
        return employeeId.hashCode();
    }
}

