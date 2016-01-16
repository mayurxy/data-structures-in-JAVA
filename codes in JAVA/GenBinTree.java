// @ author Mayur Talole

import java.util.*;
import java.io.*;


public class GenBinTree < T > {
    private BinaryTreeNode root;  // declare and create root node to be used in code
    
     char [] p = new char[100]; //global array
     int i=0;   

    public void BinaryTree() {
        root = null;   //creating null root node.
    }

/***********************Adding element******************************************/

 public  void add(T data) {
            root = new BinaryTreeNode(data, null, null);  // return value to root node 
        }
        
        /* BinaryTreeNode newNode, tempNode;
		Queue<BinaryTreeNode> q;                           // queue declaration to store all elements in the string 
		newNode = new BinaryTreeNode(data, null,null);     // new node declare
		//newNode.x = data;                               
		//newNode.leftNode = newNode.rightNode = null;
		if(root == null){ 
			//	There are no nodes in the tree right now.     
			//	Make the current node as root node.
			root = newNode;
			return;
		}
		q = new LinkedList<BinaryTreeNode>();
		q.add(root);                                  // adding only at root level node
		
		while(q.peek() != null) {                       
			tempNode = q.poll();                      
			if(tempNode.leftNode != null)              // checking for left children presence
				q.add(tempNode.leftNode);
			else{
				tempNode.leftNode = newNode;           // appointing new node to left child.
				q = null;
				return;
			}
			if(tempNode.rightNode != null)           // checking for right children presence
				q.add(tempNode.rightNode);
			else{
				tempNode.rightNode = newNode;            // appointing new node to right child.
				q = null;
				return;
			}
		}

   
   
   }
   */
    public void add(String path, T data1) {               //override function add
        /* BinaryTreeNode newNode;
        		char[] pathArr = path.toCharArray();               // convert the passed string to array
        		int loopCount = pathArr.length-1, i; 
        		newNode = new BinaryTreeNode(data, null, null);
        		//newNode.x = data;
        	//	newNode.leftNode = newNode.rightNode = null;
        		for(i=0; i<loopCount; i++){                     // scan the array
        			if(pathArr[i]=='L'){                         // check for left case
        				root = root.leftNode;
        			} else if(pathArr[i]=='R') {                    // check for right case
        				root = root.rightNode;
        			} else {
        				return;
        			}
        		}
        		if(pathArr[i]=='L')
        			root.leftNode = newNode;
        		else
        			root.rightNode = newNode;
           */
        BinaryTreeNode tempNode;            // create temp node                    
        BinaryTreeNode newNode;             // create new node
        tempNode = root;                 

        String pathexpression = path + '\0';  // append the '\0' to end of string to check end of string
        newNode = new BinaryTreeNode(data1, null, null);
        char pathArr[] = pathexpression.toCharArray();  // Convert path to array elements
        int i = 0;
        int loopCount = pathArr.length - 1;

        for (i = 0; i < loopCount; i++) {
            if ((pathArr[i] == 'L') && (pathArr[i] != '\0')) {       // check for left case and for end of string
                if (tempNode.leftNode == null) {
                    tempNode.leftNode = newNode;
                    if (tempNode.rightNode != null) {             // check for the right childen of temp or root
                        newNode = tempNode; 
                    }
                } else {
                    tempNode = tempNode.leftNode;                     
                }
            } else if ((pathArr[i] == 'R') && (pathArr[i] != '\0')) {   //  check for right case 
                if (tempNode.rightNode == null) {
                    tempNode.rightNode = newNode;
                    if (tempNode.leftNode != null) {         // check for the left childen of temp or root

                        newNode = tempNode;
                    }
                } else {
                    tempNode = tempNode.rightNode;
                }
            }

        }

    }

/*****************************  print  **********************************************************/

    public void print() {
        print(root);              // if only one node is there
        System.out.println();      // next line
    }
    private void print(BinaryTreeNode node) {
            if (node == null) return;          // tree traversal

            // left, node itself, right 
            print(node.leftNode);                // left node first
            System.out.print(node.data + "  ");  // head
            print(node.rightNode);               // right node last
            
        }
        
/*******************************************************************************************************/        
       /*  
          GenBinTree find_val(T item , GenBinTree<T> t)
          {
             GenBinTree temp;
             temp = t;
             GenBinTree result = null;
             //System.out.println(temp.data);
             if(temp.leftNode!= null)
                 result = find_val(item , temp.leftNode);
                
             if(temp.data == item)
             {   
                //System.out.println(temp.data);
                result = temp;
                //return true;
             }
             if(result == null && temp.rightNode!= null)
                 result = find_val(item , temp.rightNode);
             //System.out.println(result);
             return result;
          }
          
          boolean find(T item)
          {
             T n = item;
             //GenBinTree p = root;
             GenBinTree res;
             res = find_val(n , root);
             if(res.data == item)
             {  
                //System.out.println("Element Found");
                return true;
             }
             else
             {
                return false;
             }
          }
          */
        /*  
          void removeitem(T item , GenBinTree t , GenBinTree p)
          {
             GenBinTree temp = t;
             GenBinTree prev = p;
             GenBinTree2<T> result;
             
             if(temp == null)
                System.out.println("Tree Empty");
             if(temp.leftNode != null)
                 removeitem(item , temp.leftNode , temp);
             if(temp.data == item)
             {
                if(temp.leftNode == null && temp.rightNode == null)
                {
                   prev.leftNode = null;
                   prev.rightNode = null;
                   temp = prevNode;
                }
                else
                {
                   System.out.println("The selected node is not a leaf node");
                }
             }
             if(temp.rightNode != null)
             {
                removeitem(item , temp.rightNode , temp);
             }
          }
          
          void remove(T item)
          {
             removeitem(item , root , null);
          }
          */
/************************* binary node creation *************************************/
    private static class BinaryTreeNode < T > {
            T data;
            BinaryTreeNode leftNode;
            BinaryTreeNode rightNode;

            BinaryTreeNode(T d, BinaryTreeNode left, BinaryTreeNode right) {
                data = d;                   // data part
                leftNode = left;            // left child
                rightNode = right;          // right child
            }
        }
/*************************************************************************************/        


/******************************* mirror  **********************************************/
    public void mirror() {
        mirror(root);            // only one node is there - root

    }


    public void mirror(BinaryTreeNode node) {
            if (node != null) {
                // do the sub-trees 
                if(node.leftNode != null)     //if leftchild is present 
                {
                mirror(node.leftNode);
                }
                if(node.rightNode != null)
                {
                mirror(node.rightNode);
                }
                // swap the left/right pointers  
                BinaryTreeNode temp = node.leftNode;
                node.leftNode = node.rightNode;
                node.rightNode = temp;
            }
        else{
           throw new RuntimeException("cannot proceed already at null");
        }
        }
/***********************************************************************************************/
       

/************************** count nodes ***********************************************/

    public int countnodes() {
        return (countnodes(root));   // for only one node
    }

    public int countnodes(BinaryTreeNode node) {
            if (node == null)
                return (0);
            else {
                return (countnodes(node.leftNode) + 1 + countnodes(node.rightNode));  // returning final value
            }
        }
        
/**********************************************************************************************/        

    /*
    public boolean find(T data1) { 
        return(find(root, data1));
        }
        
    public boolean find(BinaryTreeNode cur, T val) {

            BinaryTreeNode result = null;
            if(cur.leftNode != null)
                result = find(cur.leftNode,val);


            if(cur.value == val)
                return true;
            if(result ==null && cur.rightNode != null)
                result = find(cur.rightNode,val);

            return result;

        }
    */
/*************************************  find *************************************/

    public boolean find(String val) {
            return find(root, val);        // one node at one level
        }
        /* Function to search for an element recursively */
    private boolean find(BinaryTreeNode r, String val) {           // override functions
        if (r.data == val)                         
            return true;
        if (r.leftNode != null)                     // if node has left child then enter the connected subtree
            if (find(r.leftNode, val))
                {System.out.print("right");
                
                return true;
                }
        if (r.rightNode != null)                   // if node has right child enter into that subtree
            if (find(r.rightNode, val))
                 {System.out.print("left");
                return true;
                }
             //   throw new ItemNotFoundException( );
        return false;
    }
/*********************************************************************************/



/********************************  remove ******************************************/

    public void remove(T val) {
        BinaryTreeNode prevNode = null;
        remove(root, prevNode, val);
    }


    public void remove(BinaryTreeNode < T > mroot, BinaryTreeNode < T > prevNode, T val) {

            if (mroot == null)                                        // if the node is already at null position throw exception
                throw new RuntimeException("cannot proceed to delete.");

            else if (mroot.data == val) {                
                if (mroot.leftNode == null) {
                    //     if (find(mroot.rightNode, val))
                    if (mroot.rightNode == null) {
                        if (prevNode.leftNode == mroot) {
                            // remove the previous node left link to null as leaf is present at left link
                            prevNode.leftNode = null;
                            mroot = prevNode; // to store previous nodes status to current root
                        }
                        if (prevNode.rightNode == mroot) {
                            // remove the previous node right link to null as leaf is present at right link
                            prevNode.rightNode = null;
                            mroot = prevNode; // to store previous nodes status to current root

                        }
                    } else {
                        //  if (mroot.rightNode != null)
                        //     if (find(mroot.rightNode, val))
                        System.out.println("The node is not a leaf node In order to delete node must not have children ");
                        throw new RuntimeException("cannot proceed to delete.");
                    }
                } else {
                    //  if (mroot.leftNode != null)
                    //     if (find(mroot.leftNode, val))
                    System.out.println("The node is not a leaf node In order to delete node must not have children");
                    throw new RuntimeException("cannot proceed to delete.");
                }
            }
            if (mroot.leftNode != null) {
                remove(mroot.leftNode, mroot, val); // node finding and removing through recursive function from left children
            }
            //  else 
            // throw new RuntimeException("subtree is present"); 
            if (mroot.rightNode != null) {
                remove(mroot.rightNode, mroot, val); // node finding and removing through recursive function from right children
            }
            //  else 
            // throw new RuntimeException("subtree is present"); 


        }
/*********************************************************************************************************/  



/********************************  swap *********************************************************/

    public boolean swap(String val) {
            return swap(root, val);     // root only one node   
         }
        /* Function to search for an element recursively */
    private boolean swap(BinaryTreeNode r, String val) {
            if (r.data == val) {
                if (r.leftNode == null && r.rightNode == null) {  // detecting leaf
                    System.out.print("leaf no swap");
                   throw new RuntimeException("No swapping possible");

                } else {
                    BinaryTreeNode temp = r.leftNode;       // swapping the nodes using temp
                    r.leftNode = r.rightNode;
                    r.rightNode = temp;
                    System.out.print("\n swap");

                }

                return true;
            }
            if (r.leftNode != null)
                if (swap(r.leftNode, val))        
                    return true;
            if (r.rightNode != null)
                if (swap(r.rightNode, val))
                    return true;
            return false;
        }
        
/***********************************************************************************************/


  public String toString() {
    if (root == null) {
      return "";
    } else {
      return root.toString();
    }
  }
/*
public void Rightrotate(T item)
{
BinaryTreeNode p = null;

return Rightrotate(item, root, p);

}

public void Rightrotate(T item , BinaryTreeNode<T> t , BinaryTreeNode<T> p)
   {
      if(t.left != null)
      {
         Rightrotate(item , t.left , t);
         if(t.data == item)
         {
            if(t.left != null)
            {
               p.left = t.left;
               t.left = t.left.right;
               t.left.right = t;
               t = t.left;     
            }
            else
            {
               System.out.println("rotation not possible");
            }
         }
         Rightrotate(item , t.right , t);
      }
   }


*/
void RotateRight(T val)
   {
      BinaryTreeNode prevNode = null;
      BinaryTreeNode nextNode = null;
      RotateRight(val , root , prevNode , nextNode);    //using next node and previous node to store ancestor
   }
   
   void RotateRight(T item , BinaryTreeNode<T> myroot , BinaryTreeNode<T> prevNode , BinaryTreeNode<T> nextNode)
   {
         if(myroot.leftNode != null)
         {
            RotateRight(item , myroot.leftNode , myroot , myroot.leftNode.leftNode);
         }
      
      //       res = find_val(n , root);
       //      if(res.data == item)
         if(myroot.rightNode != null)
         {
            RotateRight(item , myroot.rightNode , myroot , myroot.rightNode.rightNode);
         }

         if(myroot.data == item)
         {                                            // searching the element 
            //System.out.println(myroot.data);
           // BinaryTreeNode p = null;

           //return Rightrotate(item, root, p);

            if(myroot == root)
            {
               //System.out.println(root.data);
               nextNode = myroot.leftNode;
               //root = n;
               myroot.leftNode = nextNode.rightNode;
         //  if(t.left != null)
//          {
//             Rightrotate(item , t.left , t , t.left.left);
//          }  root = nextNode;
               myroot = nextNode.leftNode;
           //       nextNode.rightNode = myroot;
             
               nextNode = myroot.leftNode;
            }
            else if(myroot.leftNode != null)
            {
               prevNode.leftNode = nextNode;
               //  if(t.right != null)
//          {
//             Rightrotate(item , t.right , t , t.right.right);
//          }
               myroot.leftNode = nextNode.rightNode;
               nextNode.rightNode = myroot;
               //myroot = nextNode.leftNode;
           //       nextNode.rightNode = myroot;
             
               nextNode = nextNode.leftNode;
               myroot = nextNode; 
               prevNode = myroot;     
            }
            else
            {
                throw new RuntimeException("cannot proceed to rotation.");


            }
         }
         
        
    }
   
    ////////////////////////////////////////



    ///////////////////////rotate left////////////////////

void RotateLeft(T val)
   {
      BinaryTreeNode prevNode = null;
      BinaryTreeNode nextNode = null;
      RotateLeft(val , root , prevNode , nextNode);   
   }
   
   void RotateLeft(T item , BinaryTreeNode<T> myroot , BinaryTreeNode<T> prevNode , BinaryTreeNode<T> nextNode)
   {
         if(myroot.rightNode != null)
         {
            RotateLeft(item , myroot.rightNode , myroot , myroot.rightNode.rightNode);
         }
         
      //       res = find_val(n , root);
       //      if(res.data == item)
         if(myroot.leftNode != null)
         {
            RotateLeft(item , myroot.leftNode , myroot , myroot.leftNode.leftNode);
         }

      //       res = find_val(n , root);
       //      if(res.data == item)
         if(myroot.data == item)
         {
            //System.out.println(t.data);
            if(myroot == root)
            {
               //System.out.println(root.data);
               nextNode = myroot.rightNode;
               //root = n;
               myroot.rightNode = nextNode.leftNode;
          
         //  if(t.left != null)
//          {
//             Rightrotate(item , t.left , t , t.left.left);
//          }     nextNode.leftNode = myroot;
               root = nextNode;
               myroot = nextNode.rightNode;
               nextNode = myroot.rightNode;
            }
            else if(myroot.rightNode != null)
            {
      
        //  if(t.right != null)
//          {
//             Rightrotate(item , t.right , t , t.right.right);
//          }         prevNode.rightNode = nextNode;
               myroot.rightNode = nextNode.leftNode;
               nextNode.leftNode = myroot;
               nextNode = nextNode.rightNode;
               //myroot = nextNode.leftNode;
           //       nextNode.rightNode = myroot;
               myroot = nextNode; 
               prevNode = myroot;     
            }
            else
            {
             throw new RuntimeException("cannot proceed to rotation left");


            }
         }
// 
      
    }
   
/************************************  main  *****************************************/

    public static void main(String args[]) {
    
        GenBinTree < String > gbt = new GenBinTree < String > ();
   
   boolean flag1, flag2;
   int count;
   
   gbt.add("55");
   gbt.print();
   
   gbt.add("L", "14");
   gbt.print();
   gbt.add("R", "87");
   gbt.print();
   gbt.add("LL", "94");
   gbt.print();
   gbt.add("LLR", "37"); 
   gbt.print(); 
   gbt.add("LLL", "8"); 
   gbt.print();
   gbt.add("RL", "888");
   gbt.print();
   gbt.add("RR", "974");
   gbt.print();
   gbt.add("LR", "64");
   gbt.print();
   
   System.out.print("\n path of the element is \n");
   flag1 = gbt.find("94");
   System.out.print("\n 1stsearch result : "+flag1);

   System.out.print("\n path of the element is \n");   
   flag2 = gbt.find("25");
   System.out.print("\n 2ndsearch result : "+flag2);
   
   
   count = gbt.countnodes();
   System.out.print("\n no of nodes present: " +count);
   
   gbt.RotateRight("14");
   System.out.print("\n right rotated tree is \n");
   gbt.print();
   
   gbt.RotateLeft("87");
   System.out.print("\n Left rotated tree is \n");
   gbt.print();
   
   gbt.swap("50");
   System.out.print("\n tree after swapping is \n");
   
   gbt.print();
   
   gbt.mirror();
   System.out.print("\n mirror of tree is \n");
   gbt.print();
   
   gbt.remove("8");
   System.out.print("\n tree after removing node is \n");
   
   gbt.print();
   
   gbt.remove("25");
   System.out.print("\n after removal tree is \n ");
   
   gbt.print();
   
   
     }
}