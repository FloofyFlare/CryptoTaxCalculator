import java.util.Scanner;
//https://www.geeksforgeeks.org/how-to-set-precision-for-double-values-in-java/
import java.io.*;
import java.lang.*;

public class PersonalInfo
{
    static Scanner sc = new Scanner(System.in);
    static Calculations calc = new Calculations();
    
    public static void main (String args [])
    {
        
           System.out.println("Welcome to the Crypto Tax: Capital Gain Calculator");
           float income = capitalGains();
            if (income < 0){
               System.out.println("You do not need to pat tax on a loss");
               System.exit(0);
            }
           taxBracket(isLongTerm(), income);
           System.out.println("Have you paid your taxes yet");
           boolean findingLength = true; 
           String yORn = " ";
           while (findingLength == true)
           {
               yORn = sc.nextLine();
               if(yORn.substring(0,1).equalsIgnoreCase("y")){
                   findingLength = false;
                   System.out.println("good");
               }
               else if (yORn.substring(0,1).equalsIgnoreCase("n")){
                   System.out.println("The IRS will be there tomorrow");
                   findingLength = false;  
               }
               else {
                 System.out.println("input error{ try again }: ");  
               }
           }
           
    }
    public static float capitalGains ()
    {
        //Issue one no error handle for non floats  
        System.out.print("Please input the asset amount:");
        float assetAmount = 0;
        System.out.println();
        try{ assetAmount = sc.nextFloat();} catch(Exception e){System.out.println("error: Not a number");}
        System.out.print("Please input the price bought at (including network fee's):");
        float priceInt = 0;
        System.out.println();
        try{ priceInt = sc.nextFloat();} catch(Exception e){System.out.println("error: Not a number");}
        System.out.print("Please input the price sold at:");
        float pricePost = 0;
        System.out.println();
        try{ pricePost = sc.nextFloat();} catch(Exception e){System.out.println("error: Not a number");}
        float gain = calc.capitalGain(assetAmount, priceInt, pricePost);
        //makes the float display in money decimals
        //https://www.geeksforgeeks.org/how-to-set-precision-for-double-values-in-java/
        System.out.println("capital gain $" + (String.format("%.2f", gain)));
        return gain;
        }
    public static boolean isLongTerm () {
        boolean findingLength = true; 
        boolean Lterm = false;
        System.out.println("Was the asset held longer than 1 year (y/n):");
        sc.nextLine();
            String yORn = " ";
        while (findingLength == true)
           {
               yORn = sc.nextLine();
               if(yORn.substring(0,1).equalsIgnoreCase("y")){
                   findingLength = false;
                   Lterm = true;
               }
               else if (yORn.substring(0,1).equalsIgnoreCase("n")){
                   findingLength = false;
                   Lterm = false;  
               }
               else {
                 System.out.println("input error{ try again }: ");  
               }
           }
        return Lterm;
    }
    public static void taxBracket (boolean isLong, float cashEarned){
        if (isLong){
        System.out.println("Your tax owed " + (cashEarned * (calc.longTaxMatrix(cashEarned))));
        }
        else{
        System.out.println("Your tax owed " + (cashEarned * (calc.shortTaxMatrix(cashEarned))));
        }
    }
}
