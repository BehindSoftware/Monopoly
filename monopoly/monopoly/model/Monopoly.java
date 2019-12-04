package monopoly.model;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//import becker.io.*;
//import becker.util.Test;
import java.util.ArrayList;


/** Monopoly is the model's central class.  It provides access to both
properties and players.  It also alternates moves between all the players.
@author Byron Weber Becker */
public class Monopoly extends Object
{
	private static final int ROUNDS_TOTAL = 20;
	private static final int PLAYERS_TOTAL = 2;
	private List<HumanPlayer> players = new ArrayList<>( PLAYERS_TOTAL);
	//private List players = new ArrayList( PLAYERS_TOTAL);
	private Board board = new Board( );
	private RandomDice[ ] dice = { new RandomDice( ), new RandomDice( ) };
   /** Construct a new instance of Monopoly. */
	public Monopoly()
	{  
		super();
		HumanPlayer p;
		p = new HumanPlayer("Dog", dice, board); 
		players.add(p);
		p = new HumanPlayer("Car", dice, board);
		players.add(p);
	}

   /** Load a game from the named file.
   @param fileName the name of the file containing the saved game */
   public void loadGame(String fileName)
   {  
	   System.out.println("Welcome to "+fileName);
	   String text;
	   FileInputStream fStream = null;
	   try {
		fStream = new FileInputStream(fileName);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   DataInputStream dStream = new DataInputStream(fStream);
	   BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));
	   
	   try {
		while((text = bReader.readLine())!=null) {
			   System.out.println(text);
			   if(text.equals("Go")) {
				   
			   }else if(text.equals("BuildingLot")) {
				   
			   }else if(text.equals("RailRoad")) {
				   
			   }else if(text.equals("HumanPlayer")) {
				   
			   }
		   }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   try {
		dStream.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

   }

   public void playRound() {

	   for(Iterator<?> itr = players.iterator();
			   itr.hasNext(); ) {
		   Player player = (Player) itr.next();  
		   player.advanceToken();
	   }
   }

   /** Play the game by giving each player a turn, in sequence, until
   all but one are bankrupt. */
   public void playGame()
   {  
	   for (int i = 0; i < ROUNDS_TOTAL; i++)
	   {
		   System.out.println("Round "+(i+1));
		   playRound( );
	   }
   }

   /** Make available the number of squares in the game.
   @return the number of squares in the game. */
   public int getNumSquares()
   {  
	   return Board.SIZE;
   }

   /** Make available the number of players in the game.
   @return the number of players in the game. */
   public int getNumPlayers()
   {  
    return PLAYERS_TOTAL;
   }

   /** Get a Square.
   @param boardPosition the position of the Square to get
      ("Go" = position 0, "Mediterranean Ave" = position 1, etc.)
   @return the Square at the given position */
   public Square getSquare(int boardPosition)
   {  
	   Square ps = new Square("", 0);
	   ps = board.getSquareForIndex(boardPosition);
	   
	   if(ps!= null ) {
		   return  ps;
	   }
	return null;
   }

   /** Get a Square.
   @param name the name of the Square to get
      ("Go", "Mediterranean Ave", etc.)
   @return the Square with the given name */
   public Square getSquare(String name)
   {  
    return null;
   }

   /** Make available a particular player.
   @param id the id number of the player to get
   @return the player with the given id */
   public Player getPlayer(int id)
   {  
	   return players.get(id);
   }

   

   /** Represent this object as a String. Useful for debugging. */
   public String toString()
   {  return null;
   }

   /** A main method to test Monopoly, Player and Square classes.
   Errors print to the console. A correct run will only print "Done testing." */
//   public static void main(String[] args)
//   {
//      Monopoly m = new Monopoly();
//      Square sq = m.getSquare(0);
//      Test.ckEquals("Name of Go", "Go", sq.getName());
//
//      Player pl = m.getPlayer(0);
//      Test.ckEquals("1st player id", 0, pl.getID());;
//
//      sq = m.getSquare(0);
//      Test.ckEquals("Num players on square", 4, sq.getPlayers().length);
//
//      sq = m.getSquare(1);
//      Test.ckEquals("First prop name", "Mediterranean Ave", sq.getName());
//      Test.ckEquals("Num players on first prop", 0, sq.getPlayers().length);
//
//      sq = m.getSquare(m.getNumSquares()-1);
//      Test.ckEquals("Last prop name", "Boardwalk", sq.getName());
//      Test.ckEquals("Num players on last prop", 0, sq.getPlayers().length);
//
//      pl = m.getPlayer(0);
//      Test.ckEquals("initial net worth", 1500, pl.getNetWorth());
//      Test.ckEquals("initial balance", 1500, pl.getBalance());
//      Test.ckEquals("initial num owned prop", 0, pl.getOwnedPropertyNames().length);
//
//      pl.advanceToken(1);
//      Square op = m.getSquare(pl.getBoardPosition());
//      
//      Test.ckEquals("occupied square name", "Mediterranean Ave", op.getName());
//      Test.ckEquals("can buy occuppied square", true, pl.canBuyOccupiedSquare());
//      pl.buyOccupiedSquare();
//      Test.ckEquals("can buy purchased square (f)", false, pl.canBuyOccupiedSquare());
//      Test.ckEquals("balance after purchase", 1440, pl.getBalance());
//      Test.ckEquals("net worth after purchase", 1500, pl.getNetWorth());
//
//      m = new Monopoly();
//      m.loadGame("../testGame1.txt");
//      sq = m.getSquare("Baltic Ave");
//      Test.ckEquals("prop name read from file", "Baltic Ave", sq.getName());
//      pl = m.getPlayer(0);
//      Test.ckEquals("player name read from file", "Fred", pl.getName());
//      Test.ckEquals("owned prop 1", "Reading RR", pl.getOwnedPropertyNames()[0]);
//      Test.ckEquals("owned", "Baltic Ave", pl.getOwnedPropertyNames()[1]);
//
//      System.out.println("Done testing.");
//   }
   
}



