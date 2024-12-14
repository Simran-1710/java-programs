import java.util.*;
import java.lang.*;

public class BFS 
{
	
	private static int[] getIndices(String s,String d)
	{
		int i;
		int[] arr=new int[4];
		
		for(i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			
			if(c>=49 && c<=56)
			{
				arr[0]=56-c;
			}
			else
			{
				switch(c)
				{
				case 'a':
					arr[1]=0;
					break;
				case 'b':
					arr[1]=1;
					break;
				case 'c':
					arr[1]=2;
					break;
				case 'd':
					arr[1]=3;
					break;
				case 'e':
					arr[1]=4;
					break;
				case 'f':
					arr[1]=5;
					break;
				case 'g':
					arr[1]=6;
					break;
				case 'h':
					arr[1]=7;
					break;
				}
			}	
		}
		
		for(i=0;i<d.length();i++)
		{
			char c=d.charAt(i);
			
			if(c>=49 && c<=56)
			{
				arr[2]=56-c;
			}
			else
			{
				switch(c)
				{
				case 'a':
					arr[3]=0;
					break;
				case 'b':
					arr[3]=1;
					break;
				case 'c':
					arr[3]=2;
					break;
				case 'd':
					arr[3]=3;
					break;
				case 'e':
					arr[3]=4;
					break;
				case 'f':
					arr[3]=5;
					break;
				case 'g':
					arr[3]=6;
					break;
				case 'h':
					arr[3]=7;
					break;
				}
			}
		}
		
		return arr;
	}
		
	
	private static int bfs(int[] arr)
	{
		int[][] neighbours= {{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
		boolean[][] visited=new boolean[8][8];
		
		int c=-1;
		
		Queue<Integer> q=new LinkedList<Integer>();
		
		q.add(arr[0]);
		q.add(arr[1]);
		visited[arr[0]][arr[1]]=true;
		
		while(!q.isEmpty())
		{
			int size=q.size()/2;
			c++;
			
			for(int i=0;i<size;i++)
			{
				int row=q.remove();
				int col=q.remove();
				
				for(int j=0;j<8;j++)
				{
					int nextrow=row+neighbours[j][0];
					int nextcol=col+neighbours[j][1];
					
					if(nextrow==arr[2] && nextcol==arr[3])
						return c+1;
					
					if((nextrow<0 || nextrow>7) || (nextcol<=0 ||nextcol>=7))
						continue;
					
					if(visited[nextrow][nextcol]==false)
					{
						visited[nextrow][nextcol]=true;
						q.add(nextrow);
						q.add(nextcol);
					}
				}
				
			}
		}
		
		return 0;
	}
	
	
	public static void main(String args[])
	{
		Scanner inp=new Scanner(System.in);
		int i;
		Queue<Integer> q=new LinkedList<Integer>();
		
		int t=inp.nextInt();
		int p=t;
		
		while(t>0)
		{
			String s=inp.next();
			String d=inp.next();
			
			int[] arr=getIndices(s,d);
			
			int c=bfs(arr);
			
			q.add(c);
			
			t--;	
		}
		
		while(p>0)
		{
			p--;
			System.out.println(q.remove());
		}
		
		inp.close();
	}
}
