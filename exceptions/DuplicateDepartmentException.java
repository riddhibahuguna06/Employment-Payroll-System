package exceptions;

public class DuplicateDepartmentException extends Exception{

    private String departmentId ;

    public DuplicateDepartmentException(){
        super("This department id already exists");
    }

    public DuplicateDepartmentException(String message){
        super(message);
    }

    public DuplicateDepartmentException(String message , String departmentId){

        super("department id" + departmentId + "already exists");
        this.departmentId = departmentId ;
    }

public DuplicateDepartmentException(String message , Throwable cause){
    super(message , cause);
}

public String getDepartmentId(){
    return departmentId ;
}

    
}
