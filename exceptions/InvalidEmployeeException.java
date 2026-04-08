package exceptions;

public class InvalidEmployeeException extends Exception {
    private String fieldName;

    public InvalidEmployeeException(){
      super("Invalid employee data");
    }

    public InvalidEmployeeException(String message){
        super(message);
    }

    public InvalidEmployeeException(String message , Throwable cause){
        super(message ,cause);
    }

    public InvalidEmployeeException(String message , String fieldName){
     super("Field [" + fieldName + "]: " + message);
     this.fieldName = fieldName;
    }

    public String getFieldName(){
        return fieldName ;
    }
}

