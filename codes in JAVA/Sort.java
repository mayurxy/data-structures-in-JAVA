import java.util.*;
import java.util.Arrays;
import java.util.Random;


/**
 * A class that contains several sorting routines,
 * implemented as static methods.
 * Arrays are rearranged with smallest item first,
 * using compareTo.
 * @author Mayur Talole
 special thanks to Mark Allen Weiss
 */
public final class Sort
{
    /**
     * Simple insertion sort.
     * @param a an array of Comparable items.
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void insertionSort( AnyType [ ] a )
    {
        int j;

        for( int p = 1; p < a.length; p++ )
        {
            AnyType tmp = a[ p ];
            for( j = p; j > 0 && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }

    /**
     * Shellsort, using Shell's (poor) increments.
     * @param a an array of Comparable items.
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void shellsort( AnyType [ ] a )
    {
        int j;

        for( int gap = a.length / 2; gap > 0; gap /= 2 )
            for( int i = gap; i < a.length; i++ )
            {
                AnyType tmp = a[ i ];
                for( j = i; j >= gap &&
                            tmp.compareTo( a[ j - gap ] ) < 0; j -= gap )
                    a[ j ] = a[ j - gap ];
                a[ j ] = tmp;
            }
    }


    /**
     * Internal method for heapsort.
     * @param i the index of an item in the heap.
     * @return the index of the left child.
     */
    private static int leftChild( int i )
    {
        return 2 * i + 1;
    }
    
    /**
     * Internal method for heapsort that is used in deleteMax and buildHeap.
     * @param a an array of Comparable items.
     * @index i the position from which to percolate down.
     * @int n the logical size of the binary heap.
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void percDown( AnyType [ ] a, int i, int n )
    {
        int child;
        AnyType tmp;

        for( tmp = a[ i ]; leftChild( i ) < n; i = child )
        {
            child = leftChild( i );
            if( child != n - 1 && a[ child ].compareTo( a[ child + 1 ] ) < 0 )
                child++;
            if( tmp.compareTo( a[ child ] ) < 0 )
                a[ i ] = a[ child ];
            else
                break;
        }
        a[ i ] = tmp;
    }
    
    /**
     * Standard heapsort.
     * @param a an array of Comparable items.
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void heapsort( AnyType [ ] a )
    {
        for( int i = a.length / 2 - 1; i >= 0; i-- )  /* buildHeap */
            percDown( a, i, a.length );
        for( int i = a.length - 1; i > 0; i-- )
        {
            swapReferences( a, 0, i );                /* deleteMax */
            percDown( a, 0, i );
        }
    }


    /**
     * Mergesort algorithm.
     * @param a an array of Comparable items.
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void mergeSort( AnyType [ ] a )
    {
        AnyType [ ] tmpArray = (AnyType[]) new Comparable[ a.length ];

        mergeSort( a, tmpArray, 0, a.length - 1 );
    }

    /**
     * Internal method that makes recursive calls.
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void mergeSort( AnyType [ ] a, AnyType [ ] tmpArray,
               int left, int right )
    {
        if( left < right )
        {
            int center = ( left + right ) / 2;
            mergeSort( a, tmpArray, left, center );
            System.out.println( "amer " + a );

            mergeSort( a, tmpArray, center + 1, right );
            System.out.println( "amer1 " + a );

            merge( a, tmpArray, left, center + 1, right );
        }
    }

    /**
     * Internal method that merges two sorted halves of a subarray.
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param leftPos the left-most index of the subarray.
     * @param rightPos the index of the start of the second half.
     * @param rightEnd the right-most index of the subarray.
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void merge( AnyType [ ] a, AnyType [ ] tmpArray, int leftPos, int rightPos, int rightEnd )
    {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Main loop
        while( leftPos <= leftEnd && rightPos <= rightEnd )
            if( a[ leftPos ].compareTo( a[ rightPos ] ) <= 0 )
                tmpArray[ tmpPos++ ] = a[ leftPos++ ];
            else
                tmpArray[ tmpPos++ ] = a[ rightPos++ ];

        while( leftPos <= leftEnd )    // Copy rest of first half
            tmpArray[ tmpPos++ ] = a[ leftPos++ ];

        while( rightPos <= rightEnd )  // Copy rest of right half
            tmpArray[ tmpPos++ ] = a[ rightPos++ ];

        // Copy tmpArray back
        for( int i = 0; i < numElements; i++, rightEnd-- )
            a[ rightEnd ] = tmpArray[ rightEnd ];
    }

    /**
     * Quicksort algorithm.
     * @param a an array of Comparable items.
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void quicksort( AnyType [ ] a )
    {
        quicksort( a, 0, a.length - 1 );
    }

    private static final int CUTOFF = 3;

    /**
     * Method to swap to elements in an array.
     * @param a an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object.
     */
    public static <AnyType> void swapReferences( AnyType [ ] a, int index1, int index2 )
    {
        AnyType tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }

    /**
     * Return median of left, center, and right.
     * Order these and hide the pivot.
     */
    private static <AnyType extends Comparable<? super AnyType>>
    AnyType median3( AnyType [ ] a, int left, int right )
    {
        int center = ( left + right ) / 2;
        if( a[ center ].compareTo( a[ left ] ) < 0 )
            swapReferences( a, left, center );
        if( a[ right ].compareTo( a[ left ] ) < 0 )
            swapReferences( a, left, right );
        if( a[ right ].compareTo( a[ center ] ) < 0 )
            swapReferences( a, center, right );

            // Place pivot at position right - 1
        swapReferences( a, center, right - 1 );
        return a[ right - 1 ];
    }

    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     * @param a an array of Comparable items.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void quicksort( AnyType [ ] a, int left, int right )
    {
        if( left + CUTOFF <= right )
        {
            AnyType pivot = median3( a, left, right );
            System.out.println( "a1 " + a );
                // Begin partitioning
            int i = left, j = right - 1;
            for( ; ; )
            {
                while( a[ ++i ].compareTo( pivot ) < 0 ) { }
                while( a[ --j ].compareTo( pivot ) > 0 ) { }
                if( i < j )
                    swapReferences( a, i, j );
                else
                    break;
            }
System.out.println( "a2 " + a );

            swapReferences( a, i, right - 1 );   // Restore pivot
System.out.println( "a3 " + a );

            quicksort( a, left, i - 1 );    // Sort small elements
System.out.println( "a4 " + a );
            quicksort( a, i + 1, right );   // Sort large elements
System.out.println( "a5 " + a );

        }
        else  // Do an insertion sort on the subarray
            insertionSort( a, left, right );
System.out.println( "a6 " + a );

    }

    /**
     * Internal insertion sort routine for subarrays
     * that is used by quicksort.
     * @param a an array of Comparable items.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void insertionSort( AnyType [ ] a, int left, int right )
    {
        for( int p = left + 1; p <= right; p++ )
        {
            AnyType tmp = a[ p ];
            int j;

            for( j = p; j > left && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }
/************************* adding a new method for bucket sort *********************/    
/* bucket sort
params a is the input array
maxVal is the maximum number of buckets in sort

*/
    static void bucketsort( Integer[] in, int maxBuckets )
    
    {

    int [] bucket=new int[maxBuckets+1];   // initialising buckets
    
      for (int i=0; i<bucket.length; i++){
            //for (int j=0;j<a.length;++j) 
            bucket[i]=0;
        }
      //   for (int i=0;i<m;++i) count[i]=0;
     
   
          for (int i=0; i<in.length; i++){
            bucket[in[i]]++;               // increasing bucket size
            //++count[a[j]];
          }
             int Pos=0;                            // position to make changes in input array
                for (int i=0; i<bucket.length; i++){
                 //for (int j=0;j<a.length;++j) 
                       for (int j=0; j<bucket[i]; j++){
                            //a[j++]=i;
                           in[Pos++]=i;      // putting the elemnt back into input array
                         }
                  }
    
    }
    /**
     * Quick selection algorithm.
     * Places the kth smallest item in a[k-1].
     * @param a an array of Comparable items.
     * @param k the desired rank (1 is minimum) in the entire array.
     */     
    public static <AnyType extends Comparable<? super AnyType>>
    void quickSelect( AnyType [ ] a, int k )
    {
        quickSelect( a, 0, a.length - 1, k );
    }




    /**
     * Internal selection method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     * Places the kth smallest item in a[k-1].
     * @param a an array of Comparable items.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     * @param k the desired index (1 is minimum) in the entire array.
     */

    private static <AnyType extends Comparable<? super AnyType>>
    void quickSelect( AnyType [ ] a, int left, int right, int k )
    {
        if( left + CUTOFF <= right )
        {
            AnyType pivot = median3( a, left, right );

                // Begin partitioning
            int i = left, j = right - 1;
            for( ; ; )
            {
                while( a[ ++i ].compareTo( pivot ) < 0 ) { }
                while( a[ --j ].compareTo( pivot ) > 0 ) { }
                if( i < j )
                    swapReferences( a, i, j );
                else
                    break;
            }

            swapReferences( a, i, right - 1 );   // Restore pivot

            if( k <= i )
                quickSelect( a, left, i - 1, k );
            else if( k > i + 1 )
                quickSelect( a, i + 1, right, k );
        }
        else  // Do an insertion sort on the subarray
            insertionSort( a, left, right );
    }


    private static final int NUM_ITEMS = 1000;
    private static int theSeed = 1;

    private static void checkSort( Integer [ ] a )
    {
        for( int i = 0; i < a.length; i++ )
            if( a[ i ] != i )
                System.out.println( "Error at " + i );
        System.out.println( "Finished checksort" );
    }

/************************ main ***********************/

    public static void main( String [ ] args )
    {
//        Integer[] a = { 77, 99, 44, 56, 82, 49, 11, 0, 66, 33 };
/***************** getting input from user ******************/
System.out.println("Give the random size for which you want sorting algorithms to compare");
//Scanner sc = new Scanner(System.in);               // to get sizes from user
//int user_size = sc.nextInt();
    int[] sizearray = { 10 }; // add whatever input you want in here array             // put variable sizes you want to put into array

//for (int i = 0; i < a.length; i++)  
//         System.out.println(a[i]);
int index = 0;
int user_size = 0;
while(index < sizearray.length)
{
user_size = sizearray[index];
Integer array1[] =new Integer[user_size]; 
Integer array2[] =new Integer[user_size]; 
Integer array3[] =new Integer[user_size]; 
Integer array4[] =new Integer[user_size]; 

System.out.println("Randomly array generated before sorting is -  ");
Random rn = new Random();
  for (int i = 0; i < user_size; i++) { 
      array1[i] = rn.nextInt(1000) + 1;
      array2[i] = array1[i];
      array3[i] = array1[i];
      array4[i] = array1[i];

      System.out.print(" " +array1[i]+ " ");
 } 

System.out.println(" ");
System.out.println(" :::::::::::: begin sorting :::::::::::::");

/********** bucket sort******************/
long startTimeOfBucketSort = System.currentTimeMillis(); // time declaration for  start time

Sort.bucketsort(array1 , user_size*100);  // calling bucket sort

long endTimeOfBucketSort = System.currentTimeMillis(); // time determination for end
long totalTimeOfBucketSort = endTimeOfBucketSort - startTimeOfBucketSort;

/*********************** quick sort *******************/
long startTimeOfQuickSort = System.currentTimeMillis(); // time declaration for  start time

Sort.quicksort(array2);   // calling quicksort

Sort.mergeSort(array4);

long endTimeOfQuickSort = System.currentTimeMillis(); // time determination for end
long totalTimeOfQuickSort = endTimeOfQuickSort - startTimeOfQuickSort;

/************************insertion sort **************************/
long startTimeOfInsertSort = System.currentTimeMillis(); // time declaration for  start time

Sort.insertionSort(array3);     // calling insetion sort
//Sort.mergeSort(array4)      
long endTimeOfInsertSort = System.currentTimeMillis(); // time determination for end
long totalTimeOfInsertSort = endTimeOfInsertSort - startTimeOfInsertSort;
/****************************report generation ************************/
System.out.println("Array after all sorting is - ");


for (int i = 0; i < array1.length; i++)  
         System.out.print(" " +array1[i]+ " ");

System.out.println(" ");
System.out.println("report of sorting algos for user array size " +array1.length+ " is as follows");
System.out.println("Bucket sort took     =>" + totalTimeOfBucketSort + "miliseconds"); // showing complete time
System.out.println("Quick sort took      =>" + totalTimeOfQuickSort + "miliseconds"); // showing complete time
System.out.println("Insertion sort took  =>" + totalTimeOfInsertSort + "miliseconds"); // showing complete time

index++;
}
System.out.println(" ::::::::::::::::::: END :::::::::::::::::: ");



    }

}