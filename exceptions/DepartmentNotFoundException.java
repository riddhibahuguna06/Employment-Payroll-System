package exceptions;

public class DepartmentNotFoundException extends Exception{

     private String departmentId ;

    public DepartmentNotFoundException(){   //default 
        super("Member not found");
    }

    public DepartmentNotFoundException(String message){  //custom meesage
        super(message); 
    }

    public DepartmentNotFoundException(String departmentId , String message){
      super( departmentId +" Employee not found " + message) ;
       this.departmentId = departmentId ; 
    }

     public DepartmentNotFoundException(String message, Throwable cause) {  // cause + message
        super(message, cause);
    }
    

    public String getDepartmentId(){
        return departmentId ;
    }
}
