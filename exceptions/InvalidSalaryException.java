package exceptions;

public class InvalidSalaryException extends Exception {
    public InvalidSalaryException(){
        super("Invalid Salary");
    }

    public InvalidSalaryException(String message){
        super(message);
    }

    
}
