import java.io.*;
import java.util.Random;
import java.util.Scanner;
class MedianQsr
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
System.out.print("The Running time for " +n +" elements using  Median-of-three partition Recursive QuickSorting is "+actualtime);
 }
// my quick sort method
 static void quicksort(int x[], int lb, int ub, int n)
 {
 int j=0;
if(lb>=ub)
 return;
// code for median of sub array
 j=partition(x,lb,ub,j);
 quicksort(x,lb,j-1,n); // sorting left partition
 quicksort(x,j+1,ub,n); // sorting right partition

 }

 // my partition method
 static int partition (int a[], int lb, int ub, int pj)
 {
	 int x=a[ub];
	 //choosing median as pivot element
	 if(ub-lb>2){
	 int y=a[(ub-lb)/2+lb],z=a[ub-1],
	 i=lb-1,j=ub;
	 if (y>=x && y<=z || y>=z && y<=x )
	 {
     x=y;
     }
	 else if (z>x && z<y || z>y && z<x ) 
	 {
	x=z;
	 }
	 }
 int b, down, temp, up; // b is a pivot element
 b = a[ub];
 up = ub;
 down = lb;

 while (down < up)
 {
 while ( a[down] <= x && down<up )
 down=down+1;

 while ( a[up] > x )
 up=up-1;
 if ( down < up )
 {
 temp=a[down];
 a[down]=a[up];
 a[up]=temp;
 }
 }
 a[lb] = a[up];
 a[up] = x;
 return up;
 }
 // my display function
 static void display(int x[], int n)
 {
 int i;
 //System.out.println(" ");
 for(i=0; i<n; i++)
 System.out.print(" " + x[i]);
 System.out.println(" ");
 }
}