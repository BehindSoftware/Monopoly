package monopoly.model;
import becker.util.IView;



/** A class representing one square on a monopoly board. A Square can be a
building lot such as "Vermont Ave" or "Park Place". It can also be a
railroad, "Go", Chance, the jail, and so on.
@author Byron Weber Becker */
public class Square extends Object
{
   private IView[] views = new IView[1];
   private int numViews = 0;
	protected int purPrice;
	protected int houses;
	protected int houseCost;
   
	private Player[] playerList;	//Bir square has-a birden fazla player (1 to n)

	protected String name;
	protected String propertyDescription; 
	private Square nextSquare;
	protected int index;

	public Square(String propertyDescription,int index) {
		this.propertyDescription = propertyDescription;
		this.index = index;
	}

	public void setNextSquare(Square s) {
		nextSquare = s;
	}

	public Square getNextSquare(Square s) {
		return nextSquare;
	}

   public String getName()
   {  
		return name;
   }

   public int getIndex()
   {  
		return index;
   }
   
   
   ////////////////////////////////////////
   /** Get a description of this square.
   @return a String description of this square */
   public String getDescription()
   {  
		return this.propertyDescription;
   }

   

   /** Get a list of the players currently occupying this property.
   @return a full array with the 0 or more players who have most recently
   landed on this property */
   public Player[] getPlayers()
   {  
		return this.playerList;
   }


   /** Add another view to be notified whenever this part of the model changes.
   @param view the view to add */
   public void addView(IView aView)
   {  
   }

   /** Update all the views registered with this part of the model.*/
   protected synchronized void updateAllViews()
   {  
   }

}
