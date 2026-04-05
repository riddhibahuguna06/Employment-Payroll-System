package exceptions;

public class DuplicateEmployeeException extends Exception {

    private String employeeId;

    public DuplicateEmployeeException(){
        super("Employee already registered");
    }

    public DuplicateEmployeeException(String message){
        super(message) ;
    }

   public DuplicateEmployeeException(String message , String employeeId){
    super(employeeId + " Already exists " + message) ;

    this.employeeId = employeeId ;
   }

   public DuplicateEmployeeException(String message, Throwable cause){
     super(message, cause);
   }

   public String getEmployeeId(){
    return employeeId ;
   }
}
