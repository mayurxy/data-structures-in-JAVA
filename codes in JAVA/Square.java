/*@author Mayur T
*/

import java.util.*;

public class Square {
	double side;

	Square(double i)
	{
	side = i;  //constructor should take one parameter and set the side length to the parameter value
	}
	double getArea()
	{
	return side*side; // returns the area of the square
	}
	
	Square()
	{
	side = 1;  // one that has no parameters and sets the side length to one
	}
	
	}
