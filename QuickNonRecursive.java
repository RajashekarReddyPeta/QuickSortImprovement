
import java.util.Random;
import java.util.Stack;
import java.util.*;
public class QuickNonRecursive
{
    static void Display(int x[], int n)
    {
       for(int i=0;i<n;i++)
            System.out.print(x[i]+ " ");
    }

    static int Partition(int x[], int lb, int ub )
    {
        int a, down, temp, up,pj;
        a=x[lb];
        up=ub;
        down=lb;
        while(down<up)
        {
            while(x[down]<=a && down<up)
                down=down+1;       
            while(x[up]>a)
                up=up-1;         

            if(down<up)
            {
                temp=x[down]; 
                x[down]=x[up];
                x[up]=temp;
            }
        }
        x[lb]=x[up];
        x[up]=a;
        pj=up;
        return (pj);
    }

static void Quick(int[] a, int lb, int ub)
    {
        Stack S = new Stack();
        S.push(lb);
        S.push(ub);
        while (!S.empty())
        {
            ub = (Integer)S.pop();
            lb = (Integer)S.pop();
            if (ub <= lb) continue;
            int i = Partition(a, lb, ub);
            if (i-lb > ub-i)
            {
                S.push(lb);
                S.push(i-1);
            }
            S.push(i+1);
            S.push(ub);
            if (ub-i >= i-lb)
            {
                S.push(lb);
                S.push(i-1);
            }
        }
    }

    public static void main(String args[ ])
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
            Quick(x,0,n-1);
            long endtime = System.currentTimeMillis();
        System.out.println("\nSorted Elements are :");
       for(int i=0;i<n;i++)
           System.out.print(x[i] + "  ");
       actualtime=endtime-startTime;
    System.out.print("\n"+"The Running time for " +n +" elements NonRecursive QuickSort is "+actualtime);
    }
}