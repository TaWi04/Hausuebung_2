/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbertester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author tawimmer18
 */
public class NumberTester {

    /**
     * @param args the command line arguments
     */
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;

    public NumberTester(String fileName) {
        testFile(fileName);
    }

    public boolean testNumber(int action, int number, String error) {
        if (error != null && error.contains("ERROR")) {
            System.out.println(error);
        } else {
            if (error != null && error.contains("WARNING")) {
                System.out.println(error);
            }
            switch (action) {
                case 1:
                    oddEvenTester(number);
                    System.out.println("Zahl: " + number);
                    if (oddTester.testNumber(number)) {
                        System.out.println("ODD");
                        return true;
                    } else if (!oddTester.testNumber(number)) {
                        System.out.println("EVEN");
                        return false;
                    }
                    break;
                case 2:
                    primeTester(number);
                    System.out.println("Zahl: " + number);
                    if (primeTester.testNumber(number)) {
                        System.out.println("PRIME");
                        return true;
                    } else {
                        System.out.println("NO PRIME");
                        return false;
                    }

                case 3:
                    palindromeTester(number);
                    System.out.println("Zahl: " + number);
                    if (palindromeTester.testNumber(number)) {
                        System.out.println("PALINDROME");
                        return true;
                    } else {
                        System.out.println("NO PALINDROME");
                        return false;
                    }

                default:
                    break;
            }
        }
        return false;
    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }

    public void oddEvenTester(int number) {
        oddTester = (n) -> (n % 2) == 1;
        setOddEvenTester(oddTester);
    }

    public void primeTester(int number) {
        primeTester = (n) -> {
            boolean isPrime = true;
            if (n <= 1) {
                isPrime = false;
                return isPrime;
            } else {
                for (int i = 2; i <= n / 2; i++) {
                    if ((n % i) == 0) {
                        isPrime = false;
                        break;
                    }
                }
                return isPrime;
            }
        };
        setPrimeTester(primeTester);
    }

    public void palindromeTester(int number) {
        palindromeTester = (n) -> {
            String reversed = new StringBuilder(Integer.toString(n)).reverse().toString();
            String normal = Integer.toString(n);
            return reversed.equalsIgnoreCase(normal);
        };
        setPalindromeTester(palindromeTester);
    }

    public void testFile(String fileName) {

        File file = new File(fileName);
        int[][] actionPlusNumber = null;

        if (!file.canRead() || !file.isFile()) {
            System.exit(0);
        }

        BufferedReader input = null;
        //BufferedReader linesCount = null;
        try {
            input = new BufferedReader(new FileReader(fileName));
            //linesCount = new BufferedReader(new FileReader(fileName));
            String zeile = null;
            int numberOfActions = Integer.parseInt(input.readLine());
            actionPlusNumber = new int[numberOfActions][2];
            System.out.println("Anzahl Aktionen: " + numberOfActions);
            String[] errors = new String[numberOfActions];
            int error = 0;
            //int count = 0;

//            while ((zeile = linesCount.readLine()) != null) {
//                count++; 
//            }
            zeile = null;
            //if (count - 1 == numberOfActions) {
            int index1 = 0;
            int index2 = 0;

            for (int i = 0; i < numberOfActions; i++) {
                if ((zeile = input.readLine()) != null) {
                    int[] temp = new int[numberOfActions];
                    for (String splited : zeile.split(" ")) {
                        if (index2 <= 1) {
                            try {
                                temp[index2] = Integer.parseInt(splited);
                            } catch (NumberFormatException e) {
                                errors[i] = "\u001B[31m" + "ERROR" + "\u001B[0m" + " in line  " + (i + 1) + ": Incorrect arguments";
                                error += 1;
                            }
                        } else if (zeile.trim().equals("") || zeile == null) {
                            errors[i] = "\u001B[33m" + "WARNING" + "\u001B[0m" + " in line  " + (i + 1) + ": Incorrect arguments";
                            error += 1;
                        } else {
                            errors[i] = "\u001B[33m" + "WARNING" + "\u001B[0m" + " in line  " + (i + 1) + ": Too many arguments";
                            error += 1;
                        }
                        if (index2 <= 1) {
                            index2++;
                        }
                    }
                    index2 = 0;
                    actionPlusNumber[index1][0] = temp[index2];
                    index2 = 1;
                    actionPlusNumber[index1][1] = temp[index2];
                    System.out.println("Gelesene Zeile: " + zeile);
                    index1++;
                    index2 = 0;
                } else {
                    errors[i] = "\u001B[31m" + "ERROR" + "\u001B[0m" + " in line  " + (i + 1) + ": Line doesn't exist";
                    error += 1;
                }

            }
            int temp = 0;
            for (int[] is : actionPlusNumber) {

                // for (int i = 0; i < is.length; i++) {
                int m = 0;
                int action = is[m];
                m = 1;
                int number = is[m];
                testNumber(action, number, errors[temp]);
                temp += 1;// }
            }
            /*for (String error1 : errors) {
                if (error1 != null) {
                    System.out.println(error1);
                }
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                }
            }
        }

    }

}
