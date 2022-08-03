package HarshitKumar;
import java.util.Scanner;
public class GuessGame {
   Scanner sc = new Scanner(System.in);	
   public class Guesser{
      int guessNo;
      public int guessNumber()
      {
         System.out.println("Kindly Guess The Number Between 0 to 9 (Umpire): ");
         guessNo=sc.nextInt();    
      	 return guessNo;
       }
   }
    public class Player{
    	int guessByPlayers;
    	public int guessNoByPlayers()
    	{
    		System.out.println("Please Guess The Number(Player): ");
    		guessByPlayers = sc.nextInt();
    		return guessByPlayers;
        }
    }
    public class Umpire{
    	Guesser guesser = new Guesser();
    	Player playerGuess = new Player();
    	public void umpire() {
    		int guessno = guesser.guessNumber();
    		if(guessno>9||guessno<0)
    		{
    			System.out.println("Invalid No! Plz Guess B/W 0 to 9");
    			return;
    		}
    		int player1 = playerGuess.guessNoByPlayers();
        	int player2 = playerGuess.guessNoByPlayers();
        	int player3 = playerGuess.guessNoByPlayers();
    	   
    	if(guessno==player1 && guessno==player2 && guessno==player3)
    	{
    		System.out.println("Player A, Player B and Player C guess the"
    				+ " Correct Number");
    		 System.out.println(" Again Match Between A,B and C");
        	umpire();
    		}
    	
    	else if(guessno==player1 && guessno==player2)
    	{
    		matchBetweenAB();
    			
    	}
    	else if(guessno==player1 && guessno==player3)
    	{
    		matchBetweenAC();
    	}
    	else if(guessno==player2 && guessno ==player3)
    	{
    	
    		matchBetweenBC();
    	}
    	else if(guessno==player1 && player1!= player2 && player1!=player3)
    	{
    		System.out.print("Player A won the Match!");
    	}
    	else if(guessno==player2 && player2!= player1 && player2!=player3)
    	{
    		System.out.print("Player B won the Match!");
    	}
    	else if(guessno==player3 && player3!= player2 && player3!=player1 )
    	{
    		System.out.print("Player C won the Match!");
    	}
    	else
    	{
    		System.out.println("Match Draw!");
    	}
    	}
    	public void matchBetweenAB()
    	{
    		System.out.println("Match b/w Player A and B because both"
    				+ " A and B guess the correct number");
    		int guessno = guesser.guessNumber();
        	int player1 = playerGuess.guessNoByPlayers();
        	int player2 = playerGuess.guessNoByPlayers();
        	if(player1==guessno&&player2!=guessno)
        	{
        		System.out.println("Player A won the Match !");
        	}
        	else if(player2==guessno&&player1!=guessno)
        	{
        		System.out.println("Player B won the Match !");
        	}
        	else if(player2==guessno&&player1==guessno)
        	{
        		System.out.println("Again Both the player guess the correct number"
        				+ "so, A and B Won the Match !");
        	}
        	else
        	{
        		System.out.println("Match Draw!");
        	}
    	}
      	public void matchBetweenBC()
    	{
    		System.out.println("Match b/w Player B and C because both"
    				+ " B and C guess the correct number");
    		int guessno = guesser.guessNumber();
        	int player2 = playerGuess.guessNoByPlayers();
        	int player3 = playerGuess.guessNoByPlayers();
        	if(player2==guessno&&player3!=guessno)
        	{
        		System.out.println("Player B won the Match !");
        	}
        	else if(player3==guessno&&player2!=guessno)
        	{
        		System.out.println("Player C won the Match !");
        	}
        	else if(player3==guessno&&player2==guessno)
        	{
        		System.out.println("Again Both the player guess the correct number"
        				+ "so, B and C Won the Match !");
        	}
        	else
        	{
        		System.out.println("Match Draw!");
        	}
    	}
    	public void matchBetweenAC()
    	{
    		System.out.println("Match b/w Player A and C because both"
    				+ " A and C guess the correct number");
    		int guessno = guesser.guessNumber();
        	int player1 = playerGuess.guessNoByPlayers();
        	int player3 = playerGuess.guessNoByPlayers();
        	if(player1==guessno&&player3!=guessno)
        	{
        		System.out.println("Player A won the Match !");
        	}
        	else if(player3==guessno&&player1!=guessno)
        	{
        		System.out.println("Player C won the Match !");
        	}
        	else if(player3==guessno&&player1==guessno)
        	{
        		System.out.println("Again Both the player guess the correct number"
        				+ "so, A and C Won the Match !");
        	}
        	else
        	{
        		System.out.println("Match Draw!");
        	}
    	}
    	
    }
    
    public static void main(String[] args)
    {
        GuessGame ggm = new GuessGame();
       GuessGame.Umpire ump = ggm.new Umpire();
       ump.umpire();	
    }
}
