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
public class RationalCalculator extends AbstractCalculator{

    public RationalCalculator() {
        
           
        super((x,y)->{
            Number solution = new Number();
            solution.setB(x.getB()*y.getB());
            solution.setA(x.getA()*y.getB()+y.getA()*x.getB());
            return solution;
            
        }, (x,y)->{
            Number solution = new Number();
            solution.setB(x.getB()*y.getB());
            solution.setA(x.getA()*y.getB()-y.getA()*x.getB());
            return solution;
            
        }, (x,y)->{
            Number solution = new Number();
            solution.setA(x.getA()*y.getA());
            solution.setB(x.getB()*y.getB());
            return solution;            
        }, (x,y)->{
            Number solution = new Number();
            solution.setA(x.getA()*y.getB());
            solution.setB(x.getB()*y.getA());
            return solution;
        });
    }
    
    @Override
    public Number add(Number a, Number b) {
        return add.calc(a, b);
    }

    @Override
    public Number subtract(Number a, Number b) {
        return subtract.calc(a, b);
    }

    @Override
    public Number multiply(Number a, Number b) {
        return multiply.calc(a, b);
    }

    @Override
    public Number divide(Number a, Number b) {
        return divide.calc(a, b);
    }
    
}
