/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbertester;

import java.util.Scanner;

/**
 *
 * @author tawimmer18
 */
public class NumberTester implements NumberTest{
@Override
    public boolean testNumber(int number) {//TODO
    Scanner scanner = new Scanner(System.in,"Windows-1252");
        switch (number)
        {
            case 1:
                System.out.println("Zahl:");
                int number1 =Integer.parseInt(scanner.nextLine());
                if(oddTester.testNumber(number1)){
                    System.out.println("ODD");
                    return true;
                }
                else if(!oddTester.testNumber(number1)){
                    System.out.println("EVEN");
                    return false;
                }
                break;
            case 2:
                System.out.println("Zahl:");
                int number2 =Integer.parseInt(scanner.nextLine());
                if(primeTester.testNumber(number2)){
                    System.out.println("PRIME");
                    return true;
                }else{
                    System.out.println("NO PRIME");
                    return false;
                }
               
            case 3:
                 System.out.println("Zahl:");
                int number3 =Integer.parseInt(scanner.nextLine());
                if(palindromeTester.testNumber(number3)){
                    System.out.println("PALINDROME");
                    return true;
                }else{
                    System.out.println("NO PALINDROME");
                    return false;
                }
                
            default:
                break;
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */
    
    private String fileName;
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;
   
    

    public NumberTester(String fileName) {
        
    }
    public void setOddEvenTester(NumberTest oddTester){
        this.oddTester = oddTester;
    }
    public void setPrimeTester(NumberTest primeTester){
    this.primeTester = primeTester;
    }
    
    public void setPalindromeTester(NumberTest palindromeTester){
        this.palindromeTester = palindromeTester;
        //to string -> revers string -> to integer -> 1. == 2.
    }
    public void testFile(){
        //TODO
    }

    
}
