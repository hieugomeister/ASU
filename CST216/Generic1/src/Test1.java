import java.util.*;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tN = {1};		
		
		@SuppressWarnings("unused")
		int z = oddOrPos(tN);
		System.out.println("oddOrPos() returned: " + z);

	}
	
	public static int countPositive(int[] x) 
	{
		// Effects: If x==null throw NullPointerException 
		// else return the number of 
		// positive (non-zero) elements in x. 
	
		int count = 0;
		
		for(int i=0; i < x.length; i++) 
		{ 
			if(x[i] > 0) 
			{
				count++; 
			} 
		}
		return count; 
	}

	
	public static int lastZero (int[] x)
	{
	//Effects: if x==null throw NullPointerException
	// else return the index of the LAST 0 in x.
	// Return -1 if 0 does not occur in x

		int pos = 0;	//Added to fix the fault
		boolean found = false; 	//Added to fix the fault
		
		for (int i = 0; i < x.length; i++)
		{
			//Modified if() body
			if(x[i] == 0)
			{ 
				pos = i; //Changes took place here
				found = true;//Changes took place here
			}
			
			if((i == (x.length - 1)) && (found == true))//Changes
			{
				return(pos);//Changes
			}
		}
		return -1;
	}

	public static int oddOrPos(int[] x)
	{
	// Effects: if x == null throw NullPointerException
	// else return the number of elements in x that
	// are either odd or positive (or both)

		int count = 0;
		for(int i = 0; i < x.length; i++)
		{
			if((x[i]% 2 == -1) || (x[i]% 2 == 1) || (x[i] > 0))
			{
				count++;
			} 
		}
		return count;
	}
}