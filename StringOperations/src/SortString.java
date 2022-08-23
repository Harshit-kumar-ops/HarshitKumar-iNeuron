import java.util.Scanner;
public class SortString {
	
	public static void main(String[] args)
	{
		System.out.println("Enter the String to sort Alphabetically: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String str1 = str.toLowerCase();
		char str2[]=str1.toCharArray();
		for(int i=0 ; i<str1.length();i++)
		{
			for(int j=i+1;j<str1.length();j++)
			{
				if(str2[i]>str2[j])
				{
					char temp = str2[i];
					str2[i]=str2[j];
					str2[j]=temp;
				}
			}
		}
		System.out.println(str2);
		}
	}


