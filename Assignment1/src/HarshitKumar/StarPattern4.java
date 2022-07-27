package HarshitKumar;

public class StarPattern4 {
	
	public static void main(String[] args)
	{
		int n =15;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
			
				if(i>n/2&&j<i-n/2||i>n/2&&j>=n-((i+n/2+2)-n))
				{	
					
				
					System.out.print("*");
					
				}
				else
					System.out.print(" ");
				
			}
			System.out.println();
		}
		
	}

}
