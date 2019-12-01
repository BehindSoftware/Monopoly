package monopoly.model;


 
/** A subclass of Player for a computer player */
public class ComputerPlayer extends Player
{
   

   public ComputerPlayer(String name, RandomDice[] dice, Board b) {
		super(name, dice, b);
		   this.name = name;
		   this.randomDice = dice;
		   this.board = b;
		   marker = new Piece(board.getStartSquare( ) );
	}

public void makeMove()
   {  
   }
   
}
