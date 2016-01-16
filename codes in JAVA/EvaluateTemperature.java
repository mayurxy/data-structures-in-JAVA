/*@author Mayur T
*/

import java.util.*;
public class EvaluateTemperature {

	 public static void main(String args[])
	 {
		 Scanner scan1 = new Scanner(System.in); 
		 double finaltemp; 
		 System.out.print("Enter the temperature: "); 
		 double temps = scan1.nextDouble(); 

		 System.out.println("Celsius or Fahrenheight (C or F): "); 
		 Scanner sca = new Scanner(System.in);
		 char ch=sca.next().charAt(0); 
		 //System.out.println(ch);
			
		 if (ch == 'C'|| ch == 'c') { 
			// convert C to F 
			temps = (temps * 9/5) +32; 
		
		 }
			finaltemp = temps; 
			System.out.println(finaltemp);
			/* < 0   Extremely cold
		    0-32   Very cold
		    33-50  Cold
		    51-70  Mild
		    71-90  Warm
		    91-100 Hot
		    > 100  Very hot */
			
			if (finaltemp < 0)
			{
				System.out.println("Temperature is Extremely cold ");
			}
			else if (finaltemp >= 0 && finaltemp <= 32)
			{
				System.out.println("Temperature is Very cold ");
			}
			else if (finaltemp >= 33 && finaltemp <= 50)
			{
				System.out.println(" Temperature is cold ");
			}
			else if (finaltemp >= 51 && finaltemp <=70)
			{
				System.out.println("Temperature is Mild ");
			}
			else if (finaltemp >= 71 && finaltemp <= 90)
			{
				System.out.println("Temperature is Warm ");
			}
			else if (finaltemp >= 91 && finaltemp < 100)
			{
				System.out.println("Temperature is Hot ");
			}
			else if (finaltemp >= 100)
			{
				System.out.println("Temperature is Very Hot ");
			}
	 }
	
	
}
