/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grieskirchen.tawimmer18;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tawimmer18
 */
public class Main {
 private static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
         list.add("Hallo");
         list.add("Wie");
         list.add("Geht");
         list.add("Es");
         list.add("Ihnen");
         
         
                 
 HalloJavamitForEach halloJava = new HalloJavamitForEach(list);
 halloJava.printForEach();
 halloJava.printWithMethodForEach();
 halloJava.printWithConsumerInterface();
    }

         
         
 
 
 
}
