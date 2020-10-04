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
public class Main {
    public static String fileName = "File.txt";
    public static void main(String[] args) {
        NumberTester nt = new NumberTester(fileName);
       nt.testFile(fileName);
       // oddEvenTester(nt);
       //palindromeTester(nt);
       // nt.testFile(fileName);
       
    }
    
    
}
