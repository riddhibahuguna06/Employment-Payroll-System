package models;
import exceptions.InvalidSalaryException;

public class Salary {

    private double baseSalary;
    private double bonus;
    private double tax;
    private double deductions;

    
    public Salary(double baseSalary , double bonus , double tax , double deductions , double gross)throws InvalidSalaryException{
       
        validateBaseSalary(baseSalary);
        validateBonus(bonus);
        validateDeductions(deductions);
        validateNetSalary( gross , deductions);

        this.baseSalary = baseSalary ;
        this.bonus= bonus;
        this.tax = calculateTax();
        this.deductions = deductions ;
    }

        private void validateBaseSalary(double salary) throws InvalidSalaryException{

            if(salary < 0){
                throw new InvalidSalaryException("Base salary cannot be negative");
            }

            if(salary == 0 ){
                throw new InvalidSalaryException("Base salary cannot be zero");
            }

            if(salary > 100000){
                throw new InvalidSalaryException("Base saary is not realistic");
            }
        }

        private void validateBonus(double bonus) throws InvalidSalaryException{

            if(bonus < 0){
                throw new InvalidSalaryException("Bonus cannot be negative");
            }

            if(bonus > baseSalary){
              throw new InvalidSalaryException("Bonus shouldn't exceed salary");
            }
        }

        private void validateDeductions(double deductions)throws InvalidSalaryException{

            if(deductions < 0){
                throw new InvalidSalaryException("Deductions cannot be negative");
            }

            if(deductions > calculateGrossSalary()){
                throw new InvalidSalaryException("Deductions shouldn't exceed gross salary");
            }
        }

        private void validateNetSalary(double gross , double deductions)throws InvalidSalaryException{
 
            if(gross - deductions < 0){
                throw new InvalidSalaryException("Net salary cannot be negative");
            }
        }
  
    //getter methods
    public double getBaseSalary(){
        return baseSalary ;
    }

    public double getBonus(){
        return bonus;
    }

    public double getDeductions(){
        return deductions;
    }

    public double getTax(){
        return tax ;
    }

    //setter validation methods

    public void setBaseSalary(double salary) throws InvalidSalaryException{
      
        validateBaseSalary(salary) ;
        this.baseSalary = salary ;
    }

    public void setBonus(double bonus) throws InvalidSalaryException{

        validateBonus(bonus);
        this.bonus = bonus ;
    }


    public void setDeductions(double deductions)throws InvalidSalaryException{

        validateDeductions(deductions);
        this.deductions=deductions ;
    }
    //calculate methods

    public double calculateGrossSalary()throws InvalidSalaryException{
        if(baseSalary ==0 ){
            throw new InvalidSalaryException("Base salary not set");
        }
        return baseSalary + bonus ;
    }


    public double calculateTax()throws InvalidSalaryException{
        double gross =  calculateGrossSalary();
        return gross * 0.10 ;  // 10% tax

    }

    public double calculateNetSalary()throws InvalidSalaryException{
        double gross = calculateGrossSalary();
        double netSalary = gross - tax - deductions ;

        if(netSalary < 0 ){
            throw new InvalidSalaryException("Net salary cannot be negtive");
        }
        return netSalary ;
    }
}
