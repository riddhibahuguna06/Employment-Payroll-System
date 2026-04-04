package exceptions;

public class EmployeeNotFoundException extends Exception {
    private String employeeId ;

    public EmployeeNotFoundException(){   //default 
        super("Member not found");
    }

    public EmployeeNotFoundException(String message){  //custom meesage
        super(message); 
    }

    public EmployeeNotFoundException(String employeeId , String message){
      super( employeeId +" Employee not found " + message) ;
       this.employeeId = employeeId ; 
    }

     public EmployeeNotFoundException(String message, Throwable cause) {  // cause + message
        super(message, cause);
    }
    

    public String getEmployeeId(){
        return employeeId ;
    }
}


