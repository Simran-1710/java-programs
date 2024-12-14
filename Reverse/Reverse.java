
import java.util.*;
public class Reverse 
{
	public static void main(String[] args)
	{
		Scanner inp=new Scanner(System.in);
		int n=inp.nextInt();
		int x=inp.nextInt();
	   int[] arr= new int[n];
	      
	     

	int ans=getind(arr,x);
	System.out.println(ans);
	}

	public static int getind(int[] arr , int x)
	{
		if(arr[arr.length-1]<x)
			return -1;
		
	          int l=0,ans=-1;
	          int r=arr.length-1;

	        while(l<=r)
	         {
	               int mid=l+  (r-l)/2;
	      
	               
	                if(arr[mid]==x)
	                {
	                	 ans=mid;
	                	
	                	r=mid-1;
	                }
	                else
				   if(arr[mid]>x)
				   {
					   ans=mid;
				      r=mid-1;
				   }
				   else
				      l=mid+1;
	         }
	 
	        return ans;
	}     
}
