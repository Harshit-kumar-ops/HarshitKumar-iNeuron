import java.util.Scanner;
public class Pangram {
public static void main(String[] args)
{
	System.out.println("Enter the String to Check the Pangram or not :");
	Scanner sc = new Scanner(System.in);
	String str = sc.nextLine().toUpperCase();
	sc.close();
	str = str.replace(" ", "");
	int length = str.length();
	char ch[] = str.toCharArray();
	int a[]= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int i=0;
	while(i !=length)
	{
		int index =ch[i]-'A';
		a[index]=1; 
		++i;
	}
	i=0;
	while(i!=26)
	{
		if(a[i]==1)
		{
			++i;
		}
		else
		{
			System.out.println("Non Pangram!");
			System.exit(0);
		}
	}
	System.out.println("Pangram");
	
}

}
