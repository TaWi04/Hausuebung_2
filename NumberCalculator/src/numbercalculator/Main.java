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
        ComplexCalculator cc = new ComplexCalculator();
       Number a = new Number();
       a.setA(4);
       a.setB(2);
       Number b = new Number();
       b.setA(5);
       b.setB(-3);
        Number solution = cc.multiply(a, b);
        System.out.println("mult cc: " +solution.getA()+"/"+solution.getB() +"i");
        solution = cc.divide(a, b);
        System.out.println("div cc: " +solution.getA()+"/"+solution.getB() +"i");
        solution = rc.add(a, b);
        System.out.println("add: " + solution.getA()+"/"+solution.getB());
         solution = rc.subtract(a, b);
        System.out.println("sub: " + solution.getA()+"/"+solution.getB());
       solution = rc.multiply(a, b);
        System.out.println("mult: " +solution.getA()+"/"+solution.getB());
        solution = rc.divide(a, b);
        System.out.println("div: " +solution.getA()+"/"+solution.getB());
    }
}
