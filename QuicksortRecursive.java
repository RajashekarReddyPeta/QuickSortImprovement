import java.io.*;
import java.util.Random;
import java.util.Scanner;
class QSR
{
 public static void main ( String args [] )throws IOException
 {
 
	 System.out.println("Enter number values to be sorted");
     Scanner in = new Scanner(System.in);
    int n=in.nextInt();
     Random randomGenerator = new Random();
     int[] x =new int[n];
     //choosing random numbers to sort
     for (int idx = 0; idx <n; ++idx){
     	x[idx]= randomGenerator.nextInt(100); 
     	  }
     long startTime = System.currentTimeMillis();
  	long actualtime;
  // calling my recursive sort method
 quicksort(x,0,n-1,n); 
 System.out.println("\n Sorted elements are: \n");
 long endtime = System.currentTimeMillis();
 display(x,n);
 actualtime=endtime-startTime;
System.out.print("The Running time for " +n +" elements using Recursive QuickSort is "+actualtime);
 }
// my quick sort method
 static void quicksort(int x[], int lb, int ub, int n)
 {
 int j=0;
if(lb>=ub)
 return;

 j=partition(x,lb,ub,j);
 

 quicksort(x,lb,j-1,n); // sorting left partition
 quicksort(x,j+1,ub,n); // sorting right partition

 }

 // my partition method
 static int partition (int x[], int lb, int ub, int pj)
 {
 int a, down, temp, up; // a is a pivot element
 a = x[lb];
 up = ub;
 down = lb;

 while (down < up)
 {
 while ( x[down] <= a && down<up )
 down=down+1;

 while ( x[up] > a )
 up=up-1;

if ( down < up )
 {
 temp=x[down];
 x[down]=x[up];
 x[up]=temp;
 }
 }
 x[lb] = x[up];
 x[up] = a;
  return up;
 }
 //  display function
 static void display(int x[], int n)
 {
 int i;
 //System.out.println(" ");
 for(i=0; i<n; i++)
 System.out.print(" " + x[i]);
 System.out.println(" ");
 }
}