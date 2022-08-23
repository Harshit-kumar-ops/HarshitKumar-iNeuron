import java.util.Scanner;
public class RevString {
	public static void main(String args[])
	{
	System.out.println("Enter the String To Reverse: ");
	Scanner sc = new Scanner(System.in);
	String str = sc.next();
	String str1="";
    for(int i = 0; i<str.length(); i++)
    {
    	str1 = str.charAt(i)+str1;

    }
		System.out.println(str1);
	}
	
	
	

}
