package comp2402a2;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import comp2402a2.ArrayDeque;
import comp2402a2.BulkArrayDeque;

public class BulkArrayDeque<T> extends ArrayDeque<T> {
 
 public BulkArrayDeque(Class<T> clazz) {
  super(clazz);
 }
 
 /**
  * Remove all the elements with indices that belong to the range [i, j)
  * @param i the starting index
  * @param c the stopping index
  */
 public void removeRange(int firstIndex, int lastIndex) {
   //n is number of elements
   //j is next element to dequeue
  if (firstIndex < 0 || firstIndex > n - 1)  throw new IndexOutOfBoundsException();
  if (lastIndex < 0 || lastIndex > n - 1)  throw new IndexOutOfBoundsException();
  if (firstIndex >= lastIndex)  throw new IndexOutOfBoundsException();
  
  int delta = lastIndex - firstIndex;
  int midrange = delta/2+firstIndex;
  int offset = delta;
  
  System.out.println(offset);
  
  if (midrange < n/2) {  // shift a[0],..,[i-1] right one position
    for (int k = firstIndex - 1; k >= 0; k--){
      int lhs = (j+k+offset)%a.length;
      int rhs = (j+k)%a.length;
      System.out.println("LHS: " + lhs);
      System.out.println("RHS: " + rhs);
    a[lhs] = a[rhs];
    }
  j = (j + offset) % a.length;
   System.out.println("j: " + j);
  } else {        // shift a[i+1],..,a[n-1] left one position
    for (int k = firstIndex; k < n-1; k++){
      int lhs = (k)%a.length;
      int rhs = (k+offset)%a.length;
      System.out.println("LHS: " + lhs);
      System.out.println("RHS: " + rhs);
    a[lhs] = a[rhs];
    }
  }
  n -= offset;
  if (3*n < a.length) resize();
  return;
 }
 
 /**
  * testing method
  */
 public static void doIt(BufferedReader r, PrintWriter w){
   
   BulkArrayDeque<String> list = new BulkArrayDeque<String>(String.class);
   
   //adding stuff
   for(int i = 0; i < 100;i++){
    list.add(" " + i);
   }
   w.println("original list");
   //print orginal test
   for(int i = 0; i < list.size();i++){
    w.print(" " + list.get(i));    
   }
   w.println(" ");
   
   //testing front end
   list.removeRange(5,10);
   
   if(list.size() != 95){
     w.println("removeRange failed");
   }else{
    w.println("removeRange okay"); 
   }
   w.println("first half test");
   //print orginal test
   for(int i = 0; i < list.size();i++){
    w.print(" " + list.get(i));    
   }
   w.println(" ");
  // list.clear();
//   
//   //re-adding stuff
//   for(int i = 0; i < 100;i++){
//    list.add(" " + i);
//   }
   
   //testing tail end
   list.removeRange(85,88);
   
   if(list.size() != 92){
     w.println("removeRange failed");
   }else{
    w.println("removeRange okay"); 
   }
   
   w.println("second half test");
     for(int i = 0; i < list.size();i++){
    w.print(" " + list.get(i));    
   }
   w.println(" ");

   try{
    list.removeRange(20,5); 
   }catch(Exception ex){
    w.print("caught exception"); 
   }
 }
 
 
 /**
  * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
  * and System.out or from filenames specified on the command line, then call doIt.
  * @param args
  */
 public static void main(String[] args) {
  try {
   BufferedReader r;
   PrintWriter w;
   if (args.length == 0) {
    r = new BufferedReader(new InputStreamReader(System.in));
    w = new PrintWriter(System.out);
   } else if (args.length == 1) {
    r = new BufferedReader(new FileReader(args[0]));
    w = new PrintWriter(System.out);    
   } else {
    r = new BufferedReader(new FileReader(args[0]));
    w = new PrintWriter(new FileWriter(args[1]));
   }
   long start = System.nanoTime();
   doIt(r, w);
   w.flush();
   long stop = System.nanoTime();
   System.err.println("Execution time: " + 10e-9 * (stop-start));
  } catch (IOException e) {
   System.err.println(e);
   System.exit(-1);
  }
 }
}
