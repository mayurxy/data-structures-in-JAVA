// Ozbirn, 10/16/2015
// Example of poor-performing algorithm.
// Reports duplicates, but the same duplicate may be reported more than once.

import java.util.Scanner;
import java.util.LinkedList;
import java.io.File;

public class DupLL
{
   public static void main(String args[])
   {
   long startTime = System.currentTimeMillis();
      try 
      {
         Scanner sc = new Scanner(new File("C:\\Users\\mayur\\Documents\\MayurTjava\\bin\\ph.txt"));
         LinkedList<String> list = new LinkedList<>();

	 while (sc.hasNext())
	 {
	    String ph = sc.nextLine();
	    list.add(ph);
         }

	 for (int i=0; i<list.size(); i++)
	    for (int j=0; j<list.size(); j++)
               if (i != j)
	       {
	          String one = list.get(i);
	          String two = list.get(j);
	          if (one.equals(two))
		     System.out.println(list.get(i) + " is a duplicate");
               }
      }
      catch (Exception e)
      {
          System.out.println("Exception " + e);
	  System.exit(1);
      }
   
long endTime   = System.currentTimeMillis();
long totalTime = endTime - startTime;
System.out.println(totalTime);
   }
}
