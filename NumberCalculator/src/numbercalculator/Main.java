/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbercalculator;

import java.util.Scanner;

/**
 *
 * @author Tamara
 */
public class Main {
    private final static String menu = "Choose calculator :\n"
            + "1 - Rational calculator\n"
            + "2 - Vector calculator\n"
            + "3 - Complex calculator\n"
            + "4 - Exit program";
    private static Scanner scanner = new Scanner(System.in,"Windows-1252");
    private static AbstractCalculator calculator;
    
    public static void main(String[] args) {
        RationalCalculator rc = new RationalCalculator();
        ComplexCalculator cc = new ComplexCalculator();
        VectorCalculator vc = new VectorCalculator();
        
        int action =0;
        do {            
            System.out.println(menu);
            try {
                do{
                    String input = scanner.nextLine();
                    action = Integer.parseInt(input);
                    } while (action < 0 || action > 4);
                
            } catch (NumberFormatException e) {
                System.out.println("Please enter a NUMBER!");
                do {                        
                        action = Integer.parseInt(scanner.nextLine());
                    } while (action < 0 && action > 4);
            }
            
            Number x;
            Number y;
            Number result;
            switch(action){
                case 1:
                   calculator = new RationalCalculator();
                    x = setNumber('x');
                    y = setNumber('y');
                   result = chooseOperations(x, y);
                   int a_length = Double.toString(result.getA()).length();
                   int b_length = Double.toString(result.getB()).length();
                   int max = a_length;
                   if(b_length > max){
                       max = b_length;
                   }
                   
                   String breakline = "";
                    for (int i = 0; i < max; i++) {
                        breakline += "-";
                    }
                    
                   System.out.println("----------------------------------------\n"
                            + "Solution:\n"
                           +result.getA() +"\n"+breakline+"\n"+ result.getB()+"\n"
                                   + "----------------------------------------");
                    break;
                case 2:
                     calculator = new VectorCalculator();
                    x = setNumber('x');
                    y = setNumber('y');
                    result = chooseOperations(x, y);
                    System.out.println("----------------------------------------\n"
                            + "Solution:\n"
                            +"a:" + result.getA() +"\nb:" + result.getB()+"\n"
                                   + "----------------------------------------");
                    
                    break;
                case 3:
                     calculator = new ComplexCalculator();
                    x = setNumber('x');
                    y = setNumber('y');
                    result = chooseOperations(x, y);
                    System.out.println("----------------------------------------\n"
                            + "Solution:\n"
                            +result.getA() +"+" + result.getB()+"i"+"\n"
                                   + "----------------------------------------");
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        } while (action != 4);
       }
    public static Number setNumber(char var){
        Number number = new Number();
        try {
               System.out.println("Enter number "+var +" a>");
         number.setA(Double.parseDouble(scanner.nextLine()));
         System.out.println("Enter number "+var +" b>");
         number.setB(Double.parseDouble(scanner.nextLine()));
                
            } catch (NumberFormatException e) {
                System.out.println("Please enter a NUMBER!");
                setNumber(var);
            }
         
        return number;
    }
    
    public static Number chooseOperations(Number x, Number y){
        System.out.println("1 - add\n"
                + "2 - subtract\n"
                + "3 - multiply\n"
                + "4 - divide\n"
                + "5 - enter numbers again");
         int action = 0;
         try {
                do{
                    String input = scanner.nextLine();
                    action = Integer.parseInt(input);
                    } while (action < 0 || action > 5);
                
            } catch (NumberFormatException e) {
                System.out.println("Please enter a NUMBER!");
                return chooseOperations(x, y);
            }
       
        Number result = null;
        switch(action){
            case 1:
                result = calculator.add(x, y);
                break;
            case 2:
               result =  calculator.subtract(x, y);
                break;
            case 3:
               result =  calculator.multiply(x, y);
                break;
            case 4:
                result = calculator.divide(x, y);
                break;
            case 5:
                return chooseOperations(setNumber('x'),setNumber('y'));
            default:
                break;
        }
        return result;
    }
    
}
