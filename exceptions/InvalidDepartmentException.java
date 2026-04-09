package exceptions;

public class InvalidDepartmentException extends Exception {
    private String fieldName  ;
    public InvalidDepartmentException(){
        super("Invalid Department");
    }

    public InvalidDepartmentException(String message){
         super(message);
    }

    public InvalidDepartmentException(String message , String fieldName ){

    super("Field [" + fieldName + "]: " + message);
     this.fieldName = fieldName;
    }

    public String getFieldName(){
        return fieldName ;
    }
    
}
