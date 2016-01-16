/*
To implement kruskals algorithm */
//package mst;
// maintain the files in same folder to maintain the package otherwise it will not find the disjoint class


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.AbstractQueue;
import java.util.AbstractCollection;
import java.util.Objects;
import java.util.Collection;
import java.util.Comparator;


/**
 *
 * @author Mayur T
 */
public class Kruskals {
    // edge class 
    public static class Edge{
        int start;
        int end;
        int length;
        
        private Edge(int s, int e, int len) {
            start = s;
            end = e;
            length = len;
        }
        @Override
        // override equals checking function
        
        public boolean equals(Object o) {
            Edge e = (Edge) o;
            
            if (e != null) {
                if (((e.start == start && e.end == end) ||
                        (e.start == end && e.end == start)) &&
                        (e.length == length)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        
    }
    
    public static ArrayList<String> ref = new ArrayList();
    public static ArrayList<Edge> edge = new ArrayList();
    public static int [] parent = new int [edge.size()];
// as accessing the cities names by indexes
    public static int getIndex(String str) {
        str = str.trim();

        return ref.indexOf(str); // -1 not found
    }
    
    // Comparator for Edge
    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge e1, Edge e2) {
            return e1.length-e2.length;
        }
    }
    // checking for edges duplicacy
    public static boolean edgeNotDuplicate(int s, int e, int len) {
        int index = edge.indexOf(new Edge(s,e,len));
        
        if (index == -1) {
            index = edge.indexOf(new Edge(e,s,len));
            if (index == -1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    // printing all edges
    public static void printEdge(Edge e, int cnt) {
        System.out.println(cnt + ": " + ref.get(e.start) + "   ===>    " + ref.get(e.end) + "        :::: distance: " + e.length);
    }
    
    public static void main(String[] args) throws FileNotFoundException {
         int totalCost = 0;
        Scanner scanner = new Scanner(new File("F:\\UTD\\Study\\AA&DS\\xProject\\Project 6\\proj6_MT\\mst\\assn9_data.csv"));
        // mapping  number & location
        while(scanner.hasNextLine()) {
            String tmp[] = scanner.nextLine().trim().split(",");
            ref.add(tmp[0]);
        }
        
        scanner = new Scanner(new File("F:\\UTD\\Study\\AA&DS\\xProject\\Project 6\\proj6_MT\\mst\\assn9_data.csv"));
        // create edge
        while(scanner.hasNextLine()) {
            String tmp[] = scanner.nextLine().trim().split(",");
            int s = getIndex(tmp[0]);
            
            for (int i = 1; i < tmp.length;i += 2) {
                int e = getIndex(tmp[i]);
                int len = Integer.parseInt(tmp[i+1]);
                if (edgeNotDuplicate(s,e,len))
                    edge.add(new Edge(s,e,len));
            }
        }

        Comparator<Edge> comparator = new EdgeComparator();
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>(1,comparator);
        
        //
        for (Edge i : edge) {
            queue.add(i); // accept
        }
        
        int set1, set2, cnt = 1;
        
        DisjSets ds = new DisjSets( edge.size() );
         System.out.println("to                     from             value");
         System.out.println("---------------------------------------------");
        while (queue.size() != 0) {
            Edge etmp = queue.remove();
            set1 = ds.find( etmp.start );
            set2 = ds.find( etmp.end );
            // if in different set, then union
            if (set1 != set2) {
                ds.union( set1, set2 );
                printEdge(etmp, cnt);
                //sum = sum + e.length;
                totalCost = totalCost + etmp.length;
                //System.out.println("final cost "+ sum +" yo");
                
                cnt ++;
                
            }
        }
        System.out.println("");
        System.out.println("The total cost of the MST is >>>     ");
        System.out.println(totalCost);
        
    }    
}