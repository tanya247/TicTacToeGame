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
				index = desireMove(show, scanner, turn , userLetter,compLetter);
				assignValueInTheBoard(index, show, userLetter);	
				check = WinOrTieCondition(show, userLetter, compLetter);
				showBoard(show);
				if(check == true){
					break;
				}
				else{
					turn = "computer";
				}
			} 
	    	else {
				index = desireMove(show, scanner , turn,userLetter,compLetter);
				assignValueInTheBoard(index, show, compLetter);	
				check = WinOrTieCondition(show, userLetter, compLetter);
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
	 static int desireMove(char board[],Scanner scanner,String turn,char userLetter, char compLetter){
		 int index = 0;
		 if(turn == "player") {
				 if ((board[1] == compLetter && board[2] == compLetter) || (board[2] == compLetter && board[3] == compLetter)
								|| (board[1] == compLetter && board[3] == compLetter)) {
					 if ((board[1] == ' ') || (board[2] == ' ') || (board[3] == ' ')) {
							if ((board[1] == ' '))
								index = 1;
							if ((board[2] == ' '))
								index = 2;
							if ((board[3] == ' '))
								index = 3;
							}
						return index;
					}
					
				else if ((board[4] == compLetter && board[5] == compLetter) || (board[5] == compLetter && board[6] == compLetter)
								|| (board[4] == compLetter && board[6] == compLetter)) {
					if ((board[4] == ' ') || (board[5] == ' ') || (board[6] == ' ')) {
						if ((board[4] == ' '))
							index = 4;
						if ((board[5] == ' '))
							index = 5;
						if ((board[6] == ' '))
							index = 6;
						}
					return index;
				}
				else if ((board[7] == compLetter && board[8] == compLetter) || (board[8] == compLetter && board[9] == compLetter)
								|| (board[7] == compLetter && board[9] == compLetter)) {
					if ((board[7] == ' ') || (board[8] == ' ') || (board[9] == ' ')) {
						if ((board[7] == ' '))
							index = 7;
						if ((board[8] == ' '))
							index = 8;
						if ((board[9] == ' '))
							index = 9;
						}
					return index;
				}
				else if ((board[1] == compLetter && board[4] == compLetter) || (board[4] == compLetter && board[7] == compLetter)
							|| (board[1] == compLetter && board[7] == compLetter)) {
					
					if ((board[1] == ' ') || (board[4] == ' ') || (board[7] == ' ')) {
						if ((board[1] == ' '))
							index = 1;
						if ((board[4] == ' '))
							index = 4;
						if ((board[7] == ' '))
							index = 7;
						}
					return index;
					
				}
				else if ((board[2] == compLetter && board[5] == compLetter) || (board[5] == compLetter && board[8] == compLetter)
							|| (board[5] == compLetter && board[8] == compLetter)) {
					if ((board[2] == ' ') || (board[5] == ' ') || (board[8] == ' ')) {
						if ((board[2] == ' '))
							index = 2;
						if ((board[5] == ' '))
							index = 5;
						if ((board[8] == ' '))
							index = 8;
						}
					return index;
					
				}	
				else if ((board[3] == compLetter && board[6] == compLetter) || (board[6] == compLetter && board[9] == compLetter)
							|| (board[3] == compLetter && board[9] == compLetter)) {
					if ((board[3] == ' ') || (board[6] == ' ') || (board[9] == ' ')) {
						if ((board[3] == ' '))
							index = 3;
						if ((board[6] == ' '))
							index = 6;
						if ((board[9] == ' '))
							index = 9;
						}
					return index;
				}	
				else if ((board[1] == compLetter && board[5] == compLetter) || (board[5] == compLetter && board[9] == compLetter)
							|| (board[1] == compLetter && board[9] == compLetter)) {
					if ((board[1] == ' ') || (board[5] == ' ') || (board[9] == ' ')) {
						if ((board[1] == ' '))
							index = 1;
						if ((board[5] == ' '))
							index = 5;
						if ((board[9] == ' '))
							index = 9;
						}
					return index;
				}
				else if ((board[3] == compLetter && board[5] == compLetter) || (board[5] == compLetter && board[7] == compLetter)
							|| (board[7] == compLetter && board[3] == compLetter)) {
					if ((board[3] == ' ') || (board[5] == ' ') || (board[7] == ' ')) {
						if ((board[3] == ' '))
							index = 3;
						if ((board[5] == ' '))
							index = 5;
						if ((board[7] == ' '))
							index = 7;
						}
					return index;
					}
				else {
					System.out.println("What is your move ? (1-9)");
					index = scanner.nextInt();	 
					if(index > 0){
						if (index < 10 && isSpaceFree(board, index)) {
							return index;
						}
						else {
							System.out.println("Already Filled");
							return desireMove(board,scanner,turn,userLetter,compLetter);
						}
					}
				}
			 }
		 
			 else {
				 if ((board[1] == userLetter && board[2] == userLetter) || (board[2] == userLetter && board[3] == userLetter)
							|| (board[1] == userLetter && board[3] == userLetter)) {

					 if ((board[1] == ' ') || (board[2] == ' ') || (board[3] == ' ')) {
							if ((board[1] == ' '))
								index = 1;
							if ((board[2] == ' '))
								index = 2;
							if ((board[3] == ' '))
								index = 3;
							}
						return index;
				}
				else if ((board[4] == userLetter && board[5] == userLetter) || (board[5] == userLetter && board[6] == userLetter)
							|| (board[4] == userLetter && board[6] == userLetter)) {

					if ((board[4] == ' ') || (board[5] == ' ') || (board[6] == ' ')) {
						if ((board[4] == ' '))
							index = 4;
						if ((board[5] == ' '))
							index = 5;
						if ((board[6] == ' '))
							index = 6;
						}
					return index;
				}
				else if ((board[7] == userLetter && board[8] == userLetter) || (board[8] == userLetter && board[9] == userLetter)
							|| (board[7] == userLetter && board[9] == userLetter)) {
					if ((board[7] == ' ') || (board[8] == ' ') || (board[9] == ' ')) {
						if ((board[7] == ' '))
							index = 7;
						if ((board[8] == ' '))
							index = 8;
						if ((board[9] == ' '))
							index = 9;
						}
					return index;
				}
				else if ((board[1] == userLetter && board[4] == userLetter) || (board[4] == userLetter && board[7] == userLetter)
						|| (board[1] == userLetter && board[7] == userLetter)) {
					if ((board[1] == ' ') || (board[4] == ' ') || (board[7] == ' ')) {
						if ((board[1] == ' '))
							index = 1;
						if ((board[4] == ' '))
							index = 4;
						if ((board[7] == ' '))
							index = 7;
						}
					return index;
				}
				else if ((board[2] == userLetter && board[5] == userLetter) || (board[5] == userLetter && board[8] == userLetter)
						|| (board[5] == userLetter && board[8] == userLetter)) {
					if ((board[2] == ' ') || (board[5] == ' ') || (board[8] == ' ')) {
						if ((board[2] == ' '))
							index = 2;
						if ((board[5] == ' '))
							index = 5;
						if ((board[8] == ' '))
							index = 8;
						}
					return index;
				}	
				else if ((board[3] == userLetter && board[6] == userLetter) || (board[6] == userLetter && board[9] == userLetter)
						|| (board[3] == userLetter && board[9] == userLetter)) {
					if ((board[3] == ' ') || (board[6] == ' ') || (board[9] == ' ')) {
						if ((board[3] == ' '))
							index = 3;
						if ((board[6] == ' '))
							index = 6;
						if ((board[9] == ' '))
							index = 9;
						}
					return index;
				}	
				else if ((board[1] == userLetter && board[5] == userLetter) || (board[5] == userLetter && board[9] == userLetter)
						|| (board[1] == userLetter && board[9] == userLetter)) {
					if ((board[1] == ' ') || (board[5] == ' ') || (board[9] == ' ')) {
						if ((board[1] == ' '))
							index = 1;
						if ((board[5] == ' '))
							index = 5;
						if ((board[9] == ' '))
							index = 9;
						}
					return index;
				}
				else if ((board[3] == userLetter && board[5] == userLetter) || (board[5] == userLetter && board[7] == userLetter)
						|| (board[7] == userLetter && board[3] == userLetter)) {
					if ((board[3] == ' ') || (board[5] == ' ') || (board[7] == ' ')) {
						if ((board[3] == ' '))
							index = 3;
						if ((board[5] == ' '))
							index = 5;
						if ((board[7] == ' '))
							index = 7;
						}
					return index;
					
				}
				else {
					index = (int) Math.floor(Math.random()*10)%9;
					if(index > 0){
						if (index < 10 && isSpaceFree(board, index)) {
							return index;
						}
						else {
							System.out.println("Already Filled");
							return desireMove(board,scanner,turn,userLetter,compLetter);
						}
					}
			 }
		 }
		 return index;
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
	private static boolean WinOrTieCondition(char[] board, char userLetter , char compLetter) {
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