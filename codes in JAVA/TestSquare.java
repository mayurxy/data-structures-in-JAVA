/*@author Mayur T
*/

import java.util.*;

class TestSquare
{
	 public static void main(String[] args)
{
double area, i, area2;
Square square1 = new Square(); // creating new square
area = square1.getArea();
System.out.println("The area of the default constructor is" + area);
Scanner scan1 = new Scanner(System.in); // take input from user
System.out.println("Enter the length of one side of the square");
i = scan1.nextInt(); 
Square square2 = new Square(i); // creating new square
area2 = square2.getArea();
System.out.println("The area of the Parameterized Constructor is" + area2);
}
}