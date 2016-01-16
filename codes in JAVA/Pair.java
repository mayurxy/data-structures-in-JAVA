import java.util.*;
class Pair<T>
{
   T ob1;
   T ob2;

   Pair()
   {
      System.out.println("This is the default constructor");
   }

   T getob1()
   {
      //System.out.println(ob1);
      return ob1;
   }

   T getob2()
   {
      //System.out.println(ob2);
      return ob2;
   }

   void setob(T o1 , T o2)
   {
      ob1 = o1;
      ob2 = o2;
   }
}

class PairTest
{
   public static void main(String args[])
   {
      Pair<String> obj;
      obj = new Pair<String>();
      String a1, a2, a3, a4;
      Scanner s = new Scanner(System.in);
      System.out.println("Enter the Strings");
      a1 = s.nextLine();
      a2 = s.nextLine();
      obj.setob(a1 , a2);
      System.out.println("The entered values are");
      a3 = obj.getob1();
      a4 = obj.getob2();
      System.out.println(a3);
      System.out.println(a4);
   }
}