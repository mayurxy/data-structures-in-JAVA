/*@author Mayur T
*/

public class MyFour<T> {
    private T item1;
    private T item2;
    private T item3;
    private T item4;

    public MyFour(T item1, T item2, T item3, T item4) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
    }
    
    public boolean allEquals() {
        T checkValue = item1;
        return ((item1.equals(item2))&&(item1.equals(item3))&&(item1.equals(item4)));
    }
    
    public void shiftLeft() {
        T temp = item1;
        item1 = item2;
        item2 = item3;
        item3 = item4;
        item4 = temp;
    }

    public String toString() {
        return ("(" + item1 + ", " + item2 + ", " + item3 + ", " + item4 + ')');
    }
    
    public static void main(String[] args) {
        MyFour<String> objectString = new MyFour<String>("Hello1", "Hello2", "Hello3", "Hello4");
        
        System.out.println("String object:\t" + objectString.toString());
        
        System.out.println("String object allEquals:\t" + objectString.allEquals());
        
        MyFour<Integer> objectInteger = new MyFour<Integer>(1, 3, 5, 7);
        
        System.out.println("Integer object:\t" + objectInteger.toString());
        System.out.println("Integer object allEquals:\t" + objectInteger.allEquals());
        
        objectInteger.shiftLeft();
        System.out.println("Integer object:\t" + objectInteger.toString());
        
    }
    
    
}
