import java.util.Scanner;
import java.util.Arrays;
public class TicTacToeGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Tic Tac Toe");
		createBoard();
		char userLetter=chooseLetter();
		char compLetter=(userLetter =='x')?'o' :'x';
		char show[] = createBoard();
		showBoard(show);
		int userMove = desireMove(show,scanner);
	    show[userMove]=userLetter;
	    showBoard(show);
		
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
	static void showBoard( char gameBoard[]){
		System.out.println(" ");
	    System.out.println("\n "+ gameBoard[1] + " | "+ gameBoard[2] + " | " +gameBoard[3]);
	    System.out.println("-------------");
	    System.out.println(" "+ gameBoard[4] + " | " + gameBoard[5] + " | " + gameBoard[6]);
	    System.out.println("-------------");
	    System.out.println(" "+ gameBoard[7] + " | " + gameBoard[8] + " | " + gameBoard[9]);
	    System.out.println(" ");
	}	
	static int desireMove(char board[],Scanner sc){
		Integer [] validCells = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	    while (true){
	    	System.out.println("What is your next move ? (1-9)");
	    	int index = sc.nextInt();
	    	if (Arrays.asList(validCells).contains(index) && isSpaceFree(board, index)){
	    		return index;
	    	}
	    }
	    
	}
	private static boolean isSpaceFree(char[] board, int index){
		return board[index] == ' ';
	}
	private static String firstPlay() {
		int toss = (int) Math.floor(Math.random() * 10) % 2;
		if(toss == 1) {
			return "player";
		}
		else {
			return "Computer";
		}
	}

}