import java.util.Scanner;
import java.util.Arrays;
public class Anagram {
	
	public static void main(String[] args)
	{
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the first String: ");
			String str1 = sc.next();
			
			System.out.println("Enter the Second String: ");
			String str2 = sc.next();
			
			str1=str1.toLowerCase();
			str2=str2.toLowerCase();
			
			if(str1.length()==str2.length())
			{
			char[] str11 =  str1.toCharArray();
			char[] str22 =  str2.toCharArray();

			
			Arrays.sort(str11);
			Arrays.sort(str22);		
			
			boolean result = Arrays.equals(str11, str22);
			if(result)
			{
				System.out.println("Strings are Anagram");
			}
			else
			{
				System.out.println("Strings are not Anagram!");
			}
			
			}
			else
			{
				System.out.println("Strings are not Anagram!");
			}
		}
	}

}
