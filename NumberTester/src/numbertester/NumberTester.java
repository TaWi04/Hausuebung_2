/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbertester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tawimmer18
 */
public class NumberTester{

  
    /**
     * @param args the command line arguments
     */
    
    private String fileName;
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;
   
    

    public NumberTester(String fileName) {
        testFile(fileName);
    }
      public boolean testNumber(int action,int number) {//TODO
   // Scanner scanner = new Scanner(System.in,"Windows-1252");
        switch (action)
        {
            case 1:
                oddEvenTester(number);
                System.out.println("Zahl: " + number);
                
                //number =Integer.parseInt(scanner.nextLine());
                if(oddTester.testNumber(number)){
                    System.out.println("ODD");
                    return true;
                }
                else if(!oddTester.testNumber(number)){
                    System.out.println("EVEN");
                    return false;
                }
                break;
            case 2:
                 primeTester(number);
                System.out.println("Zahl: " + number);
               // number =Integer.parseInt(scanner.nextLine());
                if(primeTester.testNumber(number)){
                    System.out.println("PRIME");
                    return true;
                }else{
                    System.out.println("NO PRIME");
                    return false;
                }
               
            case 3:
                palindromeTester(number);
                 System.out.println("Zahl: " + number);
                //number =Integer.parseInt(scanner.nextLine());
                if(palindromeTester.testNumber(number)){
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
      
    public void setOddEvenTester(NumberTest oddTester){
        this.oddTester = oddTester;
    }
    public void setPrimeTester(NumberTest primeTester){
    this.primeTester = primeTester;
    }
    
    public void setPalindromeTester(NumberTest palindromeTester){
        this.palindromeTester = palindromeTester;
        
    }
    public void oddEvenTester(int number){
        oddTester = (n) -> (n%2) == 1;
        setOddEvenTester(oddTester);
       
    }
    public void primeTester(int number){
        primeTester = (n) -> {
            boolean isPrime = true;
            if(n <= 1)
            {
             isPrime = false;
             return isPrime;   
            }
            else{
                for(int i = 2; i <= n/2;i++){
                if((n % i) == 0){
                    isPrime = false;
                break;
                }
                }
                return isPrime;
            }
        };
        setPrimeTester(primeTester);

    }
    public void palindromeTester(int number){
        palindromeTester = (n) -> {
            String reversed = new StringBuilder(Integer.toString(n)).reverse().toString();
            String normal = Integer.toString(n);
           if(reversed.equalsIgnoreCase(normal))
           {
           return true;
           }
           return false;
        };
        setPalindromeTester(palindromeTester);
        //nt.testFile(fileName);
        //to string -> revers string -> to integer -> 1. == 2.
    }
    public void testFile(String fileName){
        File file = new File(fileName);
        int[][] actionPlusNumber = null;

        if (!file.canRead() || !file.isFile())
            System.exit(0);

            BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileName));
            String zeile = null;
            int numberOfActions = Integer.parseInt(in.readLine());
            actionPlusNumber = new int[numberOfActions][2];
            System.out.println("Anzahl Aktionen: " + numberOfActions);
            int i = 0;
            int j = 0;
            while ((zeile = in.readLine()) != null) {
                int[] temp = new int[numberOfActions];
                for (String splited : zeile.split(" ")) {
                    temp[j] = Integer.parseInt(splited);
                    if(j== 0){
                    j++;
                    }
                }
                j = 0;
                actionPlusNumber[i][0] = temp[j];
                j = 1;
                actionPlusNumber[i][1] = temp[j];
                System.out.println("Gelesene Zeile: " + zeile);
                i++;
                j = 0;
                
                
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }
        }
        for (int[] is : actionPlusNumber) {
                    int m = 0;
                    int action = is[m];
                    m = 1;
                    int number = is[m];
                        testNumber(action, number);
                    
                }
        List<int[]> numbersToTest = new ArrayList();
        for (int[] is : actionPlusNumber) {
            numbersToTest.add(is);
            /*for (int i : is) {
                System.out.println("number:" + i );
            }*/
        }

       
    }

    
}
