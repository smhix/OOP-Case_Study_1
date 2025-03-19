/*
 * COMP 009 - Object Oriented Programming
 * Case Study #1
 * 
 * 1. Intravenous Rate Assistant
 * 
 * Members:
 * Gesulga, Ryah Jovein C.
 * Harina, Sarah Mae D.C.
 * Padrique, Ferlyn C.
 * Tamparong, Liezel Joan M.
 */

 import java.util.Scanner;

 public class CS1_IRA {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         int choice;
 
         System.out.println("INTRAVENEOUS RATE ASSISTANT");
 
         do {
             choice = get_problem(input);
             switch (choice) {
                 case 1:
                     get_rate_drop_factor(input);
                     break;
                 case 2:
                     get_L_for_hr(input);
                     break;
                 case 3:
                     get_kg_rate_conc(input);
                     break;
                 case 4:
                     get_units_conc(input);
                     break;
                 case 5:
                     break;
                 default:
                     System.out.println("Invalid Choice!");
             }
         } while (choice != 5);
     }
 
     public static int get_problem(Scanner input) {
 
         System.out.println("\nEnter the number of the problem you wish to solve. ");
         System.out.println("\tGIVEN A MEDICAL ORDER IN\t\t     CALCULATE RATE IN");
         System.out.println("(1)\tml/hr & tubing drop factor\t\t\tdrops / min");
         System.out.println("(2)\t1 L for n hr\t\t\t\t\tml / hr");
         System.out.println("(3)\tmg/kg/hr & concentration in mg/ml\t\tml / hr");
         System.out.println("(4)\tunits/hr & concetration in units/ml\t\tml / hr");
         System.out.println("(5)\tQUIT");
 
         System.out.print("PROBLEM => ");
         return input.nextInt();
     }
 
     public static void get_rate_drop_factor(Scanner input){
         System.out.print("Enter rate in ml/hr => ");
         float rate1 = input.nextFloat();
 
         System.out.print("Enter tubing's drop factor (drops/ml) => ");
         float dropFactor = input.nextFloat();
 
         double fDropMin = fig_drops_min(rate1, dropFactor);
         System.out.println("The drop rate per minute is " + fDropMin + ".");
     }
 
     public static void get_L_for_hr(Scanner input){
         System.out.print("Enter number of hours => ");
         int noHrs = input.nextInt();
 
         int fMlHr= fig_ml_hr(noHrs);
         System.out.println("The rate in milliliters per hour is " + fMlHr + ".");
     }
 
     public static void get_kg_rate_conc(Scanner input){
         System.out.print("Enter rate in mg/kg/hr => ");
         float rate2 = input.nextFloat();
 
         System.out.print("Enter patient weight in kg => ");
         float weight = input.nextFloat();
 
         System.out.print("Enter concentration in mg/ml => ");
         float con1 =  input.nextFloat();
 
         double byWeight = by_weight(rate2, weight, con1);
         System.out.println("The rate in milliliters per hour is " + byWeight + ".");
     }
 
     public static void get_units_conc(Scanner  input){
         System.out.print("Enter rate in units/hr => ");
         float rate3 = input.nextFloat();
 
         System.out.print("Enter concentration in units/ml => ");
         float con2 = input.nextFloat();
 
         double byUnits = by_units(rate3, con2);
         System.out.println("The rate in milliliters per hour is " + byUnits + ".");
     }
 
     public static double fig_drops_min(double rate, double dropFactor){
         double dropMin = rate * dropFactor / 60;
         return Math.round(dropMin);
     }
 
     public static int fig_ml_hr(int hours){
         int mlHr = 1000 / hours;
         return Math.round(mlHr);
     }
 
     public static double by_weight(double rate, double weight, double con){
         double byWgt = rate * weight / con;
         return Math.round(byWgt);
     }
 
     public static double by_units(double rate, double con){
         double byUni = rate / con;
         return Math.round(byUni);
     }
 }