import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class mtproject2


{
   private Node head;
   private Node end;
         

private static class Node
{
   int data;
   Node next;
   Node prev;
   
   Node (int d, Node n, Node p)
   {
      data = d;
      next = n;
      prev = p;
   }
}

public int sizeof() // function for finding the length of LL
   {
      int n=0;
          Node temp;   //temporary node tot raverse through LL
          
          temp = head;  // starting from head
          
          while (temp != null) 
            {
                n++;            // counting increases
                temp = temp.next;
             }
          return n;     
    }
   

public void final_add(int element)
   {
// tried using bubble sort after adding the new node  but didnot worked so checked manually
      Node n;
      Node temp_node;
      temp_node = head;
      
      if(head == null)
      {
         n = new Node (element , null , null);
         head = n;
         end = n;
      }
      
      else if(head == end)
      {
         if(element <= head.data)
         {  
            n = new Node (element , temp_node , temp_node.prev);
            temp_node.prev = n;
            head = n;
          }
          else
          {
            n = new Node (element , temp_node.next , temp_node);
            temp_node.next = n;
            end = n;
          } 
      }
              
      else if(head != end)
      {
         if(element <= head.data)
         {
                  n = new Node(element , temp_node , temp_node.prev);
                  temp_node.prev = n;
                  head = n;
         }
         else if(element > end.data)
         {
                  n = new Node(element , end.next , end);
                  end.next = n;
                  end = n;
         }
         else
         {
            while(temp_node != null)
            {
                  if(element <= temp_node.data)
                  {
                     n = new Node(element , temp_node , temp_node.prev);
                     temp_node.prev.next = n;
                     temp_node.prev = n;
                  }
                  temp_node = temp_node.next;
               } 
         }  
            
      }
   }   
      
      
public String toString()
      {
         StringBuilder sb = new StringBuilder();
      
         sb.append("[ ");
      
         Node p = head;
         
         while (p != null)
         {
            sb.append(p.data + " ");
            p = p.next;
         }
            
         sb.append("]");
      
         return new String(sb);
   
      }
// function for list printing
     
public void printList()
      {
         Node temp;
         
         temp = head;
         
         while (temp != null)
          {
           System.out.print(temp.data+ " " );
           temp = temp.next;
          }
          System.out.println();
          System.out.println();
       }
       
// function for adding element to respective list                   
public static void add_list(mtproject2 list1, mtproject2 list2, mtproject2 list3, int element)
      {
         int s1,s2,s3,res;
         
         s1 = list1.sizeof();
         s2 = list2.sizeof();
         s3 = list3.sizeof();
         
         res = find_small(s1,s2,s3);
        
         if(res == s1)              
         {
            list1.final_add(element);
            //list1.bubbleSort();
            System.out.println("Added" + " " + element + " " + "to L1");
         }
         else if(res == s2)
         {
            list2.final_add(element);
            //list2.bubbleSort();
            System.out.println("Added" + " " + element + " " + "to L2");
         }
         else if(res == s3)
         {
            list3.final_add(element);
           //list2.bubbleSort();
            System.out.println("Added" + " " + element + " " + "to L3");
         }
      }
      
public static int find_small(int num1 , int num2 , int num3)
      {  
      int small_num;
      small_num = (num1 < num2) ?( (num1<num3) ? num1:num3):(num2<num3?num2:num3);
		return small_num;
            
      }     
public void bubbleSort()
      {
         boolean flag;
         Node last, temp;                           // int last;
         
         flag = true;
         last = end;                                  // last = length of list - 2;
         
         while (flag) {
            flag = false;             
            temp = head;
            while (temp != last)  {                      //for (int i = 0;i<= last;i++) {
               if (temp.data > temp.next.data) {        //    if (x[i]>x[i+1]) {
                   swap(temp,temp.next);                //       swap(i,i+1);
                   flag = true;
                }
               temp=temp.next;
              }
            last = last.prev;                           //    last--;
          } 
      }
      
public void swap(Node x, Node y)
      {
          int temp;
          
          temp   =   x.data;
          x.data = y.data;
          y.data = temp;
       }
                           
      
public void deleteitem(int element)
      {
         Node temp;            // ref:http://web.cse.ohio-state.edu/~reeves/CSE2421sp13/lab3linklistCOD
         temp = head;
         while(temp != null) // while LL is not empty 
         {
            if(element == temp.data)
            {
               if(temp == head)    // deleting the first node
               {
                  head = head.next;  
                  temp.next.prev = null;
                  temp.next = null;
                            
                }
               
               else if(end == temp)    // is it end
               {
                  temp.prev.next = null;
                  end = temp.prev;
                  temp.prev = null;
                   
               }
               else          // if not first then
               {
               //while(head.next != temp)
                //{
                  temp.prev.next = temp.next;
                  temp.next.prev = temp.prev;
                  temp.next = null;
                  temp.prev = null;
                //}  
               }
            }
            temp = temp.next;               // traversing through the LL by pointing to next ref
         }
      }
      
public boolean findingelement(int element)
      {
        // int flag;
         Node temp_node;
         temp_node = head;
         while(temp_node != null)
         {
            if(element == temp_node.data)
            {
              // flag = 1;
            return true;
            }
            temp_node = temp_node.next;
         }
         //flag = 0;           // when flag was used last element was remained in list but using boolean all instances were removed
         return false;
      }
    
public static void cancel(mtproject2 list1, mtproject2 list2, mtproject2 list3, int element)
      {  
         if(list1.findingelement(element)== true)
         {
            list1.deleteitem(element);
         }
         else if(list2.findingelement(element)== true)
         {
            list2.deleteitem(element);
            
         }
         else if(list3.findingelement(element)== true)
         {
            list3.deleteitem(element);
          
         }
      }
      
public int checkforfirst()
      {
         Node temp;
         temp = head;
         if(head != null)
         {
            return temp.data;
         }
         return 0;
      }
      
public void deletingfirst()
      {
         Node temp;
         temp = head;
         if(head == end)
         {
            end = null;
            head = null;
           
         } 
         else if (head != end)
         {
            head = temp.next;
            temp.next.prev = null;
            temp.next = null;
            temp.prev = null;
         }
      }
public static void remove(mtproject2 list1, mtproject2 list2, mtproject2 list3)
      {
         int a , b , c , d;
         
         a = list1.checkforfirst();
         b = list2.checkforfirst();
         c = list3.checkforfirst();         
         d = LLdetermination(a , b , c);
         if(d == 1)
         {
            list1.deletingfirst();
            System.out.println("Removed" + " " + a);
         }
         else if(d == 2)
         {
            list2.deletingfirst();
            System.out.println("Removed" + " " + b);

         }
         else if(d == 3)
         {
            list3.deletingfirst();
            System.out.println("Removed" + " " + c);

         }
         else
         {
            System.out.println("Remove called on empty lists");
         }
      }

      
public static int LLdetermination(int m , int n , int t)
      {  
/*

 if(x == 0 && y == 0 && z == 0)
return 0;

else if (x == 0 && y == 0 && z != 0) 
return 3;

else if (x == 0 && y != 0 && z == 0) 
return 2;

else if (x == 0 && y != 0 && z != 0) 
     
{
if(y <= z)
                        return 2;
                     else
                        return 3;

}
else if (x != 0 && y == 0 && z == 0) 
return 1;
else if (x != 0 && y != 0 && z != 0) 
{
                     if(x <= z)
                        return 1;
                     else
                        return 3;
}

else if (x != 0 && y != 0 ) 
{
                  if(x <= y)
                     return 1;
                  else
                     return 2;

*/     
// refered code from other as same logic was not working for above
                 
         if(m == 0|| n == 0|| t == 0)
         {
            if(m == 0)
            {
               if(n == 0)
               {
                  if(t == 0)     //(m == 0 && n == 0 && t == 0)
                     return (0);
                  else
                     return 3;
               }
               else
               {
                  if(t ==0)      // if(m == 0 && n != 0 && t == 0)
                  {
                     return 2; //select list2
                  }
                  else
                  {
                     if(n <= t)  
                        return 2;
                     else
                        return 3;
                  }
               }
            }
            else
            {
               if(n == 0)
               {
                  if(t == 0)
                     return 1;
                  else
                  {
                     if(m <= t)
                        return 1;
                     else
                        return 3;
                  }
               }
               else
               {
                  if(m <= n)
                     return 1;
                  else
                     return 2;
               }
            }
         }
         else
         {
         if(m==n && n==t)
         {  
            return 1;
         }
         else
         {
            if(m<n)
            {
               if(m<=t)
                {
                  return 1;
                }
               else
               {
                  return 3;
               }
            } 
            else if(m == n && (m <= t)) // adjusting priorities
            {
               if(m <= t)      // m preference
               {
                  return 1;
               }
               else
               {
                  return 3;
               }
            }
            else
            {
               if(n<=t)        // n reference
               {
                  return 2;
               }
               else
               {
                  return 2;
               }
            }
         }
         }      
             
   }  

public static void main(String args[])
{
mtproject2 list1 = new mtproject2();
mtproject2 list2 = new mtproject2();
mtproject2 list3 = new mtproject2();


String str = null;   // for reading element from file
int list_value = 0;

try 
{
	Scanner sc = new Scanner(new File("project2input.txt"));	// input file	
	while (sc.hasNext()) 
   {
      String line = sc.nextLine();			   
		String str1[] = line.split(" "); // ref: http://www.scit.wlv.ac.uk/~in8297/CP4044/workshops/w03.html
		str = str1[0];
		           
		if(str1.length > 1)
		  list_value   = Integer.parseInt(str1[1]);
		
      if(str.equals("A")||str.equals("a"))   // made generalised
      {  
         add_list(list1 , list2 , list3, list_value);
      }
      else if(str.equals("C")||str.equals("c"))
      {
         cancel(list1 , list2 , list3, list_value);
         System.out.println("Deleted" + " " + list_value);
      }
      else if(str.equals("R")||str.equals("r"))
      {
         remove(list1 , list2 , list3);
      }
      else if(str.equals("P")||str.equals("p"))
      {  
         System.out.println(list1);
         //list1.printList();
         System.out.println(list2);
         //list2.printList();
         System.out.println(list3);
         //list3.printList();
      
      }
  	}
   
}
catch(Exception e ) 
     {                  
        System.out.println("IO error");
        System.exit(1);
 
     }

  }


}


