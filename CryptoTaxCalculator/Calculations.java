// https://www.javatpoint.com/how-to-read-csv-file-in-java
import java.io.*;  
import java.util.Scanner;  
// end 

public class Calculations
{
    // instance variables - replace the example below with your own
    public static float capitalGain(float amount, float buy, float sell){
        float awnser = (sell * amount) - (buy*amount);
        return awnser;
    }
    
    public static float shortTaxMatrix (float income) {
        double[][] array = new double[4][7];
        System.out.println(" How are you filing your taxes: individuals(0) married filing Joint(1) For Heads Of Households(2) INTEGERS ONLY");
        Scanner sc = new Scanner(System.in);    
          boolean findingLength = true;
          String filing = " ";
          boolean Lterm = true;
          int x = 0;
         while (findingLength == true)
           {
               filing = sc.nextLine();
               if(filing.substring(0,1).equalsIgnoreCase("0")){
                   findingLength = false;
                   Lterm = true;
                   x = 1;
               }
               else if (filing.substring(0,1).equalsIgnoreCase("1")){
                   findingLength = false;
                   Lterm = false;  
                   x = 2;
               }
                else if (filing.substring(0,1).equalsIgnoreCase("2")){
                   findingLength = false;
                   Lterm = false;  
                   //https://www.javatpoint.com/java-integer-parseint-method
                   x = 3;
               }
               else {
                 System.out.println("input error{ try again }: ");  
               }
           }
           
        System.out.println("What is your yearly income (NUMBERS ONLY)");
        float yearlyIncome = sc.nextFloat();
        
        //rate
        array[0][0] = 0.10; 
        array[0][1] = 0.12;
        array[0][2] = 0.22;
        array[0][3] = 0.24;
        array[0][4] = 0.32;
        array[0][5] = 0.35;
        array[0][6] = 0.37;
        
        array[1][0] = 0; 
        array[1][1] = 9951;
        array[1][2] = 40526;
        array[1][3] = 86376;
        array[1][4] = 164926;
        array[1][5] = 209426;
        array[1][6] = 628301;
        
        array[2][0] = 0; 
        array[2][1] = 19901;
        array[2][2] = 81051;
        array[2][3] = 172751;
        array[2][4] = 329851;
        array[2][5] = 418851;
        array[2][6] = 628301;
        
        array[3][0] = 0; 
        array[3][1] = 14201;
        array[3][2] = 54201;
        array[3][3] = 86351;
        array[3][4] = 164901;
        array[3][5] = 209401;
        array[3][6] = 523601;
        
        int i = 6;
     
        while(array[x][i] >= yearlyIncome){   
            i--;
        }
        return ((float)array[0][i]);
        
    }

    public static float longTaxMatrix (float income) {
        double[][] array = new double[4][7];
        System.out.println(" How are you filing your taxes: individuals(0) married filing Joint(1) For Heads Of Households(2) INTEGERS ONLY");
        Scanner sc = new Scanner(System.in);    
          boolean findingLength = true;
          String filing = " ";
          boolean Lterm = true;
          int x = 0;
         while (findingLength == true)
           {
               filing = sc.nextLine();
               if(filing.substring(0,1).equalsIgnoreCase("0")){
                   findingLength = false;
                   Lterm = true;
                   x = 1;
               }
               else if (filing.substring(0,1).equalsIgnoreCase("1")){
                   findingLength = false;
                   Lterm = false;  
                   x = 2;
               }
                else if (filing.substring(0,1).equalsIgnoreCase("2")){
                   findingLength = false;
                   Lterm = false;  
                   //https://www.javatpoint.com/java-integer-parseint-method
                   x = 3;
               }
               else {
                 System.out.println("input error{ try again }: ");  
               }
           }
           
        System.out.println("What is your yearly income (NUMBERS ONLY)");
        float yearlyIncome = sc.nextFloat();
        
        //rate
        array[0][0] = 0; 
        array[0][1] = 0.15;
        array[0][2] = 0.20;
        
        array[1][0] = 0; 
        array[1][1] = 40000;
        array[1][2] = 441450;
        
        array[2][0] = 0; 
        array[2][1] = 80000;
        array[2][2] = 496600;
        
        array[3][0] = 0; 
        array[3][1] = 53600;
        array[3][2] = 469050;
        
        int i = 2;
        while(array[x][i] >= yearlyIncome){   
            i--;
        }
        return ((float)array[0][i]);
    }
}