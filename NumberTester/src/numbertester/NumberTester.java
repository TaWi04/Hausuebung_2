/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbertester;

/**
 *
 * @author tawimmer18
 */
public class NumberTester implements NumberTest{

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

    @Override
    public boolean testNumber(int number) {//TODO
        return false;}
}
