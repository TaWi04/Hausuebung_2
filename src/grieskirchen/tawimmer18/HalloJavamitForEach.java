package grieskirchen.tawimmer18;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tawimmer18
 */
public class HalloJavamitForEach {
    private List<String> list;

    public HalloJavamitForEach(List<String> list) {
        this.list = list;
    }
    
    public void printForEach(){
        for (String string : list) {
            System.out.println(string);
        }         
    }
     public void printWithMethodforEach(){
            
        }
 
    
}
