/*@author Mayur T
*/

import java.util.*;

public class Scores {

    public static void main(String[] args)
                 {
    	     int[] avgscores = new int[10];
    	Scanner in = new Scanner(System.in);
    	Scanner in2 = new Scanner(System.in);
                   //finding the length of the Array studentNames
                   System.out.print("how many students?:");
                   int totalStudents = in.nextInt();
                   System.out.print("how many quizes?:");
                   int quizeno = in.nextInt();
     
         String[] studentNames = new String [totalStudents];
         int[][] quizescores = new int[totalStudents][quizeno];    
            //allows user to input student names
     
        for(int j = 0; j < studentNames.length;j++) 
        {
            System.out.println(j);
            System.out.print("enter student names:");
            studentNames[j] = in.nextLine();
        }
     
            for (String element:studentNames)
            {   
           System.out.println(element);
            }
            System.out.println("Enter the Quiz Scores of the Students");
            
            Scanner scan1 = new Scanner(System.in);
            for(int j=0; j<totalStudents; j++)
            {
            for(int k=0; k<quizeno; k++)
            {
            	quizescores[j][k] = scan1.nextInt();
            }
            }
            for(int t=0; t<totalStudents; t++)
            {
            avgscores[t] = (quizescores[t][0]+quizescores[t][1]+quizescores[t][2]+quizescores[t][3]+quizescores[t][4]) / 5;
            System.out.println("Name of the student is " + studentNames[t] + "and his average quiz score is " + avgscores[t]);
            }
                 
       }

}
