import edu.princeton.cs.algs4.*;

//selection sort 选择排序
public class Selection
{
	public static void sort(Comparable[] a)
	{
		for(int i=0;i<a.length;i++)
			for(int j=i+1;j<a.length;j++)
				if(less(a[j],a[i])) exch(a,i,j);
	}
	
	private static boolean less(Comparable v,Comparable w)
	{return v.compareTo(w)<0;}
	
	private static void exch(Comparable[] a,int i,int j)
	{Comparable t=a[i];a[i]=a[j];a[j]=t;}
	
	
	private static boolean isSorted(Comparable[] a)
	{
		for(int i=1;i<a.length;i++)
			if(less(a[i],a[i-1])) return false;
		return true;
	}
	
	private static void show(Comparable[] a)
	{
		for(Comparable x: a)
			StdOut.print(x+" ");
		StdOut.println();
	}
	
	public static void main(String[] args)
	{
		String[] array={"S","O","R","T","E","X","A","M","P","L","E"};
		sort(array);
		StdOut.println(isSorted(array));
		show(array);
		
		int N=100;
		double t;
		double[] a=new double[N];
		StdDraw.setYscale(0,3);
 		
		//visualizing sorting algorithm
		for(int i=0;i<N;i++)
			a[i]=StdRandom.random();
		
		for(int i=0;i<N;i++)
			StdDraw.filledRectangle(1.0*i/N,a[i]/2.0,0.5/N,a[i]/2.0);
		
		for(int i=0;i<N;i++)
		{
			for(int j=i+1;j<N;j++)
			{
				if(a[j]<a[i])
				{
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.filledRectangle(1.0*i/N,a[i]/2.0,0.5/N,1);
					StdDraw.filledRectangle(1.0*j/N,a[j]/2.0,0.5/N,1);
		
		            t=a[i];
					a[i]=a[j];
					a[j]=t;
					
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(1.0*i/N,a[i]/2.0,0.5/N,a[i]/2.0);
					StdDraw.filledRectangle(1.0*j/N,a[j]/2.0,0.5/N,a[j]/2.0);
				}
			}
		}
	}
}