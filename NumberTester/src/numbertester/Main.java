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
    public static void main(String[] args) {
        NumberTest oddTester = (n) -> (n%2) == 1;
        NumberTest primeTester;
        NumberTest palindromeTester;
        String fileName = null;
        NumberTester nt = new NumberTester(fileName);
        nt.setOddEvenTester(oddTester = (n) -> (n%2) == 1);
        nt.testNumber(1);
    }
}
