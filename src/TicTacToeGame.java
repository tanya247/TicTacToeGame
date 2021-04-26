import java.util.Scanner;
public class TicTacToeGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Tic Tac Toe");
		createBoard();
		String turn;
		boolean check = true;
		int index;
		char userLetter=chooseLetter();
		char compLetter=(userLetter =='x')?'o' :'x';
		char show[] = createBoard();
		showBoard(show);
		
	    
	    if(whoPlayFirst().equals("player")){
	    	System.out.println("Player  Turns First");
	    	turn = "player";
	    }
	    else{
	    	System.out.println("Computer Turns First");
	    	turn = "computer";
			
		}
	    do{
	    	if (turn == "player") {
				index = desireMove(show, scanner, turn);
				assignValueInTheBoard(index, show, userLetter);	
				check = checkWinAndTieCondition(show, userLetter, compLetter);
				showBoard(show);
				if(check == true){
					break;
				}
				else{
					turn = "computer";
				}
			} 
	    	else {
				index = desireMove(show, scanner , turn);
				assignValueInTheBoard(index, show, compLetter);	
				check = checkWinAndTieCondition(show, userLetter, compLetter);
				showBoard(show);
				if(check == true){
					break;
				}
				else{
					turn = "player";
				}
			} 
	    	
	    }while(!check);
		
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
	    	System.out.println("----------------------");
	    	System.out.println(" "+ gameBoard[4] + " | " + gameBoard[5] + " | " + gameBoard[6]);
	    	System.out.println("----------------------");
	    	System.out.println(" "+ gameBoard[7] + " | " + gameBoard[8] + " | " + gameBoard[9]);
	    	System.out.println(" ");
	}
	 static int desireMove(char board[],Scanner scanner,String turn){
		 while (true){
			 
			 int index;
			 if(turn == "player"){
				 System.out.println("What is your move ? (1-9)");
				 index = scanner.nextInt();	 
			 }
			 else {
				 index = (int) Math.floor(Math.random()* 10)%10;
			 }
			 if(index > 0){
				if (index < 10 && isSpaceFree(board, index)) {
					return index;
		        }
				else {
					System.out.println("Already Filled");
					return desireMove(board,scanner,turn);
				}
			 }
				 
		 }
	 }
	 private static boolean isSpaceFree(char[] board, int index){
		 return board[index] == ' ';
	 }
	 private static String whoPlayFirst() {
		int toss = (int) Math.floor(Math.random() * 10) % 2;
		if(toss == 1) {
			return "player";
		}
		else {
			return "Computer";
		}
	}
	private static char[] assignValueInTheBoard(int index, char[] board, char letter) {
			board[index] = letter;
			return board;
	}
	private static boolean checkWinAndTieCondition(char[] board, char userLetter , char compLetter) {
		boolean check;
		int index = 0;
		if ((board[1] == userLetter && board[2] == userLetter && board[3] == userLetter) || (board[4] == userLetter && board[5] == userLetter && board[6] == userLetter)
				|| (board[7] == userLetter && board[8] == userLetter && board[9] == userLetter)
				|| (board[1] == userLetter && board[4] == userLetter && board[7] == userLetter)
				|| (board[2] == userLetter && board[5] == userLetter && board[8] == userLetter)
				|| (board[3] == userLetter && board[6] == userLetter && board[9] == userLetter)
				|| (board[1] == userLetter && board[5] == userLetter && board[9] == userLetter)
				|| (board[3] == userLetter && board[5] == userLetter && board[7] == userLetter)) {
			check = true;
			System.out.println("Player Won");
		} 
		else if((board[1] == compLetter && board[2] == compLetter && board[3] == compLetter) || (board[4] == compLetter && board[5] == compLetter && board[6] == compLetter)
				|| (board[7] == compLetter && board[8] == compLetter && board[9] == compLetter)
				|| (board[1] == compLetter && board[4] == compLetter && board[7] == compLetter)
				|| (board[2] == compLetter && board[5] == compLetter && board[8] == compLetter)
				|| (board[3] == compLetter && board[6] == compLetter && board[9] == compLetter)
				|| (board[1] == compLetter && board[5] == compLetter && board[9] == compLetter)
				|| (board[3] == compLetter && board[5] == compLetter && board[7] == compLetter)) {
			check = true;
			System.out.println("Computer Won");
		}
		else if((board[1] == userLetter || board[1] == compLetter) &&
				(board[2] == userLetter || board[2] == compLetter) &&
				(board[3] == userLetter || board[3] == compLetter) &&
				(board[4] == userLetter || board[4] == compLetter) &&
				(board[5] == userLetter || board[5] == compLetter) &&
				(board[6] == userLetter || board[6] == compLetter) &&
				(board[7] == userLetter || board[7] == compLetter) &&
				(board[8] == userLetter || board[8] == compLetter)&&
				(board[9] == userLetter || board[9] == compLetter)) {
			System.out.println("Tie");
			check = true;
		}
		else {
			check = false;
		}
		return check;
	}

}
