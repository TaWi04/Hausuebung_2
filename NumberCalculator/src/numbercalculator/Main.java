/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbercalculator;

/**
 *
 * @author Tamara
 */
public class Main {
    public static void main(String[] args) {
        RationalCalculator rc = new RationalCalculator();
       Number a = new Number();
       a.setA(1);
       a.setB(5);
       Number b = new Number();
       b.setA(1);
       b.setB(5);
       Number solution = rc.add(a, b);
        System.out.println("add: " + solution.getA()+"/"+solution.getB());
         solution = rc.subtract(a, b);
        System.out.println("sub: " + solution.getA()+"/"+solution.getB());
       solution = rc.multiply(a, b);
        System.out.println("mult: " +solution.getA()+"/"+solution.getB());
        solution = rc.divide(a, b);
        System.out.println("div: " +solution.getA()+"/"+solution.getB());
    }
}
