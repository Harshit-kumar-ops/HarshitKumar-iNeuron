import java.util.Scanner;
public class RepeatCh {

	public static void main(String[] args)
	{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the String to Check the Repeat char: ");
    String str = sc.nextLine();
    str = str.toLowerCase();
    str = str.replace(" ", "");
    int size = str.length();
    char ch[] = str.toCharArray();
     for(int i=0;i< size; i++)
     {
    	 for(int j=i+1; j<size; j++)
    	 {
    		 if(ch[i]==ch[j])
    		 {
    			 System.out.println(ch[i]);
    		 }
    	 }
     }
		
	}
}
