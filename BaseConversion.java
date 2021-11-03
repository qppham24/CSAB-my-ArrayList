// ******************************************************************
// BaseConversion.java
// Student Name: Phuong Pham
//
// Recursively converts an integer from base 10 to another base
// ******************************************************************
import java.util.Scanner;
public class BaseConversion
{
   public static void main( String[] args )
   {
      int base10Num;
      int base;
      Scanner scan = new Scanner( System.in );
      System.out.println();
      System.out.println( "Base Conversion Program" );
      System.out.print( "Enter an integer: " );
      base10Num = scan.nextInt();
      System.out.print( "Enter the base: " );
      base = scan.nextInt();
   // Call convert and print the answer
      System.out.println(convert(base10Num, base));
   }
 
 // --------------------------------------------------
 // Converts a base 10 number to another base.
 // --------------------------------------------------
   public static String convert( int num, int b )
   {
      if (num==0)
         return "";
      else
         return convert(num/b, b) + digitToString(num%b);
   }
 
 // --------------------------------------------------
 // TODO: Take in an int and convert it to it's
 // hexadecimal representation. Remember 10 == "A", 11 == "B"
 // etc... once you fill this out, use it in convert()
   public static String digitToString( int iVal )
   {
      if (iVal<10)
         return ""+iVal;
      else if (iVal==10)
         return "A";
      else if (iVal==11)
         return "B";
      else if (iVal==12)
         return "C";
      else if (iVal==13)
         return "D";
      else if (iVal==14)
         return "E";
      else if (iVal==15)
         return "F";
      else return "";
   }
}