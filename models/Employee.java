package models;
import exceptions.InvalidEmployeeException; 


public class Employee {

    private String employeeName ;
    private String employeeId ;
    private String mobileNumber;
    private String departmentName ;
    private int employeeAge;  

    public Employee(String employeeId ,  String employeeName , String departmentName , String mobileNumber , int employeeAge) throws InvalidEmployeeException{

         this.employeeId = employeeId ;
        this.departmentName = departmentName ;
        this.employeeName = employeeName ;
        this.mobileNumber = mobileNumber ;
        this.employeeAge = employeeAge ;

       

         private void validateEmployeeName(String employeeName)throws IvalidEmployeeException {
            if(employeeName == null || employeeName.trim().isEmpty()){   //trims extra spaces and is not empty
            throw new InvalidEmployeException("Employee name cannot be empty");
        }
        
         }
    
        private void validateEmployeeId(String employeeId)throws InvalidEmployeeException{
          if(employeeId == null || employeeId.trim().isEmpty()){
            throw new InvalidEmployeeException("Employee ID cannot be empty");
        }
         
    }
        private void validateMobileNumber(String mobileNumber)throws InvalidEmployeeException{
        if(mobileNumber == null || mobileNumber.trim().isEmpty()){
            throw new InvalidEmployeeException("Mobile number name cannot be empty");
        }
    }
         
      private void validateDepartmentName(String departmentName) throws InvalidEmployeeException{
        if(departmentName == null || departmentName.trim().isEmpty()){
            throw new IllegalArgumentException("Department name cannot be empty");
        }
    }
 
    private void vaidateAge(int employeeAge) throws InvalidEmployeeException{
        if(employeeAge < 20 || employeeAge > 60){
             throw new InvalidEmployeeException("Age must be between 20 to 60");
        }
    }

    }

    public String getEmployeeName(){
        return employeeName ;
    }

    public String getEmployeeId(){
        return employeeId;
    }

    public String getMobileNumber(){
        return mobileNumber ;
    }

    public String getDepartmentName(){
        return departmentName ;
    }

    public int getEmployeeAge(){
        return employeeAge;
    }

    public void getDetails(){
        System.out.println("==============Employee Details================");
        System.out.println("Employee's Name: " + employeeName);
        System.out.println("Employee's Id: " + employeeId);
        System.out.println("Employee's Department: " + departmentName);
        System.out.println("Employee's Mobile Number: " + mobileNumber);
        System.out.println("Employe's Age: " + employeeAge);
        System.out.println("================================================");
    }

    @Override 
    public String toString(){
        return "Member{" +
                "EmployeeId='" + employeeId + '\'' +
                ", Employeename='" + employeeName + '\'' +
                ", Mobile Number='" + mobileNumber + '\'' +
                ", Department=" + departmentName +
                '}' ;
    }

      @Override
     public boolean equals(Object o){
 
        if(this == o) return true ;  // exact same object 

        if(o == null || getClass() != o.getClass()) return false ;  // other object is null or of same class

        Employee employee = (Employee)o ;

        return employeeId.equals(employee.employeeId) ; //comparing using employeId

     }

     @Override
     public int hashCode(){
        return employeeId.hashCode() ;
     }

}
