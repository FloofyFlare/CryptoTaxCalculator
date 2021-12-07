package CryptoTaxCalculator9;

import java.util.Scanner;

public class PersonalInfo
{
    static Scanner sc = new Scanner(System.in);
    static Calculations calc = new Calculations();
    
    public static void main (String args [])
    {
           System.out.println("Welcome to the Crypto Tax: Capital Gain Calculator");
           boolean longTerm = isLongTerm();
           float income = capitalGains();
           taxBracket(longTerm , income);
           System.out.println("Have you paid your taxes yet");
           
            boolean findingLength = true; 
            String yORn = " ";
           while (findingLength == true)
           {
               yORn = sc.nextLine();
               if(yORn.substring(0,1).equalsIgnoreCase("y")){
                   findingLength = false;
                   
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
        //I use float because it uses less memory as compared to double 
        System.out.println("Please input the asset amount");
        float assetAmount = sc.nextFloat();
        System.out.println("Please input the price bought at (including network fee's)");
        float priceInt = sc.nextFloat();
        System.out.println("Please input the price sold at");
        float pricePost = sc.nextFloat();
        float gain = calc.capitalGain(assetAmount, priceInt, pricePost);
        System.out.println("capital gain $" + gain);
        return gain;
    } 
    public static boolean isLongTerm () {
        boolean findingLength = true; 
        boolean Lterm = false;
        System.out.println("Was the asset held longer than 1 year (y/n):");
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
