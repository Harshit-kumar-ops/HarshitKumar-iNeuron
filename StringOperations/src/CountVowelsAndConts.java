import java.util.Scanner;
public class CountVowelsAndConts {
	public static void main(String[] args)
	{
		System.out.println("Enter the String for Count Vowels and Consonents: ");
		Scanner sc = new Scanner(System.in);
		int count =0;
		int consonent=0;
	    char str[] = sc.next().toLowerCase().toCharArray();
	    for(char i : str) {
	    	if(i=='a'||i=='e'||i=='i'||i=='o'||i=='u')
	    	{
	    		count++;
	    	}
	    	else if(i>='a' && i<='z')
	    	{
	    	 consonent++;
	    	}
	    	
	    }
	    System.out.println("Number of Vowels are:"+count);
    	System.out.println("Number of Consonents are:"+consonent);
	}

}
