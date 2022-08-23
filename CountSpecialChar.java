import java.util.Scanner;
public class CountSpecialChar {
	public static void main(String[] args)
	{
	System.out.println("Enter the String to Count Special char: ");
	Scanner sc = new Scanner(System.in);
	char ch[] = sc.next().toLowerCase().toCharArray();
	sc.close();
	int count=0;
	for(char i:ch)
	{
		if(!((i>='a'&&i<='z')||(i>='A'&&i<='Z')||(i>=0&&i<=9)))
		{
			count++;
		}
	}
		System.out.println("Number Of Special Character is:"+count);
	}

}
