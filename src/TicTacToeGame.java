import java.util.Scanner;
public class TicTacToeGame {
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe");
		createBoard();
		char userLetter=chooseLetter();
		char compLetter=(userLetter =='x')?'o' :'x';
	}	
	static char[] createBoard(){
		char Board[] = new char[10];
		for (int i = 0; i < Board.length; i++) {
			
			Board[i]= ' ';
		}
		return Board;
	}
	static char chooseLetter()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the Letter o or x");
		char Letter =sc.next().toLowerCase().charAt(0);
		
		if(Letter == 'o'){
			return Letter;
		}
		else if(Letter == 'x'){
			return Letter;
		}
		else {
			System.out.println("Invalid Choice ");
			return chooseLetter();
		}
	}
		
}