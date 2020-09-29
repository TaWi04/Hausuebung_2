package grieskirchen.tawimmer18;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
        System.out.println("method: printForEach");
        for (String string : list) {
            System.out.println(string);
        }         
    }
     public void printWithMethodForEach(){
        System.out.println("method: printWithMethodForEach");
     list.forEach((string) -> System.out.println(string));
     }
     public void printWithConsumerInterface(){
        System.out.println("method: printWithConsumerInterface");
         Consumer<String> consumer = (String string) -> System.out.println(string);
         list.forEach(consumer);
        System.out.println("method: printWithConsumerInterface");
         list.forEach(System.out::println);
     }
 
    
}
