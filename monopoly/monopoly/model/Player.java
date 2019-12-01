package monopoly.model;
import becker.util.IView;
//import becker.io.TextInput;



/** A class representing one monopoly player.
@author Byron Weber Becker */

//player abstract olup humana taşınacakfonksiyonlar
public abstract class Player extends Object
{
   //private IView[] views = new IView[1];
   //private int numViews = 0;
   //private static Dice dice;
   
   private String[] propertyList; //bir player has-a birden fazla property (1 to n)

   private int ID;
   private int balance;
   private int netWorth;
   
   protected String name;
   protected RandomDice [ ] randomDice;
   protected Board board; 
   protected Piece marker;
   
   public Player(String name, RandomDice [ ] dice, Board b) {

	   this.name = name;
	   this.randomDice = dice;
	   this.board = b;
	   marker = new Piece(board.getStartSquare( ) );

   }
   
   /* Used to determine if we are debugging or not.   Once this is determined,
    * set the appropriate type of dice. */
//   private void determineDiceType()
//   {
//      /* Only needs to be called if we have not initialized dice. */
//      if(Player.dice == null)
//      {  TextInput in = new TextInput();
//
//         System.out.print("Do you want to debug? ");
//         /* Get input from the user to determine whether debugging or not. */
//         if (in.readLine().trim().equalsIgnoreCase("y"))
//         {  
//         }
//         else
//         {  
//         }
//         in.close();
//      }
//
//   }

   /** Get a list naming the properties this player has bought.
   @return a full array giving the names of the properties owned by this player. */
   public String[] getOwnedPropertyNames()
   {  
    return this.propertyList;
   }

   /** Get the name of this player.
   @return the name of this player */
   public String getName()
   {  
    return this.name;
   }

   /** Get the id of this player.
   @return the id of this player */
   public int getID()
   {  
    return this.ID;
   }

   /** Get the bank balance of this player.
   @return this player's bank balance */
   public int getBalance()
   {  
    return this.balance;
   }

   /** Get the net worth of this player.
   @return this player's net worth */
   public int getNetWorth()
   {  
    return this.netWorth;
   }

   /** Indicate whether or not this player can buy the Square it most
   recently landed on.
   @return true if the player can buy the Square; false otherwise */
   public boolean canBuyOccupiedSquare()
   {  
    return false;
   }

   

   /** Instruct this player to buy a house.
   @param propertyName the name of the square for which the player wants to
   purchase a house*/
   public void buyHouse(String propName)
   {  
   }

   /** Buy the Square most recently landed on by this player. */
   public void buyOccupiedSquare()
   {  
   }

   /** Roll the dice and advance the token. */
   protected void advanceToken()
   {  
	   //roll dice
	   int rollTotal = 0;
	   for (int i = 0; i < randomDice.length; i++) {
		   randomDice[i].roll( );
		   rollTotal = randomDice[i].getFaceValue( );
	   }

	   Square newLoc = board.getSquare(marker.getLocation( ), rollTotal);

	   marker.setLocation(newLoc);

   }

   /** Advance the token the given number of properties.
   @param howFar how many properties to advance  */
   protected void advanceToken(int howFar)
   {  
   }

   /** Make a move for this player -- find out how far to advance
   the token, advance it, complete any resulting business such as
   paying rent or buying properties/houses. Must be overridden in
   subclasses. */
   protected abstract void makeMove();

   /** Get the player's current position on the board.
   @return 0 for "Go, 1 for "Mediterrainean Ave", etc. */
   public int getBoardPosition()
   {  
 return 0;
   }

   

    /** Add another view to be notified whenever this part of the model changes.
   @param view the view to add */
   public void addView(IView aView)
   {  
   }

   /** Update all the views registered with this part of the model.*/
   protected void updateAllViews()
   {  
   }

   /** Represent this object as a String.  Useful for debugging. */
   public String toString()
   {  return null;
   }
   
}